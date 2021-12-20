package com.capg.rockstarGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.rockstarGames.beans.Game;

public interface IRockstarRepository extends JpaRepository<Game, Integer> {

}
