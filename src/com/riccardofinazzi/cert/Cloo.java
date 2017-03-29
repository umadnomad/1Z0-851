package com.riccardofinazzi.cert; // Cloo and Roo are in the same package

class Cloo extends Roo { /* the book says still ok, superclass Roo is public. bu
 * t there is no need for Roo to use public access modifier in order to get acce
 * ssed by Cloo, as Cloo and Roo share the same package, therefore, default acce
 * ss level is enough as shown & tested */
	public void testCloo() {
		System.out.println(dooRooThings()); // won't compile
	}
}
