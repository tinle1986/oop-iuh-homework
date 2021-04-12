package com.ttlecom;

import java.util.ArrayList;

public class School {
	private final ArrayList<CourseRegistration> courseRegistrationList;
	private final ArrayList<StudentRegistration> studentRegistrationList;

	public School() {
		courseRegistrationList = new ArrayList<>();
		studentRegistrationList = new ArrayList<>();
	}

	public ArrayList<CourseRegistration> getCourseRegistrationList() {
		return courseRegistrationList;
	}

	public ArrayList<StudentRegistration> getStudentRegistrationList() {
		return studentRegistrationList;
	}

	public void studentRegisterCourse(Student3 student, CourseRegistration courseRegistration) {
		boolean isDuplicateStudent = false;
		boolean isDuplicateCourse = false;

		// check is the first time of course registration?
		for(CourseRegistration courseReg: this.courseRegistrationList) {
			if (courseReg.getCourse().getName().equals(courseRegistration.getCourse().getName())) {
				isDuplicateCourse = true;
				break;
			}
		}
		// if course not exist before
		if (!isDuplicateCourse) {
			courseRegistration.addStudent(student);
			this.courseRegistrationList.add(courseRegistration);
		} else { // if course already existed
			courseRegistration.addStudent(student);
		}

		// check new student registered before or not?
		for(StudentRegistration studentReg: this.studentRegistrationList) {
			if (studentReg.getStudent().getFullname().equals(student.getFullname())) {
				isDuplicateStudent = true;
				break;
			}
		}
		if (!isDuplicateStudent) {
			StudentRegistration newStudentRegistration = new StudentRegistration();
			newStudentRegistration.setStudent(student);
			newStudentRegistration.addCourse(courseRegistration.getCourse());
			this.studentRegistrationList.add(newStudentRegistration);
		} else {
			for (StudentRegistration studentReg: this.studentRegistrationList) {
				if (studentReg.getStudent().getFullname().equals(student.getFullname())) {
					studentReg.addCourse(courseRegistration.getCourse());
					break;
				}
			}
		}
	}

	public void findStudent(String studentName) {
		for(StudentRegistration studentRegistration: getStudentRegistrationList()) {
			if (studentRegistration.getStudent().getFullname().equalsIgnoreCase(studentName)) {
				System.out.println("Student found.");
				System.out.println(studentRegistration);
				return;
			}
		}
		System.out.println("Student cannot be found!");
	}

	public void findCourse(String courseName) {
		for (CourseRegistration courseRegistration: getCourseRegistrationList()) {
			if (courseRegistration.getCourse().getName().equalsIgnoreCase(courseName)) {
				System.out.println("Course found.");
				System.out.println(courseRegistration);
				return;
			}
		}
		System.out.println("Course cannot be found!");
	}
}
