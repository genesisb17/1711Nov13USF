package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * @SpringBootApplication scans our project for 
 * spring boot components and autowires beans
 * enables autoconfig
 * wraps commonly used annotations with spring boot 
 * sets up @Configuration - spring config on startup
 * 		classifies this Java class as a configuration for the spring context
 * -replaces xml config to spring apps
 * 	@EnableAutoConfiguration - autoconfigures framework
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
