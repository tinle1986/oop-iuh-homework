package com.ttlecom;

public class StudentAndException {
	private int id;
	private String name;
	private int score;

	public StudentAndException() {
	}

	public StudentAndException(int id, String name, int score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) throws Exception {
		if (score < 0 || score > 10) {
			throw new NameException("Hello");
		} else this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}
