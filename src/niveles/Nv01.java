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
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import Principal.PanelJuego;
import Principal.Sprite;
import pantallas.IPantalla;
import pantallas.PantallaInicio;
import pantallas.PantallaVictoria;
import utiles.Casilla;
import utiles.Entidad;
import utiles.Tablero;

import java.awt.event.KeyEvent;

/**
 * Nivel 1 de dificultad Principiante (nivel 01).
 * 
 * @author Alba Vega Calzado
 *
 */

public class Nv01 implements IPantalla {
	/** PANEL JUEGO **/
	PanelJuego panelJuego;

	/** TABLERO DE JUEGO **/
	Tablero tablero;
	final int TAMANO_TABLERO = 6;
	final Color colorTablero = new Color(255, 235, 201);

	/** VARIABLES PARA EL TIEMPO **/
	Image imagenTemporizador;
	private double tiempoInicial = 0;
	private DecimalFormat formato = new DecimalFormat("#.##");
	final Font fuenteTiempo = new Font("", Font.BOLD, 30);
	final Color colorTiempo = new Color(45, 44, 47);

	/** SPRITES NIVEL 1 **/
	Sprite pajaro;

	Sprite smallGatoVerde;
	Sprite smallGatoNaranja;
	Sprite smallGatoAzul;

	Sprite bigGatoLila;
	Sprite bigGatoAzul;
	Sprite bigGatoVerde;
	Sprite bigGatoAmarillo;

	HashMap<Integer, Sprite> sprites;
	int selectedSpriteId = -1;

	/**
	 * Constructor al que le pasamos el panel de juego para que inicialice los
	 * elementos del nivel
	 * 
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
		this.panelJuego = panel;

		panel.setFocusable(true);
		panel.requestFocusInWindow();

		// TABLERO CON DIMENSIONES
		tablero = new Tablero();
		tablero.setHeight(6);
		tablero.setWidth(6);
		tablero.fill();

		// IMÁGENES
		try {
			imagenTemporizador = ImageIO.read(new File("src/Imagenes/temporizador.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("PROBLEMAS AL CARGAR LAS IMÁGENES. FIN DEL PROGRAMA");
			System.exit(1);
		}

		// CREACIÓN GATOS
		sprites = new HashMap<>();

		smallGatoVerde = new Sprite(200, 150, 195, 95, new Color(141, 214, 116), new Entidad(0, 2, 1, 0, 0));
		smallGatoNaranja = new Sprite(200, 550, 95, 195, new Color(252, 148, 58), new Entidad(1, 1, 2, 0, 4));
		smallGatoAzul = new Sprite(600, 550, 195, 95, new Color(64, 196, 232), new Entidad(2, 2, 1, 4, 4));

		bigGatoLila = new Sprite(200, 250, 95, 295, new Color(192, 152, 240), new Entidad(3, 1, 3, 0, 1));
		bigGatoAzul = new Sprite(500, 250, 95, 295, new Color(24, 46, 152), new Entidad(4, 1, 3, 3, 1));
		bigGatoVerde = new Sprite(400, 650, 295, 95, new Color(14, 127, 84), new Entidad(5, 3, 1, 2, 5));
		bigGatoAmarillo = new Sprite(700, 150, 95, 295, new Color(255, 235, 67), new Entidad(6, 1, 3, 5, 0));

		// Indicamos qué gatos son los que están en posición vertical
		bigGatoLila.getData().setVertical(true);
		bigGatoAmarillo.getData().setVertical(true);
		bigGatoAzul.getData().setVertical(true);
		smallGatoNaranja.getData().setVertical(true);

		// Añadimos todos los gatos al Hashmap
		sprites.put(smallGatoAzul.getData().getId(), smallGatoAzul);
		sprites.put(smallGatoVerde.getData().getId(), smallGatoVerde);
		sprites.put(smallGatoNaranja.getData().getId(), smallGatoNaranja);
		sprites.put(bigGatoLila.getData().getId(), bigGatoLila);
		sprites.put(bigGatoAzul.getData().getId(), bigGatoAzul);
		sprites.put(bigGatoVerde.getData().getId(), bigGatoVerde);
		sprites.put(bigGatoAmarillo.getData().getId(), bigGatoAmarillo);

		// CREACIÓN PÁJARO
		pajaro = new Sprite(300, 350, 195, 95, Color.RED, new Entidad(7, 2, 1, 1, 2));
		// Añadimos el pájaro al Hashmap
		sprites.put(pajaro.getData().getId(), pajaro);

		// Incluimos todos los sprites en el tablero
		for (int key : sprites.keySet()) {
			tablero.putEntity(sprites.get(key).getData());
		}

		// TIEMPO
		tiempoInicial = System.nanoTime();
	}

	/**
	 * Método para pintar todos los elementos en la pantalla
	 */
	@Override
	public void pintarPantalla(Graphics g) {
		// Pintar fondo de la pantalla
		g.setColor(new Color(255, 168, 200));
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());

