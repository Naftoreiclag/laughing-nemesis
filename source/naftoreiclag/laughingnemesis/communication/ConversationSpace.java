package naftoreiclag.laughingnemesis.communication;

import java.util.ArrayList;
import java.util.List;

import naftoreiclag.laughingnemesis.Person;
import naftoreiclag.laughingnemesis.World;

public class ConversationSpace
{
	public List<Bubble> bubbles = new ArrayList<Bubble>();
	
	public World world = new World();
	
	public ConversationSpace(World world)
	{
		this.world = world;
	}
	
	public void postMessage(Bubble bubble, double x, double y)
	{
		for(Person person : world.people)
		{
			
		}
	}
}
