package com.epam.bench.e03.logger.team1;

import com.epam.bench.e03.logger.Level;
import com.epam.bench.e03.logger.Logger;

public class FirstLogger implements Logger {

	public void log(Level level, String message, Exception exception) {
		System.out.println("" + level + ": " + message + ", exception: " + exception);
	}
}
