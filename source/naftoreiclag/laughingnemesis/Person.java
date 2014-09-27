package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person
{
	public Vector2d location = new Vector2d();
	
	public Random random = new Random();
	private ImaginaryWorld world = new ImaginaryWorld();
	
	public Gender gender;
	public String name;
	
	public double lookAngle = random.nextDouble() * Math.PI * 2d;
	
	public Inventory inventory;
	
	private List<Action> actionQueue = new ArrayList<Action>();
	
	public Person()
	{
		gender = Gender.getRandomGender();
		name = Names.getRandomName(gender);
	}
	
	public void tick(double delta)
	{
		Vector2d what = Vector2d.getNormalFromAngle(lookAngle);
		
		location.add(what.multiplyLocal(delta));
		
		if(location.a < -World.worldSize) { location.a = -World.worldSize; }
		if(location.b < -World.worldSize) { location.b = -World.worldSize; }
		if(location.a > World.worldSize) { location.a = World.worldSize; }
		if(location.b > World.worldSize) { location.b = World.worldSize; }
	}
}
