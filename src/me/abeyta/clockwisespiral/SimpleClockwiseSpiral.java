package me.abeyta.clockwisespiral;

import java.util.ArrayList;
import java.util.List;

public class SimpleClockwiseSpiral {

	int[][] matrix;
	int currentRow;
	int currentItem;
	int maxRowLength;
	int minRowLength;
	int maxColumnLength;
	int minColumnLength;
	
	public SimpleClockwiseSpiral(int[][] matrix) {
		if (matrix == null) {
			throw new IllegalArgumentException("Input matrix cannot be null");
		}
		this.matrix = matrix;
		this.currentRow = 0;
		this.currentItem = 0;
		this.maxRowLength = matrix[0].length - 1;
		this.maxColumnLength = matrix.length - 1;
	}

	public Integer[] traverse() {
		List<Integer> result = new ArrayList<>();

		while(maxRowLength > minRowLength && maxColumnLength > minColumnLength) {
			
			for(int top = minRowLength; top <= maxRowLength; top++) {
				result.add(matrix[currentRow][currentItem++]);
			}
			currentItem--;
			minColumnLength++;
			
			for(int right = minColumnLength; right <= maxColumnLength; right++) {
				result.add(matrix[++currentRow][currentItem]);
			}
			minRowLength++;
			
			for(int bottom = minRowLength; bottom <= maxRowLength; bottom++) {
				result.add(matrix[currentRow][--currentItem]);
			}
			maxColumnLength--;
			
			for(int left = minColumnLength; left <= maxColumnLength; left++) {
				result.add(matrix[--currentRow][currentItem]);
			}
			currentItem++;
			maxRowLength--;
		}
	
		return result.toArray(new Integer[result.size()]);
	}
	
	
}
