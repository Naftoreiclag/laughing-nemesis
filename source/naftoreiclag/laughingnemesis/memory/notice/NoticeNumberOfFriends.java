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

public class NoticeNumberOfFriends extends Notice
{
	public static final int difficulty = 10;
	
	private final int numberOfFriends;
	
	private NoticeNumberOfFriends(Examiner parent, int numberOfFriends)
	{
		super(parent, difficulty);
		
		this.numberOfFriends = numberOfFriends;
	}

	@Override
	public String toString()
	{
		return (solved ? "Verified: " : "Maybe, ") + "I have " + numberOfFriends + " friends";
	}
	
	@Override
	public boolean equals(Notice other)
	{
		if(!(other instanceof NoticeNumberOfFriends))
		{
			return false;
		}
		
		NoticeNumberOfFriends udder = (NoticeNumberOfFriends) other;
		
		return udder.numberOfFriends == this.numberOfFriends;
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
			
			return new NoticeNumberOfFriends(this, num);
		}
	}

	@Override
	public List<Want> whatDoYouWantFromThis(Identity identity)
	{
		List<Want> ret = new LinkedList<Want>();
		
		if(numberOfFriends == 0)
		{
			ret.add(new MakeFriend());
		}
		
		return ret;
	}
}
