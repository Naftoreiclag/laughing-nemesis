/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

public class MemoryFriendship extends Memory
{
	@Override
	public boolean sameType(Memory other)
	{
		return other instanceof MemoryFriendship;
	}
}
