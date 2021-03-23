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
		setTheoreticalScore(theoreticalScore);
		setPracticalScore(practicalScore);
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
		if (name != null) {
			this.name = name;
		} else {
			this.name = "unknown";
		}
	}

	public double getTheoreticalScore() {
		return theoreticalScore;
	}

	public void setTheoreticalScore(double theoreticalScore) {
		if ((theoreticalScore < 0) || (theoreticalScore > 10)) {
			this.theoreticalScore = 0;
		} else {
			this.theoreticalScore = theoreticalScore;
		}
	}

	public float getPracticalScore() {
		return (float) practicalScore;
	}

	public void setPracticalScore(double practicalScore) {
		if ((practicalScore < 0) || (practicalScore > 10)) {
			this.practicalScore = 0;
		} else {
			this.practicalScore = practicalScore;
		}
	}

	public float getAverageScore() {
		return (float) ((getPracticalScore() + getTheoreticalScore()) / 2.0);
	}

	@Override
	public String toString() {
		return String.format("|%5d | %-30s|%6.2f |%6.2f |%6.2f |", getId(), getName(), getTheoreticalScore(), getPracticalScore(), getAverageScore());
	}
}
