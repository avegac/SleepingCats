package pantallas;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Principal.PanelJuego;

public interface IPantalla {
	public void inicializarPantalla(PanelJuego panel);
	public void pintarPantalla(Graphics g);
	public void ejecutarFrame();
	
	/*
	 * LISTENERS
	 */
	public void pulsarRaton(MouseEvent e);
	public void arrastrarRaton(MouseEvent e);
	public void pulsarTecla(KeyEvent e);
}
