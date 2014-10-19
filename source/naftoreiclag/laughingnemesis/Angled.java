/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

public class Angled
{
	public double d;
	
	public Angled(double x)
	{
		this.d = x;
	}
	
	public Angled tweenLocal(double other, double amount)
	{
		double diff = (other + 8d) - (d + 8d);
		double sig = Math.signum(diff);
		
		if(diff * sig < amount)
		{
			this.d = other;
		}
		else
		{
			this.d += sig * amount;
		}
		
		return this;
	}
}
