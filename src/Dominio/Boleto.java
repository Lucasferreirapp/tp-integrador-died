package Dominio;

import java.sql.Date;

public class Boleto {

	private Integer nroBoleto;
	private String correo;
	private String nombre;
	private Date fecha;
	private Estacion origen;
	private Estacion destino;
	private Trayecto camino;
	private Double costo;
	
	public Boleto(Integer nro, String cor, String nom, Date f, Estacion ori, Estacion des, Trayecto tr, Double cos) {
		this.nroBoleto = nro;
		this.nombre = nom;
		this.correo = cor;
		this.fecha = f;
		this.origen = ori;
		this.destino = des;
		this.camino = tr;
		this.costo = cos;
	}

	public Integer getNroBoleto() {
		return nroBoleto;
	}

	public void setNroBoleto(Integer nroBoleto) {
		this.nroBoleto = nroBoleto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Estacion getOrigen() {
		return origen;
	}

	public void setOrigen(Estacion origen) {
		this.origen = origen;
	}

	public Estacion getDestino() {
		return destino;
	}

	public void setDestino(Estacion destino) {
		this.destino = destino;
	}

	public Trayecto getCamino() {
		return camino;
	}

	public void setCamino(Trayecto camino) {
		this.camino = camino;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
}
