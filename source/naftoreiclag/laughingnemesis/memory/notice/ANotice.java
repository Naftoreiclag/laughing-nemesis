/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.List;

import naftoreiclag.laughingnemesis.memory.AMemory;


public abstract class ANotice
{
	//
	public ANotice(IExaminer examiner, int difficulty)
	{
		this.examiner = examiner;
		this.hertz = 1d / difficulty;
	}
	
	public abstract String getInfo();
	
	public final double hertz;
	
	public abstract void applyGoals();
	
	// why do i have this
	protected boolean verified = false;
	public void verify() { verified = true; }
	public boolean isVerified() { return verified; }
	
	// The method which will later be reused to determine if this notice also applies to a different list of memories.
	private IExaminer examiner;
	public IExaminer getExaminer() { return examiner; }
	
	public boolean isTrueFor(List<AMemory> memories)
	{
		return this.examiner.examine(memories).equals(this);
	}
	
	// Is equal to; used to see if the examiner also returns this when examining all memories.
	public abstract boolean equals(ANotice other);
	//public abstract boolean sameType(ANotice other);
}
