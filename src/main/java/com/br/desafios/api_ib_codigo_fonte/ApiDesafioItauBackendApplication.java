package com.br.desafios.api_ib_codigo_fonte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})public class ApiDesafioItauBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDesafioItauBackendApplication.class, args);
	}

}
