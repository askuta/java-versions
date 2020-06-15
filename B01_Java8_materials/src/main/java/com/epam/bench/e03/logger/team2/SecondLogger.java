package com.epam.bench.e03.logger.team2;

import com.epam.bench.e03.logger.Level;
import com.epam.bench.e03.logger.Logger;
import com.epam.bench.e03.logger.LoggerFacade;

public class SecondLogger implements Logger, LoggerFacade {

	@Override
	public void log(Level level, String message) {
		LoggerFacade.super.log(level, message);
	}

	@Override
    public void log(Level level, String message, Exception exception) {
        System.out.println("\n\nLevel: " + level + "\n Message: " + message + "\n Exception: " + exception);
    }
}
