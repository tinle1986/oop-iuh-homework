package com.ttlecom.basics;

import java.util.ArrayList;

public class LearningClass {
	ArrayList<Student2> studentArrayList;

	public LearningClass() {
		studentArrayList = new ArrayList<>();
	}

	public void addStudent(Student2 student) {
		this.studentArrayList.add(student);
	}

	public ArrayList<Student2> getStudentArrayList() {
		return studentArrayList;
	}

	public void countStudentsDoThesis() {
		int count = 0;
		for(Student2 std: this.getStudentArrayList()) {
			if (std.getGraduationType().equalsIgnoreCase("Graduation thesis")) {
				count++;
			}
		}
		System.out.println("The number of Students doing Thesis: " + count);
	}

	public void countStudentDoExam() {
		int count = 0;
		for (Student2 std: this.getStudentArrayList()) {
			if (std.getGraduationType().equalsIgnoreCase("Graduation examination")) {
				count++;
			}
		}
		System.out.println("The number of Students doing exam: " + count);
	}

	public void countStudentRetest() {
		int count = 0;
		for (Student2 std: this.getStudentArrayList()) {
			if (std.getGraduationType().equalsIgnoreCase("Retest")) {
				count++;
			}
		}
		System.out.println("The number of Students must retest: " + count);
		if (count > 0) {
			System.out.println("\nThe list of students must retest:");
			for (Student2 std: this.getStudentArrayList()) {
				if (std.getGraduationType().equalsIgnoreCase("Retest")) {
					System.out.println("Student name: " + std.getFullname());
					System.out.println("List of subjects retested:");
					for(Subject subject: std.getSubjects()) {
						if (subject.getScore() < 5) {
							System.out.println(". " + subject.getName());
						}
					}
					System.out.println();
				}
			}
		}
	}
}
