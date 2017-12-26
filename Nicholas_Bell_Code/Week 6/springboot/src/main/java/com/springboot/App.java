package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Indicates a 
 * {@link Configuration configuration} class that declares one or more {@link Bean @Bean} methods 
 * 
 * and also triggers {@link EnableAutoConfiguration auto-configuration} and {@link ComponentScan component scanning}. 
 * This is a convenience annotation that is equivalent to declaring {@code @Configuration}, {@code @EnableAutoConfiguration} and {@code @ComponentScan}.
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
