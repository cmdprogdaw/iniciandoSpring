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

	
	
	@Bean
	public Autor cris() {
		
		Autor persona1 = new Autor();
		persona1.setNombre("Cris");
		persona1.setEdad(18);
		
		return persona1;		
	}
	
	
	@Bean 
	public Autor marcos() {
		
		Autor persona1 = new Autor();
		persona1.setNombre("Marcos");
		persona1.setEdad(28);
		
		return persona1;		
	}
}
