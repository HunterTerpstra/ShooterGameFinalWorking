/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package Entity;

import TileMap.*;

import java.awt.*;

import GameState.Level1State;

public class Player extends MapObject{

	//Player stats
	public static int health; 
	public static int score;
	public boolean dead;
	Rectangle playerRectangle;
	Level1State game;

	//Firing
	public static boolean firing;

	public Player(TileMap tm, Level1State game) {
		super(tm);
		this.game = game;
		//player size
		width = 8;
		height = 8;

		//player collision size
		cwidth = 8;
		cheight = 8;

		//speed
		moveSpeed = 4;//acceleration
		maxSpeed = 4;
		stopSpeed = 4;//deceleration

		//player stats
		health=100;
		score = 0;


		playerRectangle = new Rectangle ((int) x, (int) y, cwidth, cheight); //hitbox
	}

	//health bar UI
	public static void displayHealthBar(Graphics2D g) {
		g.setColor(Color.RED); //missing health
		g.fillRect(495, 15, 100, 20);
		g.setColor(Color.GREEN); //current health
		g.fillRect(495, 15, health, 20);	
		g.setColor(Color.black);
		g.drawString(Integer.toString(health), 530, 35); //shows health as integer
	}


	public static int getHealth() {
		return health; //gets health
	}

	public int getScore() {
		return score; //gets score

	}

	//gets player movement
	private void getNextPosition() {
		if(left) {
			dx-=moveSpeed;
			if (dx < -maxSpeed) {//accelerate to max
				dx = -maxSpeed;
			}
		}
		else if(right) {
			dx+=moveSpeed;
			if (dx > maxSpeed) {//accelerate to max
				dx = maxSpeed;
			}
		}
		else {
			if (dx > 0) {//decelerates to stop
				dx-=stopSpeed;
				if (dx < 0) dx = 0;
			}
			else if (dx < 0) {//decelerates to stop
				dx+=stopSpeed;
				if (dx > 0) dx = 0;
			} 
		}

		if(up) {
			dy-=moveSpeed;
			if (dy < -maxSpeed) {//accelerate to max
				dy = -maxSpeed;
			}
		}
		else if(down) {
			dy+=moveSpeed;
			if (dy > maxSpeed) {//accelerate to max
				dy = maxSpeed;
			}
		}
		else {
			if (dy > 0) {//decelerates to stop
				dy-=stopSpeed;
				if (dy < 0) dy = 0;
			}
			else if (dy < 0) {//decelerates to stop
				dy+=stopSpeed;
				if (dy > 0) dy = 0;
			} 
		}
		playerRectangle.setLocation((int)x, (int)y); //sets hitbox location to new place
	}

	public void setFiring() {
		firing = true; //firing to true
	}
	public void stopFiring() {
		firing = false; //firing to false
	}

	//updates the player class for position and collision
	public void update() {
		getNextPosition(); 
		checkCollision();
		setPosition(x + dx, y + dy);
	}
	
	//updates the models
	public void draw(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.fillRect((int)(x-width/2), (int)(y-height/2), width, height);//Draws player
		g.setColor(Color.BLUE);
		g.drawRect((int)(x-cwidth/2), (int)(y-cheight/2), width, height);//Draws collision box

		//draws the score number
		Font font1 = new Font("bold", Font.BOLD, 25); 
		g.setColor(Color.WHITE);
		g.setFont(font1);
		g.drawString(Integer.toString(score), 530, 65);

	}
}
