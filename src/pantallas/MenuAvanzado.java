package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Principal.BotonMenu;
import Principal.PanelJuego;

public class MenuAvanzado implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	/**BOTONES**/
	BotonMenu nivel21;
	BotonMenu nivel22;
	String fondoBoton = "src/Imagenes/botonAmarillo.png";
	
	/**
	 * Constructor por defecto
	 */
	public MenuAvanzado() {
		
	}
	
	public MenuAvanzado(PanelJuego panel) {
		inicializarPantalla(panel);
	}

	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		//CREACI�N BOTONES
		nivel21 = new BotonMenu(300, 400, 90, 90, fondoBoton);
		nivel22 = new BotonMenu(600, 400, 90, 90, fondoBoton);
	}

	@Override
	public void pintarPantalla(Graphics g) {
		//Fondo de la pantalla
		g.setColor(new Color(139, 161, 255));
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
				
		//Texto
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(37, 69, 206));
		g.drawString("Selecciona un nivel:", 230, 80);
						
		//BOTONES
		nivel21.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,28));
		g.setColor(new Color(238, 135, 24));
		g.drawString("21", 322, 450);
						
		nivel22.pintarEnMundo(g);
		g.drawString("22", 622, 450);
	}

	@Override
	public void ejecutarFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pulsarTecla(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
