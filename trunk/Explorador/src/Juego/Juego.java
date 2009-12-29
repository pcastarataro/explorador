package Juego;
import java.io.FileNotFoundException;
import java.io.IOException;

import Tablero.CargadorTableros;
import Tablero.Tablero;



public class Juego {
	private static Juego instance = new Juego();
	
	public static Juego getInstancia() {
		return instance;
	}
	
	//private int vidasRestantes;
	private Tablero tablero;
	private EstadoJuego estadoJuego;
	private int bombasExplotadas;
	private int estrellasEncontradas;
	
	public Juego()
	{
		iniciar();
	}
	
	private void SeleccionarTablero(String path) throws FileNotFoundException, IllegalArgumentException, IOException, ClassNotFoundException
	{
		this.tablero= CargadorTableros.levantarDeTXT(path);
	}
	
	public void incrementarEncontrados()
	{
		this.estrellasEncontradas= estrellasEncontradas++;
		if (estrellasEncontradas == tablero.getCantidadEstrellas())
		{
			estadoJuego= EstadoJuego.GANADO;
		}
	}
	
	public void incrementarExplotados()
	{
		this.bombasExplotadas= bombasExplotadas++;
		if (bombasExplotadas == tablero.getCantidadBombas())
		{
			estadoJuego= EstadoJuego.PERDIDO;
			//this.vidasRestantes--;
		}
	}
	
	public boolean estaGanado()
	{
		return (estadoJuego == EstadoJuego.GANADO);
	}
	
	public boolean estaPerdido()
	{
		return (estadoJuego == EstadoJuego.PERDIDO);
	}
	
	public boolean seEstaJugando()
	{
		return (estadoJuego == EstadoJuego.JUGANDO);
	}

	public Tablero getTablero() {
		return this.tablero;
	}

	public void iniciar() {
		// TODO Auto-generated method stub
		estadoJuego= EstadoJuego.JUGANDO;
		//vidasRestantes=2;
		try {
			SeleccionarTablero("./recursos/tableros/1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//See path
		this.bombasExplotadas=0;
		this.estrellasEncontradas=0;
	}
}
