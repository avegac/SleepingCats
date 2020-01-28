package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Principal.BotonMenu;
import Principal.PanelJuego;
import Principal.Sprite;
import niveles.Nv01;

public class PantallaInicio implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	final Font fuenteInicio = new Font("Goudy Stout", Font.BOLD, 50);
	Color colorTitulo = new Color(109, 80, 35);
	
	/**BOTONES**/
	BotonMenu botonJugar;
	BotonMenu botonTutorial;
	String fondoBoton="src/Imagenes/botonAmarillo.png";
	
	
	/**FONDO**/
	private BufferedImage fondo;
	private Image fondoEscalado;
	
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
		botonJugar = new BotonMenu(340, 400, 300, 100, fondoBoton);
		botonTutorial = new BotonMenu(340, 560, 300, 100, fondoBoton);
	}

	@Override
	public void pintarPantalla(Graphics g) {
		rellenarFondo(g);
		
		botonJugar.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,30));
		g.setColor(new Color(238, 135, 24));
		g.drawString("JUGAR (J)", 350, 455);
		
		botonTutorial.pintarEnMundo(g);
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,27));
		g.setColor(new Color(238, 135, 24));
		g.drawString("REGLAS (R)", 345, 611);
		
		g.setFont(fuenteInicio);
		g.setColor(colorTitulo);
		g.drawString("SLEEPING CATS", panelJuego.getWidth()/7-30, panelJuego.getHeight()/2-150);
	}

	@Override
	public void ejecutarFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		//panelJuego.setPantalla(new Nv01(panelJuego));
		
	}

	@Override
	public void arrastrarRaton(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void rellenarFondo(Graphics g){
		fondoEscalado = fondo.getScaledInstance(panelJuego.getWidth(), this.panelJuego.getHeight(), BufferedImage.SCALE_SMOOTH);
		g.drawImage(fondoEscalado, 0, 0, null);
	}

	@Override
	public void pulsarTecla(KeyEvent e) {
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("j")) {
			panelJuego.setPantalla(new Nv01(panelJuego));
		}
		
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("r")) {
			panelJuego.setPantalla(new PantallaTutorial(panelJuego));
		}
	}
}
