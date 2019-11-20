package com.cris.iniciandoSpring.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/*habilitada para ser del grupo que recibe peticiones*/
@Controller  
//esta clase que reune los requisitos va a ser un controlador, le voy a poner rutas y va a poder atenderlas
public class RutasBasicas {

	//una ruta en el navegador pretendo que se convierta en un metodo
	//pretendo que coja las solicitudes de tipo get
	@GetMapping("/start/{nombre}/{edad}") //a partir de /start con otra / vas a admitir cualquier otro valor (localhost:9090/start/cris/19
	//en una ruta siempre hay que devolver algo
	public String rutaBasicaInicial(@PathVariable String nombre, 
									@PathVariable Integer edad,
									Model model) { //objeto que puedo colar y q si le añado parametros estos van a viajar a la plantilla html
//		//lo escribe en la consola porq es un syso xd
//		System.out.println("Alguien ha llegado al servidor");
//		System.out.println("te llamas: "+nombre);
//		System.out.println("tu edad es: "+edad);
		model.addAttribute("nombre", nombre); //comunica el controlador con el html
		model.addAttribute("edad", edad);
		
		//va a buscar un fichero hola.html (solo ponemos el nombre) porque entiende que las vistas son ficheros .html
		return "hola";
	}
	
	
	//espero un parametro a traves de una peticion (localhost:9090/comienzo?id=5) o (http://localhost:9090/comienzo?id=777&nombre=cris)
	//es solo una ruta (se puede variar el orden
	@GetMapping("/comienzo")
	public String rutaCero( @RequestParam(required=false) Integer id, 
					       	@RequestParam(required=false) String nombre) { 
		
		System.out.println("id: "+id);
		System.out.println("nombre: "+nombre);
		
		return "cero";
	}
	
	
	/*
	@GetMapping("/start/hola")
	public String rutaUno() {
		
		System.out.println("Otra vez llegaste a otra ruta");
		
		return "hola q tal";
	}
	
	
	@GetMapping("/start/hola/quetal")
	public String rutaDos() {
		
		System.out.println("Ya me hartoooo");
		
		return "que tal?";
	}
	
	@GetMapping("/start/adios")
	public String rutaTres() {
		
		System.out.println("Que te vaya bien");
		
		return "chao";
	}
	*/
}
