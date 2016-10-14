package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	

	private Animation standing=new Animation();
	private BufferedImage[] standing2;
	private static int playerx,playery;
	private static int screenPosx,screenPosy;
	private int tilesize;
	
	public Player(int tilesize)
	{
		this.tilesize=tilesize;
		playerx=43;
		screenPosx=43;
		playery=30;
		screenPosy=30;
		AnimationsColection col=new AnimationsColection();
		col.initFrames("/characters/1015/");
		standing.initAnimations(col);
		standing.setDelay(200);
		//standing.setAnimType(Direction.StSS);
	}
	
	public void update()
	{
		standing.update();
	}
	
	public static void updatePlayerX(int newx){	playerx=newx;}	
	public static void updatePlayerY(int newy){	playery=newy;}
	public static int getPlayerX(){return playerx;}
	public static int getPlayerY(){return playery;}
	
	public static void updateScreenPosX(int newx){ screenPosx=newx;}
	public static void updateScreenPosY(int newy){ screenPosy=newy;}
	public static int getScreenPosX(){return screenPosx;}
	public static int getScreenPosY(){return screenPosy;}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=standing.getImage();
		g.drawImage(image,screenPosx*tilesize-70+15,screenPosy*tilesize-110+15,null);
		
		
	}
	
	
}
