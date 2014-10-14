package naftoreiclag.laughingnemesis.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import naftoreiclag.laughingnemesis.GR;
import naftoreiclag.laughingnemesis.ITickable;

// TODO: merge with Person
public class MemoryCollection implements ITickable
{
	public List<AMemory> data = new ArrayList<AMemory>();
	
	public AMemory[] getRandomMemories(int number)
	{
		AMemory[] ret = new AMemory[number];
		
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

	public List<AMemory> getRandomMemories()
	{
		List<AMemory> ret = new LinkedList<AMemory>();
		for(int i = 0; i < data.size(); ++ i)
		{
			ret.add(data.get(i));
		}
		return ret;
	}
}
