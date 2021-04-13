package com.ttlecom.basics;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private final double interestRate = 0.035;
	private final double feeRate = 0.0035;
	private long accountNumber;
	private String name;
	private double balance;

	public Account() {
		setAccountNumber(0);
		setName("");
		setBalance(0);
	}

	public Account(long accountNumber, String name, double balance) {
		setAccountNumber(accountNumber);
		setName(name);
		setBalance(balance);
	}

	public Account(long accountNumber, String name) {
		setAccountNumber(accountNumber);
		setName(name);
		setBalance(0);
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	private String getName() {
		return name;
	}

	private void setAccountNumber(long accountNumber) {
		if (accountNumber > 0 && accountNumber < 999999) {
			this.accountNumber = accountNumber;
		} else {
			this.accountNumber = 999999;
		}
	}

	private void setName(String name) {
		if (name.isEmpty()) {
			this.name = "[UNKNOWN]";
		} else {
			this.name = name;
		}
	}

	private void setBalance(double balance) {
		if (balance >= 50000) {
			this.balance = balance;
		} else {
			this.balance = 50000;
		}
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
			return true;
		}
		return false;
	}

	public boolean withdraw(double amount) {
		double fee = amount * feeRate;
		if ((fee + amount) <= balance) {
			this.balance -= (fee + amount);
			return true;
		}
		return false;
	}

	public void addInterest() {
		this.balance += (getBalance() * interestRate);
	}

	public boolean transfer(Account dest, double amount) {
		if (amount <= this.balance) {
			this.balance -= amount;
			dest.deposit(amount);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		// use Locale object to set the local currency
		Locale vn = new Locale("vi", "vn");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(vn);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);

		String vnCurrency = numberFormat.format(getBalance());
//		return String.format("Account Number: %-20s Fullname: %-30s Balance: %-,16.2f", getAccountNumber(), getName(), getBalance());
		return String.format("Account Number: %-20s Fullname: %-30s Balance: %-16s", getAccountNumber(), getName(), vnCurrency);
	}
}
