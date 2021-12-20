package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.capg.rockstarGames.beans.Game;
import com.capg.rockstarGames.mapstruct.dto.GameDto;
import com.capg.rockstarGames.mapstruct.mapper.IGameMapper;
import com.capg.rockstarGames.repository.IRockstarRepository;
import com.capg.rockstarGames.service.RockstarService;
import static com.capg.rockstarGames.util.Constants.*;


@ExtendWith(MockitoExtension.class)
class RockstarServiceTest {

	@Mock
	private IRockstarRepository repository;
	
	@Mock
	private IGameMapper mapper;
	
	@Mock
	private Game game;
	
	@Mock
	private GameDto gameDto;
	
	@InjectMocks
	private RockstarService service;
	
	@Test
	void testAddGame() {
		LOGGER.info("ServiceTest add game initialized");
		
		when(repository.save(game)).thenReturn(game);
		when(mapper.gameToGameDto(game)).thenReturn(gameDto);
		
		GameDto ans = service.addGame(game);
	
		assertEquals(gameDto,ans);
		
		LOGGER.info("ServiceTest add game completed");
	}

	@Test
	void testGetGame() {
		LOGGER.info("ServiceTest get game initialized");
		
		Optional<Game> game = Optional.of(new Game(1,"abcd",1500));
		int id = 1;
		
		when(repository.findById(id)).thenReturn(game);
		when(mapper.gameToGameDto(game.get())).thenReturn(gameDto);
		
		
		GameDto ans = service.getGame(id);
		
		assertEquals(gameDto, ans);
		
		LOGGER.info("ServiceTest get game completed");
	}
	
	@Test
	void testGetGameShouldThrowNullPointerException() {
		LOGGER.info("ServiceTest get game null pointer exception initialized");
		
		int id = 1;
		
		when(repository.findById(id)).thenThrow(NullPointerException.class);
		
		assertThrows(NullPointerException.class,()->service.getGame(id)); 
		
		LOGGER.info("ServiceTest get game null pointer exception completed");
	}

	
}
