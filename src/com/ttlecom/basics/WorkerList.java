package com.ttlecom.basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerList {
	private final ArrayList<Worker> workers;

	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	public WorkerList getWorkersByFilter(int numOfProd) {
		WorkerList workerList = new WorkerList();
		for(Worker wk: workers) {
			if (wk.getNumberOfProducts() > numOfProd) {
				workerList.addWorker(wk);
			}
		}
		return workerList;
	}

	public void sortWorkersByNumberOfProducts() {
		this.workers.sort(Worker.numberOfProductsComparator);
	}

	public int countWorkers() {
		return this.workers.size();
	}

	public boolean addWorker(Worker wk) {
		if (isNotDuplicate(wk.getId())) {
			this.workers.add(wk);
			return true;
		}
		return false;
	}

	public void initializeWorkers(int size) {
		AtomicInteger count = new AtomicInteger(1);
		AtomicInteger randomId = new AtomicInteger();

		while (count.get() <= size) {
			randomId.set((int) Math.floor(Math.random() * 999999) + 1);
			Worker wk = new Worker(randomId.get(), null, null, 0);
			if (addWorker(wk)) {
				count.getAndIncrement();
			}
		}
	}

	private boolean isNotDuplicate(int newId) {
		Set<Integer> workerSet = new HashSet<>();
		AtomicBoolean isAbleToAdd = new AtomicBoolean(true);

		if (this.workers.size() > 0) {
			for (Worker wk : this.workers) {
				workerSet.add(wk.getId());
			}
			if (!workerSet.add(newId)) {
				isAbleToAdd.set(false);
			}
		}
		return isAbleToAdd.get();
	}

	public WorkerList() {
		workers = new ArrayList<>();
	}

	@Override
	public String toString() {
		AtomicInteger order = new AtomicInteger();
		StringBuilder workersString = new StringBuilder();
		for (Worker wk : this.workers) {
			order.getAndIncrement();
			String wkString = String.format("No.: %-6d Id: %010d     Firstname: %-20s Lastname: %-20s No. of products: %-16d Salary: %-,20.2f%n", order.get(), wk.getId(), wk.getFirstname(), wk.getLastname(), wk.getNumberOfProducts(), wk.getSalary());
			workersString.append(wkString);
		}
		return workersString.toString();
	}
}
