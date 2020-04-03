package edu.dp.consumer;

import edu.dp.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {

    private IMessageService service;

    @Autowired
    public void setService(IMessageService service) {
        this.service = service;
    }

    public boolean processMessage(String msg, String receiver) {
        return this.service.sendMessage(msg, receiver);
    }
}
