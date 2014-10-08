/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */
package naftoreiclag.laughingnemesis;


/*
 * Purpose is to analyze memories and other stuff to create notices.
 * Perhaps I should merge this with Person?
 * 
 * Every tick, a random sample of memories is presented to this class. // This includes short-term, which may have interesting consequences.
 * Potentially, a question will be developed from this presentation.
 * This will be added to a queue of questions. // There may be memories which surpress further analysis
 */
public class LifeAnalyzer
{
	public Person s;
	
	public LifeAnalyzer(Person person)
	{
		this.s = person;
	}
}
