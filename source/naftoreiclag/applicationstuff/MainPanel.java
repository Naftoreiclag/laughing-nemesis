package naftoreiclag.applicationstuff;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements MouseMotionListener, KeyListener, MouseListener, MouseWheelListener, ComponentListener
{
	public static void main(String[] args) { (new MainFrame()).setVisible(true); }
	
	public static int width = 1000;
	public static int height = 1000;
	
	public static int mouseX = 0;
	public static int mouseY = 0;
	
	public static boolean leftDown = false;
	public static boolean middleDown = false;
	public static boolean rightDown = false;
	
	public static boolean leftPress = false;
	public static boolean upPress = false;
	public static boolean rightPress = false;
	public static boolean downPress = false;
	public static boolean shiftPress = false;
	
	public static int scrollDistance = 0;
	
	public static class MainFrame extends JFrame
	{
		private MainFrame()
		{
			super("PaintingThing");
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(width, height);
			this.setLocationRelativeTo(null);

			this.add(new MainPanel());
		}
	}
	
	public MainPanel()
	{
		this.setFocusable(true);
		
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
		this.addComponentListener(this);

		(new Thread()
		{
			long lastTick = System.currentTimeMillis();
			long delta;
			
			int fpsCounter = 0;
			long lastPrint = lastTick;
			
			@Override
			public void run()
			{
				while(true)
				{
					delta = System.currentTimeMillis() - lastTick;
					
					if(delta > 10d)
					{
						lastTick = System.currentTimeMillis();
						
						if(Application.staticTick(delta / 1000d))
						{
						}
						repaint();
						fpsCounter ++;
					}
					
					if(System.currentTimeMillis() - lastPrint > 1000)
					{
						lastPrint = System.currentTimeMillis();
						System.out.println("TPS: " + fpsCounter);
						fpsCounter = 0;
					}
				}
		    }
		}).start();
	}
	
	@Override
	public void paint(Graphics graphics)
	{
		Graphics2D painter = (Graphics2D) graphics;
		
		Application.staticPaint(painter, MainPanel.width, MainPanel.height);
	}

	@Override
	public void mouseMoved(MouseEvent event)
	{
		mouseX = event.getX();
		mouseY = event.getY();
	}

	@Override
	public void mouseDragged(MouseEvent event)
	{
		mouseMoved(event);
		
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent event) {}

	@Override
	public void keyReleased(KeyEvent event)
	{
		switch(event.getKeyCode())
		{
			case KeyEvent.VK_UP:
				upPress = false;
				break;
			case KeyEvent.VK_DOWN:
				downPress = false;
				break;
			case KeyEvent.VK_LEFT:
				leftPress = false;
				break;
			case KeyEvent.VK_RIGHT:
				rightPress = false;
				break;
			case KeyEvent.VK_SHIFT:
				shiftPress = false;
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		switch(event.getKeyCode())
		{
			case KeyEvent.VK_UP:
				upPress = true;
				break;
			case KeyEvent.VK_DOWN:
				downPress = true;
				break;
			case KeyEvent.VK_LEFT:
				leftPress = true;
				break;
			case KeyEvent.VK_RIGHT:
				rightPress = true;
				break;
			case KeyEvent.VK_SHIFT:
				shiftPress = true;
				break;
		}
	}

	@Override
	public void mousePressed(MouseEvent event)
	{
		switch(event.getButton())
		{
			case MouseEvent.BUTTON1:
				leftDown = true;
				break;
			case MouseEvent.BUTTON2:
				middleDown = true;
				break;
			case MouseEvent.BUTTON3:
				rightDown = true;
				break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
		switch(event.getButton())
		{
			case MouseEvent.BUTTON1:
				leftDown = false;
				break;
			case MouseEvent.BUTTON2:
				middleDown = false;
				break;
			case MouseEvent.BUTTON3:
				rightDown = false;
				break;
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseClicked(MouseEvent event) {}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event)
	{
		scrollDistance += event.getWheelRotation();
	}

	@Override
	public void componentShown(ComponentEvent event) {}

	@Override
	public void componentResized(ComponentEvent event)
	{
		Dimension size = event.getComponent().getSize();
		
		width = size.width;
		height = size.height;
	}

	@Override
	public void componentMoved(ComponentEvent event) {}

	@Override
	public void componentHidden(ComponentEvent event){}
}
