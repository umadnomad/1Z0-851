package com.riccardofinazzi.boxing;

import static java.lang.System.out; // out: instance of PrintStream class

public class WrappersAndEquals {
	public static void main(String[] args) {
		Integer i	= new Integer(100);
		Integer i2	= new Integer(100);
		Long	l	= new Long(100L);
		
		System.out.printf(
			"integer i equals integer i2? %1$b; integer i equals long l? %2$b; \n" + 
			"object i equals object i2? %3$b \n",
			i.equals( i2), i.equals( l), i == i2);
			/* i == l); // no!! you cannot do this, primitive values get unwrapped and yo
			 * u cannot compare different primitive data int with long */
	}
}