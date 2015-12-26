package me.abeyta.spiral;

import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.DOWN;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.LEFT;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.RIGHT;
import static me.abeyta.spiral.SpiralMatrixTraverser.Direction.UP;

public class ClockwiseSpiralMatrixTraverser extends SpiralMatrixTraverser {

	public ClockwiseSpiralMatrixTraverser(int[][] matrix) {
		super(matrix);
		this.upLimit = 0;
		this.currentDirection = RIGHT;
	}

	@Override
	void setNextDirection() {
		switch (currentDirection) {
			case RIGHT: {
				this.currentDirection = DOWN;
				break;
			}
			case DOWN: {
				this.currentDirection = LEFT;
				break;
			}
			case LEFT: {
				this.currentDirection = UP;
				break;
			}
			case UP: {
				this.currentDirection = RIGHT;
				break;
			}
			default: {
				throw new RuntimeException("whoops. never should have hit this. we forgot to implement a new case. please contact your normal support channels.");
			}
		}
	}

}
