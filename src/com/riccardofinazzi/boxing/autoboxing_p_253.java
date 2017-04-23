package com.riccardofinazzi.boxing;

class Vararg {
	
	static void wide_vararg(long... x)
	{ System.out.println("long..."); }
	
	static void box_vararg(Integer... x)
	{ System.out.println("Integer..."); }
	
	/* Remember that method invocation contexts allow the use of a boxing conversio
	 * n optionally followed by widening reference conversion and an unboxing conve
	 * rsion optionally followed by a widening primitive conversion */
	static void box_and_wide_vararg(Object... x)
	{ System.out.println("Object..."); }
		
	public static void main(String[] args) {
		int i = 5;
		wide_vararg(i,i);			// needs to widen and use var-args
		box_vararg(i,i);			// needs to box and use var-args
		
		box_and_wide_vararg(i,i);	// needs to box, wide and use var-args
	}
}