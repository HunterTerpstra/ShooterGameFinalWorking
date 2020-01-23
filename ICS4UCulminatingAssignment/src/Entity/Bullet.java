/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Bullet {

	//variables for x and y cords, directions, speed, and hitbox
	private int x; 
	private int y;
	private int direction;
	private int bulletSpeed;
	private Rectangle bullet;

	public Bullet(int x, int y, int direction){
		this.x =x; //sets x cord
		this.y=y;  //sets y cord
		this.direction = direction; //sets direction
		this.bulletSpeed = 5;  //bullet speed is 5
		bullet = new Rectangle(x,y,5,5); //creates a bullet rectangle for hitbox
	}

	public void tick() { //update method that runs over and over
		
		switch (direction){
		case 1:
			x -= bulletSpeed; //makes bullet go left
			break;
		case 2:
			x += bulletSpeed; //makes bullet go right
			break;
		case 3:
			y -= bulletSpeed; //makes bullet go up
			break;
		case 4:
			y += bulletSpeed; //makes bullet go down
			break;
		}
		bullet.setLocation(x, y); //sets new hitbox location for bullet
	}

	public int getX() {
		return x; //gets x
	}
	
	public int getY() {
		return y; //gets y
	}
	
	public Rectangle getRect() {
		return bullet; //gets hitbox
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 5, 5);
	}


}


