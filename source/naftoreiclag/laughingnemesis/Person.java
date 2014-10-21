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
import naftoreiclag.laughingnemesis.memory.Memory;
import naftoreiclag.laughingnemesis.memory.MemoryCollection;
import naftoreiclag.laughingnemesis.memory.notice.Notice;
import naftoreiclag.laughingnemesis.memory.notice.NoticeCollection;
import naftoreiclag.laughingnemesis.memory.notice.NoticeDictionary;
import naftoreiclag.laughingnemesis.task.Task;
import naftoreiclag.laughingnemesis.task.TaskCollection;
import naftoreiclag.laughingnemesis.want.Want;
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
	public List<Want> wants = new LinkedList<Want>();
	public List<Task> tasks = new LinkedList<Task>();
	
	// im insane
	public Task currentTask = null;
	
	public Queue<Notice> notices2 = new LinkedList<Notice>();
	
	// Brainily
	public Subconscious subcon = new Subconscious();
	public Identity identity = new Identity();
	public Stamina brainStamina = new Stamina();
	public List<Task> queuedTasks = new LinkedList<Task>();
	
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
		
		for(Notice notice : notices.data)
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
		
		for(Iterator<Notice> iterator = notices2.iterator(); iterator.hasNext();)
		{
		    Notice notice = iterator.next();
		    
		    List<Want> wants = notice.whatDoYouWantFromThis(identity);
		    
		    if(wants.size() <= 0)
		    {
		    	continue;
		    }
		    
		    Want newWant = notice.whatDoYouWantFromThis(identity).get(0);
		    
			wants.add(newWant);
			tasks.addAll(TaskGiver.howToAchieve(newWant));
			
		    
			iterator.remove();
		}
		
		if(currentTask == null)
		{
			if(tasks.size() > 0)
			{
				currentTask = tasks.get(0);
				tasks.remove(0);
			}
		}
		else
		{
			currentTask.setPerson(this);
			currentTask.tick(delta);
			
			if(currentTask.isCompleted())
			{
				currentTask = currentTask.getCompletionState();
			}
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
				List<Memory> sample = memories.getRandomSample();
				List<Notice> interestingData = NoticeDictionary.examine(sample);
				
				notices2.addAll(interestingData);
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
