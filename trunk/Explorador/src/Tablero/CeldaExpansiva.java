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

}
