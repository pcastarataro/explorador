package Juego;
import java.io.FileNotFoundException;
import java.io.IOException;

import Tablero.CargadorTableros;
import Tablero.SelectorTablerosAlAzar;
import Tablero.Tablero;



public class Juego {
	private static Juego instance = new Juego();
	
	public static Juego getInstancia() {
		return instance;
	}
	
	private Tablero tablero;
	private EstadoJuego estadoJuego;
	private int bombasExplotadas;
	private int estrellasEncontradas;
	
	public Juego()
	{
		this.iniciar();
	}
	
	private void SeleccionarTablero(String path) throws FileNotFoundException, IllegalArgumentException, IOException, ClassNotFoundException
	{
		this.tablero= CargadorTableros.levantarDeTXT(path);
	}
	
	public void incrementarEncontrados()
	{
		this.estrellasEncontradas++;
		if (this.estrellasEncontradas == this.tablero.getCantidadEstrellas())
		{
			this.estadoJuego= EstadoJuego.GANADO;
		}
	}
	
	public void incrementarExplotados()
	{
		this.bombasExplotadas++;
		if (this.bombasExplotadas == this.tablero.getCantidadBombas())
		{
			this.estadoJuego= EstadoJuego.PERDIDO;
			
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
		estadoJuego= EstadoJuego.JUGANDO;
		this.tablero=null;
		/*try {
			SeleccionarTablero("./recursos/tableros/1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		tablero=SelectorTablerosAlAzar.elegirNuevo();
		this.bombasExplotadas=0;
		this.estrellasEncontradas=0;
	}
}
