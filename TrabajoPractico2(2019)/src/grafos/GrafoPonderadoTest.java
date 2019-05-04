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
		assertThrows(IllegalArgumentException.class, () -> _grafo.agregarArco(2, 2, -1));
	}
	
	@Test
	public void verificarPosicionXNegativaTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArco(-1, 2, 5));
	}

	@Test
	public void verificarPosicionXTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArco(6, 2, 5));
	}
	
	@Test
	public void verificarPosicionYNegativaTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArco(2, -1, 5));
	}

	@Test
	public void verificarPosicionYTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IndexOutOfBoundsException.class, () -> _grafo.agregarArco(2, 6, 5));
	}
	
	@Test
	public void verificarAristaTest()
	{
		_grafo = new GrafoPonderado(5);
		assertThrows(IllegalArgumentException.class, () -> _grafo.agregarArco(1, 1, 5));
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
		_grafo.agregarArco(1, 2, 50);
		assertEquals(_grafo.obtenerPeso(1, 2), 50);
	}
	
	@Test
	public void agergarAristaInversaTest()
	{
		_grafo = new GrafoPonderado(5);
		_grafo.agregarArco(1, 2, 50);
		assertEquals(_grafo.obtenerPeso(2, 1), 50);
	}
	
	@Test
	public void obtenerTamañoTest()
	{
		_grafo = new GrafoPonderado(5);
		assertEquals(_grafo.obtenerTamaño(), 5);
	}
	
	@Test
	public void agregarVerticeTest()
	{
		_grafo = new GrafoPonderado(5);
		_grafo.agregarArco(0, 1, 5);
		_grafo.agregarArco(4, 3, 100);
		_grafo.agergarVertice();
		assertTrue(_grafo.obtenerPeso(3, 4) == 100 && _grafo.obtenerPeso(1, 0) == 5);
	}
	
	@Test
	public void agregarVerticeTest2()
	{
		_grafo = new GrafoPonderado(5);
		_grafo.agergarVertice();
		assertTrue(_grafo.obtenerTamaño() == 6);
	}
	
	@Test
	public void obtenerArcosTest()
	{
		_grafo = new GrafoPonderado(5);
		_grafo.agregarArco(0, 1, 5);
		_grafo.agregarArco(2, 3, 15);
		_grafo.agregarArco(4, 3, 25);
		String esperado = "[(0, 1, 5), (2, 3, 15), (4, 3, 25)]";
		assertEquals(_grafo.obtenerArcos().toString(), esperado);
	}
}
