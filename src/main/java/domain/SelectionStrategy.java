package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SelectionStrategy {
	public static enum Strategy {
		PREFERRED_VEHICLE, MOST_VACANT
	}

	Strategy strategy;
	String vehicleModel;

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public Ride selectOffer(ArrayList<Ride> offers) {
		
		switch(this.strategy) {
		case MOST_VACANT:
			try {
			Ride max = offers.stream().max(new Comparator<Ride>() {
				@Override
				public int compare(Ride o1, Ride o2) {
					if(o1.getNumberOfSeats() >= o2.getNumberOfSeats()) {
						return 1;
					}
					else {
						return -1;
					}
				}
			}).orElseThrow(NoSuchElementException::new);
			return max;}
			catch(NoSuchElementException e) {
				return null;
			}
			
		case PREFERRED_VEHICLE:
			offers = (ArrayList<Ride>) offers.stream().filter(prOffer -> prOffer.getVehicle().getModel().equals(this.getVehicleModel())).collect(Collectors.toList());
			if(offers == null || offers.size() == 0) {
				//Or throw a new NoOffersMatchedException();
				return null;
			}
			else {
				try {
				return offers.stream().min(new Comparator<Ride>() {
					@Override
					public int compare(Ride o1, Ride o2) {
						if(o1.getNumberOfSeats() >= o2.getNumberOfSeats()) {
							return -1;
						}
						else {
							return 1;
						}
					}
				}).orElseThrow(NoSuchElementException::new);}
				catch(NoSuchElementException e) {
					return null;
				}
				
			}
		default:
			break;
		
		}
		return null;
		
	}
}