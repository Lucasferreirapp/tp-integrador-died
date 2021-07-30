package Dominio;

import Ventanas.EstadoLinea;

public class Linea {

	private String nombre;
	private String color;
	private EstadoLinea estado;
	
	public Linea(String nom, String col) {
		this.nombre = nom;
		this.color = col;
		this.estado = EstadoLinea.Activa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public EstadoLinea getEstado() {
		return estado;
	}

	public void setEstado(EstadoLinea estado) {
		this.estado = estado;
	}
	
	
}
