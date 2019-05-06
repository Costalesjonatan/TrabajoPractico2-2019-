package agentes;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Agente 
{
	
	
	private String _nombre_clave;
	private Coordinate _ubicacion;
	private int _numero_de_agente;
	
	public Agente(String nombreClave, Coordinate ubicacion, int numeroDeAgente)
	{
		verificarArgumentos(nombreClave, ubicacion, numeroDeAgente);
		_nombre_clave = nombreClave;
		_ubicacion = ubicacion;
		_numero_de_agente = numeroDeAgente;
	}
	
	private void verificarArgumentos(String nombreClave, Coordinate ubicacion, int numeroDeAgente)
	{
		if(nombreClave == null)
		{
			throw new NullPointerException("El nombre del agente debe ser un objeto valido!");
		}
		if(nombreClave.length() == 0)
		{
			throw new IllegalArgumentException("El agente debe tener un nombre clave.");
		}
		if(ubicacion == null)
		{
			throw new NullPointerException("El agente debe tener una ubicacion valida.");
		}
		if(numeroDeAgente < 0)
		{
			throw new IndexOutOfBoundsException("El numero de agente debe ser mayor o igual a 0");
		}
	}
	
	public String obtenerNombre()
	{
		return _nombre_clave;
	}
	
	public Coordinate obtenerubicacion()
	{
		return _ubicacion;
	}
	
	public int obtenerNumeroDeAgente()
	{
		return _numero_de_agente;
	}
	
	public String toString()
	{
		return "Nombre clave : " + _nombre_clave + "\n" + "Ubicacion: " + _ubicacion.toString() + "\n" + "Numero de agente: " + _numero_de_agente + "\n";
	}
}
