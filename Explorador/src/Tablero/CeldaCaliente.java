package Tablero;

import Commons.FueraDeRangoException;
import Juego.Juego;


public class CeldaCaliente extends Celda {

	public CeldaCaliente(int i,int j){
		iniciar(i,j);
	}
	
	@Override
	public int darVuelta() {
		if (getEstado()== EstadoCelda.TAPADO){
			setEstado(EstadoCelda.DADOVUELTA);
		}
		return distanciaALaEstrellaMasCercana();
	}

	@Override
	public int getNumeroAsociado(){
		return distanciaALaEstrellaMasCercana();
	}
	
	 private int distanciaALaEstrellaMasCercana() {
		int level=0;
		boolean founded=false;
		boolean aux;
		int height= Juego.getInstancia().getTablero().getRepresentacion().getAlto();
		int weight= Juego.getInstancia().getTablero().getRepresentacion().getAncho();
		while ((!founded) && (level < height) && (level <weight))
		{
		       	for (int i= getPosicion().getPosicionX()+ level ; i < getPosicion().getPosicionX()+level; i++)
		       		for (int j= getPosicion().getPosicionX()+ level ; j < getPosicion().getPosicionX()+level; j++)
		       	{
		       		if (!founded)
		       		{
		       			aux= false;
		       			try{
		       				aux= (Juego.getInstancia().getTablero().getRepresentacion().getPosicion(i,j)instanceof CeldaEstrella);
		       			}catch (FueraDeRangoException e){}
		       			founded= (founded || aux);
		       		}
		       	}
		level++;
		}
		return level-1;
	}

}
