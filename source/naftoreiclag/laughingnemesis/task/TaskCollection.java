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
	public List<ATask> data = new LinkedList<ATask>();

	public void add(List<ATask> tasksToAdd)
	{
		for(ATask newTaskToAdd : tasksToAdd)
		{
			boolean shouldAdd = true;
			for(ATask comparison : data)
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
