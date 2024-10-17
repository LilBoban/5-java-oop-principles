package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {

    private static Logger instance;
    private LoggerLevel loggerLevel;
    private final String name;
    ArrayList<MessageHandler> handlers = new ArrayList<>();


    public Logger(String name) {
        this.name = name;
        this.loggerLevel = LoggerLevel.INFO;
        handlers.add(new ConsoleHandler());
    }

    public Logger(String name, ArrayList<MessageHandler> handlers) {
        this.name = name;
        this.loggerLevel = LoggerLevel.INFO;
        this.handlers = handlers;
    }

    public Logger(LoggerLevel loggerLevel, String name, ArrayList<MessageHandler> handlers) {
        this.loggerLevel = loggerLevel;
        this.name = name;
        this.handlers = handlers;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        if (instance == null) {
            instance = new Logger(name);
        }
        return instance;
    }

    public LoggerLevel getLevel() {
        return loggerLevel;
    }

    public void setLevel(LoggerLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    public void debug(String message) {
        log(LoggerLevel.DEBUG, message);
    }

    public void debug(String template, Object... arguments) {
        log(LoggerLevel.DEBUG, template, arguments);
    }

    public void info(String message) {
        log(LoggerLevel.INFO, message);
    }

    public void info(String template, Object... arguments) {
        log(LoggerLevel.INFO, template, arguments);
    }

    public void warning(String message) {
        log(LoggerLevel.WARNING, message);
    }

    public void warning(String template, Object... arguments) {
        log(LoggerLevel.WARNING, template, arguments);
    }

    public void error(String message) {
        log(LoggerLevel.ERROR, message);
    }

    public void error(String template, Object... arguments) {
        log(LoggerLevel.ERROR, template, arguments);
    }

    public void log(LoggerLevel level, String message) {
        if (level.ordinal() >= this.loggerLevel.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String lineToPrint = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, this.name, message);
            for (MessageHandler handler : handlers) {
                handler.log(lineToPrint);
            }
        }
    }

    public void log(LoggerLevel level, String format, Object... arguments) {
        if (level.ordinal() >= this.loggerLevel.ordinal()) {
            String message = MessageFormat.format(format, arguments);

            for (MessageHandler handler : handlers) {
                handler.log(message);
            }
        }
    }
}
