package com.capg.rockstarGames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class RockstarGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockstarGamesApplication.class, args);
	}

}
