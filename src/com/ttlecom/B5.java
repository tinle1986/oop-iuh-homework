package com.ttlecom;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class B5 {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date1 = "31/01/2022";
		String date2 = "31/12/2019";

		Food apple = new Food("US Apple", 93000, LocalDate.parse(date1, dtf), LocalDate.parse(date2, dtf));
		Food vegetable = new Food();
		Food pineapple = new Food("Pine Apple", 58000, LocalDate.parse("23/01/2020", dtf), LocalDate.parse("31/12/2021", dtf));
		Food milk = new Food("Ong Tho Condensed Milk", 15000, LocalDate.parse("15/01/2019", dtf), LocalDate.parse("31/12/2020", dtf));
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-6s %-30s %25s %20s %20s %16s%n", "Code", "Product Name", "Price", "Manufacture Date", "Expiration Date", "Notes");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println(apple.toString());
		System.out.println(vegetable.toString());
		System.out.println(pineapple.toString());
		System.out.println(milk.toString());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
}
