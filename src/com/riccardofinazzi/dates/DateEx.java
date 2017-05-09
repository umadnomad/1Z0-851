package com.riccardofinazzi.dates;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormat;

public class DateEx {
	public static void main(String[] args) {
	/* Get the current date and time. */
		Date d = new Date();
		System.out.println(d.toString());

	/* Get an object that lets you perform date and time calculations on your locale */
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d);
		c1.roll(Calendar.DAY_OF_WEEK, 1);
		System.out.println(c1.getTime().toString());

	/* Get an object that lets you perform date and time calculations in a differen
	 * t locale */
		Locale loc = new Locale("it","IT");		// ISO 639-1
		Calendar c2 = Calendar.getInstance(loc);
		c2.setTime(d);
		System.out.println(c1.getTime().toString());

	/* Get an object that lets you perform date and time calculations, and then for
	 * mat it for output in different locales with different date styles*/
		Calendar c3 = Calendar.getInstance();
		
		Locale loc1 = new Locale("ch","CH");
		Locale loc2 = new Locale("ar","SA");
		
		DateFormat[] dfa = new DateFormat[10];
		dfa[0] = DateFormat.getInstance();
		dfa[1] = DateFormat.getDateInstance();
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT, loc1);
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM, loc1);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG, loc1);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL, loc1);
		
		dfa[6] = DateFormat.getDateInstance(DateFormat.SHORT, loc1);
		dfa[7] = DateFormat.getDateInstance(DateFormat.MEDIUM, loc2);
		dfa[8] = DateFormat.getDateInstance(DateFormat.LONG, loc2);
		dfa[9] = DateFormat.getDateInstance(DateFormat.FULL, loc2);
		
		c3.setTime(d);
		Date d2 = c3.getTime();
		
		System.out.println("-");
		
		for (DateFormat df : dfa)
			if (df != dfa[5])
				System.out.println(df.format(d2));
			else {
				System.out.println(df.format(d2));
				System.out.println("---");
			}
	}
}