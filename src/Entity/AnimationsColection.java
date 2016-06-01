package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AnimationsColection {

	private int index;
	private BufferedImage[] standingNN;
	private BufferedImage[] standingNW;
	private BufferedImage[] standingWW;
	private BufferedImage[] standingWS;
	private BufferedImage[] standingSS;
	private BufferedImage[] standingSE;
	private BufferedImage[] standingEE;
	private BufferedImage[] standingEN;

	private BufferedImage[] walkingNN;
	private BufferedImage[] walkingNW;
	private BufferedImage[] walkingWW;
	private BufferedImage[] walkingWS;
	private BufferedImage[] walkingSS;
	private BufferedImage[] walkingSE;
	private BufferedImage[] walkingEE;
	private BufferedImage[] walkingEN;
	
	private BufferedImage[] sleeping;
	
	public AnimationsColection()
	{
		
	}
	
	public int getIndex(){return index;}
	
	public void initFrames(String s) 
	{
		try{
			walkingNN=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "00-"+(i+1)+".png";				
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingNN[i]=image;
			}
			
			walkingNW=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "01-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingNW[i]=image;
			}
			
			walkingWW=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "02-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingWW[i]=image;
			}
			
			walkingWS=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "03-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingWS[i]=image;
			}
		
			walkingSS=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "04-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingSS[i]=image;
			}
			
			walkingSE=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "05-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingSE[i]=image;
			}
			
			walkingEE=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "06-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingEE[i]=image;
			}
			
			walkingEN=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "07-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				walkingEN[i]=image;
			}
			
			standingNN=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "08-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingNN[i]=image;
			}
			
			standingNW=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "09-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingNW[i]=image;
			}
			
			standingWW=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "10-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingWW[i]=image;
			}
			
			standingWS=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "11-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingWS[i]=image;
			}
			
			standingSS=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "12-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingSS[i]=image;
			}
			
			standingSE=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "13-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingSE[i]=image;
			}
			
			standingEE=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "14-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingEE[i]=image;
			}
			
			standingEN=new BufferedImage[4];
			for(int i=0;i<4;i++)
			{
				String source=s+ "15-"+(i+1)+".png";
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
				standingEN[i]=image;
			}
		
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void initFrames(BufferedImage[] frames,Direction s)
	{
		switch(s)
		{
		case  StNN :
			standingNN=frames;
			
		case  StNW :
			standingNW=frames;
		
		case  StEE :	
			standingEE=frames;
			
		case  StWS :	
			standingWS=frames;
			
		case  StSS :	
			standingSS=frames;
			
		case  StSE :	
			standingSE=frames;
			
		case  StWW :	
			standingWW=frames;
			
		case  StEN :	
			standingEN=frames;	
		
		case  WaNN :	
			walkingNN=frames;
			
		case  WaNW :	
			walkingNW=frames;
		
		case  WaEE :	
			walkingEE=frames;	
			
		case  WaWS :	
			walkingWS=frames;
			
		case  WaSS :	
			walkingSS=frames;
			
		case  WaSE :	
			walkingSE=frames;
			
		case  WaWW :	
			walkingWW=frames;
			
		case  WaEN :		
			walkingEN=frames;
			
		case  Sleep :	
			sleeping=frames;
			
		default:	
			return;
			
		}
	}
	
	
	
	public BufferedImage[] getAnim(Direction s)
	{
		switch(s)
		{
		case  StNN :
			return standingNN;
			
		case  StNW :
			return standingNW;
		
		case  StEE :	
			return standingEE;
			
		case  StWS :	
			return standingWS;
			
		case  StSS :	
			return standingSS;
			
		case  StSE :	
			return standingSE;
			
		case  StWW :	
			return standingWW;
			
		case  StEN :	
			return standingEN;	
		
		case  WaNN :	
			return walkingNN;
			
		case  WaNW :	
			return walkingNW;
		
		case  WaEE :	
			return walkingEE;	
			
		case  WaWS :	
			return walkingWS;
			
		case  WaSS :	
			return walkingSS;
			
		case  WaSE :	
			return walkingSE;
			
		case  WaWW :	
			return walkingWW;
			
		case  WaEN :		
			return walkingEN;
			
		case  Sleep :	
			return sleeping;
			
		default:	
			return null;
			
		}
		
	}
	
	
	
	
	
}
