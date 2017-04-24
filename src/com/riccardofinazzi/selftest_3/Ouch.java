package com.riccardofinazzi.selftest_3;

/* This class uses so much shadowing */

public class Ouch {
	static int ouch = 7;
	public static void main(String[] args) {
		new Ouch().go(ouch);
		System.out.print(" " + ouch);
	}
	void go(int ouch) {
		ouch++;
		/* The error is here. */
		for(int ouch = 3; ouch < 6; ouch++)
			;
		System.out.print(" " + ouch);
	}
}