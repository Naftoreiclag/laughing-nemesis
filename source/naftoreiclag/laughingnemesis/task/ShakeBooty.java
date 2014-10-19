/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.task;

import naftoreiclag.laughingnemesis.Body;

// this is how you make friends, obviously
public class ShakeBooty extends Task
{
	Body body;

	@Override
	public void tick(double delta)
	{
		body.lookAngle.d += delta * 0.5d;
	}

	@Override
	public void setBody(Body body)
	{
		this.body = body;
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
