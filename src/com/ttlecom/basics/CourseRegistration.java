package com.ttlecom.basics;

import java.util.ArrayList;

public class CourseRegistration {
	private Course course;
	private final ArrayList<Student3> studentList;

	public CourseRegistration() {
		studentList = new ArrayList<>();
	}

	public void addStudent(Student3 std) {
		this.studentList.add(std);
	}

	public ArrayList<Student3> getStudentList() {
		return studentList;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getCourse().toString() +
						String.format(". Students registered (%d):%n", getStudentList().size()));
		for (int i = 0; i < getStudentList().size(); i++) {
			result.append(String.format("%d. %s%n", i + 1, getStudentList().get(i).getFullname()));
		}
		return result.toString();
	}
}
