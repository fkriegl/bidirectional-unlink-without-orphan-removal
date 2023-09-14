package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@ComponentScan(basePackages = {
//        "com.example.so",
//        "com.example.so.model",
//        "com.example.so.configuration",
//        "com.example.so.repository",
//        "com.example.so.controller"
//})
public class BidirectionalUnlinkWithoutOrphanRemovalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BidirectionalUnlinkWithoutOrphanRemovalApplication.class, args);
        System.out.println("H2 console: http://localhost:8080/h2-console");
    }

}
