package com.example.authsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthSystemApplication {

    private final AuthController authController;

    AuthSystemApplication(AuthController authController) {
        this.authController = authController;
    }
    public static void main(String[] args) {
        SpringApplication.run(AuthSystemApplication.class, args);
        System.out.println("Success");
    }
}
