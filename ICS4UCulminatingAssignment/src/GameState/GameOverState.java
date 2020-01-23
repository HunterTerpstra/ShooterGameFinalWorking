/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package GameState;


import java.awt.*;
import java.awt.event.KeyEvent;
import Main.GamePanel;
import Sounds.*;

public class GameOverState extends GameState{



	private int currentChoice = 0;//current option selected
	private String[] options = {"CONTINUE", "Quit"};//menu options

	private Color titleColor;//title color
	private Font titleFont;//title font

	private Font font;//text font

	public GameOverState(GameStateManager gsm) {//constructor 
		this.gsm = gsm;


		try { //try and catch
			titleColor = new Color(255, 0, 0); //title
			titleFont = new Font ("Century Gothic", Font.BOLD, 56);

			font = new Font ("Arial", Font.BOLD, 24);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	SoundClipTest test = new SoundClipTest(); //sound

	//empty methods from extending gameState
	public void init() {} 
	public void update() {}

	//draws everything
	public void draw(Graphics2D g) {

		//draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Game Over", GamePanel.WIDTH/2-150, GamePanel.HEIGHT/4);

		//user options for what they want to do next
		g.setFont(font);
		for (int i = 0; i < options.length;i++) {
			if (i == currentChoice) {
				g.setColor(Color.YELLOW); //if the user has the one selected, make it yellow
			}
			else {
				g.setColor(Color.RED); 
			}
			g.drawString(options[i], GamePanel.WIDTH/2-50, 160 + i * 30);
		}
	}

	private void select() {
		if (currentChoice == 0) {
			gsm.setState(GameStateManager.MENUSTATE); //brings user to menu
		}

		if (currentChoice == 1) { //exits the game
			System.exit(0);
		}
	}

	//keyboard settings
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) { 
			select();

		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}
}


