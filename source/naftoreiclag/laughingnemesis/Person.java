/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import naftoreiclag.laughingnemesis.communication.Bubble;

// Goal is to make as many friends as possible.
// Perhaps this class should just be a combination of a body and brain...
public class Person implements ITickable
{
	// Bodily
	public Gender gender;
	public String name;
	public Body body;
	
	public MemoryCollection memories = new MemoryCollection();
	
	// Brainily
	public Subconscious subcon = new Subconscious();
	public Identity identity = new Identity();
	public Stamina brainStamina = new Stamina();
	public List<Thought> thoughts = new LinkedList<Thought>();
	public List<Goal> goals = new LinkedList<Goal>();
	public List<Task> queuedTasks = new LinkedList<Task>();
	public Task currentTask;
	
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
		subcon.tick(delta);
	}

	private void saySomething(String something)
	{
		recentSayings.add(new Foo(5, something));
	}
	
	/*
	 * Purpose is to analyze memories and other stuff to create notices.
	 * Perhaps I should merge this with Person?
	 * 
	 * Every tick, a random sample of memories is presented to this class. // This includes short-term, which may have interesting consequences.
	 * Potentially, a question will be developed from this presentation.
	 * This will be added to a queue of questions. // There may be memories which surpress further analysis
	 * 
	 * The questions which are developed occur sub-conciously, meaning there is no intervention of conciousness/identity
	 * Rather, how the questions are answered is based from identity
	 */
	public class Subconscious implements ITickable
	{
		@Override
		public void tick(double delta)
		{
			memories.tick(delta);
		}
	}
	
	public class Identity
	{

		public ThoughtCookbook thoughtCooker = new ThoughtCookbook();

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
