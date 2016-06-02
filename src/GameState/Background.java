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
	
	private double moveScale;
	
	public Background(String s)
	{
		try
		{	
			image = ImageIO.read(getClass().getResourceAsStream(s));
			
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
		posx=Player.getPlayerX()*45-15*45;
		posy=Player.getPlayerY()*45-10*45;
		if(posx<0) posx=0;
		if(posy<0) posy=0;
	}
	
	public void draw(Graphics2D g)
	{
		//4320 3510
		//96 78
		//one tile is 45px
		posx=Player.getPlayerX()*45-Player.getScreenPosX()*45;
		posy=Player.getPlayerY()*45-Player.getScreenPosY()*45;
		if(posx<0) posx=0;
		if(posy<0) posy=0;
		
		if(posx>4320-1305)posx=4320-1305;
		if(posy>3510-900)posy=3510-900;
		subimage=image.getSubimage(posx, posy, 1305, 900 );
		g.drawImage(subimage,0,0, null);
		
		
	}
}
