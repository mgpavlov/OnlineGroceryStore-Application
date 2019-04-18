package org.softuni.onlinegrocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnlineGroceryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineGroceryApplication.class, args);
    }
}
