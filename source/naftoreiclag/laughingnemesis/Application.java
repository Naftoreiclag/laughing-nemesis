package naftoreiclag.laughingnemesis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Application
{
	public List<PersonEntity> people = new ArrayList<PersonEntity>();
	
	public static final double worldSize = 300;
	
	public double camX = 0;
	public double camY = 0;
	
	public Application()
	{
		people.add(new PersonEntity());
		people.add(new PersonEntity());
	}
	
	public boolean tick(long delta)
	{
		boolean shouldRedraw = true;
		for(PersonEntity person : people)
		{
			person.tick(delta);
		}
		
		return shouldRedraw;
	}
	
	public void paint(Graphics2D graphics2D, int width, int height)
	{
		BetterPainter painter = new BetterPainter(graphics2D);
		
		painter.setColor(Color.WHITE);
		painter.fillRect(0, 0, width, height);
		
		painter.translate(-camX + width * 0.5d, -camY + height * 0.5d);

		painter.setColor(Color.BLACK);
		
		painter.drawRect(-worldSize, -worldSize, worldSize * 2, worldSize * 2);
		
		for(PersonEntity person : people)
		{
			painter.translate(person.x, person.y);
			
			painter.drawCircle(0, 0, 20);

			painter.translate(-person.x, -person.y);
		}
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
