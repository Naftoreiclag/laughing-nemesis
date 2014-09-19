package naftoreiclag.laughingnemesis;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Application
{
	public List<PersonEntity> people = new ArrayList<PersonEntity>();
	
	public double camX = 0;
	public double camY = 0;
	
	public boolean tick(long delta)
	{
		boolean shouldRedraw = true;
		
		return shouldRedraw;
	}
	
	public void paint(Graphics2D painter, int width, int height)
	{
		painter.fillRect(0, 0, width, height);
		
		painter.translate(-camX, -camY);
	}

	
	
	
	
	
	
	
	
	public static Application dumbSingleton = new Application();
	public static boolean staticTick(long delta)
	{
		return dumbSingleton.tick(delta);
	}
	public static void staticPaint(Graphics2D painter, int width, int height)
	{
		dumbSingleton.paint(painter, width, height);
	}

}
