package domain;

import java.util.HashMap;

public class Location {

	String latitude;
	String longitude;
	public Location(String name) {
		super();
		this.name = name;
	}

	String name;

	// When stored in the DB, indexes created could be on ( the lat and long
	// rounded off to say three decimal places)
	// and then data bucketed. That will reduce the query time, and storing it this
	// way will not only help in the bonus question, but also help in significantly
	// reducing the time to search for a new ride from an origin

	// ArrayList - ridesStartingHere
	// ArratList - ridesEndingHere
	
	public static HashMap<String , Location> locations;
	static {
		if(locations == null)
			locations = new HashMap<>();
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Location other = (Location) obj;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
