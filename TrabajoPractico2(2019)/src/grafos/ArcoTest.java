package grafos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArcoTest 
{

	private Arco _arco;
	
	@Test
	public void posicionXtest() 
	{
		_arco = new Arco(5, 1, 20);
		assertTrue(_arco.obtenerPosicionX() == 5);
	}
	
	@Test
	public void posicionYTest()
	{
		_arco = new Arco(5, 1, 20);
		assertTrue(_arco.obtenerPosicionY() == 1);
	}
	
	@Test
	public void pesoTest()
	{
		_arco = new Arco(5, 1, 20);
		assertTrue(_arco.obtenerPeso() == 20);
	}
	
	@Test
	public void toStringTest()
	{
		_arco = new Arco(5, 1, 20);
		assertEquals("(5, 1, 20)", _arco.toString());
	}

}
