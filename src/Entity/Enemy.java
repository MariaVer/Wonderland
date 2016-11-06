package Entity;

import java.awt.image.BufferedImage;

import GameState.Area;

public class Enemy {
	
	private Animation anim=new Animation();
	private int posx,posy;
	private int tilesize;
	private double screenPosx, screenPosy;
	private Direction animType;

	public double newScreenPosX;
	public double newScreenPosY;
	
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
		updateScreenPos();
	}
	
	public void setAnimType(Direction dir)
	{
		animType=dir;
		anim.setAnimType(dir);
	}

	public void updatePosX(int newx){	posx=newx;}	
	public void updatePosY(int newy){	posy=newy;}
	public int getPosX(){return posx;}
	public int getPosY(){return posy;}
	
	public void updateScreenPos()
	{
		
		screenPosx=(posx*tilesize-Area.posx);
		screenPosy=(posy*tilesize-Area.posy);
	}

	public double getScreenPosX(){return screenPosx;}
	public double getScreenPosY(){return screenPosy;}
	
	public void draw(java.awt.Graphics2D g)
	{
		
		BufferedImage image=anim.getImage();
		g.drawImage(image,(int)(screenPosx-70+15),(int)(screenPosy-110+15),null);
		//g.drawImage(image,newScreenPosX-70+15,newScreenPosY-110+15,null);
		
	}
	
	
}
