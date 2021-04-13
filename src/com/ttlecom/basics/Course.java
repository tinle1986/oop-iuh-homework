package com.ttlecom.basics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicBoolean;

public class Course {
	private String name;
	private LocalDate startDate;
	private float numberOfMonths;

	public Course(String name, LocalDate startDate, float numberOfMonths) {

		this.name = name;
		this.startDate = startDate;
		this.numberOfMonths = numberOfMonths;
	}

	public String getName() {
		return name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public float getNumberOfMonths() {
		return numberOfMonths;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setNumberOfMonths(float numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	public LocalDate getFinishDate() {
		return this.getStartDate().plusDays(Math.round(getNumberOfMonths() * 30));
	}

	@Override
	public String toString() {
		return String.format("%s%n" +
						". Start date: %s%n" +
						". End date: %s%n" +
						". Status: %s%n", getName().toUpperCase(), formatDate(getStartDate()), formatDate(getFinishDate()), getStatus());
	}

	private String formatDate(LocalDate localDate) {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate);
	}

	public String getStatus() {
		AtomicBoolean isStarted = new AtomicBoolean(false);
		AtomicBoolean isFinished = new AtomicBoolean(false);
		if (LocalDate.now().isAfter(getFinishDate())) {
			isFinished.set(true);
			isStarted.set(true);
		} else {
			if (LocalDate.now().isAfter(getStartDate())) {
				isStarted.set(true);
			}
		}
		if (!isStarted.get()) {
			return "Not started yet";
		} else {
			if (!isFinished.get()) {
				return "In progress";
			} else {
				return "Finished";
			}
		}
	}
}
