package com.ttlecom.inheritanceAndPolymorphism;

import java.lang.ref.Reference;
import java.util.Scanner;

public class B2 {
	private final static Library sohoLib = new Library();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strInput;
		TextBook math1 = new TextBook(111, "12/03/2019", 34000, 50, "NXB Giáo Dục", true);
		TextBook math2 = new TextBook(222, "21/01/2017", 54000, 35, "NXB Giáo Dục", false);
		TextBook algorithm = new TextBook(333, "07/01/2015", 48000, 73, "NXB XHTT", false);
		TextBook java1 = new TextBook(444, "18/08/2019", 70000, 39, "NXB KHTN", true);
		TextBook oop = new TextBook(555, "03/12/2020", 53000, 67, "NXB ATTT", true);

		ReferenceBook humanity = new ReferenceBook(1111, "30/01/2017", 120000, 43, "NXB TT", 10);
		ReferenceBook community = new ReferenceBook(2222, "04/11/2019", 89000, 101, "NXB Giáo Dục", 20);
		ReferenceBook cook = new ReferenceBook(3333, "31/03/2021", 67500, 122, "NXB XH", 25.5f);

		sohoLib.addBook(math1);
		sohoLib.addBook(math2);
		sohoLib.addBook(algorithm);
		sohoLib.addBook(java1);
		sohoLib.addBook(oop);
		sohoLib.addBook(humanity);
		sohoLib.addBook(community);
		sohoLib.addBook(cook);

		System.out.println(sohoLib);

		System.out.println("Input the publisher name to find books:");
		strInput = sc.nextLine();
		sohoLib.findBooksByPublisher(strInput);
		System.out.println("Finished!");
	}
}
