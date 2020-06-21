package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

import domain.Ride.RideStatus;
import domain.Vehicle.VehicleStatus;
import domainExceptions.DuplicateObjectExcpetion;
import domainExceptions.InvalidRequestException;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("this is my first case");
		Driver driver= new Driver();
		try {
			driver.addUser("Rohan");
			driver.addVehicle("Rohan", "Swift", "KA0112345");
		} catch (DuplicateObjectExcpetion e) {
			System.out.println("Rohan is already there");
		} catch (InvalidRequestException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		try {
			driver.addUser("Shasank");
			driver.addVehicle("Shasank", "Baleno", "TS0562395");
		} catch (DuplicateObjectExcpetion e) {
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.addUser("Nandini");
		} catch (DuplicateObjectExcpetion e) {
		}
		try {
			driver.addUser("Shipra");
			driver.addVehicle("Shipra", "Polo", "KA0541491");
			driver.addVehicle("Shipra", "Activa", "KA1212332");
		} catch (DuplicateObjectExcpetion e) {
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.addUser("Gaurav");
		} catch (DuplicateObjectExcpetion e) {
		}
		try {
			driver.addUser("Rahul");
			driver.addVehicle("Rahul", "XUV", "KA051234");
		} catch (DuplicateObjectExcpetion e) {
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// --------- //
		try {
			driver.offerRide("KA0112345", "Rohan", 1, "Hyderabad", "Bangalore");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.offerRide("KA1212332", "Shipra", 1, "Bangalore", "Mysore");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.offerRide("KA0541491", "Shipra", 2, "Bangalore", "Mysore");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.offerRide("TS0562395", "Shasank", 2, "Hyderabad", "Bangalore");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.offerRide("KA051234", "Rahul", 5, "Hyderabad", "Bangalore");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			driver.offerRide("KA0112345", "Rohan", 1, "Hyderabad", "Bangalore");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			System.out.println("\"KA0112345\", \"Rohan\", 1, \"Hyderabad\", \"Bangalore\"");
			e.printStackTrace();
		}
		
		//------- //
		
		try {
			driver.selectRide("Nandini", "Bangalore", "Mysore", 1, "MOST_VACANT", null);
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			driver.selectRide("Gaurav", "Bangalore", "Mysore", 1, "PREFERRED_VEHICLE", "Activa");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.selectRide("Shasank", "Mumbai", "Bangalore", 1, "MOST_VACANT", null);
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.selectRide("Rohan", "Hyderabad", "Bangalore", 1, "PREFERRED_VEHICLE", "Baleno");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.selectRide("Shasank","Hyderabad", "Bangalore", 1, "PREFERRED_VEHICLE", "Polo");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		------//
		
		try {
			driver.endRide("KA0112345");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.endRide("KA1212332");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.endRide("KA0541491");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.endRide("TS0562395");
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.printRideStatus();
		System.out.println("all Ok");
	}
		

	public boolean offerRide(String vehicleNumber, String ownerName, int numberOfSeatsAvailable, String origin,
			String Destination) throws InvalidRequestException {
		if (numberOfSeatsAvailable < 1) {
			throw new InvalidRequestException("You need to offer at least 1 seat");
		}
		if (!Vehicle.vehicles.containsKey(vehicleNumber)) {
			throw new InvalidRequestException("The given vehicle does not exist");
		}
		Vehicle vehicle = Vehicle.vehicles.get(vehicleNumber);
//		System.out.println(vehicle.toString());
		if (!vehicle.getOwnerId().equals(ownerName)) {
			throw new InvalidRequestException("The given vehicle does not belong to this owner");
		}
		if (vehicle.getVehicleStatus().equals(Vehicle.VehicleStatus.ON_TRIP)) {
			throw new InvalidRequestException("This vehicle is on a trip");
		}
		vehicle.setVehicleStatus(VehicleStatus.ON_TRIP);
		if (!Person.persons.containsKey(ownerName)) {
			throw new InvalidRequestException("This person does not exist");
		}
		Person owner = Person.persons.get(ownerName);
		Location originLoc;
		if (!Location.locations.containsKey(origin)) {
			Location.locations.put(origin, new Location(origin));
		}
		originLoc = Location.locations.get(origin);

		Location destinationLoc;
		if (!Location.locations.containsKey(Destination))
			Location.locations.put(Destination, new Location(Destination));
		destinationLoc = Location.locations.get(Destination);
		PrOffer proffer = new PrOffer();
		proffer.setDestination(destinationLoc);
		proffer.setNumberOfSeatsAvailable(numberOfSeatsAvailable);
		proffer.setOrigin(originLoc);
		proffer.setVehicle(vehicle);
		owner.getOffers().add(proffer);
		Ride ride = new Ride(vehicle, owner, numberOfSeatsAvailable, originLoc, destinationLoc);
		Ride.rides.add(ride);
		return true;
	}

	public boolean endRide(String vehicleNumber) throws InvalidRequestException {
		if (!Vehicle.vehicles.containsKey(vehicleNumber)) {
			throw new InvalidRequestException("The given vehicle does not exist");
		}
		Vehicle vehicle = Vehicle.vehicles.get(vehicleNumber);
		if (vehicle.getVehicleStatus().equals(VehicleStatus.AVAILABLE)) {
			throw new InvalidRequestException("The given vehicle is not on a trip");
		}
		vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
		ArrayList<Ride> rideList = (ArrayList<Ride>) new ArrayList<>(Ride.rides).stream().filter(ride -> ride.getStatus().equals(Ride.RideStatus.OFFERED) && ride.getVehicle().equals(vehicle)).collect(Collectors.toList());
		Ride ride = rideList.get(0);
		ride.setStatus(RideStatus.COMPLETED);
		Ride.rides.remove(ride);
		Ride.rides.add(ride);
		return true;

	}
	
	public boolean printRideStatus() {
		HashMap<String, Integer> ridesOffered = new HashMap<>(); 
		HashMap<String, Integer> ridesTaken = new HashMap<>();
		ArrayList<Ride> rides = new ArrayList<>(Ride.rides);
		rides = (ArrayList<Ride>) rides.stream().filter(ride -> ride.getStatus().equals(Ride.RideStatus.COMPLETED)).collect(Collectors.toList());
		System.out.println(rides.size());
		for(Ride ride : rides) {
			if(ridesOffered.containsKey(ride.getDriver().getName()))
				ridesOffered.put(ride.getDriver().getName(), ridesOffered.get(ride.getDriver().getName()) + 1 );
			else
				ridesOffered.put(ride.getDriver().getName(), 1 );
			for(Person passenger : ride.getPassengers()) {
				if(ridesTaken.containsKey(passenger.getName()))
					ridesTaken.put(passenger.getName(), ridesTaken.get(passenger.getName()) + 1 );
				else
					ridesTaken.put(passenger.getName(), 1 );
			}
		}
		HashSet<String> users = new HashSet<>(ridesOffered.keySet());
		users.addAll(ridesOffered.keySet());
		for(Person p : Person.persons.values()) {
			String e = p.getName();
//			System.out.println(e + " "+ ridesTaken.getOrDefault(e, 0) + " Taken " + ridesOffered.getOrDefault(e , 0) + " Offered");
			System.out.println(e + " "+ ridesTaken.getOrDefault(e, 0) + " Taken " + ridesOffered.getOrDefault(e , 0) + " Offered");
		}
		return true;
	}

	public boolean selectRide(String person, String Origin, String Destination, int seats, String strategy,
			String vehicleModel) throws InvalidRequestException {
		if (!Location.locations.containsKey(Destination) || !Location.locations.containsKey(Origin)) {
			return false;
		}
		if (!Person.persons.containsKey(person)) {
			throw new InvalidRequestException("This person does not exist");
		}
		Person requester = Person.persons.get(person);
		Location originLoc;
		originLoc = Location.locations.get(Origin);
		Location destinationLoc;
		destinationLoc = Location.locations.get(Destination);
		ArrayList<Ride> rides = new ArrayList<>(Ride.rides);
		rides = (ArrayList<Ride>) rides.stream()
				.filter(ride -> ride.getStatus().equals(Ride.RideStatus.OFFERED) && ride.getNumberOfSeats() >= seats
						&& ride.destination.equals(destinationLoc) && ride.origin.equals(originLoc))
				.collect(Collectors.toList());
		Ride rideSelected;
		SelectionStrategy strat;
		switch (strategy) {
		case "PREFERRED_VEHICLE":
			strat = new SelectionStrategy();
			strat.strategy = SelectionStrategy.Strategy.PREFERRED_VEHICLE;
			if (vehicleModel == null) {
				throw new InvalidRequestException(
						"Vehicle model is required when selection strategy is Preferred vehicle");
			}
			strat.vehicleModel = vehicleModel;
			rideSelected = strat.selectOffer(rides);
			if (rideSelected == null)
				return false;
			else {
				Request req = new Request();
				req.setDestination(destinationLoc);
				req.setOrigin(originLoc);
				req.setPersonName(requester.getName());
				req.setStrategy(strat);
				req.setNumberOfSeatsAvailable(seats);
				rideSelected.setNumberOfSeats(rideSelected.getNumberOfSeats() - seats);
				rideSelected.getPassengers().add(requester);
				rideSelected.getRequests().add(req);
				requester.getRequests().add(req);
				Ride.rides.remove(rideSelected);
				Ride.rides.add(rideSelected);
				System.out.println(rideSelected);
				return true;
			}
		case "MOST_VACANT":
			strat = new SelectionStrategy();
			strat.strategy = SelectionStrategy.Strategy.MOST_VACANT;
			rideSelected = strat.selectOffer(rides);
			if (rideSelected == null)
				return false;
			else {
				Request req = new Request();
				req.setDestination(destinationLoc);
				req.setOrigin(originLoc);
				req.setPersonName(requester.getName());
				req.setStrategy(strat);
				req.setNumberOfSeatsAvailable(seats);
				rideSelected.setNumberOfSeats(rideSelected.getNumberOfSeats() - seats);
				rideSelected.getPassengers().add(requester);
				rideSelected.getRequests().add(req);
				requester.getRequests().add(req);
				Ride.rides.remove(rideSelected);
				Ride.rides.add(rideSelected);
				System.out.println(rideSelected);
				// return
				return true;
			}
		default:
			throw new InvalidRequestException("This strategy is not known");
		}
	}

	public boolean addUser(String name) throws DuplicateObjectExcpetion {
		Person.createANewUser(name);
		return true;
	}

	public boolean addVehicle(String name, String model, String number) throws InvalidRequestException {
		if (!doesUserExist(name)) {
			throw new InvalidRequestException("The given user does not exist");
		}
		Vehicle.createVehicle(name, number, model);
		return true;
	}

	// Supporter Functions

	public boolean doesUserExist(String name) {
		if (!Person.persons.containsKey(name)) {
			return false;
		} else {
			return true;
		}
	}

}
