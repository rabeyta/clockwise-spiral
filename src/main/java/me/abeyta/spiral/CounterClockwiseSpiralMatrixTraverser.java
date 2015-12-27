package me.abeyta.spiral;

import static me.abeyta.spiral.model.Direction.DOWN;
import static me.abeyta.spiral.model.Direction.LEFT;
import static me.abeyta.spiral.model.Direction.RIGHT;
import static me.abeyta.spiral.model.Direction.UP;

import me.abeyta.spiral.model.Direction;

public class CounterClockwiseSpiralMatrixTraverser extends SpiralMatrixTraverser {

	public CounterClockwiseSpiralMatrixTraverser(int[][] matrix) {
		super(matrix);
		this.upLimit = -1;
		this.currentDirection = DOWN;
	}

	@Override
	Direction getNextDirection(Direction currentDirection) {
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

}
