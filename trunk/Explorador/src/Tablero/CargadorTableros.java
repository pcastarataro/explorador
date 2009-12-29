package Tablero;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class CargadorTableros {
	/**
	 * 
	 * @param ruta
	 * @return unTablero
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException el archivo no pudo ser interpretado
	 */
	public static Tablero levantarDeTXT(java.lang.String ruta)throws FileNotFoundException,IOException, ClassNotFoundException, IllegalArgumentException{ 
		BufferedReader bufferDeLectura = new BufferedReader(new FileReader(ruta));
		java.lang.String cadenaDelArchivo = "";
		java.lang.String cadenaAuxiliar = "";
		while((cadenaAuxiliar = bufferDeLectura.readLine())!=null){
			cadenaDelArchivo += cadenaAuxiliar;
		}

		Tablero laberintoPedido = ParserTableros.parsear(cadenaDelArchivo);
		return laberintoPedido;
	}
}
