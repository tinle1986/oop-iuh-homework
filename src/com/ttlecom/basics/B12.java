package com.ttlecom.basics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class B12 {
	private static final School vtca = new School();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Student3 std1 = new Student3("Tèo Nguyễn", "Q.10", "0903123123");
		Student3 std2 = new Student3("Khang Lê", "Q.11", "0901123456");
		Student3 std3 = new Student3("Cường Hồ", "Q.1", "0909789123");
		Student3 std4 = new Student3("Tùng Nguyễn", "Q. Thủ Đức", "0903333123");
		Student3 std5 = new Student3("Chương Cao", "Q.3", "0901127823");
		Student3 std6 = new Student3("Khương Nguyễn", "Q.11", "0903123432");
		Student3 std7 = new Student3("Nhật Hoàng", "Q.11", "0901123876");
		Student3 std8 = new Student3("Lương Hồ", "Q.7", "0900989123");
		Student3 std9 = new Student3("Chính Cao", "Q. Thủ Đức", "0903563123");
		Student3 std10 = new Student3("Nghị Đào", "Q.8", "0901127823");

		// opening java core subject
		CourseRegistration javaCore = new CourseRegistration();
		javaCore.setCourse(new Course("Java Core", LocalDate.parse("15/12/2020", dtf), 3));
		vtca.studentRegisterCourse(std1, javaCore);
		vtca.studentRegisterCourse(std2, javaCore);
		vtca.studentRegisterCourse(std3, javaCore);
		vtca.studentRegisterCourse(std4, javaCore);

		// opening javaOop subject
		CourseRegistration javaOop = new CourseRegistration();
		javaOop.setCourse(new Course("Java OOP", LocalDate.parse("10/02/2021", dtf), 4));
		vtca.studentRegisterCourse(std4, javaOop);
		vtca.studentRegisterCourse(std5, javaOop);
		vtca.studentRegisterCourse(std6, javaOop);
		vtca.studentRegisterCourse(std7, javaOop);
		vtca.studentRegisterCourse(std8, javaOop);

		// opening dataStructureAndAlgorithm subject
		CourseRegistration dataStructureAndAlgorithm = new CourseRegistration();
		dataStructureAndAlgorithm.setCourse(new Course("Data Structure and Algorithm", LocalDate.parse("21/05/2021", dtf), 3.5f));
		vtca.studentRegisterCourse(std9, dataStructureAndAlgorithm);
		vtca.studentRegisterCourse(std10, dataStructureAndAlgorithm);
		vtca.studentRegisterCourse(std4, dataStructureAndAlgorithm);

		System.out.println("Input the student name to find:");
		input = sc.nextLine();
		vtca.findStudent(input);

		System.out.println("Input the course name to find:");
		input = sc.nextLine();
		vtca.findCourse(input);

		System.out.println("Finished!");

	}

}
