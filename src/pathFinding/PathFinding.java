package pathFinding;

import java.awt.Point;
import java.util.ArrayList;

public class PathFinding {
	private Boolean[][] map;
	private Boolean[][] explored;
	private Node[][] nodes;

	private ArrayList<Node> Frontier=new ArrayList<Node>();
	//private ArrayList<Node> Explored=new ArrayList <Node>();

	public PathFinding(Boolean[][] map){
		this.map=map;
		explored=new Boolean[map.length][map[0].length];
		nodes=new Node[map.length][map[0].length];
	}

	public void init(){
		Frontier.clear();
		//Explored.clear();
		for(int i=0;i<map.length;i++)
		{
			for(int y=0;i<map[i].length;i++)
			{
				explored[i][y]=false;
			}
		}
	}
		
	
	public int heuristic(int sx,int sy,int tx,int ty)
	{
		int dx=sx-tx;
		int dy=sy-ty;
		//return Math.abs(dx)+Math.abs(dy);
		return (int)Math.sqrt(dx*dx+dy*dy);
	}
	
	public void addToFrontier(Node n)
	{
		//System.out.println("added to frontier  "+n);
		nodes[n.x][n.y]=n;
		int f=n.g+n.h;
		for(int i=0;i<Frontier.size();i++)
		{
			if(f<Frontier.get(i).g+Frontier.get(i).h)
			{
				Frontier.add(i, n);
				return;
			}
		}
		Frontier.add(n);
		//System.out.println(Frontier);
	}
	
	public ArrayList<Point> findPath(int sx, int sy, int tx, int ty)
	{
		int cnt=0;
		init();
		if(sx==tx&&sy==ty)return null;
		Node current =new Node(sx,sy,0,heuristic(sx,sy,tx,ty),null);
		nodes[sx][sy]=current;
		Frontier.add(current);
		while(Frontier.size()>0)
		{
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					int nx=current.x+i;
					int ny=current.y+j;
					
					Node neighbour=new Node(nx,ny,current.g+1,heuristic(nx,ny,tx,ty),current);
					if(map[neighbour.x][neighbour.y])
					{
						if(nodes[nx][ny]==null)addToFrontier(neighbour);
						else
							if(!nodes[nx][ny].isExplored&&!nodes[nx][ny].isInFrontier) addToFrontier(neighbour);
							else if (neighbour.g<nodes[nx][ny].g){
								nodes[nx][ny].g=neighbour.g;
								nodes[nx][ny].parent=current;							
							}
					}
				}

			}
			
			Frontier.remove(current);
			current.isInFrontier=false;
			current.isExplored=true;
			if(Frontier.size()>0)
			{
				current=Frontier.get(0);
				cnt++;
				if(cnt>1000)return null;
				//System.out.println(cnt);
				//System.out.println(current);
				if(current.x==tx&&current.y==ty)
				{
					//reached goal
					//System.out.println("reached goal");
					break;
				}
			}else System.out.println("failed to find path");
		}
		ArrayList<Point> path=new ArrayList<Point>();
		path.add(new Point(current.x,current.y));
		while(current.parent!=null)
		{
			current=current.parent;
			path.add(0,new Point(current.x,current.y));
		}
		
		return path;
	}
	
	
	
	
}
