package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;

import naftoreiclag.pigcollision.Circle;

public class Person
{
	private ImaginaryWorld world = new ImaginaryWorld();
	
	public Gender gender;
	public String name;
	
	public Circle circle;
	
	public static final double fov = Math.PI / 4;
	
	public double lookAngle = GR.r.nextDouble() * Math.PI * 2d;
	
	public Inventory inventory;
	
	public boolean walking = true;
	
	private List<Action> actionQueue = new ArrayList<Action>();
	
	public Person()
	{
		gender = Gender.getRandomGender();
		name = Names.getRandomName(gender);
		
		circle = new Circle(Vector2d.randomNormal().multiplyLocal(50d), 20, 1);
	}
	
	public void tick(double delta)
	{
		if(walking)
		{
			Vector2d what = Vector2d.getNormalFromAngle(lookAngle);
			circle.motion = what.multiplyLocal(30);
		}
		/*
		
		if(location.a < -World.worldSize) { location.a = -World.worldSize; }
		if(location.b < -World.worldSize) { location.b = -World.worldSize; }
		if(location.a > World.worldSize) { location.a = World.worldSize; }
		if(location.b > World.worldSize) { location.b = World.worldSize; }
		*/
	}
}
