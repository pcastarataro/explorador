package Tablero;

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
}
