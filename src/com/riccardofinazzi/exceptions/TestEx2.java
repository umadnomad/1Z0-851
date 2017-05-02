package com.riccardofinazzi.exceptions;

class MalevolentException extends Exception {};

class TestEx2 {
	
	public static void main(String[] args) {		
		TestEx2 tex2 = new TestEx2();
	
		try {
			tex2.goEx();
		} catch (MalevolentException ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("The program has completed.");
			System.exit(0);
		}
	}
	
	void goEx() throws MalevolentException {
		System.out.println("All good so far.");
		throw new MalevolentException();
	}
}