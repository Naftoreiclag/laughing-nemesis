/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

public class Angled
{
	public double a;
	
	public Angled(double x)
	{
		this.a = x;
	}
	
	public Angled tweenLocal(double other, double amount)
	{
		double diff = other - this.a;
		double sig = Math.signum(diff);
		
		if(diff * sig < amount)
		{
			this.a = other;
		}
		else
		{
			if(diff * sig > Math.PI)
			{
				sig = -sig;
			}
			
			this.a = (this.a + (amount * sig)) % (Math.PI * 2);
		}
		
		
		return this;
	}
}
