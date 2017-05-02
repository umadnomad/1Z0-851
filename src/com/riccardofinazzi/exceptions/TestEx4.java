package com.riccardofinazzi.exceptions;

import java.lang.RuntimeException;

class TestEx4 {
	
	public static void main(String[] args) {
		new TestEx4().doStuff();
	}
	
	void doStuff() {
		doMore();
	}
	
	void doMore() {
		throw new RuntimeException();
	}
	
}