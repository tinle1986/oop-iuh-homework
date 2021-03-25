package com.ttlecom;

public class B9 {
	public static void main(String[] args) {
		Worker w1 = new Worker();
		WorkerList companyA = new WorkerList();
		companyA.initializeWorkers(10);

		System.out.println(w1.toString());
		System.out.println(companyA.toString());
	}
}
