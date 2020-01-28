package niveles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import Principal.PanelJuego;
import Principal.Sprite;
import pantallas.IPantalla;
import pantallas.PantallaInicio;

public class Nv02 implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	/**TABLERO DE JUEGO**/
	final int TAMANO_TABLERO=6;
	final Color colorTablero = new Color(255, 235, 201);
		
	/**VARIABLES PARA EL TIEMPO**/
	Image imagenTemporizador;
	private double tiempoInicial = 0;
	private DecimalFormat formato = new DecimalFormat("#.##");
	final Font fuenteTiempo = new Font("", Font.BOLD, 30);
	final Color colorTiempo = new Color(45, 44, 47);
	
	/**SPRITES NIVEL 2**/
	Sprite pajaro;
	
	Sprite smallGatoVerde;
	Sprite smallGatoNaranja;
	Sprite smallGatoAzul;
	Sprite smallGatoVerde2;
	Sprite smallGatoRosa;
	Sprite smallGatoNegro;
	Sprite smallGatoMorado;
	
	Sprite bigGatoLila;
	Sprite bigGatoAmarillo;
	Sprite bigGatoAzul;
	
	public Nv02(PanelJuego panel) {
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
		
		//CREACIÓN GATOS
		smallGatoVerde = new Sprite(200, 150, 95,195, new Color(141,214,116));
		smallGatoNaranja = new Sprite(500, 250, 95, 195, new Color(252, 148, 58));
		smallGatoAzul  = new Sprite(600, 350, 95, 195, new Color(64, 196, 232));
		smallGatoVerde2  = new Sprite(200, 650, 195, 95, new Color(19, 135, 24));
		smallGatoRosa  = new Sprite(400, 550, 95, 195, new Color(255, 143, 216));
		smallGatoNegro  = new Sprite(500, 650, 195, 95, new Color(54, 49, 53));
		smallGatoMorado  = new Sprite(600, 550, 195, 95, new Color(127, 44, 207));
		
		bigGatoLila = new Sprite(700, 250, 95, 295, new Color(192, 152, 240));
		bigGatoAmarillo = new Sprite(500, 150, 295, 95, new Color(255,235,67));
		bigGatoAzul = new Sprite(200, 450, 295, 95, new Color(24, 46, 152));
		
		//CREACIÓN PÁJARO
		pajaro = new Sprite(200, 350, 195, 95, Color.RED);
		
		//TIEMPO
		tiempoInicial = System.nanoTime();
	}

	@Override
	public void pintarPantalla(Graphics g) {
		//Pintar fondo de la pantalla
		g.setColor(Color.PINK);
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
				
		//FONDO TEMPORIZADOR
		g.drawImage(imagenTemporizador, 20, 20, 140, 100, null);
				
		//TIEMPO
		g.setFont(fuenteTiempo);
		g.setColor(colorTiempo);
		g.drawString(formato.format((System.nanoTime() - tiempoInicial)/1e9), 45,  90);
				
		//TITULO DEL NIVEL
		g.setFont(fuenteTiempo);
		g.setColor(colorTiempo);
		g.drawString("NIVEL 2", 200, 90);
				
		//TABLERO
		g.setColor(colorTablero);
		for(int i=0; i<6;i++) {
			for(int j=0; j<6;j++) {
				g.fillRect((i*100)+200,(j*100)+150, 95, 95);
			}
		}
				
		//Volver
		g.setFont(new Font("Goudy Stout", Font.PLAIN, 20));
		g.setColor(Color.BLACK);
		g.drawString("Volver (V)", 760, 820);
		
		//GATOS
		smallGatoVerde.pintarEnMundo(g);
		smallGatoNaranja.pintarEnMundo(g);
		smallGatoAzul.pintarEnMundo(g);
		smallGatoVerde2.pintarEnMundo(g);
		smallGatoRosa.pintarEnMundo(g);
		smallGatoNegro.pintarEnMundo(g);
		smallGatoMorado.pintarEnMundo(g);
		
		bigGatoLila.pintarEnMundo(g);
		bigGatoAmarillo.pintarEnMundo(g);
		bigGatoAzul.pintarEnMundo(g);
		
		//PÁJARO
		pajaro.pintarEnMundo(g);
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
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("v")) {
			panelJuego.setPantalla(new PantallaInicio(panelJuego));
		}
	}
	
}
