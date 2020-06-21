package domain;

public class VehicleMap {
	String model;
	int numberOfTotalVehicles;
	int numberOfAvailableVehicles;

	public VehicleMap(String model, int numberOfTotalVehicles, int numberOfAvailableVehicles) {
		super();
		this.model = model;
		this.numberOfTotalVehicles = numberOfTotalVehicles;
		this.numberOfAvailableVehicles = numberOfAvailableVehicles;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumberOfTotalVehicles() {
		return numberOfTotalVehicles;
	}

	public void setNumberOfTotalVehicles(int numberOfTotalVehicles) {
		this.numberOfTotalVehicles = numberOfTotalVehicles;
	}

	public int getNumberOfAvailableVehicles() {
		return numberOfAvailableVehicles;
	}

	public void setNumberOfAvailableVehicles(int numberOfAvailableVehicles) {
		this.numberOfAvailableVehicles = numberOfAvailableVehicles;
	}

}