package naftoreiclag.laughingnemesis;

public class Foo
{
	public final String string;
	
	public double age;
	
	public Foo(double age, String string)
	{
		this.age = age;
		this.string = string;
	}
	
	public static final double bar = 2;
	
	public double thingy()
	{
		if(age < 0)
		{
			return 0;
		}
		else if(age > bar)
		{
			return 1;
		}
		else
		{
			return ((double) age) / bar;
		}
	}
}
