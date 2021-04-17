package com.ttlecom.inheritanceAndPolymorphism;

public class B3 {
	private static final TransactionMarket vnExchange = new TransactionMarket();
	public static void main(String[] args) {
		Transaction gold1 = new GoldTransaction(111, "23/01/2018", 4350, GoldType.K9999);
		Transaction gold2 = new GoldTransaction(222, "12/04/2019", 12, GoldType.K18);
		Transaction gold3 = new GoldTransaction(333, "31/12/2020", 4, GoldType.K24);
		Transaction gold4 = new GoldTransaction(333, "20/09/2017", 9872, GoldType.K24);
		Transaction gold5 = new GoldTransaction(555, "05/02/2021", 8371, GoldType.K9999);

		Transaction dollar1 = new DollarTransaction(666, "30/03/2021", 550000, 1200000000, DollarType.EURO);
		Transaction dollar2 = new DollarTransaction(666, "10/12/2019", 2345000, 200000000, DollarType.EURO);
		Transaction dollar3 = new DollarTransaction(888, "20/02/2019", 4, 1100, DollarType.EURO);
		Transaction dollar4 = new DollarTransaction(999, "13/10/2020", 12310000, 1541000000, DollarType.EURO);
		Transaction dollar5 = new DollarTransaction(101, "03/09/2020", 52300000, 2113555000, DollarType.EURO);
		Transaction dollar6 = new DollarTransaction(102, "09/08/2018", 412000, 31000000, DollarType.EURO);

		vnExchange.addTransaction(gold1);
		vnExchange.addTransaction(gold2);
		vnExchange.addTransaction(gold3);
		vnExchange.addTransaction(gold4);
		vnExchange.addTransaction(gold5);
		vnExchange.addTransaction(dollar1);
		vnExchange.addTransaction(dollar2);
		vnExchange.addTransaction(dollar3);
		vnExchange.addTransaction(dollar4);
		vnExchange.addTransaction(dollar5);
		vnExchange.addTransaction(dollar6);

		System.out.println(vnExchange);

		System.out.println(vnExchange.filterTransactionByAmountGreaterThan1B());
		System.out.println("Finished!");
	}
}
