package com.capg.rockstarGames.health;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

import static com.capg.rockstarGames.util.Constants.*;



@Component("rockstar")
public class CompositeHealth implements CompositeHealthContributor {

	Map<String, HealthContributor> contributors = new LinkedHashMap<>();

	@Autowired
	public CompositeHealth(DatabaseHealthIndicaton databaseHealthIndication) {
		contributors.put("Database", databaseHealthIndication);
	}

	@Override
	public HealthContributor getContributor(String name) {
		return contributors.get(name);
	}

	@Override
	public Iterator<NamedContributor<HealthContributor>> iterator() {
		return contributors.entrySet().stream()
				.map(entry -> NamedContributor.of(entry.getKey(), entry.getValue()))
				.iterator();
	}

}
