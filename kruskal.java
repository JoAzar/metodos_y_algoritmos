//KRUSKAL CON UNION FIND
//contiene clase anónima Comparator (lambda) y path compression

public class Kruskal {

	  public static Set<Arista> obtenerAGM(GrafoNoDirigidoPonderado grafo) {
	    Set<Arista> mst = new HashSet<>();
	    List<Arista> aristas = new ArrayList<>();

	    //RECOLECTAR TODAS LAS ARISTAS SIN DUPLICADO
	    for(int i = 0; i < grafo.tamanio(); i++) {
	      for(int j : grafo.vecinos(i)) {
	        if(i < j) {
	          aristas.add(new Arista(i, j, grafo.obtenerPesoArista(i, j)));
	        }
	      }
	    }

	    //ORDENA LAS ARISTAS POR PESO (INT) USANDO LAMBDA (CLASE ANÓNIMA COMPARATOR)
	    Collections.sort(aristas, Comparator.comparingInt(a -> a.obtenerPeso()));
	    UnionFindClass unionFind = new UnionFindClass(grafo.tamanio());

	    //DEFINICION DE UNION FIND DE LA TEORÍA
	    //Si los nodos no están conectados, se agrega la arista al árbol y se unen los conjuntos 
	    //Si ya están conectados, se ignora para evitar ciclos
	    for(Arista arista : aristas) {
	      if(unionFind.find(arista.obtenerOrigen()) != unionFind.find(arista.obtenerDestino())) {
	        unionFind.union(arista.obtenerOrigen(), arista.obtenerDestino());
	        mst.add(arista);
	      }
	    }
	    return mst;
	  }

	  static class UnionFindClass {
	    int[] parent, rank;

	    UnionFindClass(int nodo) {
	      parent = new int[nodo];
	      rank = new int[nodo];
	      for (int i = 0; i < nodo; i++) {
	        parent[i] = i;
	        rank[i] = 0;
	      }
	    }

	    //DEVUELVE EL PADRE DEL CONJUNTO, ES UN MÉTODO RECURSIVO, USA PATH COMPRESSION (abajo lo aclaro)
	    
	    //Por qué usar path compression
	    //Al buscar el representante de un nodo, subimos por la cadena de padres hasta la raíz
	    //Si el árbol es alto, esto puede ser lento, porque recorremos muchos nodos
	    //El path compression aprovecha la recursividad y el comportamiento de la pila de llamadas para "aplanar" el árbol
	    
	    int find(int x) {
	      if(parent[x] != x) {
	        parent[x] = find(parent[x]);
	      }
	      return parent[x];
	    }

	    
	    //Une dos conjuntos X e Y (por algo se llama unión aunque no sea la union convencional)
	    void union(int x, int y) {
	      int rootX = find(x); //busca la raiz del conjunto X
	      int rootY = find(y); //busca la raiz del conjunto Y

	      if (rootX != rootY) {	//verifica que esten en conjuntos distintos
	        if (rank[rootX] > rank[rootY]) { //el menor apunta al mayor
	          parent[rootY] = rootX; //acá lo apunta
	        } else if (rank[rootX] < rank[rootY]) {	//el menor apunta al mayor
	          parent[rootX] = rootY; //acá lo apunta
	        } else {	//sino
	          parent[rootY] = rootX; //si no es menor y hay dos mayores del mismo tamaño entonces se resuelve elevando el rango de uno, para que respete los rangos
	          rank[rootX]++;
	        }
	      }
	    }
	  }
	}
