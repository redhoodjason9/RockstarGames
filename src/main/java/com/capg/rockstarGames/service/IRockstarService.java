package com.capg.rockstarGames.service;

import org.springframework.stereotype.Service;

import com.capg.rockstarGames.beans.Game;
import com.capg.rockstarGames.mapstruct.dto.GameDto;

@Service("RockstarService")
public interface IRockstarService {

	GameDto addGame(Game game);

	GameDto getGame(int id);

}
