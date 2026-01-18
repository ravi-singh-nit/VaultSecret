package com.sammu.learning.springbootDemo.mongo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MongoTestConfig {
    @Bean
    CommandLineRunner testMongo(UserRepository repo) {
        System.out.println("creating on document");
        return args -> {
            User user = new User(
                    "Ravi Singh",
                    "ravi@test.com",
                    30,
                    "ADMIN",
                    true
            );

            repo.save(user);

            repo.findAll().forEach(System.out::println);
        };
    }
}
