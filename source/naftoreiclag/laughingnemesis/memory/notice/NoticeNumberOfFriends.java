/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.List;

import naftoreiclag.laughingnemesis.memory.AMemory;
import naftoreiclag.laughingnemesis.memory.MemoryFriendship;

public class NoticeNumberOfFriends extends ANotice
{
	private final int numberOfFriends;
	
	private NoticeNumberOfFriends(IExaminer parent, int numberOfFriends)
	{
		super(parent);
		
		this.numberOfFriends = numberOfFriends;
	}

	@Override
	public String getInfo()
	{
		return "I have " + numberOfFriends + " friends";
	}
	
	@Override
	public boolean equals(ANotice other)
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
		public ANotice examine(List<AMemory> memories)
		{
			int num = 0;
			
			for(AMemory memory : memories)
			{
				if(memory instanceof MemoryFriendship)
				{
					++ num;
				}
			}
			
			return new NoticeNumberOfFriends(this, num);
		}
	}
}
