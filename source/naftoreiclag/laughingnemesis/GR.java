package naftoreiclag.laughingnemesis;

import java.util.Random;

public class GR
{
	public static Random r = new Random();
	
	/* Delta is time in seconds that have passed.
	 * Probability is the chance that true would be returned every second.
	 * This method simulates if true would have been returned given a certain delta.
	 * 
	 * Probability of 0.5   occurs about every 2 deltas
	 * Probability of 0.333 occurs about every 3 deltas
	 * 
	 * Probability is like hertz.
	 * 
	 */
	public static boolean chanceOverTime(double delta, double probabilityHertz)
	{
		return r.nextDouble() > Math.pow(1 - probabilityHertz, delta);
	}
	
	/*
	// Same, but returns how many true's would have been returned
	public static int chanceOverTime(double delta, double probability)
	{
		
	}
	*/
}
