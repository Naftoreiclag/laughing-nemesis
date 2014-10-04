package naftoreiclag.laughingnemesis.communication;

public class Bubble
{
	// How well it can be heard.
	public double hearability = 1.0d;
	
	public static int hello = 0;
	public static int goodbye = 1;
	public static int whatisyourfavcolor = 2;
	public static int myfavcoloris = 3;
	
	public final int type;
	
	public Bubble(int type)
	{
		this.type = type;
	}
}
