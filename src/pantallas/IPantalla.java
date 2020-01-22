package pantallas;

import java.awt.Graphics;

import Principal.PanelJuego;

public interface IPantalla {
	public void inicializarPantalla(PanelJuego panel);
	public void pintarPantalla(Graphics g);
}
