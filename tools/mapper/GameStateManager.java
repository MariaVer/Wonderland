package mapper;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Entity.Animation;
import Entity.Player;



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
		if(k==KeyEvent.VK_ENTER)
		{
			world.get(CurrentAreaIndex).saveMap();
		}
		
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
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			int x=(int)e.getPoint().getX()/45+1;
			int y=(int)e.getPoint().getY()/45+1;
			
			int newx=Player.getPlayerX()-Player.getScreenPosX()+x;
			int newy=Player.getPlayerY()-Player.getScreenPosY()+y;
			if(newx<15) Player.updateScreenPosX(newx); 
			else if(newx>96-15) Player.updateScreenPosX(30-(96-newx)); else Player.updateScreenPosX(15);
			
			if(newy<10) Player.updateScreenPosY(newy); 
			else if(newy>78-10) Player.updateScreenPosY(20-(78-newy)); else Player.updateScreenPosY(10);
 			
			
			Player.updatePlayerX(newx);
			Player.updatePlayerY(newy);
		}
		if (e.getButton() == MouseEvent.BUTTON3) 
		{
			int x=(int)e.getPoint().getX()/45+1;
			int y=(int)e.getPoint().getY()/45+1;
			
			int newx=Player.getPlayerX()-Player.getScreenPosX()+x;
			int newy=Player.getPlayerY()-Player.getScreenPosY()+y;
			world.get(CurrentAreaIndex).changeMap(true, newx-1, newy-1);
			
		}
		if (e.getButton() == MouseEvent.BUTTON2)
		{
			int x=(int)e.getPoint().getX()/45+1;
			int y=(int)e.getPoint().getY()/45+1;
			
			int newx=Player.getPlayerX()-Player.getScreenPosX()+x;
			int newy=Player.getPlayerY()-Player.getScreenPosY()+y;
			world.get(CurrentAreaIndex).changeMap(false, newx-1, newy-1);
			
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
		
	}

	
	public void mouseMoved(MouseEvent e) {
		
		
	}
}
