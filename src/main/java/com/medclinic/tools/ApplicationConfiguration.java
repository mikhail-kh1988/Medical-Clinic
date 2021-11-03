package com.medclinic.tools;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(basePackages = "com.medclinic")
public class ApplicationConfiguration extends WebMvcConfigurationSupport {


}
