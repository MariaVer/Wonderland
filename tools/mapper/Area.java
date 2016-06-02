package mapper;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Entity.Player;
import GameState.Background;


public class Area {
	private String s;
	private Background bg;
	private int index;
	private Player player;
	private Boolean[][] map;
	public int tilesize=45;
	public int maxX=96,maxY=78;
	
	public Area(int index)
	{
		try {
			File f = new File("resources/maps/60000.dat");
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
			FileInputStream fi=new FileInputStream("resources/maps/60000.dat");
			ObjectInputStream ois;		
			ois = new ObjectInputStream(fi);
			map=(Boolean[][])ois.readObject();
			ois.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		this.index=index;
		
		if(index==0)
		{
			this.bg=new Background("/maps/60000.png");
		
		}
		this.player=new Player();
	}
	
	public void changeMap(boolean stuff,int x,int y)
	{
		this.map[x][y]=stuff;
	}
	
	public void init()
	{
		
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
	
	public void draw(java.awt.Graphics2D g)
	{
		bg.draw(g);
		player.draw(g);
		g.setColor(Color.BLACK);
		String s=Player.getPlayerX()+" "+Player.getPlayerY();
		g.drawString(s, 50, 40);
		
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
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<20;j++)
			{
				int reali=Player.getPlayerX()-Player.getScreenPosX()+i;
				int realj=Player.getPlayerY()-Player.getScreenPosY()+j;
				if (map[reali][realj])
				{
					 g.setColor(myColour);
			         g.fillRect(i*tilesize, j*tilesize, tilesize, tilesize);
				}
				
			}
			
		}
		
	}

}
