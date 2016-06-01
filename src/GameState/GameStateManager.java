package GameState;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Entity.Animation;



public class GameStateManager 
{
	public ArrayList<Area> world=new ArrayList<Area>();
	public int CurrentAreaIndex=0;
	public static Animation anim=new Animation();
	
	public GameStateManager()
	{
		for(int i=0;i<1;i++)
		{
			Area ar=new Area(i);
			world.add(ar);
		}
	}
		
	public void init()
	{
		
	}
	
	public void update()
	{
		world.get(CurrentAreaIndex).update();
	}
	
	public void draw(java.awt.Graphics2D g)
	{
		world.get(CurrentAreaIndex).draw(g);
	}
	
	public void keyPressed(int k)
	{
			
		
	}
	
	public void keyReleased(int k)
	{
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
		
	}

	
	public void mouseMoved(MouseEvent e) {
		
		
	}
}
