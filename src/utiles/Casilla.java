package utiles;

/**
 * 
 * @author Alba Vega Calzado
 *
 */

public class Casilla {
	private String id;
	private int state;
	
	/**
	 * Constructor parametrizado
	 * @param id identificador de la casilla
	 * @param state estado de la casilla (ocupada o no)
	 */
	public Casilla(String id, int state) {
		super();
		this.id=id;
		this.state=state;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
