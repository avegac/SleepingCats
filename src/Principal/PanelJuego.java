package Principal;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pantallas.IPantalla;
import pantallas.PantallaInicio;

/**
 * RUSH HOUR
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
	
	/**
	 * Método que se llama automáticamente
	 */
	@Override
	protected void paintComponent(Graphics g) {
		pantallaEjecución.pintarPantalla();
	}
		
	@Override
	public void run() {
		while(true) {
			repaint();
			Toolkit.getDefaultToolkit().sync();
			
			pantallaEjecucion.ejecutarFrame();
		}
	}
	
	public void inicializarListeners() {
		
	}

}
