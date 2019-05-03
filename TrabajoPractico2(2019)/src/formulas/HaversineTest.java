package formulas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openstreetmap.gui.jmapviewer.Coordinate;

class HaversineTest {

	Coordinate _coordenadaDeOrigen = new Coordinate(-34.6131500, -58.3772300); //Buenos Aires
	Coordinate _coordenadaDeDestino = new Coordinate(-54.7999992, -68.3000031); //Ushuaia
	Coordinate _coordenadaDeOrigenVacia;
	Coordinate _coordenadaDeDestinoVacia;
	

	@Test
	public void verificarCoordenadaDeOrigenTest() 
	{
		assertThrows(NullPointerException.class, () -> Haversine.obtenerDistanciaEnKm(_coordenadaDeOrigenVacia, _coordenadaDeDestino));
	}
	
	@Test
	public void verificarCoordenadaDeDestinoTest() 
	{
		assertThrows(NullPointerException.class, () -> Haversine.obtenerDistanciaEnKm(_coordenadaDeOrigen, _coordenadaDeDestinoVacia));
	}
	
	@Test
	public void haversineTest() 
	{
		int esperado = 2374;
		int distancia = (int) Haversine.obtenerDistanciaEnKm(_coordenadaDeOrigen, _coordenadaDeDestino);
		assertEquals(distancia , esperado);
	}

}
