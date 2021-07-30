package Dominio;

public class Vertex<Estacion> {

	private Estacion estacion;
	
	public Vertex(){	}
	 
	public Vertex(Estacion est){
		this.estacion = est;
	}
	
	public void setValue(Estacion est){
		this.estacion = est;
	}
	
	public Estacion getValue(){
		return this.estacion;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estacion == null) ? 0 : estacion.hashCode());
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
		Vertex other = (Vertex) obj;
		if (estacion == null) {
			if (other.estacion != null)
				return false;
		} else if (!estacion.equals(other.estacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return estacion.toString();
	}
	
	
}
