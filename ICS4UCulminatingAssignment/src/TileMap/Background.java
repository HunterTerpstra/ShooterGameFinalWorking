/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package TileMap;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Background {
	
	private BufferedImage image;
	
	public Background(String s) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s)); //loads background
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, 0, 0, null); //draws background
	}
}