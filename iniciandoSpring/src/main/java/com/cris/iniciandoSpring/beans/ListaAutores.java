package com.cris.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.List;

import com.cris.iniciandoSpring.beans.Autor;
import com.cris.iniciandoSpring.beans.ListaAutores;

public class ListaAutores {

	private ArrayList<Autor> lista = null;

	private static ListaAutores listaAutores = null; //objeto de si misma dentro (singleton puro)
	
	
	private ListaAutores(){
		
		lista = new ArrayList<Autor>();
		
		/*
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
		*/
	}
	
	
	/**
	 * Le pide a la lista de autores los datos y devuelve la lista
	 * @return
	 */
	public List<Autor> getDatos() {
		
		return lista;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private int getIdNoRepetido() {
		
		int numero = (int)(Math.random()*100)+1;
		
		// busco hasta que no lo encuentro
		while(buscarDondeEsta(numero)>=0) {

			numero = (int)(Math.random()*100)+1;
		}
		return numero;
	}
	
	
	/**
	 * Devuelve un autor en concreto, si lo encuentra
	 * @param id
	 * @return
	 */
	public Autor getAutor(int idBuscado) {
		
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
	 * Añade un autor a la lista (a.k.a Modelo)
	 * 
	 * @param autor
	 */
	public void addAutor(Autor autor) {
		
		autor.setId(getIdNoRepetido()); //le pongo un id no repetido al autor
		lista.add(autor); //meto al autor en la lista
	}
	
	
	/**
	 * Actualiza un autor buscando primero su posicion en la lista
	 * 
	 * @param autor
	 */
	public void updateAutor(Autor autor) {
		
		int posicion = buscarDondeEsta(autor.getId());
		lista.set(posicion, autor);
	}
	
	
	/**
	 * Borra un objeto
	 * 
	 * @param idBuscado
	 */
	public void del(int idBuscado) {
		
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
	 * @return posición en el arrayList donde se encuentra
	 */
	private int buscarDondeEsta(int idBuscado) {
		
		// iniciamos con una bandera indicando que no está encontrado
		boolean encontrado = false;
		
		
		int indice = 0;
		// mientras que no se encuentra y no llego al final
		while((!encontrado)&&(indice<lista.size())) {
			
			// lo voy buscando
			if(lista.get(indice).getId()==idBuscado) {
				
				encontrado = true;
			}
			// y si no aparece, avanzo
			else indice ++;
		}
		if(encontrado) return indice; else return -1;
	}
	
	
	/**
	 * Petición del singleton
	 * @return
	 */
	public static ListaAutores getLista() {
		
		//si el objeto no esta construido, lo construye
		if(listaAutores==null) {
			
			listaAutores = new ListaAutores();
		}
		
		return listaAutores;
	}
	
}
