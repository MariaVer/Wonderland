package Entity;

import java.awt.image.BufferedImage;

public class AnimationsColection {

	private int index;
	private BufferedImage[] standingNN;
	private BufferedImage[] standingNE;
	private BufferedImage[] standingEE;
	private BufferedImage[] standingES;
	private BufferedImage[] standingSS;
	private BufferedImage[] standingSW;
	private BufferedImage[] standingWW;
	private BufferedImage[] standingWN;

	private BufferedImage[] walkingNN;
	private BufferedImage[] walkingNE;
	private BufferedImage[] walkingEE;
	private BufferedImage[] walkingES;
	private BufferedImage[] walkingSS;
	private BufferedImage[] walkingSW;
	private BufferedImage[] walkingWW;
	private BufferedImage[] walkingWN;
	
	private BufferedImage[] sleeping;
	
	public AnimationsColection()
	{
		
	}
	
	public int getIndex(){return index;}
	
	public void initFrames(BufferedImage[] frames,String s)
	{
		switch(s)
		{
		case "StNN":
			standingNN=frames;
			
		case "StNE":
			standingNE=frames;
		
		case "StEE":	
			standingEE=frames;
			
		case "StES":	
			standingES=frames;
			
		case "StSS":	
			standingSS=frames;
			
		case "StSW":	
			standingSW=frames;
			
		case "StWW":	
			standingWW=frames;
			
		case "StWN":	
			standingWN=frames;	
		
		case "WaNN":	
			walkingNN=frames;
			
		case "WaNE":	
			walkingNE=frames;
		
		case "WaEE":	
			walkingEE=frames;	
			
		case "WaES":	
			walkingES=frames;
			
		case "WaSS":	
			walkingSS=frames;
			
		case "WaSW":	
			walkingSW=frames;
			
		case "WaWW":	
			walkingWW=frames;
			
		case "WaWN":		
			walkingWN=frames;
			
		case "Sleep":	
			sleeping=frames;
			
		default:	
			return;
			
		}
	}
	
	
	
	public BufferedImage[] getAnim(String s)
	{
		switch(s)
		{
		case "StNN":
			return standingNN;
			
		case "StNE":
			return standingNE;
		
		case "StEE":	
			return standingEE;
			
		case "StES":	
			return standingES;
			
		case "StSS":	
			return standingSS;
			
		case "StSW":	
			return standingSW;
			
		case "StWW":	
			return standingWW;
			
		case "StWN":	
			return standingWN;	
		
		case "WaNN":	
			return walkingNN;
			
		case "WaNE":	
			return walkingNE;
		
		case "WaEE":	
			return walkingEE;	
			
		case "WaES":	
			return walkingES;
			
		case "WaSS":	
			return walkingSS;
			
		case "WaSW":	
			return walkingSW;
			
		case "WaWW":	
			return walkingWW;
			
		case "WaWN":		
			return walkingWN;
			
		case "Sleep":	
			return sleeping;
			
		default:	
			return null;
			
		}
		
	}
	
	
	
	
	
}
