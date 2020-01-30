package utiles;

import java.util.Arrays;

/**
 * Clase que recoge la información sobre el tablero de juego y que nos permite posicionar sobre el los diferentes bloques.
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
		casillas = new Casilla[this.height][this.width];
		
		for(int i = this.height - 1; i >= 0; i--) {
			for(int z = this.width - 1; z >= 0; z--) {
				casillas[i][z] = new Casilla(("x"+z+"y"+i), z, i, -1);
			}
		}
	}
	
	/**
	 * Método para incluir los bloques en las casillas del tablero. Cambiamos su estado en función de si están o no ocupadas por un bloque.
	 * @param entidad
	 */
	public void putEntity(Entidad entidad) {
		int xmax = entidad.getxOrigin() + entidad.getxSize();
		int ymax = entidad.getyOrigin() + entidad.getySize();
		
		for(int i = entidad.getxOrigin(); i < xmax; i++) {
			for(int z = entidad.getyOrigin(); z < ymax; z++) {
//				System.out.println("i: "+i);
//				System.out.println("z: "+z);
				casillas[z][i].setState(entidad.getId());
			}
		}

//		System.out.println(Arrays.deepToString(casillas));
	}
	
	/**
	 * Método para eliminar un bloque del tablero. Si el estado de la casilla es la id de un bloque, lo cambiamos a -1,
	 * que es el que indica que la casilla está vacía.
	 * @param id Identificador del bloque
	 */
	public void clearEntity(int id) {
		for(int i = this.height - 1; i >= 0; i--) {
			for(int z = this.width - 1; z >= 0; z--) {
				if(casillas[i][z].getState() == id) {
					casillas[i][z].setState(-1);
				}
			}
		}
	}
	
	/**GETTERS Y SETTERS**/
	
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
