package org.letuslearn.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingDemo {
  static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
  public static void main(String[] args) {
    logger.log(Level.INFO, "Hello");
    logger.log(Level.INFO, "Hai");

  }
}
