package grafos;

public class Arco
{
	private int _posicion_x;
	private int _posicion_y;
	private int _peso;
	
	public Arco(int posicionX, int posicionY, int peso)
	{
		_posicion_x = posicionX;
		_posicion_y = posicionY;
		_peso = peso;
	}
	
	public int obtenerPosicionX()
	{
		return _posicion_x;
	}
	
	public int obtenerPosicionY()
	{
		return _posicion_y;
	}
	
	public int obtenerPeso()
	{
		return _peso;
	}
	
	public String toString()
	{
		return "(" + _posicion_x + ", " + _posicion_y + ", "+ _peso + ")";
	}
}
