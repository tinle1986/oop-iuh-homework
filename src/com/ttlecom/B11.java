package com.ttlecom;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class B11 {
	public static void main(String[] args) {
		LearningClass avengers = new LearningClass();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// add details for ironman
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Math", 10));
		subjects.add(new Subject("Literary", 8.7f));
		subjects.add(new Subject("English", 9.5f));
		subjects.add(new Subject("History", 9.2f));
		subjects.add(new Subject("Geo", 9.8f));
		Student2 ironman = new Student2("Ironman", LocalDate.parse("23/01/1967", dtf), subjects);

		// add details for thor
		ArrayList<Subject> subjects1 = new ArrayList<>();
		subjects1.add(new Subject("Math", 2.5f));
		subjects1.add(new Subject("Literary", 9.5f));
		subjects1.add(new Subject("English", 10f));
		subjects1.add(new Subject("History", 6.5f));
		subjects1.add(new Subject("Geo", 5.9f));
		Student2 thor = new Student2("Thor", LocalDate.parse("31/08/1974", dtf), subjects1);

		// add details for spiderman
		ArrayList<Subject> subjects2 = new ArrayList<>();
		subjects2.add(new Subject("Math", 5.5f));
		subjects2.add(new Subject("Literary", 3.5f));
		subjects2.add(new Subject("English", 5.3f));
		subjects2.add(new Subject("History", 5.5f));
		subjects2.add(new Subject("Geo", 5.9f));
		Student2 spiderman = new Student2("Spider Man", LocalDate.parse("17/10/1989", dtf), subjects2);

		// add students to the learning class
		avengers.addStudent(ironman);
		avengers.addStudent(thor);
		avengers.addStudent(spiderman);

		System.out.println(ironman.toString());
		System.out.println(thor.toString());
		System.out.println(spiderman.toString());

		avengers.countStudentsDoThesis();
		avengers.countStudentDoExam();
		avengers.countStudentRetest();
	}
}
