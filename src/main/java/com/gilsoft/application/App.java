package com.gilsoft.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = "com.gilsoft")
public class App {
    public static ApplicationContext ctx;
    public static void main(String[] args) {
        ctx = run(App.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
