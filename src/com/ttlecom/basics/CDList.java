package com.ttlecom.basics;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CDList {
	private final LinkedList<CD> cdList;

	public CDList() {
		cdList = new LinkedList<>();
	}

	public LinkedList<CD> getCdList() {
		return cdList;
	}

	public void sortCdListByTitleAsc() {
		this.cdList.sort(CD.titleComparator);
	}

	public void sortCdListByPriceDesc() {
		this.cdList.sort((o1, o2) -> {
			// descending order
			return (int) (o2.getPrice() - o1.getPrice());

			// ascending order
			// return (int) (o2.getPrice() - o1.getPrice());
		});
	}

	public float getTotalPrice() {
		float totalPrice = 0;

		for (CD cd : this.cdList) {
			totalPrice += cd.getPrice();
		}
		return totalPrice;
	}

	public int countTracks() {
		AtomicInteger total = new AtomicInteger();
		for (CD cd : this.cdList) {
			total.addAndGet(cd.getNumberOfTracks());
		}
		return total.get();
	}

	public int countCDs() {
		return this.cdList.size();
	}

	public void initializeCDList(int size) {
		AtomicInteger count = new AtomicInteger(1);
		AtomicInteger randomCode = new AtomicInteger();
		while (count.get() <= size) {
			randomCode.set((int) Math.floor(Math.random() * 999999) + 1);
			if (isNotDuplicate(this.cdList, randomCode.get())) {
				CD cd = new CD(randomCode.get(), null, 0, 0);
				this.cdList.add(cd);
				count.getAndIncrement();
			}
		}
	}

	public void addCD(CD newCD) {
		if (isNotDuplicate(this.cdList, newCD.getId())) {
			this.cdList.add(newCD);
			System.out.println("Added the new CD successfully!");
		}
		System.out.println("Cannot add the new CD because of ID duplicate!");
	}

	public boolean isNotDuplicate(LinkedList<CD> cdList, int newId) {
		Set<Integer> store = new HashSet<>();
		boolean isFeasibleToAdd = true;
		if (cdList.size() > 0) {
			for (CD cd : cdList) {
				store.add(cd.getId());
			}
			if (!store.add(newId)) {
				isFeasibleToAdd = false;
			}
		}
		return isFeasibleToAdd;
	}

	@Override
	public String toString() {
		int order = 0;
		StringBuilder cdListString = new StringBuilder();
		cdListString.append(String.format("%6s  %6s   %-45s %12s %15s%n", "No.", "ID", "CD Title", "No. of Tracks", "Price"));
		for (CD cd : this.cdList) {
			order++;
			String cdString = String.format("%6d  %06d   %-46s %12d %,15.2f%n", order, cd.getId(), cd.getTitle(), cd.getNumberOfTracks(), cd.getPrice());
			cdListString.append(cdString);
		}
		return cdListString.toString();
	}
}
