package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    @Override
    public void log(String message) {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.append(message + "\n");

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
