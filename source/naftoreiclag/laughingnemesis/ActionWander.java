package naftoreiclag.laughingnemesis;

public class ActionWander extends Action
{
	Vector2d direction = Vector2d.randomNormal();
	
	double duration;
	double timeElapsed = 0d;
	
	public ActionWander(double duration)
	{
		this.duration = duration;
	}
	
	@Override
	public boolean tick(Person vi, double delta)
	{
		boolean finished = false;
		
		timeElapsed += delta;
		
		if(timeElapsed > duration)
		{
			delta = duration - timeElapsed;
			finished = true;
		}
		
		vi.x += direction.a;
		vi.y += direction.b;
		
		return finished;
	}
}
