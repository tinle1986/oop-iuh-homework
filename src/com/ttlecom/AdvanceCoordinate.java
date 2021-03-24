package com.ttlecom;

public class AdvanceCoordinate {
	private String name;
	private float x;
	private float y;

	public AdvanceCoordinate(String name, float x, float y) {
		setName(name);
		setX(x);
		setY(y);
	}

	public AdvanceCoordinate() {
		this("unknown", 0, 0);
	}

	public String getName() {
		return name;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			this.name = "unknown";
		} else {
			this.name = name;
		}
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
}
