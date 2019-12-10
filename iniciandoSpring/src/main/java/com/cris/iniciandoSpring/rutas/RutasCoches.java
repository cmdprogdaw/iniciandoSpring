package com.cris.iniciandoSpring.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.iniciandoSpring.beans.Coche;
import com.cris.iniciandoSpring.beans.ListaCoches;

@Controller
public class RutasCoches {

	private ListaCoches listaCoches = ListaCoches.getLista();
	
	
	
	/*
	 * *******************************
	 * *******************************
	 * L I S T A N D O   C O C H E S
	 * *******************************
	 * *******************************
	 */
	@GetMapping("/coches")
	public ModelAndView rutaCoches() {
	
		
		ModelAndView model = new ModelAndView();
		model.setViewName("coche/coches");
		model.addObject("coches", listaCoches.getDatos());
		model.addObject("coche",new Coche()); //esto es para poder crear un nuevo coche
		
		return model;
	}
	
	
	
	
	/*
	 * **********************************
	 * **********************************
	 * A Ñ A D I E N D O    C O C H E S
	 * **********************************
	 * **********************************
	 */
	@PostMapping("/addCoche")
	public String addCoche(@ModelAttribute Coche coche) {
		
		listaCoches.addCoche(coche);
		
		return "redirect:/coches";
	}
	
	
	
	
	/*
	 * **************************
	 * **************************
	 * D E T A L L E    C O C H E
	 * **************************
	 * **************************
	 */
	@GetMapping("/coches/{id}")
	public String verAutor(	@PathVariable Integer id, 
							Model model) {
		
		Coche coche = listaCoches.getCoche(id);
		model.addAttribute("coche", coche);
		
		return "coche/detalleCoche";
	}
	
	
	
	
	/*
	 * ***********************************
	 * ***********************************
	 * E L I M I N A N D O     C O C H E S
	 * ***********************************
	 * ***********************************
	 */

	@GetMapping("/eliminarCoche/{id}")
	public String getEliminarCoche(@PathVariable Integer id, 
								Model model) {
		
		listaCoches.del(id);
		
		return("redirect:/coches");
	}
	
	
	
	
	/*
	 * ****************************
	 * ****************************
	 * E D I T A R     C O C H E S
	 * ****************************
	 * ****************************
	 */
	@GetMapping("/editarCoche/{id}")
	public String editarAutor(@PathVariable Integer id,
							  Model model) {
		
		
		Coche coche = listaCoches.getCoche(id);
		model.addAttribute("coche", coche); 
		
		return "/coche/editarCoche"; 
	}

	
	@PostMapping("/updateCoche")
	public String updateCoche(@ModelAttribute Coche coche) {
		
		listaCoches.updateCoche(coche);
		
		return "redirect:/coches";
	}
}
