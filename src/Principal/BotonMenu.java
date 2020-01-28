package Principal;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BotonMenu {
	/**Coordenadas**/
	private int posX;
	private int posY;
	/**Dimensiones**/
	private int ancho;
	private int alto;
	/**Buffer para la imagen de fondo**/
	private BufferedImage buffer;
	
	public BotonMenu(int posX, int posY, int ancho, int alto, String ruta) {
		this.posX = posX;
		this.posY = posY; 
		this.ancho = ancho; 
		this.alto = alto;
		
		pintarBuffer(ruta);
	}
	
	/**
	 * Estampa en el buffer la imagen de la ruta
	 * @param ruta
	 */
	public void pintarBuffer(String ruta) {
		buffer = new BufferedImage(this.ancho, this.alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.getGraphics();
		
		//Cargar la imagen, redimensionarla y estamparla
		try {
			BufferedImage img = ImageIO.read(new File(ruta));
			g.drawImage(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH), 0,0, null);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		g.dispose();
	}
	
	public void pintarEnMundo(Graphics g) {
		g.drawImage(buffer, posX, posY, null);
	}
	
	
}
