package com.capg.rockstarGames.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity(name = "Game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull(message = "Name of the game should not be null")
	private String name;

	@Min(value = 1000, message = "Cost should be atleast 1000")
	@Max(value = 10000, message = "Cost should not be more than 10000")
	private int cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(@NotNull(message = "Name of the game should not be null") String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(
			@Min(value = 1000, message = "Cost should be atleast 1000") @Max(value = 10000, message = "Cost should not be more than 10000") int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}

	public Game(int id, @NotNull(message = "Name of the game should not be null") String name,
			@Min(value = 1000, message = "Cost should be atleast 1000") @Max(value = 10000, message = "Cost should not be more than 10000") int cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

	public Game() {
		super();
	}

}
