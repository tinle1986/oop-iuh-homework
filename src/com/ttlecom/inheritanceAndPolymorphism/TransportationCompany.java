package com.ttlecom.inheritanceAndPolymorphism;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class TransportationCompany {
	private final ArrayList<Vehicle> vehicleList;

	public TransportationCompany() {
		vehicleList = new ArrayList<>();
	}

	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void addVehicle(Vehicle vehicle) {
		if (isDuplicateVehicle(vehicle.getRouteId())) {
			System.out.printf("Route Id %d is duplicate, cannot be added!%n", vehicle.getRouteId());
		} else {
			this.vehicleList.add(vehicle);
			System.out.printf("Added Route Id %d successfully!%n", vehicle.getRouteId());
		}
	}

	public void removeVehicle(Vehicle vehicle) {
		if (getVehicleList() != null) {
			if (this.vehicleList.remove(vehicle)) {
				System.out.printf("Removed vehicle with Route Id %d successfully!%n", vehicle.getRouteId());
				return;
			}
		}
		System.out.printf("The vehicle with Route Id %d is not valid, nothing removed!%n", vehicle.getRouteId());
	}

	private boolean isDuplicateVehicle(int newId) {
		Set<Integer> vehicleListSet = new HashSet<>();
		if (getVehicleList().size() > 0) {
			for (Vehicle vehicle : getVehicleList()) {
				vehicleListSet.add(vehicle.getRouteId());
			}
			return !vehicleListSet.add(newId);
		}
		return false;
	}

	public float getTruckRevenueTotal() {
		float result = 0;

		for (Vehicle vehicle : getVehicleList()) {
			if (vehicle instanceof Truck) {
				result += vehicle.getRevenue();
			}
		}
		return result;
	}

	public float getBusRevenueTotal() {
		float result = 0;
		for (Vehicle v : getVehicleList()) {
			if (v instanceof Bus) {
				result += v.getRevenue();
			}
		}
		return result;
	}

	public void sortVehicleListByRouteId() {
		this.vehicleList.sort(Comparator.comparingInt(Vehicle::getRouteId));
	}

	public void sortVehicleListByRouteIdDesc() {
		this.vehicleList.sort((v1, v2) -> v2.getRouteId() - v1.getRouteId());
	}

	public void sortVehicleListByDriverName() {
		this.vehicleList.sort(Comparator.comparing(Vehicle::getDriverName));
	}

	public void sortVehicleListByDriverNameDesc() {
		this.vehicleList.sort((v1, v2) -> v2.getDriverName().compareTo(v1.getDriverName()));
	}

	@Override
	public String toString() {
		int index = 1;
		StringBuilder vehicleList = new StringBuilder("KHAI HOAN COMPANY - VEHICLE LIST:\n");
		for (Vehicle vehicle : getVehicleList()) {
			vehicleList.append(String.format("%d. ", index)).append(vehicle.toString());
			index++;
		}
		return vehicleList.toString();
	}

	public String toStringByType() {
		int truckIndex = 1;
		int busIndex = 1;
		StringBuilder truckList = new StringBuilder("TRUCK:\n");
		StringBuilder busList = new StringBuilder("BUS:\n");
		for (Vehicle v : getVehicleList()) {
			if (v instanceof Truck) {
				truckList.append(String.format("%d. ", truckIndex)).append(v);
				truckIndex++;
			} else if (v instanceof Bus) {
				busList.append(String.format("%d. ", busIndex)).append(v);
				busIndex++;
			}
		}
		truckList.append(String.format(". Total revenue: %,.2f VND%n", getTruckRevenueTotal()));
		busList.append(String.format(". Total revenue: %,.2f VND%n", getBusRevenueTotal()));
		return "KHAI HOAN COMPANY - VEHICLE LIST:\n" + String.format("TOTAL REVENUE: %,.2f VND%n", getBusRevenueTotal() + getTruckRevenueTotal()) + truckList + busList;
	}
}
