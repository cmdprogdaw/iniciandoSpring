package com.cris.iniciandoSpring.beans;

import java.util.ArrayList;
import java.util.List;

public class ListaCoches {

	private ArrayList<Coche> lista = null;

	private static ListaCoches listaCoches = null;
	
	private ListaCoches() {
		
		lista = new ArrayList<Coche>();
	}
	
	
	/**
	 * Le pide a la lista de coches los datos y devuelve la lista
	 * @return
	 */
	public List<Coche> getDatos() {
		
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
	 * Devuelve un coche en concreto, si lo encuentra
	 * @param id
	 * @return
	 */
	public Coche getCoche(int idBuscado) {
		
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
	 * Añade un coche a la lista (a.k.a Modelo)
	 * 
	 * @param autor
	 */
	public void addCoche(Coche coche) {
		
		coche.setId(getIdNoRepetido()); //le pongo un id no repetido al coche
		lista.add(coche); //meto al coche en la lista
	}
	
	
	/**
	 * Actualiza un coche buscando primero su posicion en la lista
	 * 
	 * @param coche
	 */
	public void updateCoche(Coche coche) {
		
		int posicion = buscarDondeEsta(coche.getId());
		lista.set(posicion, coche);
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
	public static ListaCoches getLista() {
		
		//si el objeto no esta construido, lo construye
		if(listaCoches==null) {
			
			listaCoches = new ListaCoches();
		}
		
		return listaCoches;
	}
}
