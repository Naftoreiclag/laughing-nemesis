package naftoreiclag.laughingnemesis.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import naftoreiclag.laughingnemesis.GR;
import naftoreiclag.laughingnemesis.ITickable;

// TODO: merge with Person
public class MemoryCollection implements ITickable
{
	public List<Memory> data = new ArrayList<Memory>();
	
	public Memory[] getRandomMemories(int number)
	{
		Memory[] ret = new Memory[number];
		
		for(int i = 0; i < number; ++ i)
		{
			data.get(GR.r.nextInt(data.size()));
		}
		
		return ret;
	}
	
	@Override
	public void tick(double delta)
	{

	}

	public List<Memory> getRandomSample()
	{
		List<Memory> ret = new LinkedList<Memory>();
		for(int i = 0; i < data.size(); ++ i)
		{
			ret.add(data.get(i));
		}
		return ret;
	}
}
