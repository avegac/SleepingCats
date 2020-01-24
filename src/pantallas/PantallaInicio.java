package pantallas;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import Principal.PanelJuego;
import niveles.Nv01;

public class PantallaInicio implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	final Font fuenteInicio = new Font("", Font.BOLD, 30);
	Color colorTitulo = Color.WHITE;
	
	/**BOTONES**/
	Button botonJugar;
	
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
		g.setColor(Color.PINK);
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
		g.setFont(fuenteInicio);
		g.setColor(colorTitulo);
		g.drawString("SLEEPING CATS", panelJuego.getWidth()/2-120, panelJuego.getHeight()/2-150);
	}

	@Override
	public void ejecutarFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		panelJuego.setPantalla(new Nv01(panelJuego));
	}

}
