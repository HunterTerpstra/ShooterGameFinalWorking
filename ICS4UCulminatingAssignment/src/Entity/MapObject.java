/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package Entity;

import java.awt.Rectangle;
import TileMap.TileMap;

public abstract class MapObject {
	
	//Tilemap
	protected TileMap tileMap;
	
	//position and vector
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	protected double xdest;
	protected double ydest;
	
	//dimensions
	protected int width;
	protected int height;
	
	//collision box
	protected int cwidth;
	protected int cheight;
	
	//movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	
	//movement attributes
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	
	//constructor
	public MapObject (TileMap tm) {
		tileMap = tm;
	}
	
	//hitbox for player 
	public Rectangle getRectangle() {
		return new Rectangle((int)x-cwidth,(int)y-cheight,cwidth,cheight);
	}
	
	//checks collision from tilemap
	public void checkCollision() {
		xdest = x + dx; //calculates where player will be  
		ydest = y + dy;
		
		//if players next position is where a block is
		for (int i = 0;i<tileMap.getBlocks();i++) {
			if(xdest==tileMap.getXMap(i) && ydest==tileMap.getYMap(i)) {
				dx = 0; //makes them not move
				dy = 0;
			}
		}
	}
	
	//getters and setters
	public int getx() {return (int)x;}
	public int gety() {return (int)y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public int getCWidth() {return cwidth;}
	public int getcHeight() {return cheight;}
	
	public void setPosition (double x, double y) {
		this.x = x; //sets position
		this.y = y;
	}
	
	public void setVector (double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setLeft(boolean b) {left = b;}
	public void setRight(boolean b) {right = b;}
	public void setUp(boolean b) {up = b;}
	public void setDown(boolean b) {down = b;}
}
