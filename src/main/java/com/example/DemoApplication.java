package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner printAll(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("All beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            for (String beanName : beanNames)
//                System.out.println(beanName);
//            System.out.println("Hello World");
//        	
//        };
//    }
//	
	@Bean
	public CommandLineRunner printMessage(HelloWorld component) {
        return args -> {
            component.setMessage("hello component");
            component.printMessage();
        };
    }
}
