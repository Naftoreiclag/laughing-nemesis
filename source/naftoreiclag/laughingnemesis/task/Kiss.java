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
	Body body;
	Person target;
	
	

	public Kiss(Body body, Person target)
	{
		this.body = body;
		this.target = target;
	}

	@Override
	public void tick(double delta)
	{
	}

	@Override
	public void setBody(Body body)
	{
	}

	@Override
	public boolean isCompleted()
	{
		return false;
	}

	@Override
	public Task getCompletionState()
	{
		return null;
	}

}
