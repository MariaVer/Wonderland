package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	

	private static Animation anim=new Animation();
	//private BufferedImage[] standing2;
	private static int playerx,playery;
	private static double screenPosx,screenPosy;
	private static int tilesize;
	public static Direction animType;
	public static double newScreenPosX;
	public static double newScreenPosY;
	
	public Player(int tilesize)
	{
		this.tilesize=tilesize;
		playerx=43;
		screenPosx=43;
		playery=30;
		screenPosy=30;
		AnimationsColection col=new AnimationsColection();
		col.initFrames("/characters/1015/");
		anim.initAnimations(col);
		anim.setDelay(200);
		anim.setAnimType(Direction.StSS);
		animType=Direction.StSS;
		newScreenPosX=screenPosx*tilesize;
		newScreenPosY=screenPosy*tilesize;
	}
	
	public void update()
	{
		anim.update();
	}
	
	public static void setAnimType(Direction dir)
	{
		animType=dir;
		anim.setAnimType(dir);
	}
	
	public static void updatePlayerX(int newx){	playerx=newx;}	
	public static void updatePlayerY(int newy){	playery=newy;}
	public static int getPlayerX(){return playerx;}
	public static int getPlayerY(){return playery;}
	
	public static void updateScreenPos(double newx,double newy)
	{
		screenPosx=newx;
		screenPosy=newy;
	}

	public static double getScreenPosX(){return screenPosx;}
	public static double getScreenPosY(){return screenPosy;}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=anim.getImage();
		g.drawImage(image,(int)(screenPosx*tilesize-70+15),(int)(screenPosy*tilesize-110+15),null);
		//g.drawImage(image,newScreenPosX-70+15,newScreenPosY-110+15,null);
		
	}
	
	
}
