package me.abeyta.spiral.model;

public enum Direction {
	RIGHT(0,1), LEFT(0,-1), UP(-1, 0), DOWN(1,0);
	
	public int rowMovement;
	public int columnMovement;
	
	private Direction(int rowMovement, int columnMovement) {
		this.rowMovement = rowMovement;
		this.columnMovement = columnMovement;
	}
}
