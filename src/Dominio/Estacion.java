package Dominio;

import java.sql.Time;

import Ventanas.EstadoEstacion;

public class Estacion {

		private Integer id;
		private String nombre;
		private String apertura;
		private String cierre;
		private String estado;
		
		public Estacion() {}
		 
		public Estacion(Integer id, String nom, String ap, String cie){
			this.id = id;
			this.nombre = nom;
			this.apertura = ap;
			this.cierre = cie;
			this.estado = "Operativa";
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
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Estacion other = (Estacion) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return id.toString();
		}
		
		
	}
