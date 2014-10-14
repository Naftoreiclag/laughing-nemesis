/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import naftoreiclag.laughingnemesis.communication.Bubble;
import naftoreiclag.laughingnemesis.memory.AMemory;
import naftoreiclag.laughingnemesis.memory.MemoryCollection;
import naftoreiclag.laughingnemesis.memory.notice.ANotice;
import naftoreiclag.laughingnemesis.memory.notice.NoticeCollection;
import naftoreiclag.laughingnemesis.memory.notice.NoticeDictionary;
import naftoreiclag.laughingnemesis.task.ATask;
import naftoreiclag.laughingnemesis.task.TaskCollection;
import naftoreiclag.laughingnemesis.want.WantCollection;

// Goal is to make as many friends as possible.
// Perhaps this class should just be a combination of a body and brain...
public class Person implements ITickable
{
	// Bodily
	public Gender gender;
	public String name;
	public Body body;
	
	public MemoryCollection memories = new MemoryCollection();
	public NoticeCollection notices = new NoticeCollection();
	public WantCollection wants = new WantCollection();
	public TaskCollection tasks = new TaskCollection();
	
	public Queue<ANotice> notices2 = new LinkedList<ANotice>();
	
	// Brainily
	public Subconscious subcon = new Subconscious();
	public Identity identity = new Identity();
	public Stamina brainStamina = new Stamina();
	public List<ATask> queuedTasks = new LinkedList<ATask>();
	public ATask currentTask;
	
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
		
		for(ANotice notice : notices.data)
		{
			if(notice.isSolved())
			{
				continue;
			}
			
			// TODO: use brainstamina
			
			if(GR.chanceHertz(delta, notice.hertz))
			{
				if(notice.isTrueFor(memories.data))
				{
					notice.markSolved();
					notices2.add(notice);
				}
				
				// todo: if it is wrong, add whatever we still noticed to the notice stack
			}
		}
		
		for(Iterator<ANotice> iterator = notices2.iterator(); iterator.hasNext();)
		{
		    ANotice notice = iterator.next();
			wants.add(notice.whatDoYouWantFromThis(identity));
			iterator.remove();
		}
		
		debugMessagesTick(delta);
	}

	private void debugMessagesTick(double delta)
	{
		for(Foo f : debugMessages)
		{
			f.age -= delta;
			
			if(f.age < 0)
			{
			}
		}
	}

	private void debug(String something)
	{
		debugMessages.add(new Foo(5, something));
	}
	
	public class Subconscious implements ITickable
	{
		double hertz = 1d / 5d;
		
		@Override
		public void tick(double delta)
		{
			if(GR.chanceHertz(delta, hertz))
			{
				debug("thunk");
				List<AMemory> sample = memories.getRandomMemories();
				List<ANotice> noticez = NoticeDictionary.examine(sample);
				
				notices.add(noticez);
			}
		}
	}
	
	public class Identity
	{
		public EnumSet<Trait> traits = EnumSet.noneOf(Trait.class);
		
		public Identity()
		{
			traits.add(Trait.extroverted);
		}
	}
	
	
	public List<Foo> debugMessages = new LinkedList<Foo>();
	public Queue<Bubble> bubbles = new LinkedList<Bubble>();
	
	public void receiveMessage(Bubble bubble)
	{
		bubbles.add(bubble);
	}
}
