package com.riccardofinazzi.arrays;

public class ArrayTest {

	int[][] multidim_a = new int[3][3]; // 3 . 3
	/*  ___ ____ ____ ____
	 * |_0_|_00_|_01_|_02_|
	 * |_1_|_10_|_11_|_12_|
	 * |_2_|_20_|_21_|_22_|
	 */
	
	int[][] multidim_b = new int[3][];  // 3 . x
	
	/* multidim_b[0] = new int[3];		// x = 3
	 * multidim_b[1] = new int[7];		// x = 7
	 * multidim_b[2] = new int[2];		// x = 2
	 * This is not working. marked this page for a review */
	
	/*  ___ ____ ____ ____
	 * |_0_|_00_|_01_|_02_|____ ____ ____ ____
	 * |_1_|_10_|_11_|_12_|_13_|_14_|_15_|_16_|
	 * |_2_|_20_|_21_|
	 */
	void testOutOfBounds() {
		multidim_a[2][3] = 0; // ArrayIndexOutOfBoundsException at runtime
	}
	
}

class ArrayTestDrive {
	
	public static void main(String[] args) {
		new ArrayTest().testOutOfBounds();
	}
}