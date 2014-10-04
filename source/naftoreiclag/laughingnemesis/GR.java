package naftoreiclag.laughingnemesis;

import java.util.Random;

public class GR
{
	public static Random r = new Random();
	
	// Delta is time in seconds that have passed.
	// Probability is the chance that true would be returned every second.
	// This method simulates if true would have been returned given a certain delta.
	public static boolean chanceOverTime(double delta, double probability)
	{
		return r.nextDouble() > Math.pow(1 - probability, delta);
	}
	
	/*
	// Same, but returns how many true's would have been returned
	public static int chanceOverTime(double delta, double probability)
	{
		
	}
	*/
}
