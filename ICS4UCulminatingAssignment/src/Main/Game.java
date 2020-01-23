/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package Main;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Game");
		frame.setContentPane(new GamePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//tells it to exit when you close it
		frame.pack();
		frame.setVisible(true);//makes window visible
	}
}
