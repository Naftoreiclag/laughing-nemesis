/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NoticeLibrary
{
	public List<IExaminer> examiners = new ArrayList<IExaminer>();
	
	public List<Notice> getQuestions(List<Memory> sample)
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