		// FONDO TEMPORIZADOR
		g.drawImage(imagenTemporizador, 20, 20, 140, 100, null);

		// TIEMPO
		g.setFont(fuenteTiempo);
		g.setColor(colorTiempo);
		g.drawString(formato.format((System.nanoTime() - tiempoInicial) / 1e9), 45, 90);

		// TITULO DEL NIVEL
		g.setFont(new Font("Goudy Stout", Font.PLAIN, 20));
		g.setColor(colorTiempo);
		g.drawString("NIVEL 1", 200, 90);

		// TABLERO
		g.setColor(colorTablero);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				g.fillRect((i * 100) + 200, (j * 100) + 150, 95, 95);
			}
		}

		// Volver
		g.setFont(new Font("Goudy Stout", Font.PLAIN, 20));
		g.setColor(Color.BLACK);
		g.drawString("Volver (V)", 760, 820);

		// GATOS
		smallGatoVerde.pintarEnMundo(g);
		smallGatoNaranja.pintarEnMundo(g);
		smallGatoAzul.pintarEnMundo(g);

		bigGatoLila.pintarEnMundo(g);
		bigGatoAzul.pintarEnMundo(g);
		bigGatoVerde.pintarEnMundo(g);
		bigGatoAmarillo.pintarEnMundo(g);

		// PÁJARO
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
		// Si no hay ningún sprite selecionado
		if (this.selectedSpriteId == -1) {
			noHaySpriteSeleccionado(e);
		}
		// Si ya hay un sprite seleccionado
		else {
			haySpriteSeleccionado(e);
		}
	}

	@Override
	public void pulsarTecla(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("v")) {
			panelJuego.setPantalla(new PantallaInicio(panelJuego));
		}

	}
	
	
	public void noHaySpriteSeleccionado(MouseEvent e) {
		// Esta variable devuelve un número positivo si lo que seleccionamos es un gato,
		// y -1 si seleccionamos una casilla vacía
		int found = -1;
		int i = 0;

		// Vamos recorriendo toda la lista de gatos
		while (i < this.sprites.size() && found == -1) {
			Sprite gA = this.sprites.get(i);

			// Determinamos los límites del bloque
			int maxX = gA.getPosX() + gA.getAncho();
			int maxY = gA.getPosY() + gA.getAlto();

			// Si el click del ratón está dentro de los límites del bloque (o sea, si
			// hacemos click en el bloque)
			if ((e.getX() >= gA.getPosX() && e.getX() <= maxX) && (e.getY() >= gA.getPosY() && e.getY() <= maxY)) {
				found = i;
			}

			i++;
		}

		// Si hemos clickado un bloque
		if (found >= 0) {
			this.selectedSpriteId = found;
		}

		// Control para ver por consola si el número de la lista de sprites que devuelve
		// se corresponde con el sprite clickado
		if (this.selectedSpriteId >= 0) {
			System.out.println(this.sprites.get(this.selectedSpriteId));
		}
	}

	public void haySpriteSeleccionado(MouseEvent e) {
		int found = -2;
		Casilla casillaElegida = null;

		for (int i = 0; i < this.tablero.getWidth() && found == -2; i++) {
			for (int z = 0; z < this.tablero.getHeight() && found == -2; z++) {
				// Obtenemos la casilla
				Casilla casilla = this.tablero.getCasillas()[i][z];

				// Obtenemos los límites de la casilla
				int minX = z * 100 + (200);
				int minY = i * 100 + (150);
				int maxX = minX + 100;
				int maxY = minY + 100;

				// Si el click del ratón está dentro de los límites de la casilla
				if ((e.getX() >= minX && e.getX() <= maxX) && (e.getY() >= minY && e.getY() <= maxY)) {
					// Obtenemos el estado de la casilla para ver si está ocupada (-1) o no
					found = casilla.getState();
					casillaElegida = casilla;
				}
			}
		}

		// Control para ver si el id del sprite que nos devuelve corresponde con el que
		// hemos clickado
		System.out.println("pieza = " + found);

		// Si la casilla de destino está vacía
		if (found == -1) {
			comprobarOrientacion(casillaElegida);
		}
		this.selectedSpriteId = -1;
	}

	public void comprobarOrientacion(Casilla casillaElegida) {
		// Creamos un nuevo sprite que recoge el bloque que seleccionemos
		Sprite piezaElegida = this.sprites.get(this.selectedSpriteId);

		// Buscar la pieza
		if (piezaElegida != null) {
			// Control para ver por consola el bloque que está seleccionado
			System.out.println(piezaElegida);

			// Si el bloque seleccionado es vertical
			if (piezaElegida.getData().getVertical()) {
				comprobarMovimientoVertical(casillaElegida, piezaElegida);
			}
			// Si es horizontal
			else {
				comprobarMovimientoHorizontal(casillaElegida, piezaElegida);
			}
		}

		if(esVictoria()) {
			panelJuego.setPantalla(new PantallaVictoria(panelJuego, System.nanoTime() - tiempoInicial));
		}
	}

	public boolean esVictoria() {
		return (pajaro.getData().getxOrigin() == this.tablero.getWidth() - pajaro.getData().getxSize());
	}
	
	public void comprobarMovimientoVertical(Casilla casillaElegida, Sprite piezaElegida) {
		boolean isDescendente = piezaElegida.getData().getyOrigin() < casillaElegida.getPosY();

		System.out.println("Movimiento Vertical " + (isDescendente ? "Descendente" : "Ascendente"));

		int initRange = !isDescendente ? casillaElegida.getPosY() : piezaElegida.getData().getyOrigin();
		int finRange = isDescendente ? casillaElegida.getPosY() : piezaElegida.getData().getyOrigin();
		int x = casillaElegida.getPosX();
		boolean movimientoPosible = true;

		for (int i = initRange; i <= finRange && movimientoPosible; i++) {
			if (this.tablero.getCasillas()[i][x].getState() != piezaElegida.getData().getId()
					&& this.tablero.getCasillas()[i][x].getState() != -1) {
				movimientoPosible = false;
			}
		}

		if (movimientoPosible) {
			System.out.println("Movimiento posible");

			moverPiezaVertical(casillaElegida, piezaElegida, isDescendente);
			movimientoPosible = false;
		}
	}

	public void comprobarMovimientoHorizontal(Casilla casillaElegida, Sprite piezaElegida) {
		boolean isDerecha = piezaElegida.getData().getxOrigin() < casillaElegida.getPosX();
		System.out.println("Movimiento Horizontal " + (isDerecha ? "Derecho" : "Izquierdo"));

		int initRange = !isDerecha ? casillaElegida.getPosX() : piezaElegida.getData().getxOrigin();
		int finRange = isDerecha ? casillaElegida.getPosX() : piezaElegida.getData().getxOrigin();
		int y = casillaElegida.getPosY();
		boolean movimientoPosible = true;

		for (int i = initRange; i <= finRange && movimientoPosible; i++) {
			if (this.tablero.getCasillas()[y][i].getState() != piezaElegida.getData().getId()
					&& this.tablero.getCasillas()[y][i].getState() != -1) {
				movimientoPosible = false;
			}
		}

		if (movimientoPosible) {
			System.out.println("Movimiento posible");
			moverPiezaHorizontal(casillaElegida, piezaElegida, isDerecha);

			movimientoPosible = false;
		}
	}

	public void moverPiezaVertical(Casilla casillaElegida, Sprite piezaElegida, boolean isDescendente) {
		int nuevaPosicion;

		if (isDescendente) {
			nuevaPosicion = casillaElegida.getPosY() - (piezaElegida.getData().getySize() - 1);
		} else {
			nuevaPosicion = casillaElegida.getPosY();
		}

		System.out.println(nuevaPosicion);

		// Movemos la coordenada y de origen del sprite a la de la casilla seleccionada
		piezaElegida.getData().setyOrigin(nuevaPosicion);
		piezaElegida.setPosY(piezaElegida.getData().getyOrigin() * 100 + (150));

		// Control para ver por consola si ha detectado correctamente el cambio de
		// coordenada de la casilla y si sabe que tiene que repintarla en la nueva
		// posición
		System.out.println("Pintamos");
		
		repintarPieza(piezaElegida);

	}

	public void moverPiezaHorizontal(Casilla casillaElegida, Sprite piezaElegida, boolean isDerecha) {
		int nuevaPosicion;

		if (isDerecha) {
			nuevaPosicion = casillaElegida.getPosX() - (piezaElegida.getData().getxSize() - 1);
		} else {
			nuevaPosicion = casillaElegida.getPosX();
		}

		System.out.println(nuevaPosicion);

		piezaElegida.getData().setxOrigin(nuevaPosicion);
		piezaElegida.setPosX(piezaElegida.getData().getxOrigin() * 100 + (200));

		System.out.println("Pintamos");

		repintarPieza(piezaElegida);
	}

	public void repintarPieza(Sprite piezaElegida) {
		// Eliminamos el sprite de su posición inicial en el tablero y lo incluimos en
		// la posición final
		this.tablero.clearEntity(piezaElegida.getData().getId());
		this.tablero.putEntity(piezaElegida.getData());
	}
}
