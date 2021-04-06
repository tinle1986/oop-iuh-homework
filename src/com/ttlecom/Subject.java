package com.ttlecom;

public class Subject {
	private String name;
	private float score;
	private boolean isRetested;

	public Subject(String name, float score) {
		setName(name);
		setScore(score);
		setRetested(false);
	}

	public Subject(String name, float score, boolean isRetested) {
		this.name = name;
		this.score = score;
		this.isRetested = isRetested;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public boolean isRetested() {
		return isRetested;
	}

	public void setRetested(boolean retested) {
		isRetested = retested;
	}
}
