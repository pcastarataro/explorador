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
		int nivel=0;
		boolean encontrado=false;
		boolean aux;
		int alto= Juego.getInstancia().getTablero().getRepresentacion().getAlto();
		int ancho= Juego.getInstancia().getTablero().getRepresentacion().getAncho();
		while ((!encontrado) && (nivel <= alto) && (nivel <= ancho))
		{
		       	for (int i= getPosicion().getPosicionX()- nivel ; i <= getPosicion().getPosicionX()+nivel; i++)
		       		for (int j= getPosicion().getPosicionY()- nivel ; j <= getPosicion().getPosicionY()+nivel; j++)
		       	{
		       		if (!encontrado)
		       		{
		       			aux= false;
		       			try{
		       				aux= (Juego.getInstancia().getTablero().getRepresentacion().getPosicion(i,j)instanceof CeldaEstrella);
		       			}catch (FueraDeRangoException e){}
		       			encontrado= (encontrado || aux);
		       		}
		       	}
		nivel++;
		}
		return nivel-1;
	}
	 
	

}
