package com.riccardofinazzi.strings;

import java.lang.StringBuilder;

class sbtest1 {
	
	StringBuilder sb;
	
	public static void main(String[] args) {
		new sbtest1().go();
		
		
	}
	
	void go() {
		StringBuilder sb = new StringBuilder("abc");
		this.sb = sb.append("def");
		System.out.println("sb = " + sb);	// Shouldn't this be sb.toString()?
											// No, it's okay like this (verified)
		System.out.println("this.sb = " + this.sb);
	}	
}