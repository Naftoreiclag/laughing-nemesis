/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;


public abstract class ANotice
{
	//
	public ANotice(IExaminer parent)
	{
		this.parent = parent;
	}
	
	public abstract String getInfo();
	
	// Returns the parent which called.
	private IExaminer parent;
	public IExaminer getParent() { return parent; }
	
	// Is equal to; used to see if the examiner also returns this when examining all memories.
	public abstract boolean equals(ANotice other);
	//public abstract boolean sameType(ANotice other);
}
