package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;


public class Graph <Trayecto> {
	private List<Edge<Ruta>> edges;
	private List<Vertex<Estacion>> vertexs;

	public Graph(){
		this.edges = new ArrayList<Edge<Ruta>>();
		this.vertexs = new ArrayList<Vertex<Estacion>>();
	}
	

	public Graph<Trayecto> addNodo(Estacion nodo){
		 this.addNodo(new Vertex<Estacion>(nodo));
		 return this;
	}

	private void addNodo(Vertex<Estacion> nodo){
		this.vertexs.add(nodo);
	}
	
	public Graph<Trayecto> conectar(Estacion n1,Estacion n2){
		this.conectar(getNodo(n1), getNodo(n2), 1.0);
		return this;
	}

	public Graph<Trayecto> conectar(Estacion n1,Estacion n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
		return this;
	}

	private void conectar(Vertex<Estacion> nodo1,Vertex<Estacion> nodo2,Number valor){
		this.edges.add(new Edge<Ruta>(nodo1,nodo2,valor));
	}
	
	public Vertex<Estacion> getNodo(Estacion valor){
		return this.vertexs.get(this.vertexs.indexOf(new Vertex<Estacion>(valor)));
	}

	public List<Estacion> getNeighbourhood(Estacion valor){ 
		Vertex<Estacion> unNodo = this.getNodo(valor);
		List<Estacion> salida = new ArrayList<Estacion>();
		for(Edge<Ruta> enlace : this.edges){
			if( enlace.getOrigin().equals(unNodo)){
				salida.add(enlace.getEnd().getValue());
			}
		}
		return salida;
	}
	
	private List<Vertex<Estacion>> getNeighbourhood(Vertex<Estacion> unNodo){ 
		List<Vertex<Estacion>> salida = new ArrayList<Vertex<Estacion>>();
		for(Edge<Ruta> enlace : this.edges){
			if( enlace.getOrigin().equals(unNodo)){
				salida.add(enlace.getEnd());
			}
		}
		return salida;
	}
	
	public void printEdges(){
		System.out.println(this.edges.toString());
	}

