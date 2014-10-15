/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis.memory.notice;

import java.util.LinkedList;
import java.util.List;

public class NoticeCollection
{
	public List<Notice> data = new LinkedList<Notice>();

	public void add(List<Notice> noticesToAdd)
	{
		for(Notice newNoticeToAdd : noticesToAdd)
		{
			boolean shouldAdd = true;
			for(Notice comparison : data)
			{
				if(newNoticeToAdd.equals(comparison))
				{
					shouldAdd = false;
					break;
				}
			}
			
			if(shouldAdd)
			{
				data.add(newNoticeToAdd);
			}
		}
	}
	
}
