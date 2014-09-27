package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person
{
	public double x;
	public double y;
	
	public Random random = new Random();
	
	public double lookAngle = random.nextDouble() * Math.PI * 2d;
	
	public Inventory inventory;
	
	private List<Action> actionQueue = new ArrayList<Action>();
	
	public Person()
	{
		
	}
	
	public void tick(double delta)
	{
		
		if(this.x < -World.worldSize) { this.x = -World.worldSize; }
		if(this.y < -World.worldSize) { this.y = -World.worldSize; }
		if(this.x > World.worldSize) { this.x = World.worldSize; }
		if(this.y > World.worldSize) { this.y = World.worldSize; }
	}
}
