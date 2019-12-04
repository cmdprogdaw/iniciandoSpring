package com.cris.iniciandoSpring.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasBasicas {

	@GetMapping("/")
	public String rutaInicial() {

		
		return "index";
	}
}
