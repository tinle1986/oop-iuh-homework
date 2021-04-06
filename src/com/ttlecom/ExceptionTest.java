package com.ttlecom;

public class ExceptionTest {
	public static void main(String[] args) {
		StudentAndException stdTest;

		stdTest = new StudentAndException();
		stdTest.setId(1);
		stdTest.setName("NTT");
		try {
			stdTest.setScore(100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
