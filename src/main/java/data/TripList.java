package data;

import java.util.ArrayList;

public class TripList {
	private ArrayList<Trip> trips;
	
	public TripList(ArrayList<Trip> trips)
	{
		this.trips = trips;
	}

	public TripList() {
		this(new ArrayList<Trip>());
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}
}
