package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.jmx.snmp.tasks.Task;

import naftoreiclag.laughingnemesis.communication.Bubble;
import naftoreiclag.pigcollision.Circle;

// Goal is to make as many friends as possible.
public class Person implements ITickable
{
	public Gender gender;
	public String name;
	
	public Body body;
	
	public Stamina brainStamina = new Stamina();
	
	public Colour favColor;
	
	public List<Foo> recentSayings = new LinkedList<Foo>();
	
	private MemoryCollection memories = new MemoryCollection();
	
	public Person(World world)
	{
		body = new Body(world);
		
		gender = Gender.getRandomGender();
		name = Names.getRandomName(gender);
		
		favColor = Colour.getRandomColor();

	}
	
	private void saySomething(String something)
	{
		recentSayings.add(new Foo(5, something));
	}

	@Override
	public void tick(double delta)
	{
		// Tick all sub-tickables
		memories.tick(delta);
		body.tick(delta);
		brainStamina.tick(delta);
		
		
		for(Foo foo : recentSayings)
		{
			foo.age -= delta;
		}
		
		if(GR.chanceOverTime(delta, 0.5))
		{
			this.saySomething("yo");
		}
		
		
		if(!bubbles.isEmpty())
		{
			Bubble bubble = bubbles.remove();
		}
		
	}
	
	public Queue<Bubble> bubbles = new LinkedList<Bubble>();
	
	public void receiveMessage(Bubble bubble)
	{
		bubbles.add(bubble);
	}

	public String getThought()
	{
		return "I want some friends";
	}
}
