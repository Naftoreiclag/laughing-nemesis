/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.task;

import naftoreiclag.laughingnemesis.Body;
import naftoreiclag.laughingnemesis.Person;

public class Kiss extends Task
{
	Person body;
	Person target;
	
	
	
	double timer = 5d;
	
	boolean completed = false;

	public Kiss(Person body, Person target)
	{
		this.body = body;
		this.target = target;
	}

	@Override
	public void tick(double delta)
	{
		timer -= delta;
		
		if(timer > 0)
		{
			body.body.walking = true;
		}
		else
		{
			body.body.walking = false;
			
			completed = true;
		}
	}

	@Override
	public void setBody(Person body)
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
