package com.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = { "com.service.demo.client.*" })
@SpringBootApplication
@EnableEurekaClient
public class ServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemoApplication.class, args);
    }
}
