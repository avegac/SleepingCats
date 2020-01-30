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
	 * @param id Identificador de la entidad
	 * @param xSize Número de casillas que ocupa la entidad en el eje x
	 * @param ySize Número de casillas que ocupa la entidad en el eje y
	 * @param xOrigin Coordenada x inicial de la entidad
	 * @param yOrigin Coordenada y inicial de la entidad
	 */
	public Entidad(int id, int xSize, int ySize, int xOrigin, int yOrigin) {
		super();
		this.id=id;
		this.xSize=xSize;
		this.ySize=ySize;
		this.xOrigin=xOrigin;
		this.yOrigin=yOrigin;
	}
	
	/**GETTERS Y SETTERS**/
	
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
	
	@Override
	public String toString() {
		return "Entidad [id=" + id + ", xSize=" + xSize + ", ySize=" + ySize + ", xOrigin=" + xOrigin + ", yOrigin="+ yOrigin + ", vertical=" + vertical + "]";
	}
}
