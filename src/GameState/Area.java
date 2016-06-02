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
			this.bg=new Background("/maps/60000",4320,3510,45);	
		
		}
		this.player=new Player(45);
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
