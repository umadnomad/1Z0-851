package com.riccardofinazzi;

class Foo {
	static final int test; // this var must be finalized before constructor ends
	/*
		As expected:
		error: variable test not initialized in the default constructor
		static final int test;
		*/
}

class FooTestDrive {
	public static void main(String[] args) {
		new Foo();
	}
}