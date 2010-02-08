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
		while(true){
			while ((!Juego.getInstancia().estaGanado())&&(!Juego.getInstancia().estaPerdido())){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (Juego.getInstancia().estaPerdido()){
					VentanaPerdedor ventana= new VentanaPerdedor();
					ventana.setVisible(true);
				}else if (Juego.getInstancia().estaGanado()){
					VentanaGanador ventana= new VentanaGanador();
					ventana.setVisible(true);
				}
				
				
			}
		}
	}
	
}


