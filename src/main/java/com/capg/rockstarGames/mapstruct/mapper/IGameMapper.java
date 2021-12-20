package com.capg.rockstarGames.mapstruct.mapper;

import org.mapstruct.Mapper;

import com.capg.rockstarGames.beans.Game;
import com.capg.rockstarGames.mapstruct.dto.GameDto;

@Mapper
public interface IGameMapper {
	
	Game gameDtoToGame(GameDto gameDto);
	
	GameDto gameToGameDto(Game game);
}
