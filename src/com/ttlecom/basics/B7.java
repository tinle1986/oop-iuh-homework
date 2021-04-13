package com.ttlecom.basics;

public class B7 {
	public static void main(String[] args) {
		Circle circle = new Circle();
		AdvanceCoordinate center = new AdvanceCoordinate("O", 5, 5);
		circle.setRadius(100.5);
		circle.setCenter(center);
		System.out.println(circle.toString());;
	}
}
