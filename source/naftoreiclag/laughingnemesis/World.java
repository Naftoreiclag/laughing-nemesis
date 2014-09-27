package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;

public class World
{
	public List<PersonEntity> people = new ArrayList<PersonEntity>();
	
	// Artifical constraint
	public static final double worldSize = 300;
	
	public World()
	{
		people.add(new PersonEntity());
		people.add(new PersonEntity());
	}
	
	public boolean tick(long delta)
	{
		boolean shouldRedraw = true;
		for(PersonEntity person : people)
		{
			person.tick(delta);
		}
		
		return shouldRedraw;
	}
}
