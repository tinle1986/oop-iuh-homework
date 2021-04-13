package com.ttlecom.basics;

public class Circle {
	private AdvanceCoordinate center;
	private double radius;

	public Circle(AdvanceCoordinate center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle() {
		this(new AdvanceCoordinate(), 0);
	}

	public AdvanceCoordinate getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}

	public void setCenter(AdvanceCoordinate center) {
		this.center = center;
	}

	public void setRadius(double radius) {
		this.radius = Math.max(radius, 0);
	}

	public double calculatePerimeter() {
		return Math.PI * 2 * getRadius();
	}

	public double calculateArea() {
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public String toString() {
		return String.format("The cicle center %s(%.2f, %.2f) " +
										"with the radius %.2f has the perimeter and area " +
										"are %,.3f and %,.3f accordingly.%n", getCenter().getName(), getCenter().getX(), getCenter().getY(),
						getRadius(), calculatePerimeter(), calculateArea());
	}
}
