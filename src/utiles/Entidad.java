package utiles;

/**
 * Clase que recoge los datos de los sprites sobre el tablero
 * 
 * @author Alba Vega Calzado
 *
 */

public class Entidad {
	private int id;
	private int xSize;
	private int ySize;
	private int xOrigin;
	private int yOrigin;
	private boolean vertical;
	
	/**
	 * Constructor parametrizado
	 * @param id identificador de la entidad
	 * @param xSize número de casillas que ocupa la entidad en el eje x
	 * @param ySize número de casillas que ocupa la entidad en el eje y
	 * @param xOrigin coordenada x inicial de la entidad
	 * @param yOrigin coordenada y inicial de la entidad
	 */
	public Entidad(int id, int xSize, int ySize, int xOrigin, int yOrigin) {
		super();
		this.id=id;
		this.xSize=xSize;
		this.ySize=ySize;
		this.xOrigin=xOrigin;
		this.yOrigin=yOrigin;
	}
	
	/*
	 * Getters y setters
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getxSize() {
		return xSize;
	}
	
	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
	
	public int getySize() {
		return ySize;
	}
	
	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
	public int getxOrigin() {
		return xOrigin;
	}
	
	public void setxOrigin(int xOrigin) {
		this.xOrigin = xOrigin;
	}
	
	public int getyOrigin() {
		return yOrigin;
	}
	
	public void setyOrigin(int yOrigin) {
		this.yOrigin = yOrigin;
	}
	
	public boolean getVertical() {
		return vertical;
	}
	
	public void setVertical(boolean vertical) {
		this.vertical=vertical;
	}
	
	
}
