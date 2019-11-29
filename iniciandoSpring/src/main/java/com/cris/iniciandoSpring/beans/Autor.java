package com.cris.iniciandoSpring.beans;

public class Autor {

	private int id;
	private String nombre;
	private Integer edad;
	private String email;
	private String coche;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCoche() {
		return coche;
	}
	public void setCoche(String coche) {
		this.coche = coche;
	}
	
	
	@Override
	public String toString() {
		return "Persona [("+id+") nombre=" + nombre + ", edad=" + edad + "]";
	}
		
}
