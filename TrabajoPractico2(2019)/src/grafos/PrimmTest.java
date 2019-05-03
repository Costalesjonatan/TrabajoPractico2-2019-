package grafos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PrimmTest {
	 
	
	@Test
	public void obtenerMenosAristaTest() 
	{
		ArrayList<Arco> arcos = new ArrayList<Arco>();
		arcos.add(new Arco(0, 1, 100));
		arcos.add(new Arco(0, 3, 2));
		arcos.add(new Arco(1, 2, 1));
		
		assertEquals(arcos.get(2).toString(), Primm.dameMenorArista(arcos).toString());
	}
	
	
	@Test
	public void obtenerAgmTest()
	{
		GrafoPonderado grafo = new GrafoPonderado(3);
		grafo.agregarArista(0, 1, 100);
		grafo.agregarArista(0, 2, 2);
		grafo.agregarArista(1, 2, 1);
		
		GrafoPonderado esperado = new GrafoPonderado(3);
		esperado.agregarArista(0, 2, 2);
		esperado.agregarArista(1, 2, 1);
		
		assertEquals(Primm.generarAgm(grafo).toString(), esperado.toString());
		
	}
}
