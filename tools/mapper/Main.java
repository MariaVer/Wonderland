package mapper;

import javax.swing.JFrame;

//hitting enter saves the map
//		  control changes to big brush or back to normal
//		  left click moves the character
//	      right click to mark squares
//        middle click to clear marked squares


public class Main {

	public static void main(String[] args)
	{
		JFrame window = new JFrame("Mapper");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
		
		
		
		
		
		
	}
	
	
	
	
}
