/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.want;

import java.util.LinkedList;
import java.util.List;

public class WantCollection
{
	public List<AWant> data = new LinkedList<AWant>();

	public void add(List<AWant> wantsToAdd)
	{
		for(AWant newWantsToAdd : wantsToAdd)
		{
			boolean shouldAdd = true;
			for(AWant comparison : data)
			{
				if(newWantsToAdd.equals(comparison))
				{
					shouldAdd = false;
					break;
				}
			}
			
			if(shouldAdd)
			{
				data.add(newWantsToAdd);
			}
		}
	}
}
