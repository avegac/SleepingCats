package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Principal.PanelJuego;
import niveles.Nv01;

public class PantallaTutorial implements IPantalla{
	/**PANEL DE JUEGO**/
	PanelJuego panelJuego;
	
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
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
	}

	@Override
	public void pintarPantalla(Graphics g) {
		//Fondo de la pantalla
		g.setColor(Color.PINK);
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
				
		//Texto del tutorial
		g.setFont(new Font("", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString("Objetivo: deslizar el pájaro fuera del tablero.", 170, 120);
		
		g.setFont(new Font("", Font.BOLD, 28));
		g.drawString("Mueve los gatitos en horizontal o en vertical hasta despejar el camino.", 20, 400);

		g.setFont(new Font("", Font.BOLD, 20));
		g.drawString("Haz click para volver al inicio.", 350, 800);
	}

	@Override
	public void ejecutarFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		panelJuego.setPantalla(new PantallaInicio(panelJuego));
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
