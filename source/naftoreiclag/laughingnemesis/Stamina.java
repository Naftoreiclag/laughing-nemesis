/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */

package naftoreiclag.laughingnemesis;

// 1 stamina = 1 second of standing up from lying down
// 1 fatigue = +1 max stamina after rest
public class Stamina implements ITickable
{
	// Rate in stamina per second
	private final float recoverSpeed = 0.1f;
	
	// Actual stamina points
	private float maxAmount;
	private float availableAmount;
	public float getAvailableAmount() { return availableAmount; }
	
	// Value which increases if more stamina is requested than is available.
	private float fatigue;
	public float getFatigue() { return fatigue; }
	
	// Value which can be changed to increase/decrease recovery rates.
	// For example, sitting in a chair boosts recovery rates.
	// This value should not be negative.
	private float bonusRecoveryRate;
	
	//
	public void setBonusRecoveryRate(float rate)
	{
		bonusRecoveryRate = rate;
		if(bonusRecoveryRate < 0f) bonusRecoveryRate = 0f;
	}
	
	@Override
	public void tick(double delta)
	{
		// Recover stamina with regards to max amount
		availableAmount += (recoverSpeed + bonusRecoveryRate) * delta;
		if(availableAmount > maxAmount) availableAmount = maxAmount;
	}
	
	// Use stamina, return how much is remaining.
	public float useStamina(float amount)
	{
		// If you are too tired to do this
		if(availableAmount < 0f) return availableAmount;
		
		// Use stamina
		availableAmount -= amount;
		
		// If we used too much
		if(availableAmount < 0f)
		{
			// Add to fatigue
			fatigue -= availableAmount;
		}
		
		// Return how much is remaining
		return availableAmount;
	}
	
	// Called when you wake up from resting
	public void completeRest()
	{
		// During rest, the amount of energy you were missing is added to your max amount.
		maxAmount += fatigue;
		if(maxAmount < 1f) maxAmount = 1f;
		
		// Well-rested, you should have negative fatigue.
		fatigue = maxAmount * -recoverSpeed;
		
		// When you wake up, you should have no available energy
		availableAmount = 0;
	}
}