	public Integer gradoEntrada(Vertex<Estacion> vertice){
		Integer res =0;
		for(Edge<Ruta> arista : this.edges){
			if(arista.getEnd().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertex<Estacion> vertice){
		Integer res =0;
		for(Edge<Ruta> arista : this.edges){
			if(arista.getOrigin().equals(vertice)) ++res;
		}
		return res;
	}
	
    protected Edge<Ruta> findEdge(Estacion v1, Estacion v2){
    	return this.findEdge(new Vertex<Estacion>(v1), new Vertex<Estacion>(v2));
    }

    private boolean isAdjacent(Vertex<Estacion> v1,Vertex<Estacion> v2){
    	List<Vertex<Estacion>> ady = this.getNeighbourhood(v1);
    	for(Vertex<Estacion> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
      	}
        return false;
    }
   
    protected Edge<Ruta> findEdge(Vertex<Estacion> v1, Vertex<Estacion> v2){
    	for(Edge<Ruta> unaArista : this.edges) {
    		
    		if(unaArista.getOrigin().equals(v1) && unaArista.getEnd().equals(v2)) return unaArista;
    	}
    	return null;
    }

	public List<Estacion> bfs(Vertex<Estacion> inicio){ // Busqueda a lo ancho
		List<Estacion> resultado = new ArrayList<Estacion>();
		//estructuras auxiliares
		Queue<Vertex<Estacion>> pendientes = new LinkedList<Vertex<Estacion>>();
		HashSet<Vertex<Estacion>> marcados = new HashSet<Vertex<Estacion>>();
		marcados.add(inicio);
		pendientes.add(inicio);
		
		while(!pendientes.isEmpty()){
			Vertex<Estacion> actual = pendientes.poll();
			List<Vertex<Estacion>> adyacentes = this.getNeighbourhood(actual);
			resultado.add(actual.getValue());
			for(Vertex<Estacion> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
	
	public List<Estacion> dfs(Vertex<Estacion> inicio){ // Busqueda en profundidad
		List<Estacion> resultado = new ArrayList<Estacion>();
		Stack<Vertex<Estacion>> pendientes = new Stack<Vertex<Estacion>>();
		HashSet<Vertex<Estacion>> marcados = new HashSet<Vertex<Estacion>>();
		marcados.add(inicio);
		pendientes.push(inicio);
		
		while(!pendientes.isEmpty()){
			Vertex<Estacion> actual = pendientes.pop();
			List<Vertex<Estacion>> adyacentes = this.getNeighbourhood(actual);
			resultado.add(actual.getValue());
			for(Vertex<Estacion> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
 	
	public List<Estacion> topological(){
		List<Estacion> resultado = new ArrayList<Estacion>();
		Map<Vertex<Estacion>,Integer> gradosVertex = new HashMap<Vertex<Estacion>,Integer>();
		for(Vertex<Estacion> vert : this.vertexs){
			gradosVertex.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertex.isEmpty()){
		
			List<Vertex<Estacion>> nodosSinEntradas = gradosVertex.entrySet()
							.stream()
							.filter( x -> x.getValue()==0)
							.map( p -> p.getKey())
							.collect( Collectors.toList());
			
            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");
            
			for(Vertex<Estacion> v : nodosSinEntradas){
            	resultado.add(v.getValue());
            	gradosVertex.remove(v);
            	for(Vertex<Estacion> ady: this.getNeighbourhood(v)){
            		gradosVertex.put(ady,gradosVertex.get(ady)-1);
            	}
            }
		}
		
		System.out.println(resultado);
		return resultado;
 	}
    
    public List<List<Vertex<Estacion>>> paths(Estacion v1,Estacion v2){
    	return this.paths(new Vertex(v1), new Vertex(v2));
    }
    
    public List<List<Vertex<Estacion>>> paths(Vertex<Estacion> v1,Vertex<Estacion> v2){
    	List<List<Vertex<Estacion>>>salida = new ArrayList<List<Vertex<Estacion>>>();
    	List<Vertex<Estacion>>visitados = new ArrayList<Vertex<Estacion>>();
    	visitados.add(v1);
    	findPathAux(v1, v2, visitados, salida);
    	return salida;
    }

    private void findPathAux(Vertex<Estacion> v1,Vertex<Estacion> v2, List<Vertex<Estacion>> visitados, List<List<Vertex<Estacion>>> todosLosCaminos) {
    	List<Vertex<Estacion>> adyacentes = this.getNeighbourhood(v1);
    	List<Vertex<Estacion>> copiaVisitados = null;
    	
    	for(Vertex<Estacion> ad : adyacentes) {
			copiaVisitados = visitados.stream().collect(Collectors.toList());
			copiaVisitados.add(ad);

    		if(ad.equals(v2)) {
        		visitados.add(ad);
    			//encontramos un camino
        		todosLosCaminos.add(new ArrayList<Vertex<Estacion>>(copiaVisitados));
    			//todos es el array de caminos
    			//si el camino es correcto, mandamos 
    			//un arraylist de los caminos, una copia
    			System.out.println("Camino!: " +copiaVisitados.toString());
    		}
    		else {
    			if(! visitados.contains(ad)) {
    			this.findPathAux(ad, v2, visitados, todosLosCaminos);
    			}
    		}
    	}
    	
    	
    }
    
    public void floydWarshall() {
    	int cantVertexs= this.vertexs.size();
    	int[][] matrizDistancias = new int[cantVertexs][cantVertexs];
    	
    	for(int i=0; i<cantVertexs;i++) {
        	for(int j=0; j<cantVertexs;j++) {
        		if(i== j) {
            		matrizDistancias[i][j] = 0;        			
        		}else {
	        		Edge<Ruta> arista = this.findEdge(this.vertexs.get(i), this.vertexs.get(j));
	        		if(arista!=null) {
	            		matrizDistancias[i][j] = arista.getValue().intValue();        			
	        		} else {
	            		matrizDistancias[i][j] = 9999;        			
	        		}
        		}
        	}    		
    	}
    	printMatrix(matrizDistancias);
    	
    	for (int k = 0; k < cantVertexs; k++) 
        { 
            // Pick all vertices as source one by one 
            for (int i = 0; i < cantVertexs; i++) 
            { 
                // Pick all vertices as destination for the 
                // above picked source 
                for (int j = 0; j < cantVertexs; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (matrizDistancias[i][k] + matrizDistancias[k][j] < matrizDistancias[i][j]) 
                    	matrizDistancias[i][j] = matrizDistancias[i][k] + matrizDistancias[k][j]; 
                } 
            } 
            System.out.println("MATRIZ "+k);
            printMatrix(matrizDistancias);
        } 
    	
    }
    
    public void printMatrix(int[][] m) {
    	for(int i=0; i<m.length;i++) {
    		System.out.print("[ ");
        	for(int j=0; j<m[i].length;j++) {
        		System.out.print(i+":"+j+" = "+m[i][j]+ ",   ");
        	}
        	System.out.println(" ]");
    	}
    	
    	

    }
    
    public Boolean pathExistsIterative(Vertex<Estacion> v1, Vertex<Estacion> v2, Integer n) {
		HashSet<Vertex<Estacion>> visitados = new HashSet<>();
		Queue<Vertex<Estacion>> aProcesar = new LinkedList<>();
		visitados.add(v1);
		while(!aProcesar.isEmpty()) {
			n--;
			if(n==0) return false;
			Vertex<Estacion> vertice = aProcesar.poll();
			if(vertice.equals(v1)) return true;
			List<Vertex<Estacion>> vecinos = getNeighbourhood(vertice);
			for(Vertex<Estacion> vecino : vecinos) {
				visitados.add(vecino);
				aProcesar.add(vecino);
			}
		}
    	//TODO
    	return false;
    }
    
   public Boolean pathExistsRecursive(Vertex<Estacion> v1, Vertex<Estacion> v2, Integer n) {
    	// TODO
    	return pathExistsRecursive(v1,v2,n,new HashSet<>());
    }
    
    private Boolean pathExistsRecursive(Vertex<Estacion> v1, Vertex<Estacion> v2, Integer n, HashSet<Vertex<Estacion>> visitados) {
		if(n == 0) return false;
		visitados.add(v1);
		List<Vertex<Estacion>> vecinos = getNeighbourhood(v1);
		for(Vertex<Estacion> vecino : vecinos) if(!visitados.contains(vecino)) {
			if(vecino.equals(v2)) return true;
			if(pathExistsRecursive(vecino, v2, n - 1, visitados)) return true;
		}
		return false;
	}
    
    
}