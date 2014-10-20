/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.task;

import naftoreiclag.laughingnemesis.Body;
import naftoreiclag.laughingnemesis.Person;

public class FindSomeone extends Task
{
	Person body;
	
	Person target = null;
	double targetAngle;
	
	double radPerSec = 1d;
	double timer = 5d;
	
	boolean completed = false;

	@Override
	public void tick(double delta)
	{
		if(completed)
		{
			return;
		}
		
		if(target == null)
		{
			target = findNearestPerson();
		}
		else
		{
			targetAngle = body.body.circle.loc.angleTo(target.body.circle.loc);
			
			
			body.body.lookAngle.tweenLocal(targetAngle, delta * radPerSec);
			
			timer -= delta;
			if(timer < 0)
			{
				completed = true;
			}
			
			//completed = true;
		}
		
	}
	
	public Person findNearestPerson()
	{
		Person nearest = null;
		double bestDist = Double.MAX_VALUE;
		
		for(Person person : body.body.world.people)
		{
			if(person.body == this.body.body)
			{
				continue;
			}
			
			double distanceToThisPerson = person.body.circle.loc.distanceSquared(this.body.body.circle.loc);
			
			if(distanceToThisPerson < bestDist)
			{
				nearest = person;
				bestDist = distanceToThisPerson;
			}
		}
		
		return nearest;
	}

	@Override
	public void setBody(Person body)
	{
		this.body = body;
	}

	@Override
	public boolean isCompleted()
	{
		return completed;
	}

	@Override
	public Task getCompletionState()
	{
		return new Kiss(body, target);
	}
	
}
