package com.cris.iniciandoSpring.rutas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cris.iniciandoSpring.beans.Autor;
import com.cris.iniciandoSpring.beans.ListaAutores;

/*habilitada para ser del grupo que recibe peticiones*/
@Controller  
//esta clase que reune los requisitos va a ser un controlador, le voy a poner rutas y va a poder atenderlas
public class RutasBasicas {

	//una ruta en el navegador pretendo que se convierta en un metodo
	//pretendo que coja las solicitudes de tipo get
	//@GetMapping("/start/{nombre}/{edad}") //a partir de /start con otra / vas a admitir cualquier otro valor (localhost:9090/start/cris/19
	//en una ruta siempre hay que devolver algo
//	public String rutaBasicaInicial(@PathVariable String nombre, 
//									@PathVariable Integer edad,
//									Model model) { //objeto que puedo colar y q si le añado parametros estos van a viajar a la plantilla html
//		//lo escribe en la consola porq es un syso xd
//		System.out.println("Alguien ha llegado al servidor");
//		System.out.println("te llamas: "+nombre);
//		System.out.println("tu edad es: "+edad);
//		model.addAttribute("nombre", nombre); //comunica el controlador con el html
//		model.addAttribute("edad", edad);
	@GetMapping("/")
	public String rutaBasicaInicial(Model model) {
	
		List<Autor> listaAutores = ListaAutores.getLista();
		model.addAttribute("autores",listaAutores);
		
		//va a buscar un fichero hola.html (solo ponemos el nombre) porque entiende que las vistas son ficheros .html
		return "hola";
	}
	
	
	
	
	
	@GetMapping("/autores/{id}")
	public String verAutor(	@PathVariable Integer id, 
							Model model) {
		
		Autor autor = ListaAutores.getAutor(id);
		model.addAttribute("autor", autor);
		
		return "autor";
	}
	
	
	@GetMapping("/eliminarAutor/{id}")
	public String eliminarAutor(@PathVariable Integer id, 
								Model model) {
		//decirle q queremos borrar
		ListaAutores.del(id);
		//coger la lista
		List<Autor> listaAutores = ListaAutores.getLista();
		model.addAttribute("autores",listaAutores);
	
		
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

}
