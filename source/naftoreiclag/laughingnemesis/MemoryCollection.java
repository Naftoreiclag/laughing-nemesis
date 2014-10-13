package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;

public class MemoryCollection implements ITickable
{
	private List<Memory> memories = new ArrayList<Memory>();
	
	public Memory[] getRandomMemories(int number)
	{
		Memory[] ret = new Memory[number];
		
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

	public Memory[] getRandomMemories()
	{
		Memory[] ret = new Memory[memories.size()];
		for(int i = 0; i < memories.size(); ++ i)
		{
			ret[i] = memories.get(i);
		}
		return ret;
	}
}
