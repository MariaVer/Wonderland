package GameState;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Entity.Animation;
import Entity.Player;
import pathFinding.PathFinding;



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
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			int x=(int)e.getPoint().getX()/world.get(CurrentAreaIndex).tilesize;
			int y=(int)e.getPoint().getY()/world.get(CurrentAreaIndex).tilesize;
			int newx=Player.getPlayerX()-Player.getScreenPosX()+x;
			int newy=Player.getPlayerY()-Player.getScreenPosY()+y;
			//newx and newy are the map coordinates where the player needs to move
			boolean goodPos=world.get(CurrentAreaIndex).getMap()[newx][newy];
			if(goodPos)
			{			
				
				PathFinding pather=new PathFinding(world.get(CurrentAreaIndex).getMap());
				ArrayList<Point> path = pather.findPath(Player.getPlayerX(),Player.getPlayerY(),newx,newy);
				//System.out.println(path);
				world.get(CurrentAreaIndex).drawPath(path);
				
				if(newx<world.get(CurrentAreaIndex).middlex) Player.updateScreenPosX(newx); 
				else if(newx>world.get(CurrentAreaIndex).map.length-world.get(CurrentAreaIndex).middlex) 
					Player.updateScreenPosX(world.get(CurrentAreaIndex).maxscreenposx-(world.get(CurrentAreaIndex).maxX-newx));
						else Player.updateScreenPosX(world.get(CurrentAreaIndex).middlex);
				
				if(newy<world.get(CurrentAreaIndex).middley) Player.updateScreenPosY(newy); 
				else if(newy>world.get(CurrentAreaIndex).map[1].length-world.get(CurrentAreaIndex).middley) 
					Player.updateScreenPosY(world.get(CurrentAreaIndex).maxscreenposy-(world.get(CurrentAreaIndex).maxY-newy));
						else Player.updateScreenPosY(world.get(CurrentAreaIndex).middley);
	 			
				
				Player.updatePlayerX(newx);
				Player.updatePlayerY(newy);
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
