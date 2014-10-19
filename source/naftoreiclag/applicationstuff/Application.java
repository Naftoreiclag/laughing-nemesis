package naftoreiclag.applicationstuff;

import java.awt.Color;
import java.awt.Graphics2D;

import naftoreiclag.laughingnemesis.*;
import naftoreiclag.laughingnemesis.memory.notice.Notice;
import naftoreiclag.laughingnemesis.want.Want;

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
			if(person.body.circle.loc.distanceSquared(
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
			Body body = person.body;
			
			painter.translate(body.circle.loc.a, body.circle.loc.b);
			
			painter.drawCircle(0, 0, 20);
			painter.drawLine(Math.cos(body.lookAngle.a - Body.fov) * 25, Math.sin(body.lookAngle.a - Body.fov) * 25, 
					Math.cos(body.lookAngle.a - Body.fov) * 20, Math.sin(body.lookAngle.a - Body.fov) * 20);
			painter.drawLine(Math.cos(body.lookAngle.a + Body.fov) * 25, Math.sin(body.lookAngle.a + Body.fov) * 25, 
					Math.cos(body.lookAngle.a + Body.fov) * 20, Math.sin(body.lookAngle.a + Body.fov) * 20);
			
			painter.drawStringCentered(person.name, 0, -30);

			painter.translate(0, (person.debugMessages.size() * -15) - 50);
			
			for(Foo foo : person.debugMessages)
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
			painter.println("Notices: ");
			for(Notice notice : analyze.notices.data)
			{
				painter.println(notice.toString());
			}
			painter.println("Wants: ");
			for(Want want : analyze.wants)
			{
				painter.println(want.toString());
			}
			
			painter.endPrinting();
			
			painter.loadTransformAndDelete(beforeAnalyzer);
		}
		
	}
	
	private String getDoubleAsPercent(double d)
	{
		return "%" + Math.round(d * 100);
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
