package pantallas;

import java.awt.Color;
import java.awt.Graphics;

import Principal.PanelJuego;

public class PantallaInicio implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
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
		//g.fillRect(0, 0, panelJuego.getWidth(), );
	}

}
