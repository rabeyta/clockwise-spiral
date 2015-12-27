package me.abeyta.spiral;

import static me.abeyta.spiral.model.Direction.DOWN;
import static me.abeyta.spiral.model.Direction.LEFT;
import static me.abeyta.spiral.model.Direction.RIGHT;
import static me.abeyta.spiral.model.Direction.UP;

import me.abeyta.spiral.model.Direction;

public class ClockwiseSpiralMatrixTraverser extends SpiralMatrixTraverser {

	public ClockwiseSpiralMatrixTraverser(int[][] matrix) {
		super(matrix);
		this.upLimit = 0;
		this.currentDirection = RIGHT;
	}

	@Override
	Direction getNextDirection(Direction currentDirection) {
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
