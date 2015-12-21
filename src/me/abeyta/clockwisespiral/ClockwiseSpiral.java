package me.abeyta.clockwisespiral;

import java.util.ArrayList;
import java.util.List;

public class ClockwiseSpiral {

	int[][] matrix;
	int currentRow;
	int currentItem;
	int totalLength;

	int rightLimit;
	int leftLimit;
	int downLimit;
	int upLimit;

	Direction currentDirection = Direction.RIGHT;

	public ClockwiseSpiral(int[][] matrix) {
		if (matrix == null) {
			throw new IllegalArgumentException("Input matrix cannot be null");
		}
		this.matrix = matrix;
		this.rightLimit = matrix[0].length - 1;
		this.totalLength = matrix.length * matrix[0].length;
		this.downLimit = matrix.length - 1;
		this.upLimit = 0;
		this.leftLimit = 0;
	}

	public Integer[] traverse() {
		List<Integer> output = new ArrayList<>();
		
		//get it started with the first number
		output.add(matrix[currentRow][currentItem]);
		
		//iterate over the rest
		for (int x = 1; x < totalLength; x++) {
			output.add(getNextItem());
		}

		//spit out the result
		return output.toArray(new Integer[totalLength]);
	}

	private int getNextItem() {
		calculateNextDirection();

		switch (currentDirection) {
			case RIGHT: {
				return matrix[currentRow][++currentItem];
			}
			case DOWN: {
				return matrix[++currentRow][currentItem];
			}
			case LEFT: {
				return matrix[currentRow][--currentItem];
			}
			case UP: {
				return matrix[--currentRow][currentItem];
			}
		}
		
		throw new RuntimeException("error in calculation...shouldn't have hit this!");
	}

	private void calculateNextDirection() {
		switch (currentDirection) {
			case RIGHT: {
				if (currentItem == rightLimit) {
					upLimit++;
					this.currentDirection = Direction.DOWN;
				}
				break;
			}
			case DOWN: {
				if (currentRow == downLimit) {
					downLimit--;
					this.currentDirection = Direction.LEFT;
				}
				break;
			}
			case LEFT: {
				if (currentItem <= leftLimit) {
					rightLimit--;
					this.currentDirection = Direction.UP;
				}
				break;
			}
			case UP: {
				if (currentRow == upLimit) {
					leftLimit++;
					this.currentDirection = Direction.RIGHT;
				}
				break;
			}
		}
	}

	enum Direction {
		RIGHT, LEFT, UP, DOWN;
	}
}
