/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.List;

import naftoreiclag.laughingnemesis.Person.Identity;
import naftoreiclag.laughingnemesis.memory.Memory;
import naftoreiclag.laughingnemesis.want.Want;


public abstract class Notice
{
	//
	public Notice(IExaminer examiner, int difficulty)
	{
		this.examiner = examiner;
		this.hertz = 1d / difficulty;
	}
	
	public final double hertz;
	
	public abstract List<Want> whatDoYouWantFromThis(Identity identity);
	
	// why do i have this
	protected boolean solved = false;
	public void markSolved() { solved = true; }
	public boolean isSolved() { return solved; }
	
	// The method which will later be reused to determine if this notice also applies to a different list of memories.
	private IExaminer examiner;
	public IExaminer getExaminer() { return examiner; }
	
	public boolean isTrueFor(List<Memory> memories)
	{
		return this.examiner.examine(memories).equals(this);
	}
	
	// Is equal to; used to see if the examiner also returns this when examining all memories.
	public abstract boolean equals(Notice other);
	//public abstract boolean sameType(ANotice other);
}
