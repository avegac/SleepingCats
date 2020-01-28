package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Principal.BotonMenu;
import Principal.PanelJuego;
import niveles.Nv01;
import niveles.Nv02;
import niveles.Nv11;
import niveles.Nv12;

public class MenuIntermedio implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	/**BOTONES**/
	BotonMenu nivel11;
	BotonMenu nivel12;
	String fondoBoton = "src/Imagenes/botonAmarillo.png";
	
	/**
	 * Constructor por defecto
	 */
	public MenuIntermedio() {
		
	}
	
	public MenuIntermedio(PanelJuego panel) {
		inicializarPantalla(panel);
	}
	
	
	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		//CREACIÓN BOTONES
		nivel11 = new BotonMenu(300, 400, 90, 90, fondoBoton);
		nivel12 = new BotonMenu(600, 400, 90, 90, fondoBoton);
	}

	@Override
	public void pintarPantalla(Graphics g) {
		//Fondo de la pantalla
		g.setColor(new Color(255, 204, 153));
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
				
		//Texto
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(228, 129, 30));
		g.drawString("Selecciona un nivel:", 230, 80);
				
		//BOTONES
		nivel11.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,28));
		g.setColor(new Color(238, 135, 24));
		g.drawString("1", 335, 450);
				
		nivel12.pintarEnMundo(g);
		g.drawString("2", 635, 450);
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
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("1")) {
			panelJuego.setPantalla(new Nv11(panelJuego));
		}
		
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("2")) {
			panelJuego.setPantalla(new Nv12(panelJuego));
		}
	}

}
