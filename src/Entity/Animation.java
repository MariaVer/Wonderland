package Entity;

import java.awt.image.BufferedImage;

public class Animation 
{
	private AnimationsColection frames;
	private BufferedImage[] currentFrames;
	private int currentFrame=0;
	
	private long startTime;
	private long delay;
	
	private boolean playedOnce;
	
	public Animation()
	{
		playedOnce=false;
		
	}
	
	public void initAnimations(AnimationsColection frames)
	{
		this.frames=frames;
		this.currentFrames=frames.getAnim(Direction.WaSS);
		currentFrame=0;
		startTime=System.nanoTime();
		playedOnce=false;
	}
	
	public void setAnimType(Direction s)
	{
		this.currentFrames=frames.getAnim(s);
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
		//if(currentFrames==null) return;
		if(delay==-1) return;
		
		long elapsed=(System.nanoTime() -startTime)/1000000;
		if(elapsed>delay)
		{
			currentFrame++;
			startTime=System.nanoTime();
		}
		if(currentFrame==currentFrames.length)
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
		//if(currentFrames==null) return null;
		return currentFrames[currentFrame];
	}
	
	public boolean hasPlayedOnce()
	{
		return playedOnce;
	}
}
