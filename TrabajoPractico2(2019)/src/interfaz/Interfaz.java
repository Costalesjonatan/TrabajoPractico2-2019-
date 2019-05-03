package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import agentes.Agente;
import formulas.Haversine;
import grafos.GrafoPonderado;
import grafos.Primm;

public class Interfaz {

	private JFrame _frame;
	private JMapViewer _mapa;
	private JButton _generar_red;
	private GrafoPonderado _grafo;
	private ArrayList<Agente> _agentes;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Interfaz window = new Interfaz();
					window._frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interfaz() 
	{
		initialize();
	}
	
	private void initialize() 
	{
		inicializarFrame();
		iniciliazarMapa();
		incializarBotonGenerarRed();
		_agentes = new ArrayList<Agente>();
	}
	
	private void inicializarFrame()
	{
		_frame = new JFrame();
		_frame.setBounds(100, 100, 600, 700);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setResizable(false);
		_frame.setLocationRelativeTo(null);
		_frame.getContentPane().setLayout(null);
	}
	
	private void iniciliazarMapa() 
	{
		_mapa = new JMapViewer();
		_mapa.setBounds(0, 0, 400, 700);
		_mapa.setZoomContolsVisible(false);
		_mapa.setDisplayPositionByLatLon( -40.8134499, -62.9966812, 4); //TODO: pone las coordenadas de algun lugar que deje cnetrado el mapa
		_mapa.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getButton() == MouseEvent.BUTTON1) 
				{
					Coordinate ubicacion = _mapa.getPosition(e.getPoint());
					agregarAgente(ubicacion);
					_mapa.removeAllMapPolygons();
				}
			}
		});
		_mapa.addMouseWheelListener(new MouseWheelListener() 
		{
			public void mouseWheelMoved(MouseWheelEvent arg0) 
			{
				_mapa.setDisplayPositionByLatLon( -40.8134499, -62.9966812, 4); 
			}
		});
		_frame.add(_mapa);
	}
	
	private void incializarBotonGenerarRed()
	{
		_generar_red = new JButton("Generar red");
		_generar_red.setBounds(425, 10, 150, 20);
		_generar_red.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				_grafo = new GrafoPonderado(_agentes.size());
				generarRed(_agentes);
			}
		});
		_frame.add(_generar_red);
	}
	
	private void agregarAgente(Coordinate ubicacion)
	{
		try
		{
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre clave: ");
			if(nombre != null)
			{
				_agentes.add(new Agente(nombre, ubicacion, _agentes.size()));
				MapMarkerDot mapMarkerDot = new MapMarkerDot(_agentes.get(_agentes.size()-1).obtenerNombre(), ubicacion);
				mapMarkerDot.setBackColor(Color.RED);
				_mapa.addMapMarker(mapMarkerDot);
			}
		} 
		catch(IllegalArgumentException e)
		{
			agregarAgente(ubicacion);
		}
	}
	
	private void generarRed(ArrayList<Agente> agentes)
	{
		for(int i = 0; i < _agentes.size(); i++)
		{
			for(int j = (i+1); j < _agentes.size(); j++)
			{
				Coordinate ubicacionOrigen = _agentes.get(i).obtenerubicacion();
				Coordinate ubicacionDestino = _agentes.get(j).obtenerubicacion();
				int distancia = (int) Haversine.obtenerDistanciaEnKm(ubicacionOrigen, ubicacionDestino);
				_grafo.agregarArista(i, j, distancia);
			}
		}
		System.out.println(_grafo.toString());
		mostrarAgm();
		System.out.println(_grafo.toString());
	}
	
	private void mostrarAgm()
	{
		_grafo = Primm.generarAgm(_grafo);
		for(int i = 0; i < _grafo.obtenerTamaño(); i++)
		{
			for(int j = i; j < _grafo.obtenerTamaño(); j++)
			{
				if(_grafo.obtenerArista(i, j) != 0)
				{
					MapPolygonImpl camino = new MapPolygonImpl("", _agentes.get(i).obtenerubicacion(), _agentes.get(j).obtenerubicacion(), _agentes.get(i).obtenerubicacion());
					_mapa.addMapPolygon(camino);
				}
			}
		}
	}
}
