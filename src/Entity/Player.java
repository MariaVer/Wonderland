package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	

	private static Animation anim=new Animation();
	//private BufferedImage[] standing2;
	private static int playerx,playery;
	private static int screenPosx,screenPosy;
	private static int tilesize;
	public static Direction animType;
	public static int newScreenPosX;
	public static int newScreenPosY;
	
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
	
	
	public static void updateScreenPosX(int newx){ 
		screenPosx=newx;
//		Thread th = new Thread() {
//
//            public synchronized void run() {
//            	int dx=newx*tilesize-screenPosx*tilesize;
//            	for(int i=0;i<5;i++)
//            	{
//            		newScreenPosX=playerx*tilesize+(dx/5)*i;
//            		try {
//						Thread.sleep(40);
//						System.out.println("sleeping thread x :"+newScreenPosX);
//					} catch (InterruptedException e) {
//						
//						e.printStackTrace();
//					}
//            	}
//            }
//            
//		};
//		th.start();
	}
	
	public static void updateScreenPosY(int newy){ 
		
		screenPosy=newy;
//		Thread th = new Thread() {
//
//            public synchronized void run() {
//            	int dy=newy*tilesize-screenPosy*tilesize;
//            	for(int i=0;i<5;i++)
//            	{
//            		newScreenPosY=playery*tilesize+(dy/5)*i;
//            		try {
//						Thread.sleep(40);
//						System.out.println("sleeping thread y: "+newScreenPosY);
//					} catch (InterruptedException e) {
//						
//						e.printStackTrace();
//					}
//            	}
//            }
//            
//		};
//		th.start();
	}
	public static int getScreenPosX(){return screenPosx;}
	public static int getScreenPosY(){return screenPosy;}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=anim.getImage();
		g.drawImage(image,screenPosx*tilesize-70+15,screenPosy*tilesize-110+15,null);
		//g.drawImage(image,newScreenPosX-70+15,newScreenPosY-110+15,null);
		
	}
	
	
}
