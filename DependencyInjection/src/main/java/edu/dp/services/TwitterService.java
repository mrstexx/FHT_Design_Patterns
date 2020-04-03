package edu.dp.services;

public class TwitterService implements IMessageService {
    @Override
    public boolean sendMessage(String msg, String receiver) {
        System.out.println("Twitter sent to: " + receiver);
        System.out.println("Message: \n" + msg);
        return true;
    }
}
