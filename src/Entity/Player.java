package Entity;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import GameState.Area;
import GameState.GameStateManager;
import pathFinding.Navigation;

public class Player implements Entity{
	

	private static Animation anim=new Animation();
	//private BufferedImage[] standing2;
	private static int playerx,playery;
	private static double screenPosx,screenPosy;
	private static int tilesize;
	public static Direction animType;
	public static double newScreenPosX;
	public static double newScreenPosY;
	public static int threadCount=0;
	
	
	public Player()
	{
		this.tilesize=GameStateManager.world.get(GameStateManager.CurrentAreaIndex).tilesize;
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
	
	public boolean isPlayer()
	{
		return true;
	}
	
	public void update()
	{
		anim.update();
	}
	
	public void setAnimType(Direction dir)
	{
		animType=dir;
		anim.setAnimType(dir);
	}
	
	public void updatePosX(int newx){
		playerx=newx;
		

		
		
	}	
	public void updatePosY(int newy){
		playery=newy;
		
		
	}
	
	
	
	public int getPosX(){return playerx;}
	public int getPosY(){return playery;}
	
	public void updateScreenPos(double newx,double newy)
	{
		screenPosx=newx;
		screenPosy=newy;
	}

	public double getScreenPosX(){return screenPosx;}
	public double getScreenPosY(){return screenPosy;}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=anim.getImage();
		g.drawImage(image,(int)(screenPosx*tilesize-70+15),(int)(screenPosy*tilesize-110+15),null);
		//g.drawImage(image,newScreenPosX-70+15,newScreenPosY-110+15,null);
		
	}

	@Override
	public void threadCountInc() {
		threadCount++;
		
	}

	@Override
	public void threadCountDec() {
		threadCount--;
		
	}
	public int getThreadCount(){return threadCount;}

	@Override
	public void move(ArrayList<Point> path,Area area) {
		
		Navigation nav=new Navigation(path,this,area);
		threadCount++;
		nav.run();		
		
		
	}
	
	
}
