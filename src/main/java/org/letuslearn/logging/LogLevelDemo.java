package org.letuslearn.logging;

import java.util.logging.*;

public class LogLevelDemo {
  static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

  public static void main(String[] args) {
    Handler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(Level.FINEST); // unless you do this FINE logs will not print because in console handler
    // they are blcoked
    logger.addHandler(consoleHandler);
    logger.setLevel(Level.FINEST);
    logger.log(Level.SEVERE, "Ooopss!!");
    logger.log(Level.INFO, "Hai");
    logger.log(Level.FINE, "developer info"); // these two lines will not print as it is out side the range
    logger.log(Level.FINEST, "special info");
  }
}
