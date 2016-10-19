package mapper;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Entity.Player;
import GameState.Background;


public class Area2 {
	private String s;
	public Background bg;
	private int index;
	private Player player;
	public Boolean[][] map;
	public int tilesize=15;
	public int maxX=288,maxY=234;
	public int middlex=43,middley=30;
	public int maxscreenposx=87,maxscreenposy=60;
	private boolean pathtodraw=false;
	private ArrayList<Point> path;
	
	public Area2(int index)
	{
		this.index=index;
		
		if(index==0)
		{
			this.bg=new Background("/maps/60000",4320,3510,15);		
		}
		
		
		try {
			File f = new File("resources"+bg.source+".dat");
			if(!f.exists()) { 
				map=new Boolean[maxX][maxY];
				for(int i=0;i<maxX;i++)
				{
					for(int j=0;j<maxY;j++)
					{
						map[i][j]=false;						
					}
					
				}
				saveMap();
			}else{
			FileInputStream fi=new FileInputStream("resources"+bg.source+".dat");
			ObjectInputStream ois;		
			ois = new ObjectInputStream(fi);
			map=(Boolean[][])ois.readObject();
			ois.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		this.player=new Player(tilesize);
	}
	
	public void changeMap(boolean stuff,int x,int y)
	{
		this.map[x][y]=stuff;
	}
	
	public void init()
	{
		
	}
	
	public Boolean[][] getMap()
	{
		return map;
	}
	
	public void saveMap()
	{
		try {
			FileOutputStream fos = new FileOutputStream("resources/maps/60000.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);		
			oos.writeObject(map);
			oos.close();
			System.out.println("written");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		bg.update();
		player.update();
	}
	public void drawPath(ArrayList<Point> path)
	{
		pathtodraw=true;
		this.path=path;
	}
	
	public void draw(java.awt.Graphics2D g)
	{
		bg.draw(g);
		player.draw(g);
		g.setColor(Color.BLACK);
		String s=Player.getPlayerX()+" "+Player.getPlayerY();
		g.drawString(s, 50, 40);
		if(pathtodraw)
		{
			//draw grid
			
			for(int i=0;i<maxX;i++)
			{
				g.draw(new Line2D.Double(0, i*tilesize, 3510, i*tilesize));
			}
			for(int j=0;j<maxY;j++)
			{
				g.draw(new Line2D.Double(j*tilesize, 0, j*tilesize, 4320));
			}
			
			
			
			int alpha = 127; // 50% transparent
			Color myColour = new Color(0, 148, 71, alpha);
			g.setColor(myColour);
			//mark the map
			for(int i=0;i<maxscreenposx;i++)
			{
				for(int j=0;j<maxscreenposy;j++)
				{
					int reali=Player.getPlayerX()-Player.getScreenPosX()+i;
					int realj=Player.getPlayerY()-Player.getScreenPosY()+j;
					if(reali<map.length&&realj<map[1].length)
					{
					
						if (map[reali][realj])
						{
							 g.setColor(myColour);
					         g.fillRect(i*tilesize, j*tilesize, tilesize, tilesize);
						}
					
					}
				}
				
			}
			
			
			
			//draw path
			if(path!=null){
			for(int y=0;y<path.size();y++)
			{
				int pointx=path.get(y).x;
				int pointy=path.get(y).y;
				for(int i=0;i<maxscreenposx;i++)
				{
					for(int j=0;j<maxscreenposy;j++)
					{
						int reali=Player.getPlayerX()-Player.getScreenPosX()+i;
						int realj=Player.getPlayerY()-Player.getScreenPosY()+j;
						if(reali<map.length&&realj<map[1].length)
						{
						
							if (pointx==reali&&pointy==realj)
							{
								 g.setColor(myColour);
						         g.fillRect(i*tilesize, j*tilesize, tilesize, tilesize);
							}
						
						}
					}
					
				}
			}
			}
		}
		
	}

}


