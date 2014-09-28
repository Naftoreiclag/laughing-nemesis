package naftoreiclag.laughingnemesis.memory;

import java.util.ArrayList;
import java.util.List;

import naftoreiclag.laughingnemesis.Emotion;
import naftoreiclag.laughingnemesis.Face;

public class MemoryCollection
{
	public Emotion emotion;
	
	private List<Memory> memories = new ArrayList<Memory>();
	
	public boolean isFriendsWith(Face face)
	{
		for(Memory mem : memories)
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
		
		return false;
	}
	
	public void tick(double delta)
	{
		emotion = Emotion.lonely;
		
		for(Memory mem : memories)
		{
			if(mem instanceof FriendshipMemory)
			{
				emotion = Emotion.nondescript;
			}
		}
	}
	
	
}
