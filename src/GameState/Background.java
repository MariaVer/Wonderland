package GameState;

import main.GamePanel;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

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
		
	}
	
	public void draw(Graphics2D g)
	{
		//one tile is 32px
		subimage=image.getSubimage(0, 0, 256, 256);
		g.drawImage(subimage,0,0, 512, 512, null);
		
		
	}
}
