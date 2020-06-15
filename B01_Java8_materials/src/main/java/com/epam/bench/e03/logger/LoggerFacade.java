package com.epam.bench.e03.logger;

public interface LoggerFacade {

	default void log(Level level, String message) {
		log(level, "Exception missing! " + message, null);
	}

	void log(Level level, String message, Exception exception);

}
