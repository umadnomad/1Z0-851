package com.riccardofinazzi.arrays;

import java.util.*;

class Feline {}
class Cat extends Feline {}

public class Array1 {

	Feline[][] feline;
	
	int[][] multidim_a;
	int[][] multidim_b;
	int[][] multidim_c;
	
	/* Page 223 follow up */
	{
			multidim_c 		= new int[3][];
	 		multidim_c[0]	= new int[3];
	 		multidim_c[1]	= new int[3];
	 		multidim_c[2]	= new int[3];
	}
	
	
	/* page 228 */
	int[]	monodim_scores;
	int[][] multidim_scores;
	
	void testOutOfBounds() {
		
		feline = new Cat[3][];	/* Testing if a 2D array ref var can refer to a 2D arra
		 * y object of its subtype. Yes it works */
		
		
		multidim_a = new int[3][3]; // 3 . 3
		/*  ___ ____ ____ ____
		 * |_0_|_00_|_01_|_02_|
		 * |_1_|_10_|_11_|_12_|
		 * |_2_|_20_|_21_|_22_|
		 */
		
		//multidim_a[2][3] = 0; // ArrayIndexOutOfBoundsException at runtime expected
		
		
		multidim_b = new int[3][];		// 3 . x
		// These are not working inside class declaration, marked page 223 for review
		/* Update, answer found, logical noob error: The places in a class where you c
		 * an perform operations are:
		 * 1) Within constructors
		 * 2) Within methods
		 * 3) Within static or instance initialization blocks
		 */
		multidim_b[0] = new int[3];		// x = 3
		multidim_b[1] = new int[7];		// x = 7
		multidim_b[2] = new int[2];		// x = 2
		/*  ___ ____ ____ ____
		 * |_0_|_00_|_01_|_02_|____ ____ ____ ____
		 * |_1_|_10_|_11_|_12_|_13_|_14_|_15_|_16_|
		 * |_2_|_20_|_21_|
		 */
		
		/* page 228 */
		monodim_scores  = new int[3];
		
		monodim_scores[0] = 1;
		monodim_scores[1] = 2;
		monodim_scores[2] = 3;
		
		
		multidim_scores = new int[3][];
		
		multidim_scores[0] = new int[4];
		multidim_scores[0][0] = 5;
		multidim_scores[0][1] = 2;
		multidim_scores[0][2] = 4;
		multidim_scores[0][3] = 7;
		
		multidim_scores[1] = new int[2];
		multidim_scores[1][0] = 9;
		multidim_scores[1][1] = 2;
		
		multidim_scores[2] = new int[2];
		multidim_scores[2][0] = 3;
		multidim_scores[2][1] = 4;
		
		
		System.out.println("Monodimensional Array Print");
		System.out.println("Arrays.toString(Obj)");
		System.out.println();
		System.out.println("Result: " + Arrays.toString(monodim_scores));
		System.out.println();
		
		System.out.println("Multidimensional Array Print");
		System.out.println("Arrays.deepToString(Obj)");
		System.out.println();
		System.out.println("Result: " + Arrays.deepToString(multidim_scores));
		System.out.println();
		
		System.out.println("Multidimensional Array Nested For Loops Print");
		System.out.println("Result:");
		for (int i = 0; i < multidim_scores.length; i++) {
			for (int j = 0; j < multidim_scores[i].length; j++) {
				System.out.print(multidim_scores[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Array1TestDrive {
	
	public static void main(String[] args) {
		new Array1().testOutOfBounds();
	}
}