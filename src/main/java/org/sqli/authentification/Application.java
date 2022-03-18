package org.sqli.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.service.AuthentificationService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run(@Autowired AuthentificationService authentificationService) {
        return args -> {
            System.out.println("RUN :)");
        };
    }
}
