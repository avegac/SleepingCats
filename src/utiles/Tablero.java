package utiles;

/**
 * 
 * @author Alba Vega Calzado
 *
 */

public class Tablero {
	private int height;
	private int width;
	private Casilla[][] casillas = null;
	
	/**
	 * Constructor por defecto
	 */
	public Tablero() {
		
	}
	
	/**
	 * Método para crear el array de casillas y meterlas en el tablero. Las inicializamos con un state -1
	 * porque al principio están vacías.
	 */
	public void fill() {
		casillas = new Casilla[this.width][this.height];
		
		for(int i = this.width-1; i >= 0; i--) {
			for(int z = this.height-1; z >= 0; z--) {
				casillas[i][z] = new Casilla(("x"+z+"y"+i), -1);
			}
		}
	}
	
	public void putEntity(Entidad entidad) {
		int xmax = entidad.getxOrigin() + entidad.getxSize();
		int ymax = entidad.getyOrigin() + entidad.getySize();
		
		for(int z = entidad.getyOrigin(); z<ymax; z++) {
			
		}
	}
	
	/*
	 * Getters y setters
	 */
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Casilla[][] getCasillas() {
		return casillas;
	}
	
	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}
	
	
}
