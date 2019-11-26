package com.cris.iniciandoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cris.iniciandoSpring.IniciandoSpringApplication;
import com.cris.iniciandoSpring.beans.Autor;

@SpringBootApplication
public class IniciandoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IniciandoSpringApplication.class, args);
	}

}
