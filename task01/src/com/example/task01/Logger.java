package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;
    private LoggerLevel loggerLevel;
    private final String name;


    public Logger(String name) {
        this.name = name;
        this.loggerLevel = LoggerLevel.INFO;
    }

    public Logger(LoggerLevel loggerLevel, String name) {
        this.loggerLevel = loggerLevel;
        this.name = name;
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
            System.out.println(lineToPrint);
        }
    }

    public void log(LoggerLevel level, String format, Object... arguments) {
        if (level.ordinal() >= this.loggerLevel.ordinal())
            System.out.println(MessageFormat.format(format, arguments));
    }
}
