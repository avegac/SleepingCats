package niveles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import Principal.PanelJuego;
import pantallas.IPantalla;

public class Nv01 implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	/**TABLERO DE JUEGO**/
	final int TAMANO_TABLERO=6;
	final Color colorTablero = new Color(255, 235, 201);
	private BufferedImage bufferTablero;
	
	/**VARIABLES PARA EL TIEMPO**/
	Image imagenTemporizador;
	private double tiempoInicial = 0;
	private DecimalFormat formato = new DecimalFormat("#.##");
	final Font fuenteTiempo = new Font("", Font.BOLD, 30);
	final Color colorTiempo = new Color(45, 44, 47);

	
	public Nv01(PanelJuego panel) {
		inicializarPantalla(panel);
	}

	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;
		
		//IMÁGENES
		try {
			imagenTemporizador = ImageIO.read(new File("src/Imagenes/temporizador.png"));
		} catch(IOException e1) {
			e1.printStackTrace();
			System.out.println("PROBLEMAS AL CARGAR LAS IMÁGENES. FIN DEL PROGRAMA");
			System.exit(1);
		}
		
		//TABLERO
		
		
		//TIEMPO
		
		tiempoInicial = System.nanoTime();	
	}

	@Override
	public void pintarPantalla(Graphics g) {
		//Pintar fondo de la pantalla
		g.setColor(Color.PINK);
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
		
		//FONDO TEMPORIZADOR
		g.drawImage(imagenTemporizador, 20, 20, 120, 100, null);
		
		//TIEMPO
		g.setFont(fuenteTiempo);
		g.setColor(colorTiempo);
		g.drawString(formato.format((System.nanoTime() - tiempoInicial)/1e9), 45,  90);
		
		//TITULO DEL NIVEL
		g.setFont(fuenteTiempo);
		g.setColor(colorTiempo);
		g.drawString("NIVEL 1", 200, 90);
		
		//TABLERO
		g.setColor(colorTablero);
		for(int i=0; i<6;i++) {
			for(int j=0; j<6;j++) {
				g.fillRect((i*100)+200,(j*100)+150, 95, 95);
			}
		}
		
		
	}

	@Override
	public void ejecutarFrame() {
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
