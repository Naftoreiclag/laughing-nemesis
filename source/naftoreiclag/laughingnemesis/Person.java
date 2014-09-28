package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;

import naftoreiclag.laughingnemesis.memory.Memory;
import naftoreiclag.laughingnemesis.memory.MemoryCollection;
import naftoreiclag.pigcollision.Circle;

public class Person
{
	//private ImaginaryWorld world = new ImaginaryWorld();
	
	public Face face;
	
	public Gender gender;
	public String name;
	
	public Circle circle;
	
	public static final double fov = Math.PI / 4;
	
	public double lookAngle = GR.r.nextDouble() * Math.PI * 2d;
	
	public Inventory inventory;
	
	public boolean walking;
	
	public World world;
	
	private MemoryCollection memories;
	
	private List<Action> actionQueue = new ArrayList<Action>();
	
	public Person(World world)
	{
		this.world = world;
		
		gender = Gender.getRandomGender();
		name = Names.getRandomName(gender);
		
		face = new Face();
		
		circle = new Circle(Vector2d.randomNormal().multiplyLocal(50d), 20, 1);
	}
	
	public void tick(double delta)
	{
		memories.tick(delta);
		
		switch(memories.emotion)
		{
			case lonely:
			{
				// make friends
				
				
			}
		}
		
		if(walking)
		{
			Vector2d what = Vector2d.getNormalFromAngle(lookAngle);
			circle.motion = what.multiplyLocal(30);
		}
	}
}
