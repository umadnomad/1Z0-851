package com.riccardofinazzi.regex;

import java.io.Console;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegEx {
	public static void main(String[] args) {
		Console c = System.console();
		String regex = c.readLine("Hand me your expression: ");
		String data = c.readLine("Feed a chunk of data here: ");
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(data);

		StringBuilder sb = new StringBuilder(input);
		
		while(m.find()) {
			//System.out.println(m.start() + " " + m.group());
			if (m.start() -5 < 0 || m.end() + 5 > input.length()-1)
				continue;
			else System.out.println(" ..." + sb.substring(m.start() - 5, m.end() + 5) + "...\t" + m.start() + "\t" + m.end());
		}
	}
}