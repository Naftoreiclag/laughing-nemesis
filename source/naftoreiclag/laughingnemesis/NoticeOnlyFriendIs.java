/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

import java.util.List;

public class NoticeOnlyFriendIs extends Notice implements IExaminer
{
	private NoticeOnlyFriendIs(IExaminer parent) { super(parent); }
	
	@Override
	public boolean equals(Notice other)
	{
		return false;
	}
	@Override
	public boolean sameType(Notice other)
	{
		return false;
	}
	
	@Override
	public Notice examine(List<Memory> memories)
	{
		return null;
	}
}
