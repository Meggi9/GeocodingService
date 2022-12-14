package com.magatella.geocogingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GeocogingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeocogingServiceApplication.class, args);
    }

}
