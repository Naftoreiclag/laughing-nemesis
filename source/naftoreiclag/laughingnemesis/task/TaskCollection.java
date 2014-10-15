/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.task;

import java.util.LinkedList;
import java.util.List;

public class TaskCollection
{
	public List<Task> data = new LinkedList<Task>();

	public void add(List<Task> tasksToAdd)
	{
		for(Task newTaskToAdd : tasksToAdd)
		{
			boolean shouldAdd = true;
			for(Task comparison : data)
			{
				if(newTaskToAdd.equals(comparison))
				{
					shouldAdd = false;
					break;
				}
			}
			
			if(shouldAdd)
			{
				data.add(newTaskToAdd);
			}
		}
	}
}
