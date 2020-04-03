package edu.dp.di;

import edu.dp.configuration.DIConfiguration;
import edu.dp.consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hello, World!", "stefan.miljevic");

        // close context
        context.close();
    }
}
