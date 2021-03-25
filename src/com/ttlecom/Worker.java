package com.ttlecom;

public class Worker {
	private int id;
	private String firstname;
	private String lastname;
	private int numberOfProducts;

	public Worker() {
		this(-1, "", null, -1);
	}

	public Worker(int id, String firstname, String lastname, int numberOfProducts) {
		setId(id);
		setFirstname(firstname);
		setLastname(lastname);
		setNumberOfProducts(numberOfProducts);
	}

	public float getSalary() {
		if (getNumberOfProducts() <= 199) {
			return (float) (getNumberOfProducts() * 0.5);
		} else if (getNumberOfProducts() <= 399) {
			return (float) (getNumberOfProducts() * 0.55);
		} else if (getNumberOfProducts() <= 599) {
			return (float) (getNumberOfProducts() * 0.6);
		} else return (float) (getNumberOfProducts() * 0.65);
	}

	public void setId(int id) {
		if (id <= 0) {
			this.id = 999999;
		} else {
			this.id = Math.min(999999, id);
		}
	}

	public void setFirstname(String firstname) {
		if (firstname == null || firstname.isEmpty()) {
			this.firstname = "[SOME_FIRSTNAME]";
		} else {
			this.firstname = firstname;
		}
	}

	public void setLastname(String lastname) {
		if (lastname == null || lastname.isEmpty()) {
			this.lastname = "[SOME_LASTNAME]";
		} else {
			this.lastname = lastname;
		}
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = Math.max(numberOfProducts, 0);
	}

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	@Override
	public String toString() {
		return String.format("Id: %-12d Firstname: %-20s Lastname: %-20s No. of products: %-16d Salary: %-,20.2f%n", getId(), getFirstname(), getLastname(), getNumberOfProducts(), getSalary());
	}
}
