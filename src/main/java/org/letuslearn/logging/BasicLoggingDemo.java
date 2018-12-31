package org.letuslearn.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BasicLoggingDemo {
  public static void main(String[] args) {
    LogManager logManager = LogManager.getLogManager();

    Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);

    logger.log(Level.INFO, "Hello world from logger");
    logger.log(Level.INFO, "Hello world again");
  }
}
