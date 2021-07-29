package Dominio;

import java.sql.Date;

public class Mantenimiento {

	private Integer id;
	private Date inicio;
	private Date fin;
	private String observaciones;
	
	public Mantenimiento(Integer id, Date inicio, Date fin, String observaciones) {
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.observaciones = observaciones;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	

}
