package GameState;

import main.GamePanel;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

import Entity.Player;
import main.GamePanel;

public class Background 
{
	private BufferedImage image,subimage;
	private double x;
	private double y;
	private double xx;
	private double yy;
	private double dx;
	private double dy;
	private int posy,posx;
	public int width,height;
	public String source;
	public int tilesize;
	private double moveScale;
	
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
	
	public void setPosition(double x, double y)
	{
		this.x=(x * moveScale) ;//% GamePanel.WIDTH;
		this.y=(y * moveScale) ;//% GamePanel.HEIGHT;
	}
	
	public void setVector(double dx, double dy)
	{
		this.dx=dx;
		this.dy=dy;
	}
	
	public void update()
	{
		
	}
	
	public void draw(Graphics2D g)
	{
		//4320 3510
		//96 78
		//one tile is tilesizepx
		posx=Player.getPlayerX()*tilesize-Player.getScreenPosX()*tilesize;
		posy=Player.getPlayerY()*tilesize-Player.getScreenPosY()*tilesize;
		
		if(posx<0) posx=0;
		if(posy<0) posy=0;
		
		if(posx>width-1305)posx=width-1305;
		if(posy>height-900)posy=height-900;
		subimage=image.getSubimage(posx, posy, 1305, 900 );
		g.drawImage(subimage,0,0, null);
		
		
	}
}
