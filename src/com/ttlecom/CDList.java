package com.ttlecom;

import java.util.*;

public class CDList {
	private LinkedList<CD> cdList;

	public CDList() {
		cdList = new LinkedList<>();
	}

	public LinkedList<CD> getCdList() {
		return cdList;
	}

	public void sortCdListByTitleAsc() {
		Collections.sort(this.cdList, CD.titleComparator);
	}

	public void sortCdListByPriceDesc() {
		Collections.sort(this.cdList, new Comparator<CD>() {
			@Override
			public int compare(CD o1, CD o2) {
				// descending order
				return (int) (o2.getPrice() - o1.getPrice());

				// ascending order
				// return (int) (o2.getPrice() - o1.getPrice());
			}
		});
	}

	public float getTotalPrice() {
		float totalPrice = 0;
		for (CD cd : this.cdList) {
			totalPrice += cd.getPrice();
		}
		return totalPrice;
	}

	public int countCD() {
		return this.cdList.size();
	}

	public void initializeCDList(int size) {
		int count = 0;
		int randomCode;
		while (count <= size) {
			randomCode = (int) Math.floor(Math.random() * 999999) + 1;
			if (isNotDuplicate(this.cdList, randomCode)) {
				CD cd = new CD(randomCode, null, 0, 0);
				this.cdList.add(cd);
				count++;
			}
		}
	}

	public boolean addCD(CD newCD) {
		if (isNotDuplicate(this.cdList, newCD.getId())) {
			this.cdList.add(newCD);
			System.out.println("Added the new CD successfully!");
			return true;
		}
		System.out.println("Cannot add the new CD because of ID duplicate!");
		return false;
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
		StringBuilder cdListString = new StringBuilder();
		cdListString.append(String.format("%6s   %-35s %12s %15s%n", "ID", "CD Title", "No. of Tracks", "Price"));
		for (CD cd : this.cdList) {
			String cdString = String.format("%06d   %-36s %12d %,15.2f%n", cd.getId(), cd.getTitle(), cd.getNumberOfTracks(), cd.getPrice());
			cdListString.append(cdString);
		}
		return cdListString.toString();
	}
}
