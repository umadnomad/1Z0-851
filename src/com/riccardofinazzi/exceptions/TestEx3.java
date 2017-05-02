package com.riccardofinazzi.exceptions;

import java.io.IOException;

class TestEx3 {
	
	public static void main(String[] args) {
		new TestEx3().doStuff();
	}
	
	void doStuff() {
		doMore();
	}
	
	void doMore() { /* You can throw a new exception within a method that does not 
	* have 'throwS' in it's signature at one condition: throw must be enclosed with
	* in a try/catch block and the catch block must (yes) catch the newly generated
	*  exception. */
		try {
			throw new IOException();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}