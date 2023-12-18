package com.teamkeygen.usuariosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsuariosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApiApplication.class, args);
	}
	// primer commit

}
