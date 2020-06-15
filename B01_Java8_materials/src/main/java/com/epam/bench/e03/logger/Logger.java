package com.epam.bench.e03.logger;

public interface Logger {

	default void log(Level level, String message) {
		log(level, message, null);
	}

	void log(Level level, String message, Exception exception);

}
