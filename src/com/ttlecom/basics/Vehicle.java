package com.ttlecom.basics;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Vehicle {
	private String owner;
	private String type;
	private long value;
	private int cylinder;

	public Vehicle() {
		this.owner = "[OWNERLESS]";
		this.type = "[NOT SPECIFIED]";
		this.value = 0;
		this.cylinder = 0;
	}

	public Vehicle(String owner, String type, long value, int cylinder) {
		setOwner(owner);
		setType(type);
		setValue(value);
		setCylinder(cylinder);
	}

	public String getOwner() {
		return owner;
	}

	public String getType() {
		return type;
	}

	public long getValue() {
		return value;
	}

	public int getCylinder() {
		return cylinder;
	}

	public void setOwner(String owner) {
		if (owner != null) {
			this.owner = owner;
			return;
		}
		this.owner = "[OWNERLESS]";
	}

	public void setType(String type) {
		if (type != null) {
			this.type = type;
			return;
		}
		this.type = "[NOT SPECIFIED]";
	}

	public void setValue(long value) {
		if (value < 0) {
			this.value = 0;
			return;
		}
		this.value = value;
	}

	public void setCylinder(int cylinder) {
		if (cylinder < 0) {
			this.cylinder = 0;
			return;
		}
		this.cylinder = cylinder;
	}

	public double calculateTax() {
		if (getCylinder() < 100) {
			return (1.0 / 100) * getValue();
		} else if (getCylinder() <= 200) {
			return (3.0 / 100) * getValue();
		} else {
			return (5.0 / 100) * getValue();
		}
	}

	@Override
	public String toString() {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		symbols.setGroupingSeparator(',');
		formatter.setDecimalFormatSymbols(symbols);
		return String.format("%-25s %-35s %,20d %,20d %,20.2f%n", getOwner(), getType(), getCylinder(), getValue(), calculateTax());
	}
}
