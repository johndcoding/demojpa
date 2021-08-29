package com.johndcoding.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemojpaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

//        new DemojpaApplication().configure(new SpringApplicationBuilder(DemojpaApplication.class))
//                        .run(args);

        SpringApplication.run(DemojpaApplication.class, args);
    }

}
