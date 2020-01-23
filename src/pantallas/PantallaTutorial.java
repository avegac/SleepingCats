package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import Principal.PanelJuego;

public class PantallaTutorial implements IPantalla{
	/**PANEL DE JUEGO**/
	PanelJuego panelJuego;
	
	/**
	 * FUENTES
	 */
	final Font fuenteTutorial = new Font("", Font.BOLD, 30);
	
	/**
	 * Constructor por defecto
	 */
	public PantallaTutorial() {}
	
	public PantallaTutorial(PanelJuego panel) {
		this.panelJuego=panel;
	}

	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;		
	}

	@Override
	public void pintarPantalla(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
		g.setFont(fuenteTutorial);
	}

	@Override
	public void ejecutarFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
