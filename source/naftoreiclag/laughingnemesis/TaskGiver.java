/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import naftoreiclag.laughingnemesis.task.ShakeBooty;
import naftoreiclag.laughingnemesis.task.Task;
import naftoreiclag.laughingnemesis.want.Want;

public class TaskGiver
{
	public static List<Task> howToAchieve(Want want)
	{
		List<Task> ret = new LinkedList<Task>();
		
		ret.add(new ShakeBooty());
		
		return ret;
	}

}
