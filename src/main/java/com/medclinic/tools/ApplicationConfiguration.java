package com.medclinic.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(basePackages = "com.medclinic")
public class ApplicationConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public ObjectMapper getMapper(){
        return new ObjectMapper();
    }

}
