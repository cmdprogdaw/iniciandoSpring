package com.cris.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.List;

import com.cris.iniciandoSpring.beans.Autor;
import com.cris.iniciandoSpring.beans.ListaAutores;

public class ListaAutores {

	private static ArrayList<Autor> lista = null;
	
	//es un singleton pq es private
	private ListaAutores(){
		
		lista = new ArrayList();
		
		Autor autor = new Autor();
		autor.setId(getIdNoRepetido());
		autor.setNombre("Ket Follet");
		autor.setEdad(70);
		autor.setEmail("kent@educastur.org");
		lista.add(autor);
		
		Autor autor2 = new Autor();
		autor2.setId(getIdNoRepetido());
		autor2.setNombre("JK Rowling");
		autor2.setEdad(58);
		autor2.setEmail("jk@educastur.org");
		lista.add(autor2);
		
		Autor autor3 = new Autor();
		autor3.setId(getIdNoRepetido());
		autor3.setNombre("Perez Reverte");
		autor3.setEdad(62);
		autor3.setEmail("arturo@educastur.org");
		lista.add(autor3);
		
		Autor autor4 = new Autor();
		autor3.setId(getIdNoRepetido());
		autor4.setNombre("Stephen King");
		autor4.setEdad(78);
		autor4.setEmail("king@educastur.org");
		lista.add(autor4);
		
	}
	
	
	/**
	 * Garantizo que lo que pretendo meter nuevo no se repita el id
	 * @return
	 */
	private int getIdNoRepetido() {
		
		int num = (int)(Math.random()*100)+1;
		
		//busco hasta que no lo encuentro
		while (buscarDondeEsta(num) != -1) {
			
			num = (int)(Math.random()*100)+1;
		}
		return num;
		
	}


	//singleton
	/**
	 * Devuleve a todos los autores
	 * @return
	 */
	public static List<Autor> getLista() {
		
		if(lista==null) {
			
			new ListaAutores();
		}
		
		return lista;
	}
	
	
	/**
	 * Devuelve un autor en concreto, si lo encuentra
	 * @param id
	 * @return
	 */
	public static Autor getAutor(int idBuscado) {
		
		//busco donde esta e el array
		int dondeEsta = buscarDondeEsta(idBuscado);
		
		//si devuelve una posicion valida
		if(dondeEsta>=0) {
			
			//lo devuelve
			return lista.get(dondeEsta);
		}
		else return null;
	}	
	
	
	
	
	/**
	 * Borra un objeto
	 * @param idBuscado
	 */
	public static void del(int idBuscado) {
		
		//pregunto si esta el id en concreto
		int dondeEsta = buscarDondeEsta(idBuscado);
		
		//si lo encuentra, lo borra
		if(dondeEsta>=0) {

			lista.remove(dondeEsta);
		}
	}
	
	

	/**
	 * 
	 * @param idBuscado
	 * @return posicion en el array donde se encuentra
	 */
	private static int buscarDondeEsta(int idBuscado) {
		
		//iniciamos con una bandera indicando que no esta encontrado
		boolean encontrado = false;
		
		int indice = 0;
		
		//mientras que no se encuentro y no llego al final
		while((!encontrado)&&(indice<lista.size())) {
			
			//lo voy buscando
			if(lista.get(indice).getId()==idBuscado) {
				
				encontrado = true;
			}
			//y si no aparece, avanzo
			else indice ++;
		}
		if(encontrado) return indice; else return -1;
	}	
	
}
