package com.riccardofinazzi.regex;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerAsFinder {
	public static void main(String[] args) {

		/* match counters */
		int hits_s = 0;

		Pattern pattern = Pattern.compile(System.console().readLine("Type the word to be searched: "));
		Scanner s = new Scanner(System.in); // Send EOF when finished

		/*// read single line
		while (s1.findInLine(pattern) != null)
			hits_s++; */

		/* read multiline */
		while(true) {
			while (s.findInLine(pattern) != null)
				hits_s++;

			if (s.hasNextLine()) {
				s.nextLine();
			}	else break;
		}
		
		s.close();
		System.out.println("I have found:\t"+hits_s+" words;");
	}
}