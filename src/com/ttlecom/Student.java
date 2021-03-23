package com.ttlecom;

public class Student {
	private static int size = 0;
	private int id;
	private String name;
	private double theoreticalScore;
	private double practicalScore;

	public Student() {
		size++;
		setId(size);
		setName("unknown");
		setTheoreticalScore(0);
		setPracticalScore(0);
	}

	public Student(String name, double theoreticalScore, double practicalScore) {
		size++;
		setId(size);
		setName(name);
		if (theoreticalScore < 0 || theoreticalScore > 10) {
			setTheoreticalScore(0);
		} else {
			setTheoreticalScore(theoreticalScore);
		}
		;
		if (practicalScore < 0 || practicalScore > 10) {
			setPracticalScore(0);
		} else {
			setPracticalScore(practicalScore);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTheoreticalScore() {
		return theoreticalScore;
	}

	public void setTheoreticalScore(double theoreticalScore) {
		this.theoreticalScore = theoreticalScore;
	}

	public float getPracticalScore() {
		return (float) practicalScore;
	}

	public void setPracticalScore(double practicalScore) {
		this.practicalScore = practicalScore;
	}

	public float getAverageScore() {
		return (float) ((getPracticalScore() + getTheoreticalScore()) / 2.0);
	}

	@Override
	public String toString() {
		return String.format("|%5d | %-30s|%6.2f |%6.2f |%6.2f |", getId(), getName(), getTheoreticalScore(), getPracticalScore(), getAverageScore());
	}
}
