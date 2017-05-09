package com.riccardofinazzi.dates;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

import java.util.TimeZone;		// import caused by further studying

import java.text.DateFormat;

/* Beware that all this is outdated, the java.time framework is built into Java 
 * 8 and later. These classes supplant the old troublesome date-time classes suc
 * h as java.util.Date, .Calendar, & java.text.SimpleDateFormat. */

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
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT,	loc1);
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM,	loc1);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG,	loc1);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL,	loc1);
		
		dfa[6] = DateFormat.getDateInstance(DateFormat.SHORT,	loc1);
		dfa[7] = DateFormat.getDateInstance(DateFormat.MEDIUM,	loc2);
		dfa[8] = DateFormat.getDateInstance(DateFormat.LONG,	loc2);
		dfa[9] = DateFormat.getDateInstance(DateFormat.FULL,	loc2);
		
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
		
		System.out.println("---");
		
	/* Locale's class getDisplayCountry() and getDisplayLanguage() methods test:
	 * NB: These methods are NOT static! */
		System.out.println("default	country: "	+ loc1.getDisplayCountry());
		System.out.println("locale	country: "	+ loc1.getDisplayCountry(loc1));
		System.out.println("default	country: "	+ loc2.getDisplayCountry());
		System.out.println("locale	country: "	+ loc2.getDisplayCountry(loc2));
		System.out.println("-");
		System.out.println("default	language: "	+ loc1.getDisplayLanguage());
		System.out.println("locale	language: "	+ loc1.getDisplayLanguage(loc1));
		System.out.println("default	language: "	+ loc2.getDisplayLanguage());
		System.out.println("locale	language: "	+ loc2.getDisplayLanguage(loc2));



	/* Remember that you can get a particular Date object without having to deal w
	 * ith milliseconds like this: */
		
	/* IMPORTANT NOTE: Date is always UTC-based... or time-zone neutral, depending 
	 * on how you want to view it. A Date only represents a point in time; it is in
	 * dependent of time zone, just a number of milliseconds since the Unix epoch. 
	 * There's no notion of a "local instance of Date." Use Date in conjunction wit
	 * h Calendar and/or TimeZone.getDefault() to use a "local" time zone. Use Time
	 * Zone.getTimeZone("Europe/Madrid") to get the Madrid time zone.
	 * ... or use Joda Time, which tends to make the whole thing clearer, IMO. In J
	 * oda Time you'd use a DateTime value, which is an instant in time in a partic
	 * ular calendar system and time zone.
	 * In Java 8 you'd use java.time.ZonedDateTime, which is the Java 8 equivalent 
	 * of Joda Time's DateTime. */

		Calendar c4 = Calendar.getInstance();
		// Could have been
		// Calendar c4 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		
	/* Setting the date, you can go as deep as:
	 * set(int year, int month, int date, int hourOfDay, int minute, int second)
	 * IMPORTANT NOTES: 1) Months are 0 indexed, Days are not! 2) What you won't se
	 * t will be generated starting off the current date/time */
		c4.set(2012, Calendar.DECEMBER, 21, 19, 0, 0);
		
		Date d3 = c4.getTime();
		System.out.println(d3.toString());
	
	
	}
}