package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Principal.PanelJuego;

public class PantallaInicio implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	final Font fuenteInicio = new Font("", Font.BOLD, 30);
	Color colorTitulo = Color.WHITE;
	
	/**
	 * Constructor por defecto
	 */
	public PantallaInicio() {}
	
	/**
	 * Constructor parametrizado
	 * @param panel
	 */
	public PantallaInicio(PanelJuego panel)	{
		inicializarPantalla(panel);
	}
	
	
	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;
	}

	@Override
	public void pintarPantalla(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
		g.setFont(fuenteInicio);
		g.setColor(colorTitulo);
		g.drawString("RUSH HOUR", panelJuego.getWidth()/2-120, panelJuego.getHeight()/2-10);
	}

}
