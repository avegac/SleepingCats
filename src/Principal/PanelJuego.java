package Principal;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		pantallaEjecucion.pintarPantalla(g);
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
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pantallaEjecucion.pulsarRaton(e);
			}
		});
	}
	
	public void setPantalla(IPantalla pantalla) {
		this.pantallaEjecucion=pantalla;
	}
}
