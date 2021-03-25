package com.ttlecom;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class B8 {
	public static void main(String[] args) {
		// initialize the list
		int price = 50000;
		List<String> titleList = new LinkedList<>(Arrays.asList(
						"As the spring", "The new beginning",
						"Attack on the titan", "Your light at the sun",
						"You are the world", "Start the new journey",
						"Where are you", "The first going on",
						"Bye bye", "Uptown girls",
						"It's easy to go", "You are the mermaid",
						"Hey boy!", "Too dangerous",
						"What the heck in the internet", "So strange"
		));
		Random random = new Random();

		CD cd1 = new CD();
		CD cd2 = new CD(-10, "", -10, -10);
		CD cd3 = new CD(-10, "", -10, -10);


		CDList seriesA = new CDList();
		seriesA.initializeCDList(10);
		System.out.println(seriesA.toString());
		seriesA.addCD(cd2);
		seriesA.addCD(cd3);

		// set prices
		for (CD cd : seriesA.getCdList()) {
			float randomScale = random.nextFloat() * (5 - 1) + 1;
			cd.setPrice(price * randomScale);
		}

		// set title
		for (CD cd : seriesA.getCdList()) {
			int randomIndex = (int) Math.floor(Math.random() * titleList.size());
			cd.setTitle(titleList.get(randomIndex));
			titleList.remove(randomIndex);
		}


		// set no. of tracks
		for (CD cd: seriesA.getCdList()) {
			int randomNum = (int) Math.floor(Math.random() * (15 - 10)) + 10;
			cd.setNumberOfTracks(randomNum);
		}


		System.out.println(cd1.toString());
		System.out.println(cd2.toString());
		System.out.println(cd3.toString());


		// sort price descending
		System.out.println("After sorting by price descending:");
		seriesA.sortCdListByPriceDesc();
		System.out.println(seriesA.toString());

		System.out.println("After sorting by title ascending");
		seriesA.sortCdListByTitleAsc();
		System.out.println(seriesA.toString());
		
		// summary
		System.out.printf("The number of CDs: %d%n", seriesA.countCDs());
		System.out.printf("The number of tracks: %d%n", seriesA.countTracks());
		System.out.printf("Total price is: %,.2f%n", seriesA.getTotalPrice());
	}
}
