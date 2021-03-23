package com.ttlecom;

public class B6 {
	public static void main(String[] args) {
		Account ttl = new Account();
		Account pp = new Account(0, "", 10000);
		Account kk = new Account(998439, "Nguyễn Phong Khang");
		Account uu = new Account(423456, "Cao Nguyên Khánh", 1000000);

		System.out.println(ttl.toString());
		System.out.println(pp.toString());
		System.out.println(kk.toString());
		System.out.println(uu.toString());

		// deposit
		System.out.println("Deposit by Khang");
		kk.deposit(1500000);
		System.out.println(kk.toString());
		System.out.println("Deposit by Khánh");
		uu.deposit(530000);
		System.out.println(uu.toString());

		// withdraw
		System.out.println("Withdraw by Khang");
		kk.withdraw(250000);
		System.out.println(kk.toString());

		// get interest
		System.out.println("Get interest by Khánh");
		uu.addInterest();
		System.out.println(uu.toString());

		// transfer money from Khang to Khánh
		System.out.println("Khanh transfer 250,000 VND to Khánh");
		kk.transfer(uu, 250000);
		System.out.println("Khanh account after transferring");
		System.out.println(kk.toString());
		System.out.println("Khanh account after receiving new amount");
		System.out.println(uu.toString());
	}
}
