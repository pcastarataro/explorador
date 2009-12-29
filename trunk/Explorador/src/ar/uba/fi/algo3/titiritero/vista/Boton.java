package ar.uba.fi.algo3.titiritero.vista;

import javax.swing.JButton;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class Boton extends JButton implements Dibujable{

	private Posicionable boton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		super.paint(getGraphics());
		
	}

	@Override
	public Posicionable getPosicionable() {
		return boton;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.boton= posicionable;
		
	}

}
