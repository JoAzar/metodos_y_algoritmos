# Método de la rejilla

## Una técnica simple pero eficaz para mantener relaciones de proximidad entre los puntos del plano consisten en contruir una rejilla imaginaria que divida la zona de búsqueda en pequeñas celdas y en mantener listas de pequeño tamaño de los puntos que están dentro de cada celda

### El método rejilla para la búsqueda por rango es lineal en el número de puntos del rango, por término medio, y lineal en el número total de puntos en el peor caso


```C++
class Rango {

	private:
		struct nodo {
			struct punto p; struct nodo *siguiente;
			};
		struct nodo *rejilla[MAXR][MAXR];
		struct nodo *z;
		public:
			Rango();
			void  insertar(struct punto p);
			int buscar(rect rango);
};

Rango::Rango() {
	int i, j;
	z = new nodo;
	for(i = 0; i <= MAXR; i++)
		for(j = 0; j <= MAXR; i++)
			rejilla[i][j];
}

void Rango::insertar() {
	struct nodo *t = new nodo;
	t->p = p;t-*siguiente = rejilla[p.x/talla][p.y/talla];
	rejilla[p.x/talla][p.y/talla] = t;
}

int Rango::buscar(struct rect rango) {
	struct nodo *t;
	int i,j, contador=0;
	for(i = rango.x1/talla; i <= rango.x2/talla; i++)
		for(j = rango.y1/talla; j <= rango.y2/talla; j++)
			for(t = rejilla[i][j]; t != z; t = t-*siguiente)
				if(dentro_rect(t->p, rango)) contador++;
	return contador;
}
 
```
