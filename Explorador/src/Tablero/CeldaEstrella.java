package Tablero;

import Juego.Juego;


public class CeldaEstrella extends Celda{

	public CeldaEstrella(int i, int j) {
		iniciar(i,j);
		
		
	}

	@Override
	public int darVuelta() {
		if (getEstado()== EstadoCelda.TAPADO){
			this.setEstado(EstadoCelda.ENCONTRADO);
			Juego.getInstancia().incrementarEncontrados();
		}
		return 0;
	}

}
