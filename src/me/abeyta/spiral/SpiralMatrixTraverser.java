package me.abeyta.spiral;

import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.DOWN;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.LEFT;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.RIGHT;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.UP;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraverser {

	int[][] matrix;
	int currentRow;
	int currentItem;
	int totalLength;

	int rightLimit;
	int leftLimit;
	int downLimit;
	int upLimit;

	Direction currentDirection;
	SpiralDirection spiralDirection;

	public SpiralMatrixTraverser(int[][] matrix, SpiralDirection spiralDirection) {
		if (matrix == null) {
			throw new IllegalArgumentException("Input matrix cannot be null");
		}
		if(spiralDirection == null) {
			this.spiralDirection = SpiralDirection.CLOCKWISE;
		}
		
		this.spiralDirection = spiralDirection;
		this.matrix = matrix;
		this.rightLimit = matrix[0].length - 1;
		this.totalLength = matrix.length * matrix[0].length;
		this.downLimit = matrix.length - 1;
		this.leftLimit = 0;

		if (SpiralDirection.COUNTERCLOCKWISE == spiralDirection) {
			this.upLimit = -1;
			this.currentDirection = DOWN;
		} else {
			this.upLimit = 0;
			this.currentDirection = RIGHT;
		}
	}

	public Integer[] traverse() {
		List<Integer> output = new ArrayList<>();

		// get it started with the first number
		output.add(matrix[currentRow][currentItem]);

		// iterate over the rest
		for (int x = 1; x < totalLength; x++) {
			output.add(getNextItem());
		}

		// spit out the result
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
				setNextDirection();
			}
			break;
		}
		case DOWN: {
			if (currentRow == downLimit) {
				downLimit--;
				setNextDirection();
			}
			break;
		}
		case LEFT: {
			if (currentItem == leftLimit) {
				rightLimit--;
				setNextDirection();
			}
			break;
		}
		case UP: {
			if (currentRow == upLimit) {
				leftLimit++;
				setNextDirection();
			}
			break;
		}
		}
	}

	private void setNextDirection() {
		this.currentDirection = spiralDirection.getNextDirection(currentDirection);
	}

	enum Direction {
		RIGHT, LEFT, UP, DOWN;
	}

	enum SpiralDirection {
		CLOCKWISE, COUNTERCLOCKWISE;

		public Direction getNextDirection(Direction currentDirection) {
			switch (this) {
				case CLOCKWISE: {
					return getNextClockwiseDirection(currentDirection);
				}
				case COUNTERCLOCKWISE: {
					return getNextCounterClockwiseDirection(currentDirection);
				}
				default: {
					throw new RuntimeException("whoops. never should have hit this. we forgot to implement a new case. please contact your normal support channels.");
				}
			}
		}

		private Direction getNextCounterClockwiseDirection(Direction currentDirection) {
			switch (currentDirection) {
				case DOWN: {
					return RIGHT;
				}
				case RIGHT: {
					return UP;
				}
				case UP: {
					return LEFT;
				}
				case LEFT: {
					return DOWN;
				}
				default: {
					throw new RuntimeException("whoops. never should have hit this. we forgot to implement a new case. please contact your normal support channels.");
				}
			}
		}

		private Direction getNextClockwiseDirection(Direction currentDirection) {
			switch (currentDirection) {
				case RIGHT: {
					return DOWN;
				}
				case DOWN: {
					return LEFT;
				}
				case LEFT: {
					return UP;
				}
				case UP: {
					return RIGHT;
				}
				default: {
					throw new RuntimeException("whoops. never should have hit this. we forgot to implement a new case. please contact your normal support channels.");
				}
			}
		}
	}
}
