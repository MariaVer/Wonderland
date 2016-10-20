package GameState;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Entity.Animation;
import Entity.Direction;
import Entity.Player;
import pathFinding.PathFinding;



public class GameStateManager 
{
	public ArrayList<Area> world=new ArrayList<Area>();
	public int CurrentAreaIndex=0;
	public static Animation anim=new Animation();
	private int threadCount=0;
	
	public GameStateManager()
	{
		for(int i=0;i<1;i++)
		{
			Area ar=new Area(i);
			world.add(ar);
		}
	}
		
	public void init()
	{
		
	}
	
	public void update()
	{
		world.get(CurrentAreaIndex).update();
	}
	
	public void draw(java.awt.Graphics2D g)
	{
		world.get(CurrentAreaIndex).draw(g);
	}
	
	public void keyPressed(int k)
	{
			
		
	}
	
	public void keyReleased(int k)
	{
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			
			int x=(int)e.getPoint().getX()/world.get(CurrentAreaIndex).tilesize;
			int y=(int)e.getPoint().getY()/world.get(CurrentAreaIndex).tilesize;
			int newxx=Player.getPlayerX()-(int)Player.getScreenPosX()+x;
			int newyy=Player.getPlayerY()-(int)Player.getScreenPosY()+y;
			//newx and newy are the map coordinates where the player needs to move
			boolean goodPos=world.get(CurrentAreaIndex).getMap()[newxx][newyy];
			if(goodPos)
			{			
				
				PathFinding pather=new PathFinding(world.get(CurrentAreaIndex).getMap());
				ArrayList<Point> path = pather.findPath(Player.getPlayerX(),Player.getPlayerY(),newxx,newyy);
				
				world.get(CurrentAreaIndex).drawPath(path);
				//this updates the player position immediately 
				/* 
				if(newx<world.get(CurrentAreaIndex).middlex) Player.updateScreenPosX(newx); 
				else if(newx>world.get(CurrentAreaIndex).map.length-world.get(CurrentAreaIndex).middlex) 
					Player.updateScreenPosX(world.get(CurrentAreaIndex).maxscreenposx-(world.get(CurrentAreaIndex).maxX-newx));
						else Player.updateScreenPosX(world.get(CurrentAreaIndex).middlex);
				
				if(newy<world.get(CurrentAreaIndex).middley) Player.updateScreenPosY(newy); 
				else if(newy>world.get(CurrentAreaIndex).map[1].length-world.get(CurrentAreaIndex).middley) 
					Player.updateScreenPosY(world.get(CurrentAreaIndex).maxscreenposy-(world.get(CurrentAreaIndex).maxY-newy));
						else Player.updateScreenPosY(world.get(CurrentAreaIndex).middley);
	 			
				
				Player.updatePlayerX(newx);
				Player.updatePlayerY(newy);
				*/
				Thread th = new Thread() {

		            public synchronized void run() {
		            	int threadNumber=threadCount;
		            	if(path!=null){
			                for (int i = 1; i < path.size(); i++) {
			                	if(threadNumber<threadCount) 
			                	{
			                		//threadCount--;
			                		break;
			                	}
			                	if(threadNumber>threadCount)
			                	{
			                		threadNumber--;
			                		
			                	}
			                	while(threadCount>1)
			                	{
			                		try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
			                	}
			                	
			                    try {
			                        int newx=path.get(i).x;
			                        int newy=path.get(i).y;
			                        int dx=Player.getPlayerX()-newx;
			                        int dy=Player.getPlayerY()-newy;
			                        //System.out.println("dx: "+dx+"  dy: "+dy);
			                        switch(dx){
			                        case -1:
			                        	switch(dy){
				                        case -1:
				                        	Player.setAnimType(Direction.WaSE);	
				                        	break;
				                        	
				                        case 0:
				                        	Player.setAnimType(Direction.WaEE);	
				                        	break;
				                        	
				                        case 1:
				                        	Player.setAnimType(Direction.WaEN);	
				                        	break;
				                        	
				                        default:
				                        	//Player.setAnimType(Direction.StSS);	
				                        	break;
				                        }
			                        	break;
			                        	
			                        case 0:
			                        	switch(dy){
				                        case -1:
				                        	Player.setAnimType(Direction.WaSS);	
				                        	break;
				                        	
				                        case 0:
				                        	//Player.setAnimType(Direction.StSS);	
				                        	break;
				                        	
				                        case 1:
				                        	Player.setAnimType(Direction.WaNN);	
				                        	break;
				                        	
				                        default:
				                        	//Player.setAnimType(Direction.StSS);	
				                        	break;
				                        }
			                        	break;
			                        	
			                        case 1:
			                        	switch(dy){
				                        case -1:
				                        	Player.setAnimType(Direction.WaWS);
				                        	break;
				                        	
				                        case 0:
				                        	Player.setAnimType(Direction.WaWW);
				                        	break;
				                        	
				                        case 1:
				                        	Player.setAnimType(Direction.WaNW);
				                        	break;
				                        	
				                        default:
				                        	//Player.setAnimType(Direction.StSS);	
				                        	break;
				                        }
			                        	break;
			                        	
			                        default:
			                        	//Player.setAnimType(Direction.StSS);	
			                        	break;
			                        }
			                       
			                        int posx=newx;
			                        int posy=newy;
			                        if(newx>=world.get(CurrentAreaIndex).middlex) 
			                        {
				        				if(newx>world.get(CurrentAreaIndex).map.length-world.get(CurrentAreaIndex).middlex) 
				        				{
				        					
				        					posx=world.get(CurrentAreaIndex).maxscreenposx-(world.get(CurrentAreaIndex).maxX-newx);
				        				}	else
				        					{
				        						
				        						posx=world.get(CurrentAreaIndex).middlex;
				        					}
			                        }
			        				if(newy>=world.get(CurrentAreaIndex).middley)
			        				{
				        				if(newy>world.get(CurrentAreaIndex).map[1].length-world.get(CurrentAreaIndex).middley) 
				        				{
				        					
				        					posy=world.get(CurrentAreaIndex).maxscreenposy-(world.get(CurrentAreaIndex).maxY-newy);
				        				}else
				        				{
				        					
				        					posy=world.get(CurrentAreaIndex).middley;
				        				}
			        				}	
			        	 				
			        	 			
			        				
			        				
			        				//System.out.println("updateing bg to "+newx+" "+newy);
			        				double oldposx=world.get(CurrentAreaIndex).bg.posx;
		        					double oldposy=world.get(CurrentAreaIndex).bg.posy;
			        				double newxbg=Player.getPlayerX()*world.get(CurrentAreaIndex).tilesize-Player.getScreenPosX()*world.get(CurrentAreaIndex).tilesize;
		        					double newybg=Player.getPlayerY()*world.get(CurrentAreaIndex).tilesize-Player.getScreenPosY()*world.get(CurrentAreaIndex).tilesize;
		        					double dxbg=(oldposx-newxbg)/10;
		        					double dybg=(oldposy-newybg)/10;
		        					double oldpposx=Player.getScreenPosX();
		        					double oldpposy=Player.getScreenPosY();
		        					double dxppos=(oldpposx-posx)/10;
		        					double dyppos=(oldpposy-posy)/10;
			        				for(int g=1;g<=10;g++)
			        				{
			        					world.get(CurrentAreaIndex).bg.setPosition(oldposx-(dxbg*g),oldposy-(dybg*g));
			        					Player.updateScreenPos((oldpposx-(dxppos*g)), (oldpposy-(dyppos*g)));
			        					//System.out.println("new x: "+Player.getScreenPosX()+" new y: "+Player.getScreenPosY());
			        					Thread.sleep(20);
			        				}
			        				Player.updatePlayerX(newx);
			        				Player.updatePlayerY(newy);
			        				world.get(CurrentAreaIndex).bg.setPosition(newxbg,newybg);
			        				
			                    } catch (Exception e) {
			                        e.printStackTrace();
			                    }
			                }
			                //reached destination
			                switch(Player.animType){
			                case WaNN:
			                	Player.setAnimType(Direction.StNN);
			                	break;
			                	
			                case WaNW:
			                	Player.setAnimType(Direction.StNW);
			                	break;
			                
			                case WaWW:
			                	Player.setAnimType(Direction.StWW);
			                	break;
			                	
			                case WaWS:
			                	Player.setAnimType(Direction.StWS);
			                	break;
			                	
			                case WaSS:
			                	Player.setAnimType(Direction.StSS);
			                	break;
			                	
			                case WaSE:
			                	Player.setAnimType(Direction.StSE);
			                	break;
			                	
			                case WaEE:
			                	Player.setAnimType(Direction.StEE);
			                	break;
			                	
			                case WaEN:
			                	Player.setAnimType(Direction.StEN);
			                	break;
			                	
			                default:
			                	//Player.setAnimType(Direction.StSS);
			                		
			                
			                
			                }
		            	}
		            	threadCount--;
		            	
		            }

		        };		        
		        th.start();
		        threadCount++;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
		
	}

	
	public void mouseMoved(MouseEvent e) {
		
		
	}
}
