/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import naftoreiclag.laughingnemesis.memory.Memory;

public class NoticeDictionary
{
	// Functional instances to examine a list of memories
	public static final List<IExaminer> examiners = new ArrayList<IExaminer>();
	static
	{
		addExaminer(new NumberOfFriends.Examiner());
	}
	
	public static void addExaminer(IExaminer examiner)
	{
		examiners.add(examiner);
	}
	
	// Given a sample of memories, return a list of all things which are true for this sample.
	public static List<Notice> examine(List<Memory> sample)
	{
		List<Notice> notices = new LinkedList<Notice>();
		
		for(IExaminer examiner : examiners)
		{
			Notice nuNotice = examiner.examine(sample);
			
			if(nuNotice != null)
			{
				notices.add(nuNotice);
			}
		}
		
		return notices;
	}
}
