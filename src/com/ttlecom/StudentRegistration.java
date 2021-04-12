package com.ttlecom;

import java.util.ArrayList;

public class StudentRegistration {
	private Student3 student;
	private final ArrayList<Course> courseList;

	public StudentRegistration() {
		this.courseList = new ArrayList<>();
	}

	public StudentRegistration(Student3 student) {
		courseList = new ArrayList<>();
		this.student = student;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public Student3 getStudent() {
		return student;
	}

	public void setStudent(Student3 student) {
		this.student = student;
	}

	public void addCourse(Course course) {
		boolean isDuplicateCourse = false;
		for (Course course1 : this.courseList) {
			if (course1.getName().equals(course.getName())) {
				isDuplicateCourse = true;
			}
		}
		if (!isDuplicateCourse) {
			this.courseList.add(course);
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder(getStudent().toString() +
						String.format(". Courses registered (%d):%n", getCourseList().size()));
		for (int i = 0; i < getCourseList().size(); i++) {
			stringBuilder.append(String.format("%d. %s (%s)%n", i + 1, getCourseList().get(i).getName(), getCourseList().get(i).getStatus()));
		}
		return stringBuilder.toString();
	}
}
