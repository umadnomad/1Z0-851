package com.riccardofinazzi.exceptions;

import java.util.Arrays;

/*
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
*/

class StringIsNull extends Exception {};

class Propagate {
	
	public static void main(String[] args) {
		
		try {
			System.out.println(new Propagate().reverse("ciao"));
		} catch (StringIsNull ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("The program has completed.");
			System.exit(0);
		}
	}
	
	String reverse(String str) throws StringIsNull {
		
		if (str.length() == 0) throw new StringIsNull();
		
		StringBuilder result = new StringBuilder();
		for (int i = str.length(); i -->0;) {
			result.append(str.charAt(i));
		}	
		
		return result.toString();
	}
}
	