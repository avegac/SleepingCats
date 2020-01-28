package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Principal.BotonMenu;
import Principal.PanelJuego;

public class MenuDificultades implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	/**FONDO**/
	/**FONDO**/
	private BufferedImage fondo;
	private Image fondoEscalado;
	
	/**BOTONES**/
	BotonMenu botonPrincipiante;
	BotonMenu botonIntermedio;
	BotonMenu botonAvanzado;
	BotonMenu botonExperto;
	String fondoBoton = "src/Imagenes/botonRosa.png";
	
	/**
	 * Constructor por defecto
	 */
	public MenuDificultades() {	}
	
	public MenuDificultades(PanelJuego panel) {
		inicializarPantalla(panel);
	}
	
	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		//IMÁGENES
		try {
			fondo = ImageIO.read(new File("src/Imagenes/fondoInicio.jpg"));
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMAS AL CARGAR LAS IMÁGENES. FIN DEL PROGRAMA");
			System.exit(1);
		}
		
		//CREACIÓN BOTONES
		botonPrincipiante = new BotonMenu(250, 150, 500, 100,fondoBoton);
		botonIntermedio = new BotonMenu(250, 300, 500, 100,fondoBoton);
		botonAvanzado = new BotonMenu(250, 450, 500, 100,fondoBoton);
		botonExperto = new BotonMenu(250, 600, 500, 100,fondoBoton);
	}

	@Override
	public void pintarPantalla(Graphics g) {
		//Fondo
		rellenarFondo(g);

		//Texto
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(109, 80, 35));
		g.drawString("Selecciona una dificultad:", 150, 80);
		
		//Botones
		botonPrincipiante.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(214, 41, 63));
		g.drawString("Principiante (P)", 290, 200);
		
		botonIntermedio.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(214, 41, 63));
		g.drawString("Intermedio (I)", 310, 350);
		
		botonAvanzado.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(214, 41, 63));
		g.drawString("Avanzado (A)", 330, 500);
		
		botonExperto.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,25));
		g.setColor(new Color(214, 41, 63));
		g.drawString("Experto (E)", 350, 650);
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
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("p")) {
			panelJuego.setPantalla(new MenuPrincipiante(panelJuego));
		}
		
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("i")) {
			panelJuego.setPantalla(new MenuIntermedio(panelJuego));
		}
		
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("a")) {
			panelJuego.setPantalla(new MenuAvanzado(panelJuego));
		}
		
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("e")) {
			panelJuego.setPantalla(new MenuExperto(panelJuego));
		}
	}
	
	private void rellenarFondo(Graphics g){
		fondoEscalado = fondo.getScaledInstance(panelJuego.getWidth(), this.panelJuego.getHeight(), BufferedImage.SCALE_SMOOTH);
		g.drawImage(fondoEscalado, 0, 0, null);
	}

}
