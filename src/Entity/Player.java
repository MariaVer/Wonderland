package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	public static Animation standing=new Animation();
	public static BufferedImage[] standing2;
	
	public Player()
	{
		AnimationsColection col=new AnimationsColection();
		col.initFrames("/characters/1015/");
		standing.initAnimations(col);
		standing.setDelay(250);
		//standing.setAnimType(Direction.StSS);
	}
	
	public void update()
	{
		standing.update();
	}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=standing.getImage();
		g.drawImage(image,200,290,null);
	}
	
	
}
