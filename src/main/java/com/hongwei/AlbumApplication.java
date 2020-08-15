package com.hongwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// Deploy 1 - IntelliJ IDEA Debug
@SpringBootApplication
@EnableScheduling
public class AlbumApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlbumApplication.class, args);
    }
}

// Deploy 3 - deploy war to Tomcat/NGINX server
//@EntityScan
//@SpringBootApplication
//@EnableScheduling
//public class AlbumApplication extends SpringBootServletInitializer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(AlbumApplication.class, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(AlbumApplication.class);
//    }
//}
