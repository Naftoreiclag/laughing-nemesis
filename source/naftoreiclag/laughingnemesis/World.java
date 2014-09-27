package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;

public class World
{
	public List<Person> people = new ArrayList<Person>();
	
	// Artifical constraint
	public static final double worldSize = 300;
	
	public World()
	{
		people.add(new Person());
		people.add(new Person());
	}
	
	public boolean tick(long delta)
	{
		boolean shouldRedraw = true;
		for(Person person : people)
		{
			person.tick(delta);
		}
		
		return shouldRedraw;
	}
}
