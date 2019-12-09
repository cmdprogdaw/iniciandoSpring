package com.cris.iniciandoSpring.rutas;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.iniciandoSpring.beans.Autor;
import com.cris.iniciandoSpring.beans.Coche;
import com.cris.iniciandoSpring.beans.ListaAutores;
import com.cris.iniciandoSpring.beans.ListaCoches;

/*habilitada para ser del grupo que recibe peticiones*/
@Controller  
//esta clase que reune los requisitos va a ser un controlador, le voy a poner rutas y va a poder atenderlas
public class RutasAutores {

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
	
	
	private ListaAutores listaAutores = ListaAutores.getLista();
	private ListaCoches listaCoches = ListaCoches.getLista();
	
	
	/*
	 * *******************************
	 * *******************************
	 * L I S T A N D O   A U T O R E S
	 * *******************************
	 * *******************************
	 */
	@GetMapping("/autores")
	public ModelAndView rutaAutores() {
		
		//todo va junto, devuelve un 'paquete' donde esta todo, cosa que no pasa con Model o ModelMap
		ModelAndView model = new ModelAndView();
		model.setViewName("autor/autores");
		model.addObject("coches", listaCoches.getDatos());
		model.addObject("autores",listaAutores.getDatos());
		
		return model;
	}
	
	
	
	/*
	 * **************************
	 * **************************
	 * D E T A L L E    A U T O R
	 * **************************
	 * **************************
	 */
	@GetMapping("/autores/{id}")
	public String verAutor(	@PathVariable Integer id, 
							Model model) {
		
		Autor autor = listaAutores.getAutor(id);
		model.addAttribute("autor", autor);
		
		return "autor/detalleAutor";
	}
	
	
	
	
	/*
	 * ***********************************
	 * ***********************************
	 * E L I M I N A N D O   A U T O R E S
	 * ***********************************
	 * ***********************************
	 */

	@GetMapping("/eliminarAutor/{id}")
	public String getEliminarAutor(@PathVariable Integer id, 
								Model model) {
		
		listaAutores.del(id);
		
		/*
		 * Me lo curro yo
		 * 
		 * model.addAttribute("autores",lista.getDatos());
		 * return "hola";
		 */
	
		//le digo al controlador que quiero que vaya a otra ruta (me aprovecho)
		return("redirect:/autores");
	}
	
	//postman
	@DeleteMapping("/autor/{id}")
	public String eliminarAutor(@PathVariable Integer id, 
								Model model) {
		
		listaAutores.del(id);
		
		return("200");
	}
	
	
	
	/*
	 * **********************************
	 * **********************************
	 * A Ñ A D I E N D O    A U T O R E S
	 * **********************************
	 * **********************************
	 */
	@GetMapping("/nuevoAutor")
	public String nuevoAutor(Model model) {
		
		
		model.addAttribute("coches", listaCoches.getDatos());
		model.addAttribute("autor",new Autor()); // coloco en el modelo un atributo que es el nuevo autor para que se rellene
		
		return "autor/nuevoAutor"; //html del formulario nuevo autor
	}

	
	@PostMapping("/addAutor")
	public String addAutor(@ModelAttribute Autor autor) { //me llega el autor que colé antes
		
		listaAutores.addAutor(autor);
		
		return "redirect:/autores"; //redirect va a una ruta
	}
	
	
	
	
	/*
	 * ****************************
	 * ****************************
	 * E D I T A R    A U T O R E S
	 * ****************************
	 * ****************************
	 */
	@GetMapping("/editarAutor/{id}")
	public String editarAutor(@PathVariable Integer id,
							  Model model) {
		
		
		model.addAttribute("coches", listaCoches.getDatos());
		
		Autor autor = listaAutores.getAutor(id);
		model.addAttribute("autor", autor); 
		
		return "/autor/editarAutor"; 
	}

	
	@PostMapping("/updateAutor")
	public String updateAutor(@ModelAttribute Autor autor) {
		
		listaAutores.updateAutor(autor);
		
		return "redirect:/autores";
	}
	
	
	
	/*
	private ArrayList<Coche> crearListaCoches() {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		Coche volvo = new Coche();
		volvo.setId(1);
		volvo.setMarca("Volvo");
		
		Coche ford = new Coche();
		ford.setId(2);
		ford.setMarca("Ford");
		
		listaCoches.add(volvo);
		listaCoches.add(ford);
		return listaCoches;
	}
	*/
	
	
	
	/*
	//espero un parametro a traves de una peticion (localhost:9090/comienzo?id=5) o (http://localhost:9090/comienzo?id=777&nombre=cris)
	//es solo una ruta (se puede variar el orden
	@GetMapping("/comienzo")
	public String rutaCero( @RequestParam(required=false) Integer id, 
					       	@RequestParam(required=false) String nombre) { 
		
		System.out.println("id: "+id);
		System.out.println("nombre: "+nombre);
		
		return "cero";
	}
	 */
}
