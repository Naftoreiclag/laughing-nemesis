/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

public class Angled
{
	public double x;
	
	public Angled(double x)
	{
		this.x = x;
	}
	
	public Angled tweenLocal(double other, double radPerSec)
	{
		double diff = (other + 8d) - (x + 8d);
		double sig = Math.signum(diff);
		
		if(diff * sig < radPerSec)
		{
			this.x = other;
		}
		else
		{
			this.x += sig * radPerSec;
		}
		
		return this;
	}
}
