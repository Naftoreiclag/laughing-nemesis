/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory;


public class MemoryFriendship extends AMemory
{
	@Override
	public boolean sameType(AMemory other)
	{
		return other instanceof MemoryFriendship;
	}
}
