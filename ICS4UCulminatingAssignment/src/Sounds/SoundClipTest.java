/*
 Hunter Terpstra, Gabriel Olivotto, Jarod Pelkie, Nico Moniz	
 ICS 4U
 Ms. Dufault 
 January 23, 2020
 Java Culminating Game
 */
package Sounds;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame{
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// Constructor
   public SoundClipTest() {
   
   }
	   public void playSound(String path) {
       try {
         // Open an audio input stream.
         URL url = this.getClass().getClassLoader().getResource(path);
         
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
	  new SoundClipTest();
	  }

	   public void PlayMusic(String path, boolean isRunning) {
		 
		   
		   Clip clip = null;
		   try {
		   URL url = this.getClass().getClassLoader().getResource(path);
	         
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         
	         
	         // Get a sound clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         //clip.start();
	         clip.loop(Clip.LOOP_CONTINUOUSLY);
	         
	         if (!isRunning) {
	        	 clip.stop();
	         }
	         
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		  
		  //new SoundClipTest();
	   }
	   
}