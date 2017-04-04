package com.riccardofinazzi.interfaces;

interface Bounceable {
	
	void bounce();
	void setBounceFactor(int bf);
	
}

public class Ball implements Bounceable {
	
	public void bounce() {}
	/* In the book, at page 120, it says this code is supposed to compile but I har
	 * dly believe so as the method is set to take an int parameter that was not de
	 * clared in the interface contract */
	public void setBounceFactor(int bf) {}
	/*
		I was right, probably its a typo:
		
		com/riccardofinazzi/interfaces/Ball.java:10: error: Ball is not abstract and does not override abstract method setBounceFactor() in Bounceable
		public class Ball implements Bounceable {
			   ^
		1 error
	*/
	
}