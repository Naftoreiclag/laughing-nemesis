package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonEntity
{
	private Vida vida = new Vida();
	public double x;
	public double y;
	
	public Emotion emotion;
	
	Random random = new Random();
	
	private List<Action> actionQueue = new ArrayList<Action>();
	
	public PersonEntity()
	{
		actionQueue.add(new ActionWander(2000d));
		actionQueue.add(new ActionWander(2000d));
		actionQueue.add(new ActionWander(2000d));
		actionQueue.add(new ActionWander(2000d));
		actionQueue.add(new ActionWander(2000d));
	}
	
	public void tick(double delta)
	{
		if(actionQueue.size() < 1)
		{
			return;
		}
		
		Action action = actionQueue.get(0);
		
		if(action == null)
		{
			return;
		}

		if(action.tick(this, delta))
		{
			actionQueue.remove(0);
		}
		
		if(this.x < -Application.worldSize) { this.x = -Application.worldSize; }
		if(this.y < -Application.worldSize) { this.y = -Application.worldSize; }
		if(this.x > Application.worldSize) { this.x = Application.worldSize; }
		if(this.y > Application.worldSize) { this.y = Application.worldSize; }
	}
}
