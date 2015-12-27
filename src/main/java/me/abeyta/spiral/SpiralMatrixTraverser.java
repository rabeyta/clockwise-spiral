package me.abeyta.spiral;

import java.util.ArrayList;
import java.util.List;

import me.abeyta.spiral.model.Direction;
import me.abeyta.spiral.model.MatrixLimits;

public abstract class SpiralMatrixTraverser {

	public Integer[] traverse(int[][] matrix) {
		validateMatrix(matrix);
		
		MatrixLimits limits = new MatrixLimits(matrix[0].length - 1, 0, matrix.length - 1, getUpLimit());
		Direction currentDirection = getStartingDirection();

		int currentRow = 0;
		int currentItem = 0;
		int totalLength = matrix.length * matrix[0].length;
		
		List<Integer> output = new ArrayList<>();

		// get it started with the first number
		output.add(matrix[currentRow][currentItem]);
		
		// iterate over the rest
		for (int x = 1; x < totalLength; x++) {
			currentDirection = calculateNextDirection(currentDirection, limits, currentItem, currentRow);
			currentRow += currentDirection.rowMovement;
			currentItem += currentDirection.columnMovement;
			output.add(matrix[currentRow][currentItem]);
		}

		// spit out the result
		return output.toArray(new Integer[totalLength]);
	}

	private void validateMatrix(int[][] matrix) {
		if (matrix == null) {
			throw new IllegalArgumentException("Input matrix cannot be null");
		}
		// TODO add more validations and tests
	}

	private Direction calculateNextDirection(Direction currentDirection, MatrixLimits limits, int currentItem, int currentRow) {
		switch (currentDirection) {
			case RIGHT: {
				if (currentItem == limits.getRightLimit()) {
					limits.increaseUpLimit();
					return getNextDirection(currentDirection);
				}
				break;
			}
			case DOWN: {
				if (currentRow == limits.getDownLimit()) {
					limits.decreaseDownLimit();
					return getNextDirection(currentDirection);
				}
				break;
			}
			case LEFT: {
				if (currentItem == limits.getLeftLimit()) {
					limits.decreaseRightLimit();
					return getNextDirection(currentDirection);
				}
				break;
			}
			case UP: {
				if (currentRow == limits.getUpLimit()) {
					limits.increaseLeftLimit();
					return getNextDirection(currentDirection);
				}
				break;
			}
		}
		return currentDirection;
	}

	abstract Direction getNextDirection(Direction currentDirection);
	abstract int getUpLimit();
	abstract Direction getStartingDirection();

}
