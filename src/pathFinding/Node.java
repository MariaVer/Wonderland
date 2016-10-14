package pathFinding;

public class Node  {
	int x,y;
	double g,h;
	Node parent;
	Boolean isExplored=false,isInFrontier=false;
	
	public Node(int x,int y,double g, double h,Node parent)
	{
		this.x=x;
		this.y=y;
		this.h=h;
		this.g=g;
		this.parent=parent;
		isInFrontier=true;
	}
	
	public Boolean equals(Node n)
	{
		if(n.x==x&&n.y==y)return true;
		else return false;
	}
	
	public String toString()
	{
		return "x= "+x+" y= "+y +" Parent: "+g;
	}
}
