/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;


public abstract class ANotice
{
	//
	public ANotice(IExaminer parent, int difficulty)
	{
		this.parent = parent;
		this.hertz = 1d / difficulty;
	}
	
	public abstract String getInfo();
	
	public final double hertz;
	
	protected boolean verified = false;
	public void verify() { verified = true; }
	public boolean isVerified() { return verified; }
	
	// Returns the parent which called.
	private IExaminer parent;
	public IExaminer getExaminer() { return parent; }
	
	// Is equal to; used to see if the examiner also returns this when examining all memories.
	public abstract boolean equals(ANotice other);
	//public abstract boolean sameType(ANotice other);
}
