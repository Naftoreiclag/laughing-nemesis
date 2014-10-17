/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.LinkedList;
import java.util.List;

import naftoreiclag.laughingnemesis.Person.Identity;
import naftoreiclag.laughingnemesis.memory.Memory;
import naftoreiclag.laughingnemesis.memory.MemoryFriendship;
import naftoreiclag.laughingnemesis.want.Want;
import naftoreiclag.laughingnemesis.want.MakeFriend;

public class NumberOfFriends extends Notice
{
	public static final int difficulty = 10;
	
	private final int num;
	
	private NumberOfFriends(Examiner parent, int numberOfFriends)
	{
		super(parent, difficulty);
		
		this.num = numberOfFriends;
	}

	@Override
	public String toString()
	{
		return (solved ? "Verified: " : "Maybe, ") + "I have " + num + " friends";
	}
	
	@Override
	public boolean equals(Notice other)
	{
		if(!(other instanceof NumberOfFriends))
		{
			return false;
		}
		
		NumberOfFriends udder = (NumberOfFriends) other;
		
		return udder.num == this.num;
	}

	@Override
	public List<Want> whatDoYouWantFromThis(Identity identity)
	{
		List<Want> ret = new LinkedList<Want>();
		
		if(num == 0)
		{
			ret.add(new MakeFriend());
		}
		
		return ret;
	}
	
	protected static class Examiner implements IExaminer
	{
		@Override
		public Notice examine(List<Memory> memories)
		{
			int num = 0;
			
			for(Memory memory : memories)
			{
				if(memory instanceof MemoryFriendship)
				{
					++ num;
				}
			}
			
			return new NumberOfFriends(this, num);
		}
	}
}
