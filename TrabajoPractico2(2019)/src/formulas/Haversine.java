package formulas;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Haversine 
{	
	public static double obtenerDistanciaEnKm(Coordinate coordenadaDeOrigen, Coordinate coordenadaDeDestino)
	{
		verificarCoordenadas(coordenadaDeOrigen, coordenadaDeDestino);
		double RADIO = 6378;
		double diferenciaDeLatitud = Math.toRadians(coordenadaDeDestino.getLat() - coordenadaDeOrigen.getLat());
		double diferenciaDeLongitud = Math.toRadians(coordenadaDeDestino.getLon() - coordenadaDeOrigen.getLon());
		double sinDeLatitud = Math.sin((diferenciaDeLatitud/2));
		double sinDeLongitud = Math.sin((diferenciaDeLongitud/2));
		double a = Math.pow(sinDeLatitud, 2) + Math.pow(sinDeLongitud, 2) * Math.cos(Math.toRadians(coordenadaDeOrigen.getLat())) * Math.cos(Math.toRadians(coordenadaDeDestino.getLat())); 		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return RADIO * c;
	}
	
	private static void verificarCoordenadas(Coordinate coordenadaDeOrigen, Coordinate coordenadaDeDestino)
	{
		if(coordenadaDeOrigen == null )
		{
			throw new NullPointerException("La coordenada de origen no fue especificada; coordenadaDeOrigen = null");
		}
		if(coordenadaDeDestino == null )
		{
			throw new NullPointerException("La coordenada de destino no fue especificada; coordenadaDeDestino = null");
		}
		
	}
}
