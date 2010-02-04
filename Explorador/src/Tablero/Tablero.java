package Tablero;

import Commons.Matriz;


public class Tablero {

	public int getCantidadEstrellas() {
		int cantidadEstrellas=0;
		Matriz matriz= this.getRepresentacion();
		for (int i=0; i<matriz.getAncho(); i++)
			for (int j=0; j<matriz.getAlto(); j++)
		{
			if ((matriz.getPosicion(i,j)) instanceof CeldaEstrella)
			{
				cantidadEstrellas++;
			}
		}
		return cantidadEstrellas;
	}

	public int getCantidadBombas() {
		int cantidadBombas=0;
		Matriz matriz= this.getRepresentacion();
		for (int i=0; i<matriz.getAncho(); i++)
			for (int j=0; j<matriz.getAlto(); j++)
		{
			if ((matriz.getPosicion(i,j)) instanceof CeldaBomba)
			{
				cantidadBombas++;
			}
		}
		return cantidadBombas;
	}
	
	private Matriz tablero;
	
	public Matriz getRepresentacion() {
		return tablero;
	}
	
	public Tablero(int ancho, int alto)
	{
		this.tablero= new Matriz(ancho, alto);
	}
	


}
