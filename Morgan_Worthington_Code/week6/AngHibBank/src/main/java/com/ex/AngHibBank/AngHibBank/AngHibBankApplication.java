package com.ex.AngHibBank.AngHibBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ex.respositories")
public class AngHibBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngHibBankApplication.class, args);
	}
}
