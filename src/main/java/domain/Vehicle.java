package domain;

import java.util.HashMap;

public class Vehicle {

	public enum VehicleStatus {
		ON_TRIP, AVAILABLE
	}

	public static HashMap<String, Vehicle> vehicles;
						//number, vehicle
	// This is the in memory DS to simulate a DB.

	public static HashMap<String, VehicleMap> vehicleMap;
						//Model , VehicleMap
	// This is an optimization

	static {
		if (vehicleMap == null)
			vehicleMap = new HashMap<>();
		if (vehicles == null)
			vehicles = new HashMap<>();
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", number=" + number + ", vehicleStatus=" + vehicleStatus + ", ownerId="
				+ ownerId + ", vehicleClass=" + vehicleClass + "]";
	}

	String model;
	String number;
	VehicleStatus vehicleStatus;
	String ownerId;

	String vehicleClass;
	// This field is not required in the question, but it should be. This will help
	// in implementing different classes of rides;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public Vehicle(String model, String number, String ownerId) {
		super();
		this.model = model;
		this.number = number;
		this.ownerId = ownerId;
		this.vehicleStatus = VehicleStatus.AVAILABLE;
	}

	public static void createVehicle(String ownerId, String number, String model) {
		Vehicle vehicle = new Vehicle(model, number, ownerId);
		if(vehicleMap.containsKey(model)) {
			VehicleMap map = vehicleMap.get(model);
			map.setNumberOfTotalVehicles(map.getNumberOfTotalVehicles()+1);
			map.setNumberOfAvailableVehicles(map.getNumberOfAvailableVehicles() + 1);
			vehicleMap.put(model, map);
			vehicles.put(number, vehicle);
		}
		else {
			vehicles.put(number, vehicle);
			vehicleMap.put(model, new VehicleMap(model, 1, 1));
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

}
