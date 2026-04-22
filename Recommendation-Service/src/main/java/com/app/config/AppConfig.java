package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   // setup
public class AppConfig {

    @Bean // to create objects and manage
    public RestTemplate restTemplate() {  //
        return new RestTemplate();
    }
}// resttemplate = to call api external call another microservices here we can use it anywhere to call its object