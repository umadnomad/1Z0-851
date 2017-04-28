package com.riccardofinazzi.swt;

public class Switch {
	
	public static void main(String[] args) {
		
		new Switch().testString();
		
	}
	
	void testString() {
		String s = "test";
		switch(s) {
		/* As expected, compiling this file with java sdk 1.6 prompts this error:
		 * error: strings in switch are not supported in -source 1.6
		 * (use -source 7 or higher to enable strings in switch) */
			case "test":
				System.out.println("Test string");
				break;
			case "notest":
				System.out.println("Notest string");
				break;
			default:
				System.out.println("Nothing");
		}
	}
	
	void exercise5_1() {
		char c = 'y';
		switch(c) {
			case 'x':
				System.out.println("x");
				break;
			case 'y':
				System.out.println("y");
				break;
			case 'z':
				System.out.println("z");
				break;
			default:
				System.out.println("exercise5_1(): no match");
		}
	}
				
}