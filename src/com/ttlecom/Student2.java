package com.ttlecom;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student2 {
	private static int autoId = 0;
	private int id;
	private String fullname;
	private LocalDate birthDate;
	private final ArrayList<Subject> subjects = new ArrayList<>();
	private String graduationType;

	public Student2(String fullname, LocalDate birthDate, ArrayList<Subject> subjects) {
//		subjects = new ArrayList<>();
		setId();
		setFullname(fullname);
		setBirthDate(birthDate);
		setSubjects(subjects);
		this.graduationType = "";
	}

	public int getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public String getGraduationType() {
		setGraduationType();
		return graduationType;
	}

	public void setId() {
		autoId++;
		this.id = autoId;
	}

	public void setFullname(String fullname) {
		if (fullname == null || fullname.isEmpty()) {
			this.fullname = "empty name";
		} else {
			this.fullname = fullname;
		}
	}

	public void setBirthDate(LocalDate birthDate) {
		if (birthDate.isAfter(LocalDate.now())) {
			this.birthDate = LocalDate.now().minusYears(18);
		} else {
			this.birthDate = birthDate;
		}
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		for (Subject subject : subjects) {
			if (subject.getScore() < 0 || subject.getScore() > 10) {
				subject.setScore(0f);
				this.subjects.add(subject);
			} else {
				this.subjects.add(subject);
			}
		}
	}

	private void setGraduationType() {
		// if there is any subject score lower than or equal 5, re-take the exam
		if (isScoreDependency()) {
			this.graduationType = "Retest";
		} else {
			if (calculateAverageScore() > 7) {
				this.graduationType = "Graduation thesis";
			} else {
				this.graduationType = "Graduation examination";
			}
		}
	}

	public boolean isScoreDependency() {
		boolean isScoreDependency = false;
		for (int i = 0; i < getSubjects().size(); i++) {
			if (this.subjects.get(i).getScore() < 5) {
				isScoreDependency = true;
				this.subjects.get(i).setRetested(true);
			}
		}
		return isScoreDependency;
	}

	public float calculateAverageScore() {
		float total = 0f;
		for (Subject subject : this.subjects) {
			total += subject.getScore();
		}
		return total / this.subjects.size();
	}

	@Override
	public String toString() {
		return String.format("Fullname: %s%n" +
						"%s: %.2f%n" +
						"%s: %.2f%n" +
						"%s: %.2f%n" +
						"%s: %.2f%n" +
						"%s: %.2f%n" +
						"Average score: %.2f%n" +
						"Score is dependency: %b%n" +
						"Graduation type: %s%n", getFullname(), getSubjects().get(0).getName(), getSubjects().get(0).getScore(),
						getSubjects().get(1).getName(), getSubjects().get(1).getScore(),
						getSubjects().get(2).getName(), getSubjects().get(2).getScore(),
						getSubjects().get(3).getName(), getSubjects().get(3).getScore(),
						getSubjects().get(4).getName(), getSubjects().get(4).getScore(),
						calculateAverageScore(), isScoreDependency(), getGraduationType());
	}
}
