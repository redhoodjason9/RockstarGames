package com.capg.rockstarGames.mapstruct.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.capg.rockstarGames.beans.Game;
import com.capg.rockstarGames.mapstruct.dto.GameDto;
import static com.capg.rockstarGames.util.Constants.*;

@Component
public class GameMapper implements IGameMapper{

//	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Game gameDtoToGame(GameDto gameDto) {
		LOGGER.info("GameDto to Game conversion initialized");
		Game game = new Game();
		game.setId(gameDto.getId());
		game.setCost(gameDto.getCost());
		game.setName(gameDto.getName());
		LOGGER.info("GameDto to Game conversion completed");
		return game;
	}

	@Override
	public GameDto gameToGameDto(Game game) {
		LOGGER.info("Game to GameDto conversion initialized");
		GameDto gameDto = new GameDto();
		gameDto.setId(game.getId());
		gameDto.setName(game.getName());
		gameDto.setCost(game.getCost());
		LOGGER.info("Game to GameDto conversion completed");
		return gameDto;
	}

}
