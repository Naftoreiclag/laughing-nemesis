/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.task;

import naftoreiclag.laughingnemesis.Person;

public abstract class Task
{
	public abstract void tick(double delta);

	public abstract void setBody(Person body);

	public abstract boolean isCompleted();

	public abstract Task getCompletionState();
}
