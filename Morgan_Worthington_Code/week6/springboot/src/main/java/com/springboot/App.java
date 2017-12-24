package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication scans our project for
 * spring boot components and autowires beans
 * enables autoconfig
 * wraps commonly used annotations with spring boot
 *  sets up @Configuration - spring config on startup
 *  	classifies this Java class as a configuration for the spring context
 *  	- replaces xml config of spring apps
 * , @EnableAutoConfiguration - autoconfigures frameworks
 *   	- spring-boot specific annotation
 *   	- tells boot that if it finds any spring sub project
 *   		other spring compatible frameworks on the classpath,
 *   		that it should attempt to autoconfigure them and get
 *   		them wired up and integrated automatically with spring. 
 *, and @ComponentScan- scans project for spring components
 *= not written explicitly but comes with @SpringBootApplication
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
