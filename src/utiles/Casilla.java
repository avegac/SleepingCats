package utiles;

/**
 * Clase que recoge la información sobre la casilla que luego incluiremos en un array dentro del tablero
 * 
 * @author Alba Vega Calzado
 *
 */

public class Casilla {
	private String id;
	private int state;
	private int posX;
	private int posY;
		
	/**
	 * Constructor parametrizado
	 * @param id	Identificador de la casilla
	 * @param posX	Coordenada X de inicio de la casilla
	 * @param posY	Coordenada Y de inicio de la casilla
	 * @param state	Estado de la casilla (ocupada o no). Si está vacía valdrá -1.
	 */
	public Casilla(String id, int posX, int posY, int state) {
		super();
		this.id=id;
		this.posX=posX;
		this.posY=posY;
		this.state=state;
	}
	
	/**GETTERS Y SETTERS**/
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Casilla [id=" + id + ", state=" + state + "]";
	}
}
