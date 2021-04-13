package com.ttlecom.inheritanceAndPolymorphism;

public class B1 {
	private static final TravelCompany vnTrip = new TravelCompany();
	public static void main(String[] args) {
		UrbanTrip urbanTrip1 = new UrbanTrip(111, "Tèo Nguyễn", "K6M2", 20, 540);
		UrbanTrip urbanTrip2 = new UrbanTrip(222, "Cường Lê", "M52L", 22, 621);
		UrbanTrip urbanTrip3 = new UrbanTrip(333, "Sính Hồ", "UF43", 31, 538);

		SuburbanTrip suburbanTrip1 = new SuburbanTrip(1111, "Phú Trần", "WD32", "Independent Palace", 2);
		SuburbanTrip suburbanTrip2 = new SuburbanTrip(2222, "Lý Ngô", "DS34", "Dalat Market", 5);
		SuburbanTrip suburbanTrip3 = new SuburbanTrip(3333, "Thảo Lê", "4DFL", "Dam Sen Park", 3);
		SuburbanTrip suburbanTrip4 = new SuburbanTrip(4444, "Hà Cao", "VC3N", "Tan Son Nhat Airport", 1);
		SuburbanTrip suburbanTrip5 = new SuburbanTrip(5555, "Tùng Lý", "423D", "Sword Lake", 7);

		vnTrip.addUrbanTrip(urbanTrip1);
		vnTrip.addUrbanTrip(urbanTrip2);
		vnTrip.addUrbanTrip(urbanTrip3);
		vnTrip.addSuburbanTrip(suburbanTrip1);
		vnTrip.addSuburbanTrip(suburbanTrip2);
		vnTrip.addSuburbanTrip(suburbanTrip3);
		vnTrip.addSuburbanTrip(suburbanTrip4);
		vnTrip.addSuburbanTrip(suburbanTrip5);

		System.out.println(vnTrip);
		System.out.println("Finished!");

	}
}
