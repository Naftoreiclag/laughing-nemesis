package naftoreiclag.applicationstuff;

import java.awt.Color;
import java.awt.Graphics2D;

import naftoreiclag.laughingnemesis.*;

public class Application
{
	public double camX = 0;
	public double camY = 0;
	
	public double realMx;
	public double realMy;
	
	public World world = new World();
	
	private Person analyze = null;
	
	public boolean tick(double delta)
	{
		realMx = camX + (MainPanel.mouseX - (MainPanel.width / 2));
		realMy = camY + (MainPanel.mouseY - (MainPanel.height / 2));
		if(MainPanel.leftDown)
		{
			analyze = findPersonUnderMouse();
		}
		
		return world.tick(delta);
	}
	
	private Person findPersonUnderMouse()
	{
		for(Person person : world.people)
		{
			if(person.circle.loc.distanceSquared(
					realMx, 
					realMy) <= 400)
			{
				return person;
			}
		}
		
		return null;
	}

	public void paint(Graphics2D graphics2D, int width, int height)
	{
		BetterPainter painter = new BetterPainter(graphics2D);
		
		painter.setColor(Color.WHITE);
		painter.fillRect(0, 0, width, height);
		
		painter.translate(-camX + width * 0.5d, -camY + height * 0.5d);

		painter.setColor(Color.BLACK);
		
		painter.drawRect(-world.worldSize, -world.worldSize, world.worldSize * 2, world.worldSize * 2);
		
		String beforePeople = "beforePeople";
		painter.saveTransform(beforePeople);
		for(Person person : world.people)
		{
			painter.translate(person.circle.loc.a, person.circle.loc.b);
			
			painter.drawCircle(0, 0, 20);
			painter.drawLine(Math.cos(person.lookAngle - Person.fov) * 25, Math.sin(person.lookAngle - Person.fov) * 25, 
					Math.cos(person.lookAngle - Person.fov) * 20, Math.sin(person.lookAngle - Person.fov) * 20);
			painter.drawLine(Math.cos(person.lookAngle + Person.fov) * 25, Math.sin(person.lookAngle + Person.fov) * 25, 
					Math.cos(person.lookAngle + Person.fov) * 20, Math.sin(person.lookAngle + Person.fov) * 20);
			
			painter.drawStringCentered(person.name, 0, -30);

			painter.translate(0, (person.recentSayings.size() * -15) - 50);
			
			for(Foo foo : person.recentSayings)
			{
				painter.setAlpha(foo.thingy());
				painter.drawStringCentered(foo.string, 0, 0);
				painter.translate(0, 15);
			}
			painter.clearAlpha();

			painter.loadTransform(beforePeople);
		}
		
		painter.deleteTransform(beforePeople);
		
		if(analyze != null)
		{
			String beforeAnalyzer = "beforeAnalyzer";
			painter.saveTransform(beforeAnalyzer);
			
			painter.beginPrinting(realMx + 30, realMy + 30);
			
			painter.print("Name: ");
			painter.println(analyze.name);
			painter.print("Emotion: ");
			painter.println(analyze.getEmotion());
			painter.print("Thinking: ");
			painter.println(analyze.getThought());
			
			
			painter.endPrinting();
			
			painter.loadTransformAndDelete(beforeAnalyzer);
		}
		
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
