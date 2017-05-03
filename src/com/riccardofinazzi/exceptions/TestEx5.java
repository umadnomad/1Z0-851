package com.riccardofinazzi.exceptions;

import java.lang.*;

class BadFoodException extends Exception {
	
	public static void main(String[] args) {
		try {
			new BadFoodException().checkFood(args[0].trim());
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("you must pass this program an argument");
			System.exit(0);
		} catch (BadFoodException ex) {
			ex.printStackTrace();
		}			 
	}
	
	void checkFood(String food) throws BadFoodException {
		boolean success = false;
		String[] yums = {"pizza","kebab","sweet","fussy"};
		
		for (String in:yums) {
			if (in.equals(food)) {
				System.out.println("A " + food + " tastes yum!");
				success = true;
				break;
			}
		}
		if (!success)
			throw new BadFoodException();
		else
			return;
	}
	
}