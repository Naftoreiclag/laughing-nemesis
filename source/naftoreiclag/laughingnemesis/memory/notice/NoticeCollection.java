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
	public List<ANotice> notices = new LinkedList<ANotice>();

	public void add(List<ANotice> noticesToAdd)
	{
		for(ANotice newNoticeToAdd : noticesToAdd)
		{
			boolean shouldAdd = true;
			for(ANotice comparison : notices)
			{
				if(newNoticeToAdd.equals(comparison))
				{
					shouldAdd = false;
					break;
				}
			}
			
			if(shouldAdd)
			{
				notices.add(newNoticeToAdd);
			}
		}
	}
	
}
