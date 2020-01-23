/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package GameState;

import java.util.ArrayList;

public class GameStateManager {
	
	private static ArrayList<GameState> gameStates;
	private static int currentState;
	
	public static final int MENUSTATE = 0; //each state set to a number
	public static final int SHOPSTATE = 1;
	public static final int LEVEL1STATE = 2;
	public static final int GAMEOVERSTATE = 3;
	
	public GameStateManager() {
	
		gameStates = new ArrayList<GameState>();
		
		currentState = MENUSTATE;
		gameStates.add(new MenuState(this)); //creates the states
		gameStates.add(new ShopState(this));
		gameStates.add(new Level1State(this));
		gameStates.add(new GameOverState(this));
	}
	
	//sets the state
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	//gets the game state
	public static GameState getCurrentState() {
		return gameStates.get(currentState);
	}
	
	//updates game state
	public void update() {
		gameStates.get(currentState).update();
	}
	
	//draws the current state
	public void draw(java.awt.Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
	
	//keyboard 
	public void keyPressed(int k) {
		gameStates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}
}
