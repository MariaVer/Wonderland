package pathFinding;

import java.awt.Point;
import java.util.ArrayList;

import Entity.Direction;
import Entity.Entity;
import Entity.Player;
import GameState.Area;
import GameState.GameStateManager;


public class Navigation extends Thread{

	private ArrayList<Point> path;
	private Entity entity;
	private Area area;
	
	
	public Navigation(ArrayList<Point> path,Entity entity,Area area)
	{
		this.entity=entity;
		this.area=area;
		this.path=path;
	}
	
	public synchronized void run() {
		
        int threadNumber=entity.getThreadCount();
        
        if(path!=null){
        	
        	for (int i = 1; i < path.size(); i++) {
        			
        			//make sure there aren't other threads running
                	if(threadNumber<entity.getThreadCount()) 
                	{
                		//threadCount--;
                		break;
                	}
                	if(threadNumber>entity.getThreadCount())
                	{
                		threadNumber--;
                		
                	}
                	//wait for the first thread to stop before the second one starts
                	while(entity.getThreadCount()>1)
                	{
                		try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
                	}
                	
                    try {
                    	//decide on the direction the entity is moving
                        int newx=path.get(i).x;
                        int newy=path.get(i).y;
                        int dx=entity.getPosX()-newx;
                        int dy=entity.getPosY()-newy;
                        
                        switch(dx){
                        case -1:
                        	switch(dy){
	                        case -1:
	                        	entity.setAnimType(Direction.WaSE);	
	                        	break;
	                        	
	                        case 0:
	                        	entity.setAnimType(Direction.WaEE);	
	                        	break;
	                        	
	                        case 1:
	                        	entity.setAnimType(Direction.WaEN);	
	                        	break;
	                        	
	                        default:
	                        	break;
	                        }
                        	break;
                        	
                        case 0:
                        	switch(dy){
	                        case -1:
	                        	entity.setAnimType(Direction.WaSS);	
	                        	break;
	                        	
	                        case 0:
	                        	break;
	                        	
	                        case 1:
	                        	entity.setAnimType(Direction.WaNN);	
	                        	break;
	                        	
	                        default:
	                        	break;
	                        }
                        	break;
                        	
                        case 1:
                        	switch(dy){
	                        case -1:
	                        	entity.setAnimType(Direction.WaWS);
	                        	break;
	                        	
	                        case 0:
	                        	entity.setAnimType(Direction.WaWW);
	                        	break;
	                        	
	                        case 1:
	                        	entity.setAnimType(Direction.WaNW);
	                        	break;
	                        	
	                        default:
	                        	break;
	                        }
                        	break;
                        	
                        default:                        	
                        	break;
                        }
                       
                        //decide on the new screen position
                        int posx=newx;
                        int posy=newy;
                        if(newx>=area.middlex) 
                        {
	        				if(newx>area.map.length-area.middlex) 
	        				{	        					
	        					posx=area.maxscreenposx-(area.maxX-newx);
	        				}	else
	        					{	        						
	        						posx=area.middlex;
	        					}
                        }
        				if(newy>=area.middley)
        				{
	        				if(newy>area.map[1].length-area.middley) 
	        				{
	        					
	        					posy=area.maxscreenposy-(area.maxY-newy);
	        				}else
	        				{
	        					
	        					posy=area.middley;
	        				}
        				}	
        	 				
        	 			
        				
        				
        				//System.out.println("updateing bg to "+newx+" "+newy);
        				double oldposx=area.posx;
    					double oldposy=area.posy;
        				double newxbg=entity.getPosX()*area.tilesize-entity.getScreenPosX()*area.tilesize;
    					double newybg=entity.getPosY()*area.tilesize-entity.getScreenPosY()*area.tilesize;
    					double dxbg=(oldposx-newxbg)/10;
    					double dybg=(oldposy-newybg)/10;
    					double oldpposx=entity.getScreenPosX();
    					double oldpposy=entity.getScreenPosY();
    					double dxppos=(oldpposx-posx)/10;
    					double dyppos=(oldpposy-posy)/10;
    					double myoldx=entity.getScreenPosX();
    					double myoldy=entity.getScreenPosY();
	        				for(int g=1;g<=10;g++)
	        				{
	        					if(entity.isPlayer())
	        					{
	        						area.bg.setPosition(oldposx-(dxbg*g),oldposy-(dybg*g));
	        						entity.updateScreenPos((oldpposx-(dxppos*g)), (oldpposy-(dyppos*g)));
	        					}else
	        					{
	        						double ddx=(myoldx-(newx*area.tilesize-area.posx))/10;
	        						double ddy=(myoldy-(newy*area.tilesize-area.posy))/10;
	        						entity.updateScreenPos(myoldx-ddx*g,myoldy-ddy*g);
	        					}
	        					
	        					Thread.sleep(20);
	        				}
	        				if(!entity.isPlayer())
	        				{
	        					//entity.updateScreenPos((newx*area.tilesize-area.posx),(newy*area.tilesize-area.posy));
	        					//System.out.println("WRONG posx and posy "+ newx+"  "+newy);

	        				}
	        				entity.updatePosX(newx);
	        				entity.updatePosY(newy);
	        				if(entity.isPlayer())
        					{
	        					area.bg.setPosition(newxbg,newybg);
        					}
        				//world.get(CurrentAreaIndex).og.setPosition(newxbg,newybg);
        				
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //reached destination
                switch(Player.animType){
                case WaNN:
                	entity.setAnimType(Direction.StNN);
                	break;
                	
                case WaNW:
                	entity.setAnimType(Direction.StNW);
                	break;
                
                case WaWW:
                	entity.setAnimType(Direction.StWW);
                	break;
                	
                case WaWS:
                	entity.setAnimType(Direction.StWS);
                	break;
                	
                case WaSS:
                	entity.setAnimType(Direction.StSS);
                	break;
                	
                case WaSE:
                	entity.setAnimType(Direction.StSE);
                	break;
                	
                case WaEE:
                	entity.setAnimType(Direction.StEE);
                	break;
                	
                case WaEN:
                	entity.setAnimType(Direction.StEN);
                	break;
                	
                default:
                	//Player.setAnimType(Direction.StSS);
                		
                
                
                }
        	}
        	entity.threadCountDec();
        	entity.setNotMoving();
        	
        }   	        
    
	
	
	
	
}
