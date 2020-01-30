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
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import Principal.PanelJuego;

/**
 * Pantalla de victoria que aparece cuando reunimos las condiciones de victoria.
 * 
 * @author Alba Vega Calzado
 *
 */

public class PantallaVictoria implements IPantalla {
	/** PANEL JUEGO **/
	PanelJuego panelJuego;

	/** FONDO **/
	private BufferedImage fondo;
	private Image fondoEscalado;
	
	/**CONTADOR DE TIEMPO**/
	private DecimalFormat formato = new DecimalFormat("#.##");
	final Font fuenteTiempo = new Font("", Font.BOLD, 30);
	private double tiempoTranscurrido;

	/**
	 * Constructor por defecto
	 */
	public PantallaVictoria() {

	}

	public PantallaVictoria(PanelJuego panel, double tiempoTranscurrido) {
		inicializarPantalla(panel);
		
		this.tiempoTranscurrido=tiempoTranscurrido;
	}

	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego = panel;

		panel.setFocusable(true);
		panel.requestFocusInWindow();

		// IMÁGENES
		try {
			fondo = ImageIO.read(new File("src/Imagenes/fondoVictoria.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PROBLEMAS AL CARGAR LAS IMÁGENES. FIN DEL PROGRAMA");
			System.exit(1);
		}
		
		fondoEscalado = fondo.getScaledInstance(panelJuego.getWidth(), panelJuego.getHeight(), BufferedImage.SCALE_SMOOTH);
	}

	@Override
	public void pintarPantalla(Graphics g) {
		// Fondo
		rellenarFondo(g);
		
		//Texto
		g.setFont(new Font ("Goudy Stout",Font.PLAIN,40));
		g.setColor(new Color(151, 83, 148));
		g.drawString("Nivel superado", 170, panelJuego.getHeight()/2-50);
		
		g.setFont(new Font ("",Font.PLAIN,40));
		g.setColor(Color.BLACK);
		g.drawString("Tu tiempo: "+formato.format((tiempoTranscurrido)/1e9), panelJuego.getWidth()/3+30, panelJuego.getHeight()/2+50);
		
		g.setFont(new Font ("",Font.PLAIN,20));
		g.drawString("Haz click para seguir jugando", panelJuego.getWidth()/3+30,  panelJuego.getHeight()-100);
	}

	@Override
	public void ejecutarFrame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		panelJuego.setPantalla(new MenuDificultades(panelJuego));
	}

	@Override
	public void pulsarTecla(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private void rellenarFondo(Graphics g){
		fondoEscalado = fondo.getScaledInstance(panelJuego.getWidth(), this.panelJuego.getHeight(), BufferedImage.SCALE_SMOOTH);
		g.drawImage(fondoEscalado, 0, 0, null);
	}
}
