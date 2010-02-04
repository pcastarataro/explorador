package Tablero;
import Juego.Juego;
import Commons.FueraDeRangoException;


public class CeldaFria extends Celda{

	@Override
	public int darVuelta() {
		if (getEstado()== EstadoCelda.TAPADO){
			setEstado(EstadoCelda.DADOVUELTA);
		}
		return distanciaALaBombaMasCercana();
	}
	
	@Override
	public int getNumeroAsociado(){
		return distanciaALaBombaMasCercana();
	}
	
	public CeldaFria(int i,int j){
		iniciar(i,j);
	}
	
	 private int distanciaALaBombaMasCercana() {
		int nivel=1;
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
		       				aux= (Juego.getInstancia().getTablero().getRepresentacion().getPosicion(i,j)instanceof CeldaBomba);
		       			}catch (FueraDeRangoException e){}
		       			encontrado= (encontrado || aux);
		       		}
		       	}
		nivel++;
		}
		return nivel-1;
	}

}
