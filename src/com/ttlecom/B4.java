package com.ttlecom;

import java.util.Scanner;

public class B4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strInput;
		int intInput;
		Vehicle wavezx = new Vehicle("Trần Bảo Cường", "Honda Wave ZX", 17500000, 100);
		Vehicle airblade = new Vehicle("Lê Trung Tín", "Honda Air Blade Black Red", 47000000, 125);
		Vehicle nvx = new Vehicle("Lê Hữu Phát", "Yamaha NVX 150 Black", 57000000, 150);
		Vehicle innova = new Vehicle(null, null , -10, 1000);

		System.out.println("Input the owner name of Innova:");
		strInput = sc.nextLine();
		innova.setOwner(strInput);
		System.out.println("Input the type of Innova:");
		strInput = sc.nextLine();
		innova.setType(strInput);
		System.out.println("Input the value of Innova:");
		intInput = Integer.parseInt(sc.nextLine());
		innova.setValue(intInput);

		System.out.printf("%-25s %-35s %20s %20s %20s%n", "Owner Name", "Vehicle Type", "Cylinder", "Value", "Tax");
		System.out.println("============================================================================================================================");
		System.out.println(wavezx.toString());
		System.out.println(airblade.toString());
		System.out.println(nvx.toString());
		System.out.println(innova.toString());
	}
}
