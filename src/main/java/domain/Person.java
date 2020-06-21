package domain;

import java.util.ArrayList;
import java.util.HashMap;

import domainExceptions.DuplicateObjectExcpetion;
import domainExceptions.InvalidRequestException;

public class Person {

	public enum PersonRideStatus {
		DORMANT, ON_A_RIDE
	}

	public static HashMap<String, Person> persons;

	static {
		if (persons == null) {
			persons = new HashMap<>();
		}
	}

	String _id;
	// Since a name can be too common, we assign an id to every user.
	// The user inevitably will have a UI layer between herself and the system.
	// This layer can be made to Proffer the id instead of the name.
	// Not going to use it here because the interface is where we enter the names.

	String name;
	ArrayList<PrOffer> offers;
	ArrayList<Request> requests;
	Ride currentRide;
	PersonRideStatus status;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<PrOffer> getOffers() {
		if (offers == null) {
			offers = new ArrayList<PrOffer>();
		}
		return offers;
	}

	public void setOffers(ArrayList<PrOffer> offers) {
		this.offers = offers;
	}

	public ArrayList<Request> getRequests() {
		if (requests == null) {
			requests = new ArrayList<Request>();
		}
		return requests;
	}

	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}

	public Ride getCurrentRide() {
		return currentRide;
	}

	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}

	public PersonRideStatus getStatus() {
		return status;
	}

	public void setStatus(PersonRideStatus status) {
		this.status = status;
	}

	public Person(String name) throws InvalidRequestException {
		super();
		if (name == null) {
			throw new InvalidRequestException("Name is a required field");

		}
		this.name = name;
		this._id = name + System.currentTimeMillis();
	}

	public static void createANewUser(String name) throws DuplicateObjectExcpetion {
		try {
			Person person = new Person(name);
			if (persons.containsKey(name))
				throw new DuplicateObjectExcpetion("Person with name " + name + " already exists");
			persons.put(name, person);
		} catch (InvalidRequestException e) {
			return;
		}

	}

}
