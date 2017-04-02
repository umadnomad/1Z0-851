package com.riccardofinazzi;

class ArraySizeTest {

	int[5] i_just_set_an_array_size_in_declaration; // will this compile?
	/*
		No it won't!
	
		javac com/riccardofinazzi/ArraySizeTest.java 
		com/riccardofinazzi/ArraySizeTest.java:5: error: ']' expected
			int[5] i_just_set_an_array_size_in_declaration; // will this compile?
				^
		com/riccardofinazzi/ArraySizeTest.java:5: error: ';' expected
			int[5] i_just_set_an_array_size_in_declaration; // will this compile?
				 ^
		com/riccardofinazzi/ArraySizeTest.java:5: error: <identifier> expected
			int[5] i_just_set_an_array_size_in_declaration; // will this compile?
														  ^
		3 errors
	*/
	
	int[] i_just_set_an_array_size_in_declaration = new int[5]; // this compiles
}