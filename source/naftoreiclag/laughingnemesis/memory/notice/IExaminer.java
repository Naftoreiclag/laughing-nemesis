/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.List;

import naftoreiclag.laughingnemesis.memory.Memory;

public interface IExaminer
{
	public abstract Notice examine(List<Memory> memories);
}
