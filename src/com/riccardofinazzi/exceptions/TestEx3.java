package com.riccardofinazzi.exceptions;

import java.io.IOException;

class TestEx3 {
	
	public static void main(String[] args) {
		new TestEx3().doStuff();
		try {
			new TestEx3().doStuff2();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
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
	
	void doStuff2() throws IOException {
		doMore2();
	}
	
	void doMore2() throws IOException { /* If a method's signature/public interface
	* declares that an exception can be thrown, it does not matter if said thrown e
	* xception gets intercepted and handled within the method: the Handle or Declar
	* e rule (book's page 372) is still valid for all the other methods until one o
	* f them finally handles the exception */
		try {
			throw new IOException();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}