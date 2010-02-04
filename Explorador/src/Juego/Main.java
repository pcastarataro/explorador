package Juego;

import Vista.VentanaGanador;
import Vista.VentanaPerdedor;
import Vista.VentanaPrincipal;

public class Main {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {	
		VentanaPrincipal v= new VentanaPrincipal();
		v.setVisible(true);
		while ((!Juego.getInstancia().estaGanado())&&(!Juego.getInstancia().estaPerdido())){
			System.out.println("Jugando");
		}	
		if (Juego.getInstancia().estaPerdido()){
			System.out.println("Perdido");
			VentanaPerdedor ventana= new VentanaPerdedor();
			ventana.setVisible(true);
		}else
		if (Juego.getInstancia().estaGanado()){
			System.out.println("Ganado");
			VentanaGanador ventana= new VentanaGanador();
			ventana.setVisible(true);
		}
	}


}
