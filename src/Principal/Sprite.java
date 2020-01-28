package Principal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Representa un objeto en movimiento.
 * Los sprites son colisionables.
 * Un Sprite se concibe como un BufferedImage con un ancho, alto y posición que tiene una velocidad y que se puede estambar en un {@link Graphics}
 * @author Alba Vega Calzado
 *
 */
public class Sprite {
	protected int posX;
	protected int posY;
	protected int ancho;
	protected int alto;
	protected BufferedImage buffer;
	
	
	/**
	 * Constructor privado para evitar repetición de código en los otros constructores.
	 */
	private Sprite(int posX, int posY, int ancho,int alto) {
		this.posX = posX;
		this.posY = posY; 
		this.ancho = ancho; 
		this.alto = alto;
	}
	
	/**
	 * Inicializa el {@link Sprite} con un color.
	 * @param color Color del sprite.
	 */
	public Sprite(int posX, int posY, int ancho,int alto, Color color) {
		this(posX, posY, ancho, alto);
		pintarBuffer(color);
	}
	/**
	 * Inicializa el {@link Sprite} a partir de una ruta.
	 * Si hay varios sprites con la misma ruta, mejor evitar este constructor para evitar accesos a disco.
	 * @param ruta Ruta de la imagen.
	 */
	public Sprite(int posX, int posY, int ancho,int alto, String ruta) {
		this(posX, posY, ancho, alto);
		pintarBuffer(ruta);
	}
	
	/**
	 * Pinta el buffer del color dado
	 * @param color
	 */
	private void pintarBuffer(Color color) {
		buffer = new BufferedImage(this.ancho, this.alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.getGraphics();
		g.setColor(color);
		g.fillRect(0, 0, this.ancho, this.alto);
		g.dispose();
	}
	
	/**
	 * Estampa en el buffer la imagen de la ruta.
	 * @param ruta
	 */
	private void pintarBuffer(String ruta) {
		buffer = new BufferedImage(this.ancho, this.alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.getGraphics();
		//Cargar la imagen, redimensionarla y estamparla:
		try {
			BufferedImage img = ImageIO.read(new File(ruta));
			g.drawImage(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH), 0, 0, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.dispose();
	}
	
	

	/**
	 * Actualiza la posici�n del Sprite para que siempre se mantega en el panelJuego.
	 * @param panelJuego
	 */
	/*public void actualizarPosicion(PanelJuego panelJuego) {
		
		if(posX+ancho >= panelJuego.getWidth()) { //Si te vas por la derecha!
			velX= - Math.abs(velX);
		}
		if(posX <0 ) {
			velX = Math.abs(velX) ;
		}
		
		//Eje vertical:
		if(posY+alto >= panelJuego.getHeight()) { //Si te vas por abajo!!
			velY = - Math.abs(velY);
		}
		if(posY < 0) {
			velY = Math.abs(velY);
		}
		
		posX = posX+velX;
		posY = posY+velY;
	}*/
	
	/**
	 * Comprueba si hay colisi�n entre este Sprite y otro que viene por par�metros.
	 * La colisi�n es cuadrada.
	 * @param otro
	 * @return
	 */
	public boolean colisiona(Sprite otro) {
		boolean colisionX = posX < otro.posX ? 
				(posX+ancho >= otro.posX) : 
					(otro.posX+otro.ancho >=posX);
				
		boolean colisionY = posY < otro.posY ? 
				(posY+alto >= otro.posY) : 
					(otro.posY+otro.alto >=posY);
		
		return colisionX && colisionY;
	}
	
	/**
	 * Estampa el {@link Sprite#buffer} del {@link Sprite} en el gr�ficos de entrada.
	 * @param g
	 */
	public void pintarEnMundo(Graphics g) {
		g.drawImage(buffer, posX, posY, null);
	}

	
	/** GETTERS && SETTERS **/

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}	
}
