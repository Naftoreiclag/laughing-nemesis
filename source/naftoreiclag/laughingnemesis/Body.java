package naftoreiclag.laughingnemesis;

import naftoreiclag.pigcollision.Circle;

public class Body implements ITickable
{
	public static final double fov = Math.PI / 4;
	public Circle circle;
	
	public boolean walking;
	public Stamina stamina = new Stamina();

	
	public World world;
	public double lookAngle = GR.r.nextDouble() * Math.PI * 2d;
	
	public Body(World world)
	{
		this.world = world;
		circle = new Circle(Vector2d.randomNormal().multiplyLocal(50d), 20, 1);
	}	
	/*
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
	*/
	
	@Override
	public void tick(double delta)
	{
		stamina.tick(delta);
		if(walking)
		{
			Vector2d what = Vector2d.getNormalFromAngle(lookAngle);
			circle.motion = what.multiplyLocal(30);
		}
	}
}
