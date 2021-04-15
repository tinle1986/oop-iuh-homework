package com.ttlecom.inheritanceAndPolymorphism;

public class Exam01 {
	private final static TransportationCompany khaihoan = new TransportationCompany();

	public static void main(String[] args) {
		TruckType eightTon = TruckType.EIGHTTON;
		Vehicle truck1 = new Truck(1111, "M12-5432", "Lê Văn Tùng", 123400, -8, eightTon);
		Vehicle truck2 = new Truck(2222, "K34-1235", "Võ Văn Hưởng", 123000, 6, TruckType.SIXTEENTON);
		Vehicle truck3 = new Truck(3333, "X63-8394", "Xương Cao Tứ", 471620, 18, TruckType.SIXTEENTON);
		Vehicle truck4 = new Truck(4444, "F92-9812", "Lê Bá Tú", 375000, 18, TruckType.EIGHTTON);
		Vehicle truck5 = new Truck(5555, "U22-3132", "Trần Đình Phương", 128000, 7, TruckType.EIGHTTON);
		Vehicle truck6 = new Truck(6666, "L98-2351", "Hồ Quốc Ba", 89500, -10, TruckType.SIXTEENTON);

		Vehicle bus1 = new Bus(7777, "M43-4321", "Cao Hùng Dũng", 10, 120000);
		Vehicle bus2 = new Bus(8888, "R31-9981", "Lương Đình Toàn", 25, 150000);
		Vehicle bus3 = new Bus(9999, "D34-1309", "Tào Hồ Lĩnh", 60, 220000);
		Vehicle bus4 = new Bus(1010, "S34-1109", "Ngô Chương", 48, 220000);


//		System.out.println(truck1);

		khaihoan.addVehicle(truck1);
		khaihoan.addVehicle(truck5);
		khaihoan.addVehicle(truck3);
		khaihoan.addVehicle(truck4);
		khaihoan.addVehicle(truck6);
		khaihoan.addVehicle(truck2);
		khaihoan.addVehicle(truck2);

		khaihoan.addVehicle(bus3);
		khaihoan.addVehicle(bus1);
		khaihoan.addVehicle(bus2);
		khaihoan.addVehicle(bus1);

		System.out.println(khaihoan);

		khaihoan.removeVehicle(bus2);
		khaihoan.removeVehicle(bus4);

		System.out.println("The vehicle list after removing:".toUpperCase());
		System.out.println(khaihoan);

		System.out.println("The list after sorting by route id:");
		khaihoan.sortVehicleListByRouteId();
		System.out.println(khaihoan);

		System.out.println("The list after sorting by driver name:");
		khaihoan.sortVehicleListByDriverNameDesc();
		System.out.println(khaihoan);

		System.out.println("The list after separating by type:");
		System.out.println(khaihoan.toStringByType());
		System.out.println("Finished!");
	}
}
