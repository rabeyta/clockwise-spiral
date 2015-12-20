package me.abeyta.clockwisespiral;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SimpleClockwiseSpiralTest {

	@Test
	public void traverse4x4() {
		int[][] arrayToTraverse = new int[4][4];
		
		arrayToTraverse[0] = new int[]{ 1,  2,  3,  4};
		arrayToTraverse[1] = new int[]{ 5,  6,  7,  8};
		arrayToTraverse[2] = new int[]{ 9, 10, 11, 12};
		arrayToTraverse[3] = new int[]{13, 14, 15, 16};
		
		Integer[] output = new SimpleClockwiseSpiral(arrayToTraverse).traverse();
		
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10}, output);
	}
	
}
