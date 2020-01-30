package Principal;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


import pantallas.IPantalla;
import pantallas.PantallaInicio;

/**
 * SLEEPING CATS
 * 
 * @author Alba Vega Calzado
 *
 */

public class PanelJuego extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
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
		
	public void inicializarListeners() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pantallaEjecucion.pulsarRaton(e);
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				pantallaEjecucion.pulsarTecla(e);
			}
		});
	}
	
	@Override
	public void run() {
		while(true) {
			repaint();
						
			pantallaEjecucion.ejecutarFrame();
		}
	}
		
	
	public void setPantalla(IPantalla pantalla) {
		this.pantallaEjecucion=pantalla;
	}
}
