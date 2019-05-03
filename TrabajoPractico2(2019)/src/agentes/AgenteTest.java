package agentes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openstreetmap.gui.jmapviewer.Coordinate;

class AgenteTest {

	private Agente _agente;
	
	@Test
	public void verificarNombreVacioTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> _agente = new Agente("", new Coordinate(0, 0), 1));
	}
	
	@Test
	public void verificarNombreNullTest() 
	{
		assertThrows(NullPointerException.class, () -> _agente = new Agente(null, new Coordinate(0, 0), 1));
	}
	
	@Test
	public void verificarUbicacionTest() 
	{
		assertThrows(NullPointerException.class, () -> _agente = new Agente("Aaron", null, 1));
	}
	
	@Test
	public void verificarNumeroDeAgenteTest() 
	{
		assertThrows(IndexOutOfBoundsException.class, () -> _agente = new Agente("Aaron", new Coordinate(0, 0), -1));
	}
	
	@Test
	public void obtenerNombreTest()
	{
		_agente = new Agente("Moskov", new Coordinate(0,0), 0);
		assertEquals(_agente.obtenerNombre(), "Moskov");
	}
	
	@Test
	public void obtenerUbicacionTest()
	{
		_agente = new Agente("Moskov", new Coordinate(0,0), 0);
		Coordinate esperado = new Coordinate(0,0);
		assertTrue(_agente.obtenerubicacion().getLat() == esperado.getLat() && _agente.obtenerubicacion().getLon() == esperado.getLon());
	}
	
	@Test
	public void obtenerNumeroDeAgenteTest()
	{
		_agente = new Agente("Moskov", new Coordinate(0,0), 0);
		assertEquals(_agente.obtenerNumeroDeAgente(), 0);
	}
	
	@Test
	public void toStringTest()
	{
		_agente = new Agente("Moskov", new Coordinate(0,0), 0);
		assertEquals(_agente.toString(), "Nombre clave : Moskov\nUbicacion: Coordinate[0.0, 0.0]\nNumero de agente: 0\n");
	}
	
}
