package GameState;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Entity.Animation;
import Entity.Direction;
import Entity.Enemy;
import Entity.Player;
import pathFinding.PathFinding;



public class GameStateManager 
{
	private static ArrayList<Area> world=new ArrayList<Area>();
	private static int CurrentAreaIndex=0;
	public static Animation anim=new Animation();
	public static Player player;
	private boolean bigBrush=false;
	private static int mode;
	
	public GameStateManager(int mode)
	{
		for(int i=0;i<1;i++)
		{
			Area ar=new Area(i);
			world.add(ar);
		}
		this.player=new Player();
		this.mode=mode;
	}
	
	public static int getMode()
	{
		return mode;
	}
		
	public static Area getCurrentArea()
	{
		return world.get(CurrentAreaIndex);
	}
	
	public static Boolean[][] getMap()
	{
		return world.get(CurrentAreaIndex).getMap();
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
		if(mode==1)
		{
			if(k==KeyEvent.VK_ENTER)
			{
				world.get(CurrentAreaIndex).saveMap();
			}
			if(k==KeyEvent.VK_CONTROL)
			{
				bigBrush=!bigBrush;
			}	
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
			
			int x=(int)e.getPoint().getX()/world.get(CurrentAreaIndex).tilesize;
			int y=(int)e.getPoint().getY()/world.get(CurrentAreaIndex).tilesize;
			int newxx=player.getPosX()-(int)player.getScreenPosX()+x;
			int newyy=player.getPosY()-(int)player.getScreenPosY()+y;
			//newx and newy are the map coordinates where the player needs to move
			boolean goodPos=world.get(CurrentAreaIndex).getMap()[newxx][newyy];
			if(goodPos)
			{			
				
				PathFinding pather=new PathFinding(world.get(CurrentAreaIndex).getMap());
				ArrayList<Point> path = pather.findPath(player.getPosX(),player.getPosY(),newxx,newyy);
				Enemy en=world.get(CurrentAreaIndex).getEnemies().get(0);
				PathFinding pather2=new PathFinding(world.get(CurrentAreaIndex).getMap());
				ArrayList<Point> path2= pather2.findPath(en.getPosX(),en.getPosY(),player.getPosX(),player.getPosY());
				
				player.move(path, world.get(CurrentAreaIndex));
				en.move(path2, world.get(CurrentAreaIndex));
				world.get(CurrentAreaIndex).drawPath(path);
				
				
			}
		}
		
		if(mode==1)
		{
			if (e.getButton() == MouseEvent.BUTTON3) 
			{
				int x=(int)e.getPoint().getX()/world.get(CurrentAreaIndex).tilesize+1;
				int y=(int)e.getPoint().getY()/world.get(CurrentAreaIndex).tilesize+1;
				
				int newx=player.getPosX()-(int)player.getScreenPosX()+x;
				int newy=player.getPosY()-(int)player.getScreenPosY()+y;
				if(!bigBrush){
					world.get(CurrentAreaIndex).changeMap(true, newx-1, newy-1);
				}else{
					world.get(CurrentAreaIndex).changeMap(true, newx-1-1, newy-1-1);
					world.get(CurrentAreaIndex).changeMap(true, newx-1-1, newy-1);
					world.get(CurrentAreaIndex).changeMap(true, newx-1, newy-1-1);
					
					world.get(CurrentAreaIndex).changeMap(true, newx-1+1, newy-1+1);
					world.get(CurrentAreaIndex).changeMap(true, newx-1+1, newy-1);
					world.get(CurrentAreaIndex).changeMap(true, newx-1, newy-1+1);
					
					world.get(CurrentAreaIndex).changeMap(true, newx-1+1, newy-1-1);
					world.get(CurrentAreaIndex).changeMap(true, newx-1-1, newy-1+1);
					world.get(CurrentAreaIndex).changeMap(true, newx-1, newy-1);
					
				}
				
			}
			if (e.getButton() == MouseEvent.BUTTON2)
			{
				int x=(int)e.getPoint().getX()/world.get(CurrentAreaIndex).tilesize+1;
				int y=(int)e.getPoint().getY()/world.get(CurrentAreaIndex).tilesize+1;
				
				int newx=player.getPosX()-(int)player.getScreenPosX()+x;
				int newy=player.getPosY()-(int)player.getScreenPosY()+y;
				world.get(CurrentAreaIndex).changeMap(false, newx-1, newy-1);
				
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
		
	}

	
	public void mouseMoved(MouseEvent e) {
		
		
	}
}
