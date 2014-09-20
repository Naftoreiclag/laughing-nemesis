/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */

package naftoreiclag.laughingnemesis;

// Version 17

public class Vector2i
{
	// TODO: add some vector pool or something for recycling of Vector2d's
	
	public int a;
	public int b;
	
	public Vector2i(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public Vector2i()
	{
		this(0, 0);
	}
	
	public Vector2i clone()
	{
		return new Vector2i(this.a, this.b);
	}
	
	public Vector2i setZero()
	{
		this.a = 0;
		this.b = 0;
		
		return this;
	}
	
	public boolean isZero()
	{
		return a == 0 && b == 0;
	}
	
	public Vector2i addLocal(Vector2i other)
	{
		this.a += other.a;
		this.b += other.b;
		
		return this;
	}
	
	public Vector2i addLocalMultiplied(Vector2i other, int multiplicant)
	{
		this.a += other.a * multiplicant;
		this.b += other.b * multiplicant;
		
		return this;
	}
	
	public Vector2i add(Vector2i other)
	{
		return this.clone().addLocal(other);
	}
	
	public Vector2i addLocal(int a)
	{
		this.a += a;
		this.b += a;
		
		return this;
	}
	
	public Vector2i add(int a)
	{
		return this.clone().addLocal(a);
	}
	
	public Vector2i subtractLocal(Vector2i other)
	{
		this.a -= other.a;
		this.b -= other.b;
		
		return this;
	}
	
	public Vector2i subtract(Vector2i other)
	{
		return this.clone().subtractLocal(other);
	}
	
	public Vector2i subtractLocal(int a)
	{
		this.a -= a;
		this.b -= a;
		
		return this;
	}
	
	public Vector2i subtract(int a)
	{
		return this.clone().subtractLocal(a);
	}
	
	public Vector2i multiplyLocal(int a)
	{
		this.a *= a;
		this.b *= a;
		
		return this;
	}
	
	public Vector2i multiply(int a)
	{
		return this.clone().multiplyLocal(a);
	}
	
	public Vector2i divideLocal(int a)
	{
		this.a /= a;
		this.b /= a;
		
		return this;
	}
	
	public Vector2i divide(int a)
	{
		return this.clone().divideLocal(a);
	}
	
	public Vector2i inverseLocal()
	{
		this.a = -this.a;
		this.b = -this.b;
		
		return this;
	}
	
	public Vector2i inverse()
	{
		return this.clone().inverseLocal();
	}
	
	public int distanceSquared(Vector2i other)
	{
		return ((this.a - other.a) * (this.a - other.a)) + ((this.b - other.b) * (this.b - other.b));
	}
	
	public int magnitudeSquared()
	{
		return (this.a * this.a) + (this.b * this.b);
	}
	
	public int dotProduct(Vector2i other)
	{
		return (this.a * other.a) + (this.b * other.b);
	}
	
	public int crossProduct(Vector2i other)
	{
		return (this.a * other.b) - (this.b * other.a);
	}
	
	// Vector 90 degrees clockwise from this one
	public Vector2i perpendicularLocal()
	{
		int oldA = a;
		a = b;
		b = -oldA;
		
		return this;
	}
	
	public Vector2i perpendicular()
	{
		return this.clone().perpendicularLocal();
	}
}
