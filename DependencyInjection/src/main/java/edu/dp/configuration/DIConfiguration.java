package edu.dp.configuration;

import edu.dp.services.EmailService;
import edu.dp.services.IMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"edu.dp.consumer"})
public class DIConfiguration {

    @Bean
    public IMessageService getMessageService() {
        return new EmailService();
    }
}
