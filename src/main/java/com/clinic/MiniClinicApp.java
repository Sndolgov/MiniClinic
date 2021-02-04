package com.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MiniClinicApp
{
    public static void main(String[] args) {
        SpringApplication.run(MiniClinicApp.class, args);
    }
}
