package Dominio;

public class Ruta {

		private Integer id;
		private Estacion origen;
		private Estacion destino;
		private Integer distanciaKm;
		private Integer duracionMin;
		private Integer capacidad;
		private EstadoRuta estado;
		private Double costo;

	
		public Ruta(Integer id, Estacion origen, Estacion destino, Integer dis, Integer dur, Integer cap, EstadoRuta est, Double costo){
			this.id = id;
			this.origen = origen;
			this.destino = destino;
			this.distanciaKm = dis;
			this.duracionMin = dur;
			this.capacidad = cap;
			this.estado = est;
			this.costo = costo;
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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
		public Integer getDistanciaKm() {
			return distanciaKm;
		}
		public void setDistanciaKm(Integer distanciaKm) {
			this.distanciaKm = distanciaKm;
		}
		public Integer getDuracionMin() {
			return duracionMin;
		}
		public void setDuracionMin(Integer duracionMin) {
			this.duracionMin = duracionMin;
		}
		public Integer getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(Integer capacidad) {
			this.capacidad = capacidad;
		}
		public EstadoRuta getEstado() {
			return estado;
		}
		public void setEstado(EstadoRuta estado) {
			this.estado = estado;
		}
		public Double getCosto() {
			return costo;
		}
		public void setCosto(Double costo) {
			this.costo = costo;
		}

		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((origen == null) ? 0 : origen.hashCode());
			result = prime * result + ((destino == null) ? 0 : destino.hashCode());
			result = prime * result + ((id == null) ? 0 : id.intValue());
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
			Ruta other = (Ruta) obj;
			if (destino == null) {
				if (other.destino != null)
					return false;
			} else if (!destino.equals(other.destino))
				return false;
			if (origen == null) {
				if (other.origen != null)
					return false;
			} else if (!origen.equals(other.origen))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
			}

