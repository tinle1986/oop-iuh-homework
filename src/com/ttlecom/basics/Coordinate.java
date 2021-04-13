package com.ttlecom.basics;

public class Coordinate {
	private int x;
	private int y;
	private String name;

	public Coordinate() {
		setX(0);
		setY(0);
		setName("unknown point");
	}

	public Coordinate(int x, int y, String name) {
		setX(x);
		setY(y);
		setName(name);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName() + "(" + getX() + ", " + getY() + ")";
	}
}
