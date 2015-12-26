package me.abeyta.spiral;

import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.DOWN;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.LEFT;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.RIGHT;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.UP;

public class CounterClockwiseSpiralMatrixTraverser extends SpiralMatrixTraverser {

	public CounterClockwiseSpiralMatrixTraverser(int[][] matrix) {
		super(matrix);
		this.upLimit = -1;
		this.currentDirection = DOWN;
	}

	@Override
	void setNextDirection() {
		switch (currentDirection) {
			case DOWN: {
				this.currentDirection = RIGHT;
				break;
			}
			case RIGHT: {
				this.currentDirection = UP;
				break;
			}
			case UP: {
				this.currentDirection = LEFT;
				break;
			}
			case LEFT: {
				this.currentDirection = DOWN;
				break;
			}
			default: {
				throw new RuntimeException("whoops. never should have hit this. we forgot to implement a new case. please contact your normal support channels.");
			}
		}
	}

}
