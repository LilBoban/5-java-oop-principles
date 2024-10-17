package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private ArrayList<MessageHandler> handlers;
    private ArrayList<String> messages = new ArrayList<>();
    private int maxOfMessages;

    public MemoryHandler(int maxOfMessages, ArrayList<MessageHandler> handlers) {
        this.maxOfMessages = maxOfMessages;
        this.handlers = handlers;
    }

    @Override
    public void log(String message) {
        messages.add(message);

        if (messages.size() >= maxOfMessages) {
            for (MessageHandler handler : handlers) {
                for (String msg : messages) {
                    handler.log(msg);
                }
                messages.clear();
            }
        }
    }

}
