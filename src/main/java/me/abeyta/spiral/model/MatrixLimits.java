package me.abeyta.spiral.model;

public class MatrixLimits {
	
	private int rightLimit;
	private int leftLimit;
	private int downLimit;
	private int upLimit;

	public MatrixLimits(int right, int left, int down, int up) {
		this.rightLimit = right;
		this.leftLimit = left;
		this.downLimit = down;
		this.upLimit = up;
	}

	public int getRightLimit() {
		return rightLimit;
	}

	public void setRightLimit(int rightLimit) {
		this.rightLimit = rightLimit;
	}

	public int getLeftLimit() {
		return leftLimit;
	}

	public void setLeftLimit(int leftLimit) {
		this.leftLimit = leftLimit;
	}

	public int getDownLimit() {
		return downLimit;
	}

	public void setDownLimit(int downLimit) {
		this.downLimit = downLimit;
	}

	public int getUpLimit() {
		return upLimit;
	}

	public void setUpLimit(int upLimit) {
		this.upLimit = upLimit;
	}

	public void increaseUpLimit() {
		this.upLimit++;
	}

	public void decreaseDownLimit() {
		this.downLimit--;
	}

	public void decreaseRightLimit() {
		this.rightLimit--;
	}

	public void increaseLeftLimit() {
		this.leftLimit++;
	}
}
