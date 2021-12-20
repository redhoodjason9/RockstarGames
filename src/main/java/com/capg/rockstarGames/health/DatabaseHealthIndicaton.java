package com.capg.rockstarGames.health;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import static com.capg.rockstarGames.util.Constants.*;

@Component
public class DatabaseHealthIndicaton implements HealthIndicator, HealthContributor {

	@Autowired
	private DataSource dataSource;

	@Override
	public Health health() {
		try (Connection conn = dataSource.getConnection();) {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(HEALTHQUERY);
		} catch (SQLException e) {
			return Health.down().withDetail("Database", "not running").withException(e).build();
		}
		return Health.up().withDetail("Database", "running").build();
	}

}
