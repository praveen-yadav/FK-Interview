package domain;

public class Request {
	
	String personName;
	Location origin;
	Location destination; 
	int numberOfSeatsAvailable; 
	SelectionStrategy strategy;
	
	
	
	
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
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
	public int getNumberOfSeatsAvailable() {
		return numberOfSeatsAvailable;
	}
	public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
	}
	public SelectionStrategy getStrategy() {
		return strategy;
	}
	public void setStrategy(SelectionStrategy strategy) {
		this.strategy = strategy;
	}
	
	
}
