package com.ttlecom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class B9 {
	private static final WorkerList companyA = new WorkerList();
	private static final ArrayList<String> firstnames = new ArrayList<>(Arrays.asList(
					"Tín", "Thành", "Cường", "Anh", "Bé",
					"Xương", "Cúc", "Lan", "Xuân", "Hương",
					"Khánh", "Lợi", "Tâm", "Cương", "Hồng",
					"Thắm", "Phong", "Khang", "Tống", "Tự",
					"Lâm", "Nhung", "Đức", "Nhật", "Nhựt",
					"Nhất", "Thống", "Long", "Hà", "Phát"
	));
	private static final LinkedList<String> lastnames = new LinkedList<>(Arrays.asList(
					"Lê", "Nguyễn", "Cung", "Hồ", "Bá",
					"Cao", "Lý", "Phạm", "Đặng", "Bùi",
					"Đỗ", "Ngô", "Dương", "Phan", "Vũ"
	));

	private static final int companySize = 20;

	public static void main(String[] args) {
		Worker w1 = new Worker();

		System.out.println(w1.toString());


		// initialize default workers
		initializeList();

		// check the number of workers
		System.out.println("The number of workers: " + companyA.countWorkers());

		// filter workers have more than 200 products
		System.out.println("Show workers have more than 200 products:");
		printWorkers(companyA.getWorkersByFilter(200));

		// after soring by no. of products
		System.out.println("The woker list after sorting by no. of products:");
		companyA.sortWorkersByNumberOfProducts();
		printWorkers(companyA);
	}

	private static void initializeList() {
		companyA.initializeWorkers(companySize);

		// input firstnames
		for (Worker wk : companyA.getWorkers()) {
			AtomicInteger randomIndex = new AtomicInteger((int) Math.floor(Math.random() * firstnames.size()));
			wk.setFirstname(firstnames.get(randomIndex.get()));
		}

		// input lastnames
		for (Worker wk : companyA.getWorkers()) {
			AtomicInteger randomIndex = new AtomicInteger((int) Math.floor(Math.random() * lastnames.size()));
			wk.setLastname(lastnames.get(randomIndex.get()));
		}

		// input number of products
		for (Worker wk : companyA.getWorkers()) {
			AtomicInteger randomNum = new AtomicInteger((int) Math.floor(Math.random() * (500 - 150)) + 150);
			wk.setNumberOfProducts(randomNum.get());
		}
	}

	private static void printWorkers(WorkerList wks) {
		System.out.println(wks.toString());
	}
}
