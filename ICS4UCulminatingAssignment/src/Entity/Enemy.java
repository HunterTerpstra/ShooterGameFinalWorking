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
import java.util.Random;
import TileMap.TileMap;


public class Enemy extends MapObject {

	private double x,y;  //x and y cord of the enemy
	private Controller c; //controller object
	public Rectangle enemyRectangle; //enemy rectangle hitbox
	Random r = new Random(); //random number object
	private int speed; //speed of enemy
	Player player;


	public Enemy (double x, double y, Player player, TileMap tileMap, Controller c) {
		super(tileMap);
		this.c = c;
		this.x=x; //x cord
		this.y=y; //y cord
		this.player=player; //player
		speed = r.nextInt((4 -3) +1 )+ 3; //speed range between 3 and 6
		enemyRectangle = new Rectangle ((int) x, (int) y, 10, 10); //enemy hitbox
	}

	public void tick() {

		//if statement to get enemy as close to player in short time as possible
		if (Math.abs(disToPlayerX()) > Math.abs(disToPlayerY())) {
			if (disToPlayerX()<0) {
				x -= speed;	//moves enemy to the left
			}
			else {
				x += speed; //moves enemy to the right
			}
		}
		else {
			if (disToPlayerY()<0) {
				y-=speed; //moves enemy up
			}
			else {
				y+=speed; //moves enemy down
			}
		}
		enemyRectangle.setLocation((int)x,(int) y); //updates hitbox of enemy

		//checks all enemies and see if they run into player
		for (int i=0;i<c.getEnemys().size();i++) {
			if (enemyRectangle.getBounds().intersects(player.getRectangle().getBounds())) {
				killEnemy(); //removes the enemy
				Player.health -=10; //removes 10 health
				break; //doesn't work without this BREAK. DO NOT REMOVE
			}
		}

		//checks all bullets if they hit an enemy
		for (int i = 0;i<c.getBullets().size();i++) {
			if (enemyRectangle.getBounds().intersects(c.getBullets().get(i).getRect().getBounds())) {
				killEnemy(); //removes enemy
				c.removeBullet(c.getBullets().get(i)); //removes the bullet
				Player.score += 50;  //adds 50 to the score
			}
		}
	}


	public int disToPlayerX() {
		return player.getx()-(int)x; //gets distance from enemy to player in x direction
	}

	public int disToPlayerY() {
		return player.gety()-(int)y;//gets distance from enemy to player in y direction
	}

	public void killEnemy() {  //removes enemy
		c.removeEnemy(this);
	}
	public void removeBullet() { //removes bullet
		c.removeBullet(null);
	}

	public void render(Graphics g) { //draws the enemy 
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, 10, 10); 
	}

}
