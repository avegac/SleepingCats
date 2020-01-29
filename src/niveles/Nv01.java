package niveles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Principal.PanelJuego;
import Principal.Sprite;
import pantallas.IPantalla;
import pantallas.PantallaInicio;
import utiles.Entidad;
import utiles.Tablero;

import java.awt.event.KeyEvent;

/**
 * Nivel 1 de dificultad Principiante (nivel 01).
 * 
 * @author Alba Vega Calzado
 *
 */

public class Nv01 implements IPantalla{
	/**PANEL JUEGO**/
	PanelJuego panelJuego;
	
	/**TABLERO DE JUEGO**/
	Tablero tablero;
	final int TAMANO_TABLERO=6;
	final Color colorTablero = new Color(255, 235, 201);
		
	/**VARIABLES PARA EL TIEMPO**/
	Image imagenTemporizador;
	private double tiempoInicial = 0;
	private DecimalFormat formato = new DecimalFormat("#.##");
	final Font fuenteTiempo = new Font("", Font.BOLD, 30);
	final Color colorTiempo = new Color(45, 44, 47);
	
	/**SPRITES NIVEL 1**/
	//Están creados por separado y luego añadidos a la lista para poder probarlos individualmente
	Sprite pajaro;
	
	Sprite smallGatoVerde;
	Sprite smallGatoNaranja;
	Sprite smallGatoAzul;
	
	Sprite bigGatoLila;
	Sprite bigGatoAzul;
	Sprite bigGatoVerde;
	Sprite bigGatoAmarillo;
	
	List<Sprite> gatos; 
	int selectedSprite = -1;
	
	/**
	 * Constructor al que le pasamos el panel de juego para que inicialice los elementos del nivel
	 * @param panel
	 */
	public Nv01(PanelJuego panel) {
		inicializarPantalla(panel);
	}

	/**
	 * Método para inicializar todos los elementos del nivel
	 */
	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego=panel;
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		//TABLERO CON DIMENSIONES
		tablero = new Tablero();
		tablero.setHeight(6);
		tablero.setWidth(6);
		tablero.fill();
		
		//IMÁGENES
		try {
			imagenTemporizador = ImageIO.read(new File("src/Imagenes/temporizador.png"));
		} catch(IOException e1) {
			e1.printStackTrace();
			System.out.println("PROBLEMAS AL CARGAR LAS IMÁGENES. FIN DEL PROGRAMA");
			System.exit(1);
		}
		
		//CREACIÓN GATOS
		gatos = new ArrayList<>();
		
		smallGatoVerde = new Sprite(200, 150, 195,95, new Color(141,214,116), new Entidad(0,2,1,0,0));
		smallGatoNaranja = new Sprite(200, 550, 95, 195, new Color(252, 148, 58), new Entidad(1,1,2,0,4));
		smallGatoAzul  = new Sprite(600, 550, 195, 95, new Color(64, 196, 232), new Entidad(2,2,1,4,4));
		
		bigGatoLila = new Sprite(200, 250, 95, 295, new Color(192, 152, 240), new Entidad(3,1,3,0,1));
		bigGatoAzul = new Sprite(500, 250, 95, 295, new Color(24, 46, 152), new Entidad(4,1,3,3,1));
		bigGatoVerde = new Sprite(400, 650, 295, 95, new Color(14, 127, 84), new Entidad(5,3,1,2,5));
		bigGatoAmarillo = new Sprite(700, 150, 95, 295, new Color(255,235,67), new Entidad(6,1,3,5,0));
		
		//Indicamos qué gatos son los que están en posición vertical
		bigGatoLila.getData().setVertical(true);
		bigGatoAmarillo.getData().setVertical(true);
		bigGatoAzul.getData().setVertical(true);
		
		//Añadimos todos los gatos a la lista
		gatos.add(smallGatoAzul);
		gatos.add(smallGatoVerde);
		gatos.add(smallGatoNaranja);
		
		gatos.add(bigGatoLila);
		gatos.add(bigGatoAzul);
		gatos.add(bigGatoVerde);
		gatos.add(bigGatoAmarillo);
		
		for(Sprite gato : gatos) {
			tablero.putEntity(gato.getData());
		}
		tablero.putEntity(smallGatoVerde.getData());
		
		//CREACIÓN PÁJARO
		pajaro = new Sprite(300, 350, 195, 95, Color.RED, new Entidad(7,2,1,1,2));
		//Añadimos el pájaro al tablero
		tablero.putEntity(pajaro.getData());
		
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
		g.drawString("NIVEL 1", 200, 90);
		
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
		
		bigGatoLila.pintarEnMundo(g);
		bigGatoAzul.pintarEnMundo(g);
		bigGatoVerde.pintarEnMundo(g);
		bigGatoAmarillo.pintarEnMundo(g);
		
		//PÁJARO
		pajaro.pintarEnMundo(g);
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

	@Override
	public void arrastrarRaton(MouseEvent e) {
		
	}

	@Override
	public void pulsarTecla(KeyEvent e) {
		if(KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("v")) {
			panelJuego.setPantalla(new PantallaInicio(panelJuego));
		}
		
	}
	
	
}
