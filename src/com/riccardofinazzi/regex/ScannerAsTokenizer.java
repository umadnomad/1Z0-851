package com.riccardofinazzi.regex;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ScannerAsTokenizer {
	public static void main(String[] args) {

		/* match counters */
		int hits_s = 0, hits_i = 0, hits_b = 0;

		/* current token value */
		String	s;
		Integer	i;
		Boolean b;

		ArrayList<Object> al = new ArrayList<Object>();

		Scanner s1 = new Scanner(System.console().readLine("Feed a chunk of data here: "));

		/* delimiters.
		 * I had to open a topic@stackoverflow (available here: https://goo.gl/huvRcN
		 * to sort this out:
		 * 
		 * default behaviour:
		 * Scanner.WHITESPACE_PATTERN or \\p{javaWhitespace}+
		 * https://goo.gl/huvRcN */

		s1.useDelimiter(Pattern.compile("\\s+"));
		/* totally unnecessary as this fully mimics def behaviour, I put it here to n
		 * ot forget the method */

		/* Scanner.hasNext() simply tells you if there is a new delimted token.
		 * Scanner.next() simply returns that token */
		while(s1.hasNext()) {
			if (		s1.hasNextInt()) {
						al.add(s1.nextInt());		hits_i++;

			} else if (	s1.hasNextBoolean()) {
						al.add(s1.nextBoolean());	hits_b++;

			} else {	al.add(s1.next());			hits_s++;
			}
		}

		s1.close();
		System.out.println("I have found:\t"+hits_s+" words; "+hits_i+" ints; "+hits_b+" booleans;");

		for (Object in : al) {
			if (in instanceof String)
				System.out.print("s");
			if (in instanceof Integer)
				System.out.print("i");
			if (in instanceof Boolean)
				System.out.print("b");
		}
		System.out.print("\n");
	}
}