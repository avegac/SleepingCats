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
import java.util.HashMap;

import javax.imageio.ImageIO;

import Principal.PanelJuego;
import Principal.Sprite;
import pantallas.IPantalla;
import pantallas.MenuIntermedio;
import pantallas.PantallaVictoria;
import utiles.Casilla;
import utiles.Entidad;
import utiles.Tablero;

/**
 * Nivel 1 de dificultad Intermedio (nivel 11).
 * 
 * @author Alba Vega Calzado
 *
 */

public class Nv11 implements IPantalla {
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

	/** SPRITES NIVEL 11 **/
	Sprite pajaro;

	Sprite smallGatoVerde;
	Sprite smallGatoNaranja;
	Sprite smallGatoMorado;

	Sprite bigGatoLila;
	Sprite bigGatoAmarillo;
	Sprite bigGatoAzul;
	Sprite bigGatoVerde;

	Sprite meta;

	HashMap<Integer, Sprite> sprites;
	int selectedSpriteId = -1;

	/**
	 * Constructor al que le pasamos el panel de juego para que inicialice los
	 * elementos del nivel
	 * 
	 * @param panel
	 */
	public Nv11(PanelJuego panel) {
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

		smallGatoVerde = new Sprite(300, 150, 195, 95, new Color(141, 214, 116), new Entidad(0, 2, 1, 1, 0));
		smallGatoNaranja = new Sprite(400, 450, 95, 195, new Color(252, 148, 58), new Entidad(1, 1, 2, 2, 3));
		smallGatoMorado = new Sprite(700, 550, 95, 195, new Color(127, 44, 207), new Entidad(2, 1, 2, 5, 4));

		bigGatoLila = new Sprite(500, 150, 95, 295, new Color(192, 152, 240), new Entidad(3, 1, 3, 3, 0));
		bigGatoAmarillo = new Sprite(200, 150, 95, 295, new Color(255, 235, 67), new Entidad(4, 1, 3, 0, 0));
		bigGatoAzul = new Sprite(500, 450, 295, 95, new Color(24, 46, 152), new Entidad(5, 3, 1, 3, 3));
		bigGatoVerde = new Sprite(400, 650, 295, 95, new Color(14, 127, 84), new Entidad(6, 3, 1, 2, 5));

		// Indicamos qué gatos son los que están en posición vertical
		smallGatoMorado.getData().setVertical(true);
		smallGatoNaranja.getData().setVertical(true);
		bigGatoLila.getData().setVertical(true);
		bigGatoAmarillo.getData().setVertical(true);

		// Añadimos todos los gatos al Hashmap
		sprites.put(smallGatoVerde.getData().getId(), smallGatoVerde);
		sprites.put(smallGatoNaranja.getData().getId(), smallGatoNaranja);
		sprites.put(smallGatoMorado.getData().getId(), smallGatoMorado);
		sprites.put(bigGatoLila.getData().getId(), bigGatoLila);
		sprites.put(bigGatoAmarillo.getData().getId(), bigGatoAmarillo);
		sprites.put(bigGatoAzul.getData().getId(), bigGatoAzul);
		sprites.put(bigGatoVerde.getData().getId(), bigGatoVerde);

		// CREACIÓN PÁJARO
		pajaro = new Sprite(300, 350, 195, 95, Color.RED, new Entidad(7, 2, 1, 1, 2));
		// Añadimos el pájaro al Hashmap
		sprites.put(pajaro.getData().getId(), pajaro);

		// Incluimos todos los sprites en el tablero
		for (int key : sprites.keySet()) {
			tablero.putEntity(sprites.get(key).getData());
		}

		// META
		meta = new Sprite(760, 330, 150, 150, "src/Imagenes/meta.png");

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
		g.drawString("NIVEL 11", 200, 90);

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

		// SPRITES
		for (int key : sprites.keySet()) {
			sprites.get(key).pintarEnMundo(g);
		}

		meta.pintarEnMundo(g);
	}

	@Override
	public void ejecutarFrame() {
		// TODO Auto-generated method stub

	}

	/**
	 * Listener que recoge el click del ratón sobre la pantalla. En función de si ya
	 * habíamos hecho click con anterioridad en un sprite o no, nos dirige a un
	 * método diferente.
	 */
	@Override
	public void pulsarRaton(MouseEvent e) {
		if (this.selectedSpriteId == -1) {
			noHaySpriteSeleccionado(e);
		} else {
			haySpriteSeleccionado(e);
		}
	}

