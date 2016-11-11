package GameState;


import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Entity.Enemy;
import Entity.Player;


public class Background
{
	private BufferedImage image,image2,subimage,subimage2;
	
	//public double posy=0,posx=0;
	public int width,height;
	public String source;
	public int tilesize;
	
	
	public Background(String s,String s2, int width,int height,int tilesize)
	{
		this.height=height;
		this.width=width;
		this.tilesize=tilesize;
		source=s;
		try
		{	
			image = ImageIO.read(getClass().getResourceAsStream(s+".png"));
			image2 = ImageIO.read(getClass().getResourceAsStream(s2+".png"));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setPosition(double newx,double newy)
	{
		
		if(newx<0) newx=0;
		if(newy<0) newy=0;		
		if(newx>width-1305)newx=width-1305;
		if(newy>height-900)newy=height-900;
		GameStateManager.getCurrentArea().posx=newx;
		GameStateManager.getCurrentArea().posy=newy;
		
		
	}
	
	
	
	public void update()
	{
		
		
	}
	
	public void draw(Graphics2D g, Player player, ArrayList<Enemy> enemies)
	{
		subimage=image.getSubimage((int)GameStateManager.getCurrentArea().posx, (int)GameStateManager.getCurrentArea().posy, 1305, 900 );
		subimage2=image2.getSubimage((int)GameStateManager.getCurrentArea().posx, (int)GameStateManager.getCurrentArea().posy, 1305, 900 );
		g.drawImage(subimage,0,0, null);
		player.draw(g);
		for(int i=0;i<enemies.size();i++)
		{
			enemies.get(i).draw(g);
		}
		g.drawImage(subimage2,0,0, null);
		
	}
	
	public void draw(Graphics2D g)
	{
		//4320 3510
		//96 78
		//one tile is tilesizepx

		
		//System.out.println("new positions: "+posx+"  "+posy);
		subimage=image.getSubimage((int)GameStateManager.getCurrentArea().posx, (int)GameStateManager.getCurrentArea().posy, 1305, 900 );
		
		g.drawImage(subimage,0,0, null);
		
		
	}
}
