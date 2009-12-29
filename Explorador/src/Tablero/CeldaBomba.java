package Tablero;

import Juego.Juego;


public class CeldaBomba extends Celda{

	public CeldaBomba(int i, int j) {
		super.iniciar(i, j);
	}

	@Override
	public int darVuelta() {
		if (getEstado()== EstadoCelda.TAPADO){
			super.setEstado(EstadoCelda.EXPLOTADO);
			Juego.getInstancia().incrementarExplotados();
		}
		return 0;
		
	}

}
