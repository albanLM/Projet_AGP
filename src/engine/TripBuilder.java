package engine;

import java.util.ArrayList;

import data.Date;
import data.Event;
import data.Excursion;
import data.Hotel;
import data.Place;
import data.Trip;

public class TripBuilder {
	public static Trip buildTrip(int id, Hotel hotel, ArrayList<Place> places, float price, Date start, Date end) {
		
		ArrayList<Excursion> excursions = buildExcursion(places);
		Trip trip = new Trip(id, hotel, excursions, price, start, end);
		return trip;
	}
	
	public static ArrayList<Excursion> buildExcursion(ArrayList<Place> places) {
		ArrayList<Excursion> excursions = new ArrayList<Excursion>();
		//create events
		
		return excursions;
		
	}
	
	public static ArrayList<Event> buildEvents(){
		ArrayList<Event> events = new ArrayList<Event>();
		
		return events;
		
	}
	
	
	
}
