package naftoreiclag.laughingnemesis.memory;

import java.util.ArrayList;
import java.util.List;

import naftoreiclag.laughingnemesis.GR;
import naftoreiclag.laughingnemesis.ITickable;

public class MemoryCollection implements ITickable
{
	private List<AMemory> memories = new ArrayList<AMemory>();
	
	public AMemory[] getRandomMemories(int number)
	{
		AMemory[] ret = new AMemory[number];
		
		for(int i = 0; i < number; ++ i)
		{
			memories.get(GR.r.nextInt(memories.size()));
		}
		
		return ret;
	}
	
	@Override
	public void tick(double delta)
	{

	}

	public AMemory[] getRandomMemories()
	{
		AMemory[] ret = new AMemory[memories.size()];
		for(int i = 0; i < memories.size(); ++ i)
		{
			ret[i] = memories.get(i);
		}
		return ret;
	}
}
