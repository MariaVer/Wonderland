package main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import GameState.GameStateManager;

public class GamePanel extends JPanel implements Runnable,KeyListener,MouseListener,MouseMotionListener
{
	//dimensions
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int SCALE = 1;	
	
	//game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 /FPS;
	
	//image
	private BufferedImage image;
	private Graphics2D g;
	
	//game state manager
	private GameStateManager gsm;
	
	public GamePanel()
	{
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		gsm =new GameStateManager();
		
	}
	
	public void addNotify() 
	{
		super.addNotify();
		if(thread==null)
		{
			thread = new Thread(this);
			addKeyListener(this);
			addMouseListener(this);
			addMouseMotionListener(this);
			thread.start();
			
		}
		
	}
	
	public void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g=(Graphics2D) image.getGraphics();
		running=true;
		
	}
	
	
	public void run()
	{
		init();
		
		long start;
		long elapsed;
		long wait;
		
		while(running)
		{
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			
			elapsed= System.nanoTime()-start;
			wait = targetTime - elapsed / 1000000;
			if(wait<0) wait=5;
			try
			{
				Thread.sleep(wait);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	private void update()
	{
		gsm.update();
	}
	private void draw()
	{
		gsm.draw(g);
	}
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key)
	{
		
	}
	public void keyPressed(KeyEvent key)
	{
		gsm.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key)
	{
		gsm.keyReleased(key.getKeyCode());
	}

	public void mouseClicked(MouseEvent e) {
		gsm.mouseClicked(e);
		
	}

	
	public void mouseEntered(MouseEvent e) {
		gsm.mouseEntered(e);
		
	}

	
	public void mouseExited(MouseEvent e) {
		gsm.mouseExited(e);
		
	}

	
	public void mousePressed(MouseEvent e) {
		gsm.mousePressed(e);
		
	}

	
	public void mouseReleased(MouseEvent e) {
		gsm.mouseReleased(e);
	}

	
	public void mouseDragged(MouseEvent e) {
		gsm.mouseDragged(e);
	}

	
	public void mouseMoved(MouseEvent e) {
		gsm.mouseMoved(e);
		
	}
}
