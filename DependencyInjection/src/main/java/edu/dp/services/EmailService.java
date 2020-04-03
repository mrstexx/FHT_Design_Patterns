package edu.dp.services;

public class EmailService implements IMessageService {
    @Override
    public boolean sendMessage(String msg, String receiver) {
        System.out.println("-----------------------------");
        System.out.println("Email sent to: " + receiver);
        System.out.println("Message: \n" + msg);
        System.out.println("-----------------------------");
        return true;
    }
}
