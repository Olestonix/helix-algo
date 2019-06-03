package com.github.olestonix.helixalgo;

public enum HelixDirection {

	COUNTERLOCK_WISE(true, false),
	CLOCKWISE(false, true);
	
	private final boolean negative, xAxis;
	
	private HelixDirection(boolean negative, boolean xAxis) {
		this.negative = negative;
		this.xAxis = xAxis;
	}
	
	public boolean isNegative() {
		return negative;
	}
	
	public boolean isXAxis() {
		return xAxis;
	}
}