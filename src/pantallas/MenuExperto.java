package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Principal.BotonMenu;
import Principal.PanelJuego;

public class MenuExperto implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	/**BOTONES**/
	BotonMenu nivel31;
	BotonMenu nivel32;
	String fondoBoton = "src/Imagenes/botonAmarillo.png";
	
	/**
	 * Constructor por defecto
	 */
	public MenuExperto() {
		
	}
	
	public MenuExperto(PanelJuego panel) {
		inicializarPantalla(panel);
	}

	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		//CREACIÓN BOTONES
		nivel31 = new BotonMenu(300, 400, 90, 90, fondoBoton);
		nivel32 = new BotonMenu(600, 400, 90, 90, fondoBoton);
	}

	@Override
	public void pintarPantalla(Graphics g) {
		//Fondo de la pantalla
		g.setColor(new Color(255, 141, 141));
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
						
		//Texto
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(204, 42, 42));
		g.drawString("Selecciona un nivel:", 230, 80);
						
		//BOTONES
		nivel31.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,28));
		g.setColor(new Color(238, 135, 24));
		g.drawString("31", 322, 450);
						
		nivel32.pintarEnMundo(g);
		g.drawString("32", 622, 450);
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
	public void arrastrarRaton(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pulsarTecla(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
