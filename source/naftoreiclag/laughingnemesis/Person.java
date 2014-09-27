package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;

public class Person
{
	public Vector2d location = new Vector2d();
	
	private ImaginaryWorld world = new ImaginaryWorld();
	
	public Gender gender;
	public String name;
	
	public double lookAngle = GR.r.nextDouble() * Math.PI * 2d;
	
	public Inventory inventory;
	
	public boolean walking;
	
	private List<Action> actionQueue = new ArrayList<Action>();
	
	public Person()
	{
		gender = Gender.getRandomGender();
		name = Names.getRandomName(gender);
		
		location = Vector2d.randomNormal().multiplyLocal(50d);
	}
	
	public void tick(double delta)
	{
		Vector2d what = Vector2d.getNormalFromAngle(lookAngle);
		location.addLocal(what.multiplyLocal(delta * 30));
		
		if(location.a < -World.worldSize) { location.a = -World.worldSize; }
		if(location.b < -World.worldSize) { location.b = -World.worldSize; }
		if(location.a > World.worldSize) { location.a = World.worldSize; }
		if(location.b > World.worldSize) { location.b = World.worldSize; }
	}
}
