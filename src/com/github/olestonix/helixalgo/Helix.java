package com.github.olestonix.helixalgo;

public abstract class Helix {

	private final HelixDirection direction;
	private final int length;
	private int x, y, repeated, repeats;
	private boolean negative, xAxis;
	
	public Helix(HelixDirection direction, int length, int x, int y, int repeated, int repeats) {
		this.direction = direction;
		this.length = length;
		this.x = x;
		this.y = y;
		this.repeated = repeated;
		this.repeats = repeats;
		this.negative = direction.isNegative();
		this.xAxis = direction.isXAxis();
	}
	
	public Helix(HelixDirection direction, int length, int x, int y) {
		this(direction, length, x, y, 0, 1);
	}
	
	public Helix(HelixDirection direction, int length) {
		this(direction, length, 0, 0, 0, 1);
	}
	
	public HelixDirection getDirection() {
		return direction;
	}
	
	public int getLength() {
		return length;
	}
	
	public abstract void draw(int x, int y);
	
	public void add() {
		int add = (negative) ? -length : length;
		if (xAxis) {
			if (repeated < repeats) {
				draw(x, y);
				x+=add;
				repeated++;
			} else {
				xAxis = !xAxis;
				repeated = 0;
				if (!direction.isXAxis()) {
					negative = !negative;
					repeats++;
				}
			}
		} else {
			if (repeated < repeats) {
				draw(x, y);
				y+=add;
				repeated++;
			} else {
				xAxis = !xAxis;
				repeated = 0;
				if (direction.isXAxis()) {
					negative = !negative;
					repeats++;
				}
			}
		}
	}
}