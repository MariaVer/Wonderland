package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	public static Animation standing=new Animation();
	public static BufferedImage[] standing2;
	
	public Player()
	{
		try {
			BufferedImage sprites,subimage;		
			sprites = ImageIO.read(getClass().getResourceAsStream("/Pokemon/Espeon.png"));
			
			standing2=new BufferedImage[3];
			for(int i=0;i<=2;i++)
			{
				subimage=sprites.getSubimage( 80+i*40,0, 40, 40);
				standing2[i]=subimage;
				
			}
			standing.setFrames(standing2,1);
			standing.setDelay(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		standing.update();
	}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=standing.getImage();
		g.drawImage(image,200,290,60,60,null);
	}
	
	
}
