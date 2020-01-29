package Principal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import niveles.Nv01;
import utiles.Entidad;

/**
 * Representa un objeto en movimiento.
 * Los sprites son colisionables.
 * Un Sprite se concibe como un BufferedImage con un ancho, alto y posición que tiene una velocidad y que se puede estambar en un {@link Graphics}
 * @author Alba Vega Calzado
 *
 */
public class Sprite{
	protected int posX;
	protected int posY;
	protected int ancho;
	protected int alto;
	protected BufferedImage buffer;
	protected Entidad data;
	
	/**
	 * Constructor privado para evitar repetición de código en los otros constructores.
	 */
	private Sprite(int posX, int posY, int ancho,int alto) {
		this.posX = posX;
		this.posY = posY; 
		this.ancho = ancho; 
		this.alto = alto;
	}
	
	private Sprite(int posX, int posY, int ancho,int alto, Entidad data) {
		this.posX = posX;
		this.posY = posY; 
		this.ancho = ancho; 
		this.alto = alto;
		this.data = data;
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
	 * Inicializa el {@link Sprite} con un color.
	 * @param color Color del sprite.
	 */
	public Sprite(int posX, int posY, int ancho,int alto, Color color, Entidad data) {
		this(posX, posY, ancho, alto, data);
		
		pintarBuffer(color);
	}
	/**
	 * Inicializa el {@link Sprite} a partir de una ruta.
	 * Si hay varios sprites con la misma ruta, mejor evitar este constructor para evitar accesos a disco.
	 * @param ruta Ruta de la imagen.
	 */
	public Sprite(int posX, int posY, int ancho,int alto, String ruta, Entidad data) {
		this(posX, posY, ancho, alto, data);
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
	
	public Entidad getData() {
		return data;
	}
	
	public void setData(Entidad data) {
		this.data = data;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public String toString() {
		return "Sprite [posX=" + posX + ", posY=" + posY + ", ancho=" + ancho + ", alto=" + alto + ", buffer=" + buffer+ ", data=" + data + "]";
	}
}
