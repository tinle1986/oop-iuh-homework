package com.ttlecom.inheritanceAndPolymorphism;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TransactionMarket {
	private final ArrayList<Transaction> transactionList;

	public TransactionMarket() {
		transactionList = new ArrayList<>();
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public void addTransaction(Transaction transaction) {
		if (isDuplicate(transaction.getId())) {
			System.out.printf("Transaction id %d is duplicate, cannot add the new transaction!%n", transaction.getId());
		} else {
			this.transactionList.add(transaction);
			System.out.printf("Added transaction (%d) successfully!%n", transaction.getId());
		}
	}

	private boolean isDuplicate(int newId) {
		Set<Integer> set = new HashSet<>();
		if (getTransactionList().size() > 0) {
			for (Transaction t : getTransactionList()) {
				set.add(t.getId());
			}
			return !set.add(newId);
		}
		return false;
	}

	public double getTotalAmount(TransactionType transactionType) {
		double total = 0;
		if (transactionType == TransactionType.GOLD) {
			for (Transaction t : getTransactionList()) {
				if (t instanceof GoldTransaction) {
					total += t.getPrice();
				}
			}
		} else {
			for (Transaction t : getTransactionList()) {
				if (t instanceof DollarTransaction) {
					total += t.getPrice();
				}
			}
		}
		return total;
	}

	public double getAverageAmount(TransactionType transactionType) {
		int count = 0;
		if (transactionType == TransactionType.GOLD) {
			for (Transaction t : getTransactionList()) {
				if (t instanceof GoldTransaction) {
					count++;
				}
			}
			return getTotalAmount(transactionType) / count;
		} else {
			for (Transaction t : getTransactionList()) {
				if (t instanceof DollarTransaction) {
					count++;
				}
			}
			return getTotalAmount(transactionType) / count;
		}
	}

	public String filterTransactionByAmountGreaterThan1B() {
		int index = 1;
		StringBuilder result = new StringBuilder("TRANSACTION LIST HAVING AMOUNT GREATER THAN 1B:\n");
		for (Transaction t : getTransactionList()) {
			if (t.getPrice() > 1000000000) {
				result.append(String.format("%d. ", index++)).append(t);
			}
		}
		return result.toString();
	}

	@Override
	public String toString() {
		int goldIndex = 1, dollarIndex = 1;
		StringBuilder strGold = new StringBuilder("GOLD TRANSACTIONS:\n");
		StringBuilder strDollar = new StringBuilder("DOLLAR TRANSACTIONS:\n");
		for (Transaction t : getTransactionList()) {
			if (t instanceof GoldTransaction) {
				strGold.append(String.format("%d. ", goldIndex++)).append(t);
			} else {
				strDollar.append(String.format("%d. ", dollarIndex++)).append(t);
			}
		}
		strGold.append(String.format(". Total amount: %,.2f VND%n" +
						". Average amount: %,.2f VND%n", getTotalAmount(TransactionType.GOLD), getAverageAmount(TransactionType.GOLD)));
		strDollar.append(String.format(". Total amount: %,.2f VND%n" +
						". Average amount: %,.2f VND%n", getTotalAmount(TransactionType.DOLLAR), getAverageAmount(TransactionType.DOLLAR)));
		return String.format("GOLD AND MONEY EXCHANGE: " +
						"TOTAL VALUE: %,.2f VND%n", (getTotalAmount(TransactionType.GOLD) + getTotalAmount(TransactionType.DOLLAR))) + strGold + strDollar;
	}
}
