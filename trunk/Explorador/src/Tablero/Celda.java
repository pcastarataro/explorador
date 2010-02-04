package Tablero;

import java.util.ArrayList;

import Commons.Punto;


public abstract class Celda {
	private EstadoCelda estado;
	private Punto posicion;
	
	protected void setPosicion(Punto posicion)
	{
		this.posicion= posicion;
	}
	
	public Punto getPosicion(){
		return this.posicion;
	}
	
	protected void iniciar(int x, int y)
	{
		this.setPosicion(new Punto(x,y));
		this.estado= EstadoCelda.TAPADO;
	}
	
	public abstract int darVuelta();

	public int getNumeroAsociado(){
		return 0;
	}

	public EstadoCelda getEstado() {
		return estado;
	}


	public void setEstado(EstadoCelda estado) {
		this.estado= estado;
		
	}

	protected ArrayList<Punto> getPosicionesAdyacentes() {
		ArrayList<Punto> list= new ArrayList<Punto>();
		Punto posicionActual= this.getPosicion();
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
