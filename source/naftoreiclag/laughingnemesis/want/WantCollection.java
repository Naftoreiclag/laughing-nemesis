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
	public List<Want> data = new LinkedList<Want>();

	public void add(List<Want> wantsToAdd)
	{
		for(Want newWantsToAdd : wantsToAdd)
		{
			boolean shouldAdd = true;
			for(Want comparison : data)
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
