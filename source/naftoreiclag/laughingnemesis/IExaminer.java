/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

import java.util.List;

import naftoreiclag.laughingnemesis.memory.AMemory;
import naftoreiclag.laughingnemesis.memory.notice.ANotice;

public interface IExaminer
{
	public abstract ANotice examine(List<AMemory> memories);
}
