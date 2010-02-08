package Tablero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class SelectorTablerosAlAzar {
	public static Tablero elegirNuevo(){
		try{
			Tablero nuevoTablero= null;
			
			BufferedReader bufferDeLectura = new BufferedReader(new FileReader("./recursos/listaTableros.txt"));
			java.lang.String cadenaDelArchivo = "";
			java.lang.String cadenaAuxiliar = "";
			while((cadenaAuxiliar = bufferDeLectura.readLine())!=null){
				cadenaDelArchivo += cadenaAuxiliar;
			}
			String lista=cadenaDelArchivo.replaceAll("/n", ""); //agarrar el archivo con path tableros
			String[] listaTableros= lista.split(";");
			int cantidad= listaTableros.length;
			Random s= new Random();
			int eleccion= s.nextInt(cantidad);
			
			nuevoTablero= CargadorTableros.levantarDeTXT(listaTableros[eleccion]);
			return nuevoTablero;
			
		} catch (Exception e){
			return SelectorTablerosAlAzar.elegirNuevo();
		}
		
	}
}
