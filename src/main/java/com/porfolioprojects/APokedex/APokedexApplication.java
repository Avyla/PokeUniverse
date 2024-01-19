package com.porfolioprojects.APokedex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class APokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(APokedexApplication.class, args);
	}

}
