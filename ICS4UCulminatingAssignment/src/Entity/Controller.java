/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package Entity;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

	//array list for enemies and bullets
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	private LinkedList<Enemy> e = new LinkedList<Enemy>(); 

	Bullet TempBullet; //bullet object
	Enemy TempEnemy; //enemy object
	Random r = new Random(); //random number getter

	//empty constructor
	public Controller() {
		
	}


	//method that updates bullets and enemies
	public void tick() {
		for (int i=0; i<b.size();i++) {
			TempBullet = b.get(i); //gets all bullets and updates them
			TempBullet.tick();
		}

		for (int i=0; i<e.size();i++) {
			TempEnemy = e.get(i); //gets all enemies and updates them
			TempEnemy.tick();
		}
	}


	public void render(Graphics g) {
		for (int i=0; i<b.size();i++) {
			TempBullet = b.get(i); //draws all bullets and keeps updating them
			TempBullet.render(g);
		}

		for (int i=0; i<e.size();i++) {
			TempEnemy = e.get(i); //gets all enemies and draws them
			TempEnemy.render(g);
		}
	}


	public LinkedList<Bullet> getBullets(){
		return b; //returns array with bullets
	}

	public LinkedList<Enemy> getEnemys(){
		return e; //returns array with enemies
	}

	public void addBullet(Bullet block) {
		b.add(block); //adds a bullet to the array
	}
	public void removeBullet(Bullet block) {
		b.remove(block); //removes a bullet from array
	}
	public void addEnemy(Enemy block) {
		e.add(block); //adds enemy to array
	}
	public void removeEnemy(Enemy block) {
		e.remove(block); //removes enemy from array
	}

}
