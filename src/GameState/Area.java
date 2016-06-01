package GameState;

import Entity.Player;

public class Area {
	private String s;
	private Background bg;
	private int index;
	private Player player;
	
	public Area(int index)
	{
		this.index=index;
		
		if(index==0)
		{
			this.bg=new Background("/backgrounds/Area1.png");
		
		}
		this.player=new Player();
	}
	
	
	
	public void init()
	{
		
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
	}

}
