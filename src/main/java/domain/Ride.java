package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Ride {
	public enum RideStatus {
		OFFERED , COMPLETED
	}
	
	public static ArrayList<Ride> rides;
	static {
		if (rides == null) {
			rides = new ArrayList<>();
		}
	}
	
	String ts;
	@Override
	public String toString() {
		return "Ride [ts=" + ts + ", vehicle=" + vehicle + ", driver=" + driver + ", numberOfSeats=" + numberOfSeats
				+ ", status=" + status + ", origin=" + origin + ", destination=" + destination + "]";
	}
	Vehicle vehicle; 
	Person driver;
	ArrayList<Request> requests;
	ArrayList<Person> passengers; 
	int numberOfSeats;
	RideStatus status;
	Location origin, destination;
	
	public RideStatus getStatus() {
		return status;
	}
	public void setStatus(RideStatus status) {
		this.status = status;
	}
	public Location getOrigin() {
		return origin;
	}
	public void setOrigin(Location origin) {
		this.origin = origin;
	}
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Person getDriver() {
		return driver;
	}
	public void setDriver(Person driver) {
		this.driver = driver;
	}
	public ArrayList<Request> getRequests() {
		if (requests == null )
			requests = new ArrayList<>();
		return requests;
	}
	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}
	public ArrayList<Person> getPassengers() {
		if(passengers == null)
			passengers = new ArrayList<>();
		return passengers;
	}
	public void setPassengers(ArrayList<Person> passengers) {
		this.passengers = passengers;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Ride(Vehicle vehicle, Person driver, int numberOfSeats, Location origin, Location destination) {
		super();
		this.ts = System.currentTimeMillis() + "";
		this.vehicle = vehicle;
		this.driver = driver;
		this.numberOfSeats = numberOfSeats;
		this.status = RideStatus.OFFERED;
		this.origin = origin;
		this.destination = destination;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ts == null) ? 0 : ts.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		Ride other = (Ride) obj;
		if (ts == null) {
			if (other.ts != null)
				return false;
		} else if (!ts.equals(other.ts))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}
	
	
	
	
}
