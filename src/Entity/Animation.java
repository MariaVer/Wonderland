package Entity;

import java.awt.image.BufferedImage;

public class Animation 
{
	private static AnimationsColection[] colection;
	//private AnimationsColection colection=new AnimationsColection();
	private int currentFrame=0;
	
	private long startTime;
	private long delay;
	private BufferedImage[] frames;
	
	private boolean playedOnce;
	
	public Animation()
	{
		playedOnce=false;
		
	}
	
	public void setFrames(String s,int index)
	{
		this.frames=colection[index].getAnim(s);
		currentFrame=0;
		startTime=System.nanoTime();
		playedOnce=false;
	}
	
	public void setDelay(long d) 
	{
		delay=d;
	}
	
	public void setFrame(int i)
	{
		currentFrame=i;
	}
	
	public void update()
	{
		if(delay==-1) return;
		
		long elapsed=(System.nanoTime() -startTime)/1000000;
		if(elapsed>delay)
		{
			currentFrame++;
			startTime=System.nanoTime();
		}
		if(currentFrame==frames.length)
		{
			currentFrame=0;
			playedOnce=true;
		}		
	}
	
	public int getFrame()
	{
		return currentFrame;
	}
	
	public BufferedImage getImage()
	{
		return frames[currentFrame];
	}
	
	public boolean hasPlayedOnce()
	{
		return playedOnce;
	}
}
