/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.List;

import naftoreiclag.laughingnemesis.memory.AMemory;

public class NoticeOnlyFriendIs extends ANotice implements IExaminer
{
	private NoticeOnlyFriendIs(IExaminer parent) { super(parent); }
	
	@Override
	public boolean equals(ANotice other)
	{
		return false;
	}
	@Override
	public boolean sameType(ANotice other)
	{
		return false;
	}
	
	@Override
	public ANotice examine(List<AMemory> memories)
	{
		return null;
	}
}
