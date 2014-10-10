package naftoreiclag.laughingnemesis;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import naftoreiclag.laughingnemesis.communication.Bubble;

// Goal is to make as many friends as possible.
public class Person implements ITickable
{
	public Gender gender;
	public String name;
	public Body body;
	
	public Stamina brainStamina = new Stamina();
	
	public Subconscious analyzer = new Subconscious(this);
	
	public ThoughtCookbook thoughtCooker = new ThoughtCookbook();
	
	public MemoryCollection memories = new MemoryCollection();
	public List<Thought> thoughts = new LinkedList<Thought>();
	public List<Goal> goals = new LinkedList<Goal>();
	public List<Task> queuedTasks = new LinkedList<Task>();
	public Task currentTask;
	
	public double subconciousHertz = 1d / 5d; // every 5 seconds
	
	public Person(World world)
	{
		body = new Body(world);
		
		gender = Gender.getRandomGender();
		name = Names.getRandomName(gender);
	}

	@Override
	public void tick(double delta)
	{
		memories.tick(delta);
		body.tick(delta);
		brainStamina.tick(delta);
		
		if(GR.chanceOverTime(delta, subconciousHertz))
		{
			scAnalyzeSelf();
		}
	}
	
	private void scAnalyzeSelf()
	{
		
	}

	private void saySomething(String something)
	{
		recentSayings.add(new Foo(5, something));
	}
	
	
	public List<Foo> recentSayings = new LinkedList<Foo>();
	public Queue<Bubble> bubbles = new LinkedList<Bubble>();
	
	public void receiveMessage(Bubble bubble)
	{
		bubbles.add(bubble);
	}

	public String getThought()
	{
		return "I want some friends";
	}
}
