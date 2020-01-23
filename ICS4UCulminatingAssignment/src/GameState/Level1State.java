/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;
import Entity.Bullet;
import Entity.Controller;
import Entity.Enemy;
import Entity.Player;

import Sounds.SoundClipTest;
import TileMap.*;

public class Level1State extends GameState {

	private TileMap tileMap; //tile map
	private Background bg;//background
	private static Controller c; //controller
	private Player player; //player
	public static int direction; //direction
	private long lastShotTime; //timing for shots
	Random r = new Random(); //random
	Enemy e; //enemy

	public static int wave; //waves


	public Level1State(GameStateManager gsm) {//constructor 
		this.gsm = gsm;
		init();
	}

	SoundClipTest test = new SoundClipTest();
	public void init() {
		tileMap = new TileMap("/Level1Map.png");
		tileMap.LoadLevel();
		bg = new Background("/ArenaFloor.jpg");
		wave = 1; //wave set to 1
		c = new Controller(); //creates a new controller

		player = new Player(tileMap, this); //creates a new player
		player.setPosition(100, 100); //spawns player at 100, 100
		createEnemy(wave); //creates 1 enemy to start

	}

	public static void UI(Graphics2D g){ //creates UI for the game

		//shows enemies left
		Font fnt0 = new Font("arial", Font.BOLD, 12);
		g.setColor(Color.BLUE);
		g.fillRect(10, 15, 100, 20);
		g.setColor(Color.WHITE);
		g.setFont(fnt0);
		g.drawString("Enemies Left: " + Integer.toString(c.getEnemys().size()), 15, 29);

		//shows the wave you are on
		g.setColor(Color.PINK);
		g.fillRect(10, 45, 100, 20);
		g.setColor(Color.BLUE);
		g.setFont(fnt0);
		g.drawString("WAVE: " + Integer.toString(wave), 15, 60);



	}

	public void update() {
		player.update();
		c.tick(); 

		//if no enemies are left
		if (c.getEnemys().size()==0) {
			wave++; //adds 1 to wave
			createEnemy(wave);
		}
		if (Player.getHealth() <= 0) {	
			//test.PlayMusic("Level1Music.wav", false);
			gsm.setState(GameStateManager.GAMEOVERSTATE);
		}
	}

	public void createEnemy(int enemyCount) {
		for (int i =0; i<enemyCount; i++) {  //creates as many enemies as waves
			c.addEnemy(new Enemy(r.nextInt(640), r.nextInt(480), player, tileMap, c)); //creates a new enemy in a random spot on the map
		}
	}

	public void draw(java.awt.Graphics2D g) {

		//draw bg
		bg.draw(g);

		//draw tilemap
		tileMap.draw(g);

		//draw player
		player.draw(g);

		c.render(g);

		Player.displayHealthBar(g); //shows the health bar
		Level1State.UI(g); //sets UI of game
	}

	//keyboard settings
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_A) player.setLeft(true);
		if(k == KeyEvent.VK_D) player.setRight(true);
		if(k == KeyEvent.VK_W) player.setUp(true);
		if(k == KeyEvent.VK_S) player.setDown(true);

		//keyboard settings with delay between shots, 0.1s delay
		if(k == KeyEvent.VK_LEFT && (System.currentTimeMillis() - lastShotTime >= 100)) {//100 is rate of fire
			direction = 1;//shoot left
			c.addBullet(new Bullet(player.getx(), player.gety(), direction)); //creates a new bullet at player position and gives it direction
			player.setFiring();//sound effect
			lastShotTime = System.currentTimeMillis();
		}
		if(k == KeyEvent.VK_RIGHT && (System.currentTimeMillis() - lastShotTime >= 100)) {
			direction = 2;//shoot right
			c.addBullet(new Bullet(player.getx(), player.gety(), direction));//creates a new bullet at player position and gives it direction
			player.setFiring();//sound effect
			lastShotTime = System.currentTimeMillis();
		}
		if(k == KeyEvent.VK_UP && (System.currentTimeMillis() - lastShotTime >= 100)) {
			direction = 3;//shoot up
			c.addBullet(new Bullet(player.getx(), player.gety(), direction));//creates a new bullet at player position and gives it direction
			player.setFiring();//sound effect
			lastShotTime = System.currentTimeMillis();
		}
		if(k == KeyEvent.VK_DOWN && (System.currentTimeMillis() - lastShotTime >= 100)) {
			direction = 4;//shoot down
			c.addBullet(new Bullet(player.getx(), player.gety(), direction));//creates a new bullet at player position and gives it direction
			player.setFiring(); //sound effect
			lastShotTime = System.currentTimeMillis();
		}
		if (k == KeyEvent.VK_UP ||  k == KeyEvent.VK_DOWN || k == KeyEvent.VK_LEFT || k == KeyEvent.VK_RIGHT) test.playSound("GunSound.wav");
	}


	//key release
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A) player.setLeft(false);
		if(k == KeyEvent.VK_D) player.setRight(false);
		if(k == KeyEvent.VK_W) player.setUp(false);
		if(k == KeyEvent.VK_S) player.setDown(false);
		if(k == KeyEvent.VK_UP) player.stopFiring();
		if(k == KeyEvent.VK_DOWN) player.stopFiring();
		if(k == KeyEvent.VK_LEFT) player.stopFiring();
		if(k == KeyEvent.VK_RIGHT) player.stopFiring();
	}


}
