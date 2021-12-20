package com.capg.rockstarGames.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Constants {
	
	public static final String API = "${api}";
	
	public static final String ADD = "${add}";
	
	public static final String GET = "${get}";
	
	public static final String DATABASE = "${database}";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Constants.class);
	
	public static final String HEALTHQUERY = "SELECT * FROM Game";
}
