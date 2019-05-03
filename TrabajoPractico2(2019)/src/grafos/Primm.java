package grafos;

import java.util.ArrayList;

public class Primm 
{
	public static GrafoPonderado generarAgm(GrafoPonderado grafo)
	{
		GrafoPonderado AGM = new GrafoPonderado(grafo.obtenerTamaño());
		ArrayList<Integer> verticesVisitados = new ArrayList<Integer>();
		verticesVisitados.add(0);
		
		int i = 0;
		while(i < grafo.obtenerTamaño()-1)
		{	
			ArrayList<Arco> arcosPendientes = new ArrayList<Arco>();
			for(Integer I : verticesVisitados)
			{
				int[] vecinos = grafo.obtenerVecinos(I);
				for(int j = 0; j < vecinos.length; j++)
				{
					if(!verticesVisitados.contains(j)) //evito que se analizen las aristas que prodian formar circuitos simples
					{
						Arco arista = new Arco(I, j, grafo.obtenerArista(I, j));
						if(grafo.obtenerArista(I, j) != 0 &&  AGM.obtenerArista(I, j) == 0) //hay una arista y no esta en el AGM
						{
							arcosPendientes.add(arista);
						}
					}
				}
			}
			Arco arcoMenor = dameMenorArista(arcosPendientes);
			AGM.agregarArista(arcoMenor.obtenerPosicionX(), arcoMenor.obtenerPosicionY(), arcoMenor.obtenerPeso());
			verticesVisitados.add(arcoMenor.obtenerPosicionY());
			i++;
		}
		return AGM;
	}
	
	static Arco dameMenorArista(ArrayList<Arco> arcosPendientes)
	{
		Arco arcoMenor = arcosPendientes.get(0);
		int i = 1;
		
		while(i < arcosPendientes.size())
		{
			if(arcoMenor.obtenerPeso() >= arcosPendientes.get(i).obtenerPeso())
			{
				arcoMenor = arcosPendientes.get(i);
			}
			i++;
		}
		return arcoMenor;
	}
}
