package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Task04Main {
    public static void main(String[] args) {
        ArrayList<MessageHandler> handlers = new ArrayList<>();
        handlers.add(new ConsoleHandler());
        handlers.add(new FileHandler());
        handlers.add(new RotationFileHandler(ChronoUnit.HOURS));
        handlers.add(new MemoryHandler(5, handlers));
        Logger logger = new Logger("testlog", handlers);
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warning("Warning message");
        logger.error("Error message");
    }
}
