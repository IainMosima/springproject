package com.javaproject;

import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class ApplicationConfiguration {
    public ApplicationConfiguration() {
        Dotenv.configure().load();
    }
}
