package Commons;
public class Matriz {
	private int tamanioHorizontal;
	private int tamanioVertical;
	private Object representacion[][];

	private boolean rangoValido(int posicionHorizontal,int posicionVertical){
		return ((posicionHorizontal>=0)&&(posicionHorizontal<tamanioHorizontal)&&(posicionVertical>=0)&&(posicionVertical<tamanioVertical));
	}
	/*
	 * Crea una matriz cuadrada con 'tamanio' como cantidad de filas y columnas
	 */
	public Matriz(int tamanio){
		tamanioHorizontal = tamanio;
		tamanioVertical = tamanio;
		representacion = new Object[tamanioHorizontal][tamanioVertical];
		for (int i=0; i<tamanioHorizontal;i++)
			for (int j=0; j<tamanioVertical; j++){
				representacion[i][j]= new Object();
			}
	}

	/*
	 * Crea una matriz de dimensiones tamanioHorizontal, tamanioVertical. 
	 */
	public Matriz (int tamanioHorizontal, int tamanioVertical){
		this.tamanioHorizontal = tamanioHorizontal;
		this.tamanioVertical = tamanioVertical;
		representacion = new Object[tamanioHorizontal][tamanioVertical];
		for (int i=0; i<tamanioHorizontal;i++)
			for (int j=0; j<tamanioVertical; j++){
				representacion[i][j]=new Object();
			}
	}


	public void setPosicion(int posicionHorizontal,int posicionVertical,Object nuevoElemento){
		if (rangoValido(posicionHorizontal,posicionVertical)){
			representacion[posicionHorizontal][posicionVertical]=nuevoElemento;
		}
	}

	public Object getPosicion(int posicionHorizontal, int posicionVertical){
		if (rangoValido(posicionHorizontal,posicionVertical)){
			return representacion[posicionHorizontal][posicionVertical];
		}else throw new FueraDeRangoException();
	}
	public int getAncho() {

		return this.tamanioHorizontal;
	}
	public int getAlto() {
		return this.tamanioVertical;
	}
}
