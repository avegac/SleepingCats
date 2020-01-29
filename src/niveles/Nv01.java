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

	/**
	 * Método para pintar todos los elementos en la pantalla
	 */
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
		//Si no hay ningún sprite selecionado
		if(this.selectedSprite == -1) {
			//Esta variable devuelve un número positivo si lo que seleccionamos es un gato, y -1 si seleccionamos una casilla vacía
			int found = -1;
			int i = 0;
			
			//Vamos recorriendo toda la lista de gatos
			while(i < this.gatos.size() && found == -1) {
				//Prueba con el gato amarillo (gA)
				Sprite gA = this.gatos.get(i);
				
				//Determinamos los límites del bloque
				int maxX = gA.getPosX() + gA.getAncho();
				int maxY = gA.getPosY() + gA.getAlto();
				
				//Si el click del ratón está dentro de los límites del bloque (o sea, si hacemos click en el bloque)
				if((e.getX() >= gA.getPosX() && e.getX() <= maxX) && (e.getY() >= gA.getPosY() && e.getY() <= maxY)){
					found = i;
				}
				
				++i;
			}
			
			//Si hemos clickado un bloque
			if (found >= 0) {
				this.selectedSprite = found;
			}
			
			//Control para ver por consola si el número de la lista de sprites que devuelve se corresponde con el sprite clickado
			if(this.selectedSprite >= 0) {
				System.out.println(this.gatos.get(this.selectedSprite));
			}
		}
		//Si ya hay un sprite seleccionado
		else {
			int found = -2;
			int i;
			int z = 0;
			
			for(i = 0; i < this.tablero.getWidth() && found == -2; ++i) {
				for(z = 0; z < this.tablero.getHeight() && found == -2; ++z) {
					//Obtenemos la casilla
					Casilla casilla = this.tablero.getCasillas()[i][z];
					
					//Obtenemos los límites de la casilla
					int minX = z*100 + (200);
					int minY = i*100 + (150);
					int maxX = minX + 100;
					int maxY = minY + 100;
					
					//Si el click del ratón está dentro de los límites de la casilla
					if((e.getX() >= minX && e.getX() <= maxX) && (e.getY() >= minY && e.getY() <= maxY)) {
						//Obtenemos el estado de la casilla para ver si está ocupada (-1) o no
						found = casilla.getState();
						
						//Control para ver por consola si estamos detectando correctamente las coordenadas de la casilla
						System.out.println(minX);
					}
					
				}
			}
			
			//Control para ver si el id del sprite que nos devuelve corresponde con el que hemos clickado
			System.out.println("pieza = "+found);
			
			if(found == -1) {
				//Creamos un nuevo sprite que recoge el bloque que seleccionemos
				Sprite piezaElegida = null;
				
				//Buscar la pieza
				for(Sprite gato: this.gatos) {
					//Si el id de uno de los bloques corresponde con el sprite seleccionado
					if(gato.getData().getId() == this.selectedSprite) {
						piezaElegida = gato;
					}
				}
				
				if(piezaElegida == null) {
					//Si el id del pájaro corresponde con el sprite seleccionado
					if(this.pajaro.getData().getId() == this.selectedSprite) {
						piezaElegida = this.pajaro;
					}
				}
				
				if(piezaElegida != null) {
					//Control para ver por consola el bloque que está seleccionado
					System.out.println(piezaElegida);
					
					//Si el bloque seleccionado es vertical
					if(piezaElegida.getData().getVertical()) {
						int a;
						boolean movimientoPosible = true;
						z--;
						
						for(a = 0; a < this.tablero.getHeight() && movimientoPosible; ++a) {
							//Comprobamos las casillas cuyo estado corresponde con la id del sprite seleccionado
							if(this.tablero.getCasillas()[a][z].getState() == piezaElegida.getData().getId()) {
								System.out.println();
								
								int initRange = piezaElegida.getData().getyOrigin() > i - 1 ? i - 1 : piezaElegida.getData().getyOrigin();
								int endRange = piezaElegida.getData().getyOrigin() > i - 1 ? piezaElegida.getData().getyOrigin() : i - 1;
								
								//Control para ver si se han registrado correctamente las coordenadas y del sprite
								System.out.println(initRange);
								System.out.println(endRange);
								
								for(int b = initRange; b <= endRange && movimientoPosible; b++) {
									System.out.println(z);
									System.out.println(this.tablero.getCasillas()[z][b].getState());
									
									//Si la casilla está ocupada por un bloque que no es el que hemos seleccionado
									if(this.tablero.getCasillas()[b][z].getState() != -1 && this.tablero.getCasillas()[b][z].getState() != piezaElegida.getData().getId()) {
										movimientoPosible = false;
									}
								}
								
								if(movimientoPosible) {
									//Movemos la coordenada y de origen del sprite a la de la casilla seleccionada
									piezaElegida.getData().setyOrigin((i - (piezaElegida.getData().getySize())));
									
									//Si el sprite se va a salir de los bordes del tablero dejamos su origen en el borde
									if(piezaElegida.getData().getyOrigin() < 0) {
										piezaElegida.getData().setyOrigin(0);
									}
									
									piezaElegida.setPosY(piezaElegida.getData().getyOrigin()*100 + (150));
									//Control para ver por consola si ha detectado correctamente el cambio de coordenada de la casilla y si sabe que tiene que repintarla en la nueva posición
									System.out.println("Pintamos");
									
									movimientoPosible = false;
									
									//Eliminamos el sprite de su posición inicial en el tablero y lo incluimos en la posición final
									this.tablero.clearEntity(piezaElegida.getData().getId());
									this.tablero.putEntity(piezaElegida.getData());
								}
							}
						}
					}
					//Si el bloque elegido no es vertical
					else {
						//Control para comprobar por consola si está detectando que el bloque elegido no es vertical
						System.out.println("No vertical");
						
						int a;
						boolean movimientoPosible = true;
						i--;
						
						//Ahora recorremos el eje x
						for(a = 0; a < this.tablero.getWidth() && movimientoPosible; ++a) {
							//Si el estado de la casilla corresponde con el id del bloque elegido
							if(this.tablero.getCasillas()[a][i].getState() == piezaElegida.getData().getId()) {
								System.out.println();
								
								int initRange = piezaElegida.getData().getxOrigin() > z - 1 ? z - 1 : piezaElegida.getData().getxOrigin();
								int endRange = piezaElegida.getData().getxOrigin() > z - 1 ? piezaElegida.getData().getxOrigin() : z - 1;
								
								//Control para ver si se han registrado correctamente las coordenadas del sprite
								System.out.println(initRange);
								System.out.println(endRange);
								
								for(int b = initRange; b <= endRange && movimientoPosible; b++) {
									System.out.println(i);
									System.out.println(this.tablero.getCasillas()[i][b]);
									System.out.println(this.tablero.getCasillas()[b][i]);
									System.out.println(piezaElegida.getData().getId());
									
									//Si la casilla está ocupada por un bloque que no es el que hemos seleccionado
									if(this.tablero.getCasillas()[b][i].getState() != -1 && this.tablero.getCasillas()[b][i].getState() != piezaElegida.getData().getId()) {
										movimientoPosible = false;
									}
									
									if(movimientoPosible) {
										piezaElegida.getData().setxOrigin((z - (piezaElegida.getData().getySize())));
										
										//Si el sprite se va a salir del borde del tablero
										if(piezaElegida.getData().getxOrigin() < 0) {
											piezaElegida.getData().setxOrigin(0);
										}
										
										piezaElegida.setPosX(piezaElegida.getData().getxOrigin()*100 + (200));
										//Control
										System.out.println("Pintamos");
										
										movimientoPosible = false;
										this.tablero.clearEntity(piezaElegida.getData().getId());
										this.tablero.putEntity(piezaElegida.getData());
									}
								}
							}
						}
					}
				}
			}
			this.selectedSprite = -1;
		}
		
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
