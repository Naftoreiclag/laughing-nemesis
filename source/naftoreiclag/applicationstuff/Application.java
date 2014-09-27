package naftoreiclag.applicationstuff;

import java.awt.Color;
import java.awt.Graphics2D;

import naftoreiclag.laughingnemesis.*;

public class Application
{
	public double camX = 0;
	public double camY = 0;
	
	public World world = new World();
	
	public boolean tick(double delta)
	{
		return world.tick(delta);
	}
	
	public void paint(Graphics2D graphics2D, int width, int height)
	{
		BetterPainter painter = new BetterPainter(graphics2D);
		
		painter.setColor(Color.WHITE);
		painter.fillRect(0, 0, width, height);
		
		painter.translate(-camX + width * 0.5d, -camY + height * 0.5d);

		painter.setColor(Color.BLACK);
		
		painter.drawRect(-world.worldSize, -world.worldSize, world.worldSize * 2, world.worldSize * 2);
		
		String transformKey = "beforePeople";
		painter.saveTransform(transformKey);
		for(Person person : world.people)
		{
			painter.translate(person.circle.loc.a, person.circle.loc.b);
			
			painter.drawCircle(0, 0, 20);
			painter.drawLine(Math.cos(person.lookAngle) * 15, Math.sin(person.lookAngle) * 15, 
					Math.cos(person.lookAngle) * 20, Math.sin(person.lookAngle) * 20);
			
			painter.drawStringCentered(person.name, 0, -30);

			painter.loadTransform(transformKey);
		}
		painter.deleteTransform(transformKey);
	}

	
	
	
	
	
	
	
	
	public static Application dumbSingleton = new Application();
	public static boolean staticTick(double delta)
	{
		return dumbSingleton.tick(delta);
	}
	public static void staticPaint(Graphics2D painter, int width, int height)
	{
		dumbSingleton.paint(painter, width, height);
	}

}