	/**
	 * Método que detecta la tecla pulsada y nos devuelve a la pantalla
	 * correspondiente
	 */
	@Override
	public void pulsarTecla(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("v")) {
			panelJuego.setPantalla(new MenuIntermedio(panelJuego));
		}
	}

	/**
	 * Método que se llama si no había ningún sprite seleccionado cuando hacemos
	 * click con el ratón sobre el tablero. Recorre la lista de bloques y determina
	 * sus dimensiones, después comprueba si las coordenadas del ratón se encuentran
	 * dentro de alguno de los bloques calculados.
	 * 
	 * Si el click está dentro de uno de los bloques, la id del sprite seleccionado
	 * pasa a ser la misma que la de found
	 * 
	 * @param e
	 *            Click del ratón
	 */
	public void noHaySpriteSeleccionado(MouseEvent e) {
		int found = -1;
		int i = 0;

		/* Vamos recorriendo toda la lista de gatos */
		while (i < this.sprites.size() && found == -1) {
			Sprite gA = this.sprites.get(i);

			/* Determinamos los límites del bloque */
			int maxX = gA.getPosX() + gA.getAncho();
			int maxY = gA.getPosY() + gA.getAlto();

			/*
			 * Si el click del ratón está dentro de los límites del bloque (o sea, si
			 * hacemos click en el bloque)
			 */
			if ((e.getX() >= gA.getPosX() && e.getX() <= maxX) && (e.getY() >= gA.getPosY() && e.getY() <= maxY)) {
				found = i;
			}

			i++;
		}

		if (found >= 0) {
			this.selectedSpriteId = found;
		}

		/*
		 * Control para ver por consola si el número de la lista de sprites que devuelve
		 * se corresponde con el sprite clickado
		 */
		if (this.selectedSpriteId >= 0) {
			System.out.println(this.sprites.get(this.selectedSpriteId));
		}
	}

	/**
	 * Método que se llama si ya hay un sprite seleccionado cuando hacemos click con
	 * el ratón, lo que indica que nuestro click va a ser la casilla a la que
	 * queremos mover ese sprite.
	 * 
	 * Obtiene las coordenadas de la casilla seleccionada y sus dimensiones y
	 * comprueba si está o no ocupada. Si está vacía, llama al método que comprueba
	 * la orientación de la pieza que queremos mover (horizontal o vertical)
	 * 
	 * @param e
	 *            Click del ratón
	 */
	public void haySpriteSeleccionado(MouseEvent e) {
		int found = -2;
		Casilla casillaElegida = null;

		for (int i = 0; i < this.tablero.getWidth() && found == -2; i++) {
			for (int z = 0; z < this.tablero.getHeight() && found == -2; z++) {
				/* Obtenemos la casilla */
				Casilla casilla = this.tablero.getCasillas()[i][z];

				/* Obtenemos los límites de la casilla */
				int minX = z * 100 + (200);
				int minY = i * 100 + (150);
				int maxX = minX + 100;
				int maxY = minY + 100;

				/* Si el click del ratón está dentro de los límites de la casilla */
				if ((e.getX() >= minX && e.getX() <= maxX) && (e.getY() >= minY && e.getY() <= maxY)) {
					/* Obtenemos el estado de la casilla para ver si está ocupada (-1) o no */
					found = casilla.getState();
					casillaElegida = casilla;
				}
			}
		}

		/*
		 * Control para ver si el id del sprite que nos devuelve corresponde con el que
		 * hemos clickado
		 */
		System.out.println("pieza = " + found);

		/* Si la casilla de destino está vacía */
		if (found == -1) {
			comprobarOrientacion(casillaElegida);
		}
		this.selectedSpriteId = -1;
	}

	/**
	 * Método que comprueba si la pieza que queremos mover es horizontal o vertical.
	 * 
	 * En función de la orientación de la pieza, llama a un método u otro.
	 * 
	 * También comprueba si se han producido las condiciones de victoria después de
	 * realizar el movimiento.
	 * 
	 * @param casillaElegida
	 *            Casilla que tenemos seleccionada como destino
	 */
	public void comprobarOrientacion(Casilla casillaElegida) {
		/* Creamos un nuevo sprite que recoge el bloque que seleccionemos */
		Sprite piezaElegida = this.sprites.get(this.selectedSpriteId);

		/* Buscar la pieza */
		if (piezaElegida != null) {
			// Control para ver por consola el bloque que está seleccionado
			System.out.println(piezaElegida);

			/* Si el bloque seleccionado es vertical */
			if (piezaElegida.getData().getVertical()) {
				comprobarMovimientoVertical(casillaElegida, piezaElegida);
			}
			/* Si es horizontal */
			else {
				comprobarMovimientoHorizontal(casillaElegida, piezaElegida);
			}
		}

		/* Si se producen las condiciones de victoria */
		if (esVictoria()) {
			panelJuego.setPantalla(new PantallaVictoria(panelJuego, System.nanoTime() - tiempoInicial));
		}
	}

	/**
	 * Método que comprueba si el movimiento a la casilla elegida se puede realizar
	 * teniendo en cuenta la orientación de la pieza, ya que aunque la casilla esté
	 * vacía hay movimientos no permitidos. Comprueba si el movimiento a realizar es
	 * hacia arriba (ascendente) o hacia abajo (descendente).
	 * 
	 * Si el movimiento es posible, llama al método para mover la pieza en vertical.
	 * 
	 * @param casillaElegida
	 *            Casilla de destino de la pieza
	 * @param piezaElegida
	 *            Pieza seleccionada con el ratón
	 */
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

	/**
	 * Método que comprueba si el movimiento a la casilla elegida se puede realizar
	 * teniendo en cuenta la orientación de la pieza, ya que aunque la casilla esté
	 * vacía hay movimientos no permitidos.
	 * 
	 * Comprueba si el movimiento a realizar es hacia la izquierda o hacia la
	 * derecha(isDerecha).
	 * 
	 * Si el movimiento es posible, llama al método para mover la pieza en
	 * horizontal.
	 * 
	 * @param casillaElegida
	 *            Casilla de destino de la pieza
	 * @param piezaElegida
	 *            Pieza seleccionada con el ratón
	 */
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

	/**
	 * Método que realiza el movimiento de la pieza en vertical en función de si es
	 * o no ascendente.
	 * 
	 * @param casillaElegida
	 *            Casilla de destino de la pieza
	 * @param piezaElegida
	 *            Pieza seleccionada
	 * @param isDescendente
	 *            Indica si el movimiento es hacia abajo o no
	 */
	public void moverPiezaVertical(Casilla casillaElegida, Sprite piezaElegida, boolean isDescendente) {
		int nuevaPosicion;

		if (isDescendente) {
			nuevaPosicion = casillaElegida.getPosY() - (piezaElegida.getData().getySize() - 1);
		} else {
			nuevaPosicion = casillaElegida.getPosY();
		}

		System.out.println(nuevaPosicion);

		/*
		 * Movemos la coordenada y de origen del sprite a la de la casilla seleccionada
		 */
		piezaElegida.getData().setyOrigin(nuevaPosicion);
		piezaElegida.setPosY(piezaElegida.getData().getyOrigin() * 100 + (150));

		/*
		 * Control para ver por consola si ha detectado correctamente el cambio de
		 * coordenada de la casilla y si sabe que tiene que repintarla en la nueva
		 * posición
		 */
		System.out.println("Pintamos");

		repintarPieza(piezaElegida);

	}

	/**
	 * Método que realiza el movimiento de la pieza en horizontal en función de si
	 * es hacia la derecha o hacia la izquierda.
	 * 
	 * @param casillaElegida
	 *            Casilla de destino de la pieza
	 * @param piezaElegida
	 *            Pieza seleccionada
	 * @param isDerecha
	 *            Indica si el movimiento es hacia la derecha o hacia la izquierda
	 */
	public void moverPiezaHorizontal(Casilla casillaElegida, Sprite piezaElegida, boolean isDerecha) {
		int nuevaPosicion;

		if (isDerecha) {
			nuevaPosicion = casillaElegida.getPosX() - (piezaElegida.getData().getxSize() - 1);
		} else {
			nuevaPosicion = casillaElegida.getPosX();
		}

		System.out.println(nuevaPosicion);

		/*
		 * Movemos la coordenada y de origen del sprite a la de la casilla seleccionada
		 */
		piezaElegida.getData().setxOrigin(nuevaPosicion);
		piezaElegida.setPosX(piezaElegida.getData().getxOrigin() * 100 + (200));

		/*
		 * Control para ver por consola si ha detectado correctamente el cambio de
		 * coordenada de la casilla y si sabe que tiene que repintarla en la nueva
		 * posición
		 */
		System.out.println("Pintamos");

		repintarPieza(piezaElegida);
	}

	/**
	 * Método que recoge los datos de la pieza que vamos a mover, la elimina del
	 * tablero y la vuelve a pintar en la nueva posición con las coordenadas nuevas.
	 * 
	 * @param piezaElegida
	 *            Pieza a mover
	 */
	public void repintarPieza(Sprite piezaElegida) {
		this.tablero.clearEntity(piezaElegida.getData().getId());
		this.tablero.putEntity(piezaElegida.getData());
	}

	/**
	 * Método que comprueba si el sprite del pájaro ha llegado al borde derecho del
	 * tablero
	 * 
	 * @return true si ha llegado al borde y false si aún no ha llegado
	 */
	public boolean esVictoria() {
		return (pajaro.getData().getxOrigin() == this.tablero.getWidth() - pajaro.getData().getxSize());
	}

}
