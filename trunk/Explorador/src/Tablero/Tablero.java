package Tablero;

import Commons.Matriz;


public class Tablero {

	public int getCantidadEstrellas() {
		int starsAmount=0;
		Matriz matriz= this.getRepresentacion();
		for (int i=0; i<matriz.getAncho(); i++)
			for (int j=0; j<matriz.getAlto(); j++)
		{
			if ((matriz.getPosicion(i,j)) instanceof CeldaEstrella)
			{
				starsAmount++;
			}
		}
		return starsAmount;
	}

	public int getCantidadBombas() {
		int bombsAmount=0;
		Matriz matriz= this.getRepresentacion();
		for (int i=0; i<matriz.getAncho(); i++)
			for (int j=0; j<matriz.getAlto(); j++)
		{
			if ((matriz.getPosicion(i,j)) instanceof CeldaBomba)
			{
				bombsAmount++;
			}
		}
		return bombsAmount;
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
