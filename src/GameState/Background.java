package GameState;


import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;


public class Background
{
	private BufferedImage image,subimage;
	
	public double posy=0,posx=0;
	public int width,height;
	public String source;
	public int tilesize;
	
	
	public Background(String s,int width,int height,int tilesize)
	{
		this.height=height;
		this.width=width;
		this.tilesize=tilesize;
		source=s;
		try
		{	
			image = ImageIO.read(getClass().getResourceAsStream(s+".png"));
			
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
		this.posx=newx;
		this.posy=newy;
		
		
	}
	
	
	
	public void update()
	{
		
		
	}
	
	public void draw(Graphics2D g)
	{
		//4320 3510
		//96 78
		//one tile is tilesizepx

		
		//System.out.println("new positions: "+posx+"  "+posy);
		subimage=image.getSubimage((int)posx, (int)posy, 1305, 900 );
		
		g.drawImage(subimage,0,0, null);
		
		
	}
}
