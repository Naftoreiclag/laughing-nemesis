package naftoreiclag.laughingnemesis;

import naftoreiclag.laughingnemesis.memory.FriendshipMemory;
import naftoreiclag.laughingnemesis.memory.Memory;
import naftoreiclag.laughingnemesis.memory.MemoryCollection;

public class EmotionFromMemory
{
	public Emotion emo = Emotion.nondescript;
	
	public final MemoryCollection memColl;
	
	public EmotionFromMemory(MemoryCollection memColl)
	{
		this.memColl = memColl;
	}
	
	public void tick(double delta, double awareness)
	{
		int countFriends;

		for(Memory mem : memColl.memories)
		{
			if(mem instanceof FriendshipMemory)
			{
				FriendshipMemory fmem = (FriendshipMemory) mem;
				
				if(fmem.face.equals(face))
				{
					return true;
				}
			}
		}
	}
}
