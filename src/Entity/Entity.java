package Entity;

import java.awt.Point;
import java.util.ArrayList;

import GameState.Area;

public interface Entity {

	
	
	public void update();	
	public void setAnimType(Direction dir);	
	public void updatePosX(int newx);
	public void updatePosY(int newy);
	public int getPosX();
	public int getPosY();
	public void updateScreenPos(double newx,double newy);
	public double getScreenPosX();
	public double getScreenPosY();
	public void draw(java.awt.Graphics2D g);
	public void threadCountInc();
	public void threadCountDec();
	public int getThreadCount();
	public void move(ArrayList<Point> path,Area area);
	public boolean isPlayer();
	
}
