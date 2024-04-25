package com.javaproject.springproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
    @Bean
    // @Qualifier
    // @Profile("dev")
    public MyFirstClass myFisrtClass() {
        return new MyFirstClass("from 1st bean (dev)");
    }

    @Bean
    public MyFirstClass mySecondClass() {
        return new MyFirstClass("from 2nd bean (test)");
    }

    @Bean
    // @Primary
    public MyFirstClass myThirdClass() {
        return new MyFirstClass("from 3rd bean (dev)");
    }
}
