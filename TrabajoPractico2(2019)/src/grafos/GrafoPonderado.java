package grafos;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import agentes.Agente;
import formulas.Haversine;

public class GrafoPonderado 
{
	
	private int[][] _grafo;
	private ArrayList<Arco> _arcos;
	
	public GrafoPonderado(int vertices)
	{
		verificarVerticeConstructor(vertices);
		_grafo = new int[vertices][vertices];
		_arcos = new ArrayList<Arco>();
	}
	//TODO: testealo
	public void agergarVertice()
	{
		int[][] nuevo = new int[obtenerTamaño()+1][obtenerTamaño()+1];
		for(int i = 0; i < obtenerTamaño(); i++)
		{
			for(int j = 0; j < obtenerTamaño(); j++)
			{
				nuevo[i][j] = obtenerPeso(i,j);
			}
		}
		_grafo = nuevo;
	}
	
	public void agregarArco(int posicionX, int posicionY, int peso)
	{
		verificarPeso(peso);
		verificarPosiciones(posicionX, posicionY);
		verificarBucle(posicionX, posicionY);
		_grafo[posicionX][posicionY] = peso;
		_grafo[posicionY][posicionX] = peso;
		_arcos.add(new Arco(posicionX, posicionY, peso));
	}
	//TODO: este metodo hace ruido... falta testearlo tambien
	public void generarGrafoCompleto(ArrayList<Agente> agentes)
	{
		for(int i = 0; i < agentes.size(); i++)
		{
			for(int j = (i+1); j < agentes.size(); j++)
			{
				Coordinate ubicacionOrigen = agentes.get(i).obtenerubicacion();
				Coordinate ubicacionDestino = agentes.get(j).obtenerubicacion();
				int distancia = (int) Haversine.obtenerDistanciaEnKm(ubicacionOrigen, ubicacionDestino);
				agregarArco(i, j, distancia);
			}
		}
	}
	
	public int obtenerPeso(int posicionX, int posicionY)
	{
		return _grafo[posicionX][posicionY];
	}
	
	public ArrayList<Arco> obtenerArcos()
	{
		return _arcos;
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
				int distancia = obtenerPeso(i,j);
				if(distancia != 0)
				{
					ret.append("(" + (i) + ", " + (j) + ", "+ obtenerPeso(i,j) +")");
				}
			}
		}
		
		return ret.toString();
	}
}
