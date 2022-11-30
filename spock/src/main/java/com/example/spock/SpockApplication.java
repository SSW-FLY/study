package com.example.spock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpockApplication.class, args);
    }

}
