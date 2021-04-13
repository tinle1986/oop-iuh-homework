package com.ttlecom.inheritanceAndPolymorphism;

import java.util.ArrayList;

public class Library {
	private final ArrayList<Book> bookList;

	public Library() {
		bookList = new ArrayList<>();
	}

	public void addBook(Book book) {
		this.bookList.add(book);
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	@Override
	public String toString() {
		int countRefBooks = 0;
		float totalRefBookPrices = 0;
		float totalRefBookUnitPrices = 0;
		float totalTxtBookPrices = 0;
		StringBuilder txtBookDetails = new StringBuilder();
		StringBuilder refBookDetails = new StringBuilder();

		for (Book book : getBookList()) {
			if (book instanceof TextBook) {
				totalTxtBookPrices += ((TextBook) book).getPrice();
				txtBookDetails.append(". ").append(book);
			} else {
				totalRefBookPrices += ((ReferenceBook) book).getPrice();
				totalRefBookUnitPrices += book.getUnitPrice();
				countRefBooks++;
				refBookDetails.append(". ").append(book);
			}
		}
		return "Text books:\n".toUpperCase() + txtBookDetails +
						String.format(". Text book total value: %,.2f VND%n", totalTxtBookPrices) + "Reference books:\n".toUpperCase() + refBookDetails +
						String.format(". Reference book total value: %,.2f VND%n", totalRefBookPrices) +
						String.format(". Average unit price: %,.2f VND%n", (totalRefBookUnitPrices / countRefBooks));
	}

	public void findBooksByPublisher(String publisherName) {
		StringBuilder result = new StringBuilder();
		for(Book book: getBookList()) {
			if (book.getPublisher().equalsIgnoreCase(publisherName)) {
				result.append(". ").append(book);
			}
		}
		if (result.isEmpty()) {
			System.out.println("Cannot find any book by Publisher " + publisherName.toUpperCase());
		}
		System.out.println(result);
	}
}
