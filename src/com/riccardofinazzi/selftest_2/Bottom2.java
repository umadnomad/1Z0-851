package com.riccardofinazzi.selftest_2;

class Top {
	public Top(String s) { System.out.print("B"); }
}

public class Bottom2 extends Top {
	/* public Bottom2(String s) { System.out.print("D"); } // the error is here. */
	
	/* Any constructor at it's very first line must make a call to either super(), 
	 * super(Argtype optional_arg), this() or this(Argtype optional_arg). This cons
	 * tructor makes no exception and by default, if you do not type anything in, t
	 * he compiler will prepend super() to call the superclass' costructor; The sam
	 * e goes on up till the very top of the inheritance three where you will reach
	 * Object constructor, which has no super() call (because nothing is above Obje
	 * ct class). Then, the object constructor finishes, and all the constructors w
	 * ill execute in a cascading style till the Class' constructor whom you want a
	 * n object to be generated from */
	
	// correct code:
	public Bottom2(String s) {
		super(s);
		System.out.print("D");
	}
	public static void main(String[] args) {
		new Bottom2("C");
		System.out.println(" ");
	}
}