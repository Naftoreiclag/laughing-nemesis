package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import naftoreiclag.laughingnemesis.communication.Bubble;
import naftoreiclag.laughingnemesis.memory.Memory;
import naftoreiclag.laughingnemesis.memory.MemoryCollection;
import naftoreiclag.pigcollision.Circle;

public class Person
{
	public Face face;
	
	public Gender gender;
	public String name;
	
	public Circle circle;
	
	public static final double fov = Math.PI / 4;
	
	public double lookAngle = GR.r.nextDouble() * Math.PI * 2d;
	
	public Inventory inventory;
	
	public boolean walking;
	
	public World world;
	
	// favorite color
	public Colour favColor;
	
	private MemoryCollection memories = new MemoryCollection();
	
	private List<Action> actionQueue = new ArrayList<Action>();
	
	public Person(World world)
	{
		this.world = world;
		
		gender = Gender.getRandomGender();
		name = Names.getRandomName(gender);
		
		favColor = Colour.getRandomColor();
		
		face = new Face();
		
		circle = new Circle(Vector2d.randomNormal().multiplyLocal(50d), 20, 1);
	}
	
	public Person findNearestPerson()
	{
		Person nearest = null;
		double bestDist = Double.MAX_VALUE;
		
		for(Person person : world.people)
		{
			if(person == this)
			{
				continue;
			}
			
			double distanceToThisPerson = person.circle.loc.distanceSquared(this.circle.loc);
			
			if(distanceToThisPerson < bestDist)
			{
				nearest = person;
				bestDist = distanceToThisPerson;
			}
		}
		
		return nearest;
	}
	
	
	public void tick(double delta)
	{
		memories.tick(delta);
		
		if(bubbles.isEmpty())
		{
			
		}
		
		/*
		switch(memories.emotion)
		{
			case lonely:
			{
				// make friends
				Person newFriend = findNearestPerson();
				
				if(newFriend == null)
				{
					break;
				}
				
				
				break;
			}
		}
		
		*/
		
		if(walking)
		{
			Vector2d what = Vector2d.getNormalFromAngle(lookAngle);
			circle.motion = what.multiplyLocal(30);
		}
	}
	
	public Queue<Bubble> bubbles = new LinkedList<Bubble>();
	
	public void receiveMessage(Bubble bubble)
	{
		bubbles.add(bubble);
	}

	public Emotion getEmotion()
	{
		return memories.emotion;
	}

	public String getThought()
	{
		return "I want some friends";
	}
}
