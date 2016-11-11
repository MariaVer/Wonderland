package Entity;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameState.Area;
import GameState.GameStateManager;
import pathFinding.Navigation;
import pathFinding.PathFinding;

public class Enemy implements Entity{
	
	private Animation anim=new Animation();
	private int posx,posy;
	private int tilesize;
	private double screenPosx, screenPosy;
	private Direction animType;

	public double newScreenPosX;
	public double newScreenPosY;
	public int threadCount=0;
	
	public Enemy(int tilesize, int id,int level)
	{
		this.tilesize=tilesize;
		
		AnimationsColection col=new AnimationsColection();
		posx=45;
		screenPosx=45;
		posy=32;
		screenPosy=32;
		col.initFrames("/enemies/1028/");
		anim.initAnimations(col);
		anim.setDelay(200);
		anim.setAnimType(Direction.StSS);
		animType=Direction.StSS;
	}
	
	public void update()
	{
		anim.update();
		screenPosx=(posx*tilesize-Area.posx);
		screenPosy=(posy*tilesize-Area.posy);
//		int dx=GameStateManager.player.getPosX()-this.posx;
//		int dy=GameStateManager.player.getPosY()-this.posy;
//		if((Math.abs(dx)>1)||(Math.abs(dy)>1))
//		{
//			//executePath(getNewPath());
//		}
	}
	public boolean isPlayer()
	{
		return false;
	}
	
	public void setAnimType(Direction dir)
	{
		animType=dir;
		anim.setAnimType(dir);
	}

	public ArrayList<Point> getNewPath()
	{
		
		PathFinding pather=new PathFinding(GameStateManager.getMap());
		ArrayList<Point> path = pather.findPath(posx,posy,GameStateManager.player.getPosX(),GameStateManager.player.getPosY());
		
		return path;
	}
	
	public void updatePosX(int newx){	posx=newx;}	
	public void updatePosY(int newy){	posy=newy;}
	public int getPosX(){return posx;}
	public int getPosY(){return posy;}
	
	public void updateScreenPos(double newx, double newy)
	{
		
		//screenPosx=newx;
		//screenPosy=newy;
	}

	public double getScreenPosX(){return screenPosx;}
	public double getScreenPosY(){return screenPosy;}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=anim.getImage();
		g.drawImage(image,(int)(screenPosx-70+15),(int)(screenPosy-110+15),null);
		//g.drawImage(image,newScreenPosX-70+15,newScreenPosY-110+15,null);
		
	}
	
	
	private void executePath(ArrayList<Point> path)
	{
		
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
		//System.out.println("getting here  "+threadCount);

	}

	
	
}
