package Tablero;
import java.util.ArrayList;
import java.util.Iterator;

import Commons.FueraDeRangoException;
import Commons.Punto;
import Juego.Juego;



public class CeldaExpansiva extends Celda{

	public CeldaExpansiva(int x, int y){
		iniciar(x,y);
	}
	
	@Override
	public int darVuelta() {
		if (getEstado()== EstadoCelda.TAPADO){
			super.setEstado(EstadoCelda.DADOVUELTA);
			ArrayList<Punto> list= getPosicionesAdyacentes();
			Iterator<Punto> it= list.iterator();
			while (it.hasNext()){
				Punto actual= it.next();
				try{
					Celda unaCelda= (Celda)(Juego.getInstancia().getTablero().getRepresentacion().getPosicion(actual.getPosicionX(),actual.getPosicionY()));
					unaCelda.darVuelta();
				}catch (FueraDeRangoException e){}
			}
		}
		return 0;
	}

	private ArrayList<Punto> getPosicionesAdyacentes() {
		ArrayList<Punto> list= new ArrayList<Punto>();
		Punto posicionActual= super.getPosicion();
        int currentX = posicionActual.getPosicionX();
        int currentY = posicionActual.getPosicionY();
        int fromX = -1 + currentX;
        int toX = 1 + currentX;
        int fromY= -1 + currentY;
        int toY= 1+ currentY;
		for (int i= fromX; i<= toX; i++)
			for (int j= fromY; j<= toY; j++){
			    list.add(new Punto(i,j));
		}
		return list;
	}

}
