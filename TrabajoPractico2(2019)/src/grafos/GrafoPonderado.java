package grafos;

public class GrafoPonderado 
{
	
	private int[][] _grafo;
	
	public GrafoPonderado(int vertices)
	{
		verificarVerticeConstructor(vertices);
		_grafo = new int[vertices][vertices];
	}
	
	public void agregarArista(int posicionX, int posicionY, int peso)
	{
		verificarPeso(peso);
		verificarPosiciones(posicionX, posicionY);
		verificarBucle(posicionX, posicionY);
		_grafo[posicionX][posicionY] = peso;
		_grafo[posicionY][posicionX] = peso;
	}
	
	public int obtenerArista(int posicionX, int posicionY)
	{
		return _grafo[posicionX][posicionY];
	}
	
	private void verificarVerticeConstructor(int vertice)
	{
		if(vertice < 0)
		{
			throw new IllegalArgumentException("La cantidad de vertices no puede ser negativa");
		}
	}
	
	private void verificarVertice(int vertice)
	{
		if(vertice > obtenerTamaño()-1)
		{
			throw new IllegalArgumentException("El vertice especificado no existe." + vertice);
		}
	}
	
	private void verificarPosiciones(int posicionX, int posicionY)
	{
		if(posicionX < 0 || posicionX > obtenerTamaño()-1)
		{
			throw new IndexOutOfBoundsException("El vertice " + posicionX + " no existe");
		}
		if(posicionY < 0 || posicionY > obtenerTamaño()-1)
		{
			throw new IndexOutOfBoundsException("El vertice " + posicionY + " no existe");
		}
		
	}
	
	private void verificarBucle(int posicionX, int posicionY)
	{
		if(posicionX == posicionY)
		{
			throw new IllegalArgumentException("No son validos los bucles en los vertices.");
		}
	}
	
	private void verificarPeso(int peso)
	{
		if(peso < 0)
		{
			throw new IllegalArgumentException("No se le puede aplicar pesos negativos a las aristas.");
		}
	}
	
	public int[] obtenerVecinos(int vertice)
	{
		verificarVerticeConstructor(vertice);
		verificarVertice(vertice);
		return _grafo[vertice];
	}
	
	public int obtenerTamaño()
	{
		return _grafo.length;
	}
	
	public String toString()
	{
		StringBuilder ret = new StringBuilder();
		
		for(int i = 0; i < obtenerTamaño(); i++)
		{
			for(int j = i; j < obtenerTamaño(); j++)
			{
				int distancia = obtenerArista(i,j);
				if(distancia != 0)
				{
					ret.append("(" + (i) + ", " + (j) + ", "+ obtenerArista(i,j) +")");
				}
			}
		}
		
		return ret.toString();
	}
}
