package com.capg.rockstarGames.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.capg.rockstarGames.beans.Game;
import com.capg.rockstarGames.mapstruct.dto.GameDto;
import com.capg.rockstarGames.service.IRockstarService;
import static com.capg.rockstarGames.util.Constants.*;

@CrossOrigin
@RestController
@RequestMapping(API)
public class RockstarController {

	@Autowired
	private IRockstarService service;

	@PostMapping(ADD)
	public ResponseEntity<GameDto> addGame(@RequestBody Game game) {
		LOGGER.info("Add game controller initialized");
		GameDto gameDto = service.addGame(game);
		LOGGER.info("Add game controller executed");
		return new ResponseEntity<GameDto>(gameDto, HttpStatus.OK);
	}

	@GetMapping(GET)
	public ResponseEntity<GameDto> getGame(@PathVariable int id) {
		LOGGER.info("Get game controller initialized");
		GameDto gameDto = service.getGame(id);
		LOGGER.info("Get game controller executed");
		return new ResponseEntity<GameDto>(gameDto, HttpStatus.OK);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> exceptionConstraintViolationException(ConstraintViolationException exception) {
		StringBuilder msg = new StringBuilder();
		exception.getConstraintViolations().forEach(i -> msg.append(i.getConstraintDescriptor().getMessageTemplate()));
		return new ResponseEntity<>(msg.toString(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(NullPointerException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(MethodArgumentTypeMismatchException exception) {
		return new ResponseEntity<>("Please enter a valid id", HttpStatus.NOT_ACCEPTABLE);
	}

}
