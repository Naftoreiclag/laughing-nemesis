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
	public static final List<IExaminer> examiners = new ArrayList<IExaminer>();
	static
	{
		addExaminer(new NoticeNumberOfFriends.Examiner());
	}
	
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
	
	public static void addExaminer(IExaminer examiner)
	{
		examiners.add(examiner);
	}
}
