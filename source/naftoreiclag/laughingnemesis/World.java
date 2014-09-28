package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;

import naftoreiclag.pigcollision.Line;
import naftoreiclag.pigcollision.Space;

public class World
{
	public List<Person> people = new ArrayList<Person>();
	
	public Space space = new Space();
	
	// Artifical constraint
	public static final double worldSize = 300;
	
	public World()
	{
		addPerson();
		addPerson();
		
		space.lines.add(new Line(new Vector2d(-worldSize, -worldSize), new Vector2d(worldSize, -worldSize)));
		space.lines.add(new Line(new Vector2d(worldSize, -worldSize), new Vector2d(worldSize, worldSize)));
		space.lines.add(new Line(new Vector2d(worldSize, worldSize), new Vector2d(-worldSize, worldSize)));
		space.lines.add(new Line(new Vector2d(-worldSize, worldSize), new Vector2d(-worldSize, -worldSize)));
	}

	private void addPerson()
	{
		Person person = new Person(this);
		people.add(person);
		space.circles.add(person.circle);
	}
	
	public boolean tick(double delta)
	{
		space.simulate(delta);
		
		boolean shouldRedraw = true;
		for(Person person : people)
		{
			person.tick(delta);
		}
		
		return shouldRedraw;
	}
}
