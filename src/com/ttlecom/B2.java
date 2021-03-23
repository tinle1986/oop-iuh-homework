package com.ttlecom;

import java.util.Scanner;

public class B2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strInput;
		double dblInput;

		Student student1 = new Student("Lê Trung Tín", 8.1, 8.3);
		Student student2 = new Student("Nguyễn Hoàng Phú", 8.4, 9.3);
		Student student3 = new Student();

		System.out.println("Input the name of 3rd student:");
		strInput = sc.nextLine();
		student3.setName(strInput);
		System.out.println("Input the theoretical score of 3rd student:");
		dblInput = Double.parseDouble(sc.nextLine());
		student3.setTheoreticalScore(dblInput);
		System.out.println("Input the practical score of 3rd student:");
		dblInput = Double.parseDouble(sc.nextLine());
		student3.setPracticalScore(dblInput);

		System.out.printf("|%5s | %-30s|%6.2s |%6.2s |%6.2s |%n", "ID", "Fullname", "TS", "PS", "AS");
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
	}
}
