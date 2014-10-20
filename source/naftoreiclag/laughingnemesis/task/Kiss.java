/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.task;

import naftoreiclag.laughingnemesis.Body;
import naftoreiclag.laughingnemesis.Person;
import naftoreiclag.laughingnemesis.memory.MemoryFriendship;

public class Kiss extends Task
{
	Person person;
	Person target;
	
	
	
	double timer = 5d;
	
	boolean completed = false;

	public Kiss(Person person, Person target)
	{
		this.person = person;
		this.target = target;
	}

	@Override
	public void tick(double delta)
	{
		timer -= delta;
		
		if(timer > 0)
		{
			person.body.walking = true;
		}
		else
		{
			person.body.walking = false;
			
			person.memories.data.add(new MemoryFriendship());
			
			completed = true;
		}
	}

	@Override
	public void setPerson(Person body)
	{
	}

	@Override
	public boolean isCompleted()
	{
		return completed;
	}

	@Override
	public Task getCompletionState()
	{
		return null;
	}

}
