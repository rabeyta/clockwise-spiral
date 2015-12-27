package me.abeyta.spiral;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class ClockwiseSpiralMatrixTraverserTest {
	
	SpiralMatrixTraverser traverser;
	
	@Before
	public void setup() {
		traverser = new ClockwiseSpiralMatrixTraverser();
	}

	@Test(expected=IllegalArgumentException.class)
	public void nullInputThrowsException() {
		traverser.traverse(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void emptyInputThrowsException() {
		int[][] input = new int[0][0];
		traverser.traverse(input);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullInternalArrayThrowsException() {
		int[][] input = new int[1][0];
		input[0] = null;
		traverser.traverse(input);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void emptyInternalArrayThrowsException() {
		int[][] input = new int[1][0];
		input[0] = new int[0];
		traverser.traverse(input);
	}
	
	@Test
	public void clockwiseTraverse3x3() {
		int[][] arrayToTraverse = new int[3][3];
		
		arrayToTraverse[0] = new int[]{ 1,  2,  3};
		arrayToTraverse[1] = new int[]{ 4,  5,  6};
		arrayToTraverse[2] = new int[]{ 7,  8,  9};
		
		Integer[] output = traverser.traverse(arrayToTraverse);
		
		assertArrayEquals(new Integer[] {1, 2, 3, 6, 9, 8, 7, 4, 5}, output);
	}
	
	@Test
	public void clockwiseTraverse4x4() {
		int[][] arrayToTraverse = new int[4][4];
		
		arrayToTraverse[0] = new int[]{ 1,  2,  3,  4};
		arrayToTraverse[1] = new int[]{ 5,  6,  7,  8};
		arrayToTraverse[2] = new int[]{ 9, 10, 11, 12};
		arrayToTraverse[3] = new int[]{13, 14, 15, 16};
		
		Integer[] output = traverser.traverse(arrayToTraverse);
		
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10}, output);
	}
	
	@Test
	public void clockwiseTraverse3x5() {
		int[][] arrayToTraverse = new int[3][5];
		
		arrayToTraverse[0] = new int[]{ 1,  2,  3,  4,  5};
		arrayToTraverse[1] = new int[]{ 6,  7,  8,  9, 10};
		arrayToTraverse[2] = new int[]{11, 12, 13, 14, 15};
		
		Integer[] output = traverser.traverse(arrayToTraverse);
		
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9}, output);
	}
	
	@Test
	public void clockwiseTraverse5x3() {
		int[][] arrayToTraverse = new int[5][3];
		
		arrayToTraverse[0] = new int[]{ 1,  2,  3};
		arrayToTraverse[1] = new int[]{ 4,  5,  6};
		arrayToTraverse[2] = new int[]{ 7,  8,  9};
		arrayToTraverse[3] = new int[]{10, 11, 12};
		arrayToTraverse[4] = new int[]{13, 14, 15};
		
		Integer[] output = traverser.traverse(arrayToTraverse);
		
		assertArrayEquals(new Integer[] {1, 2, 3, 6, 9, 12, 15, 14, 13, 10, 7, 4, 5, 8, 11}, output);
	}
}
