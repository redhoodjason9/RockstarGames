package com.capg.rockstarGames.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capg.rockstarGames.beans.Game;
import com.capg.rockstarGames.mapstruct.dto.GameDto;
import com.capg.rockstarGames.mapstruct.mapper.IGameMapper;
import com.capg.rockstarGames.repository.IRockstarRepository;
import static com.capg.rockstarGames.util.Constants.*;

@Component
public class RockstarService implements IRockstarService{

	@Autowired
	private IRockstarRepository repository;
	
	@Autowired
	private IGameMapper mapper;
	
//	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public GameDto addGame(Game game) {
		LOGGER.info("Add Game service initialized");
		LOGGER.info("Add Game service executed");
		return mapper.gameToGameDto(this.repository.save(game));
	}

	@Override
	public GameDto getGame(int id) {
		LOGGER.info("Get Game service initialized");
		Game game = repository.findById(id)
				.orElseThrow(()->{throw new NullPointerException("The given game doesn't exist");});
		LOGGER.info("Get Game service executed");
		return mapper.gameToGameDto(game);
	}

}
