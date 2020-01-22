package Principal;

import javax.swing.JPanel;

import pantallas.IPantalla;
import pantallas.PantallaInicio;

/**
 * PIXEL SOULS
 * 
 * @author Alba Vega Calzado
 *
 */

public class PanelJuego extends JPanel implements Runnable{
	/** PANTALLA **/
	IPantalla pantallaEjecucion;
	
	/**
	 * Constructor
	 */
	public PanelJuego() {
		pantallaEjecucion = new PantallaInicio(this);
		
		//HILO
		new Thread(this).start();
		
		//LISTENERS
		inicializarListeners();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void inicializarListeners() {
		
	}

}
