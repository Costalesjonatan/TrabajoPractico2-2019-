package grafos;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class GrafoPonderadoTest 
{
	private GrafoPonderado _grafo;

	@Test
	public void verticesNegativosTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> _grafo = new GrafoPonderado(-1));
	}
	
	@Test
	public void verificarPesoValidoTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IllegalArgumentException.class, () -> _grafo.agregarArista(2, 2, -1));
	}
	
	@Test
	public void verificarPosicionXNegativaTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArista(-1, 2, 5));
	}

	@Test
	public void verificarPosicionXTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArista(6, 2, 5));
	}
	
	@Test
	public void verificarPosicionYNegativaTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArista(2, -1, 5));
	}

	@Test
	public void verificarPosicionYTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArista(2, 6, 5));
	}
	
	@Test
	public void verificarAristaTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IllegalArgumentException.class, () -> _grafo.agregarArista(1, 1, 5));
	}
	
	@Test
	public void verificarVerticeObtenerVecinosTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IllegalArgumentException.class, () -> _grafo.obtenerVecinos(5));
	}
	
	@Test
	public void agergarAristaTest()
	{
		_grafo = new GrafoPonderado(5);
		_grafo.agregarArista(1, 2, 50);
		assertEquals(_grafo.obtenerArista(1, 2), 50);
	}
	
	@Test
	public void agergarAristaInversaTest()
	{
		_grafo = new GrafoPonderado(5);
		_grafo.agregarArista(1, 2, 50);
		assertEquals(_grafo.obtenerArista(2, 1), 50);
	}
	
	@Test
	public void obtenerTamañoTest()
	{
		_grafo = new GrafoPonderado(5);
		assertEquals(_grafo.obtenerTamaño(), 5);
	}
}
