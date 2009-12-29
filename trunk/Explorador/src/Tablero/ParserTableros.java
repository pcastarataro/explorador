package Tablero;


public class ParserTableros {
	private static int alto;
	private static int ancho;
	private static Tablero tablero;
	
	public ParserTableros()
	{
	}
	
	public static Tablero parsear(String representation)
	{
		int alturaActual=0;
		alto=0;
		ancho=0;
		try{
			cargarDimensiones(representation);
			tablero= new Tablero(ancho,alto);
			for(int i=0; i< tablero.getRepresentacion().getAlto();i++){
			alturaActual=i;
			String unaLinea = getLineaDeRepresentacion(i,representation);
			ParsearLineaDeRepresentacion (unaLinea,alturaActual);
		}
		alto = 0;
		ancho = 0;
		return tablero;
		}catch (Exception e){throw new IllegalArgumentException();}
	}
	
	private static void cargarDimensiones(String representation) 
	{
		int cantidadColumnas = 0;
		boolean error = false;
		String unaLinea = null;
		while (! error){
			try{
				unaLinea = getLineaDeRepresentacion(cantidadColumnas, representation);
			}
			catch (Exception e) {
				error = true;
			}
			if (ancho == 0)
				ancho = unaLinea.length();
			if (unaLinea.length() != ancho)
				throw new IllegalArgumentException();
			if (! error)
				cantidadColumnas ++;
		}
		alto = cantidadColumnas;
	}
	
	private static String getLineaDeRepresentacion (int i, String representacion) 
	{
		String[] lista = representacion.split(";");
		return lista[i];
	}
	
	
	private static void ParsearLineaDeRepresentacion(String oneLine,int currentHeight)
	{
		if (oneLine.length() != ancho){
			throw new RuntimeException();
		}else{
			for(int i=0; i<ancho ;i++){
				char oneChar = oneLine.charAt(i);
				Celda unaCelda = generateSquare(oneChar,i,currentHeight);
				tablero.getRepresentacion().setPosicion(i,currentHeight,unaCelda);
			}
		}
	}
	
	private static Celda generateSquare(char oneChar, int x, int y) 
	{
		Celda unaCelda;
		switch(oneChar)
		{
			case 'B':
				{
					unaCelda= new CeldaBomba(x,y);
					break;
				}
			case 'S':
				{
					unaCelda= new CeldaEstrella(x,y);
					break;
				}
			case 'C':
				{
					unaCelda= new CeldaFria(x,y);
					break;
				}
			case 'H':
				{
					unaCelda= new CeldaCaliente(x,y);
					break;
				}
			case 'E':
				{
					unaCelda= new CeldaExpansiva(x,y);
					break;
				}
			default:
				{
					unaCelda = new CeldaFria(x,y);
					break;
				}
		//Complete here in the future if any other type of square is added.
		
		}
		 
		
		return unaCelda;
	}
}
