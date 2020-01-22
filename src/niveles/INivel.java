package niveles;

import java.awt.Graphics;

import Principal.PanelJuego;

public interface INivel {
	public void inicializarNivel(PanelJuego panel);
	public void pintarNivel(Graphics g);
}
