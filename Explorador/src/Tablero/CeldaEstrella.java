package Tablero;


public class CeldaEstrella extends Celda{

	public CeldaEstrella(int i, int j) {
		iniciar(i,j);
		
		
	}

	@Override
	public int darVuelta() {
		if (getEstado()== EstadoCelda.TAPADO){
			this.setEstado(EstadoCelda.ENCONTRADO);
		}
		return 0;
	}

}
