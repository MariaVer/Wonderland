package main;

import javax.swing.JFrame;


public class Game {

	public static void main(String[] args)
	{
		JFrame window = new JFrame("Wonderland");
		window.setContentPane(new GamePanel(0));
		//for mapper:
		//window.setContentPane(new GamePanel(1));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
		
		
		
		
		
		
	}
	
	
	
	
}
