package com.ttlecom;

public class Student3 {
	private String fullname;
	private String address;
	private String phone;

	public Student3(String fullname, String address, String phone) {
		setFullname(fullname);
		setAddress(address);
		setPhone(phone);
	}

	public String getFullname() {
		return fullname;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("%s%n" +
						". Address: %s%n" +
						". Phone number: %s%n", getFullname().toUpperCase(), getAddress() ,getPhone());
	}
}
