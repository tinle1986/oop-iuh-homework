package com.ttlecom;

public class CD {
	private int id;
	private String title;
	private int numberOfTracks;
	private float price;

	public CD(int id, String title, int numberOfTracks, float price) {
		setId(id);
		setTitle(title);
		setNumberOfTracks(numberOfTracks);
		setPrice(price);
	}

	public CD() {
		this(0, null, 0, 0);
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	public float getPrice() {
		return price;
	}

	public void setId(int id) {
		if (id <= 0 || id > 999999) {
			this.id = 999999;
		} else {
			this.id = id;
		}
	}

	public void setTitle(String title) {
		if (title == null || title.isEmpty()) {
			this.title = "undefined";
		} else {
			this.title = title;
		}
	}

	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = Math.max(numberOfTracks, 0);
	}

	public void setPrice(float price) {
		this.price = Math.max(price, 0);
	}

	@Override
	public String toString() {
		return String.format("%10d %20s %10d %16f", getId(), getTitle(), getNumberOfTracks(), getPrice());
	}
}
