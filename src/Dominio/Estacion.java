package Dominio;

import java.sql.Time;

import Ventanas.EstadoEstacion;

public class Estacion {

		private Integer id;
		private String nombre;
		private String apertura;
		private String cierre;
		private EstadoEstacion estado;
		
		public Estacion() {}
		 
		public Estacion(Integer id, String nom, String ap, String cie){
			this.id = id;
			this.nombre = nom;
			this.apertura = ap;
			this.cierre = cie;
			this.estado = EstadoEstacion.Operativa;
		}
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApertura() {
			return apertura;
		}
		public void setApertura(String apertura) {
			this.apertura = apertura;
		}
		public String getCierre() {
			return cierre;
		}
		public void setCierre(String cierre) {
			this.cierre = cierre;
		}
		public EstadoEstacion getEstado() {
			return estado;
		}
		public void setEstado(EstadoEstacion estado) {
			this.estado = estado;
		}
		
	}
