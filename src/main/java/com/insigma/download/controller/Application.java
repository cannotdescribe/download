package com.insigma.download.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages={"com.insigma.download.controller"})
@ComponentScan(basePackages={"com.insigma.download.controller.file"})
@ComponentScan(basePackages={"com.insigma.download.service"})
@RestController
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
}
