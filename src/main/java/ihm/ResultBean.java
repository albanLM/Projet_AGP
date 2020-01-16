package ihm;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import data.Coordinates;
import data.Date;
import data.Event;
import data.Excursion;
import data.Hotel;
import data.Place;
import data.Trip;
import data.TripList;
import data.Visit;


@ManagedBean
@RequestScoped
public class ResultBean implements Serializable{
	

	private static final long serialVersionUID = 6955508471291131930L;
	@ManagedProperty(value="#{entryBean}")
	private EntryBean entryBeans; 
	private int duration;
	private String type;
	private double priceMin;
	private double priceMax;
	private TripList trips; 
	private ArrayList<Trip> trip = new ArrayList<Trip>(); 
	private ArrayList<Event> events = new ArrayList<Event>(); 
	private String keywords;
	private ArrayList<String> types = new ArrayList<String>();
	private ArrayList<Excursion> exc = new ArrayList<Excursion>(); 
	public double getPriceMin() {
		return  entryBeans.getPriceMin();
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	
	public ResultBean() {
		events.add(new Visit(10,10, new Place("salut", new Coordinates(10,10), "salut"))); 
		events.add(new Visit(20,20, new Place("au revoir", new Coordinates(10,10), "au revoir")));
		exc.add(new Excursion(events, new Date(10,10,2012), new Date(10,10,2012), 20));
		Hotel hotel = new Hotel("salut", new Coordinates(10,10), keywords, duration,
				new Place("salut", new Coordinates(10,10), "salut")); 
		trip.add(new Trip(hotel, exc,
				duration, 
				new Date(10,10,2012), 
				new Date(10,10,2012))); 
		trip.add(new Trip(hotel, exc,
				duration, 
				new Date(10,10,2012), 
				new Date(10,10,2012))); 
		trip.add(new Trip(hotel, exc,
				duration, 
				new Date(10,10,2012), 
				new Date(10,10,2012))); 
		trip.add(new Trip(hotel, exc,
				duration, 
				new Date(10,10,2012), 
				new Date(10,10,2012))); 
		
		setTrips(new TripList(trip)); 
		
		System.out.println("hotel "+trips.getTrips().get(0).getHotel().getName());
	}
	
	public ArrayList<Trip> getTrip() {
		return trip;
	}

	public void setTrip(ArrayList<Trip> trip) {
		this.trip = trip;
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public ArrayList<Excursion> getExc() {
		return exc;
	}

	public void setExc(ArrayList<Excursion> exc) {
		this.exc = exc;
	}

	public String start() {
		return "entry"; 
	}
	
	public int getDuration() {
		return entryBeans.getDuration();
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getType() {
		return entryBeans.getType();
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeywords() {
		return entryBeans.getKeywords();
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public EntryBean getEntryBeans() {
		return entryBeans;
	}

	public void setEntryBeans(EntryBean entryBeans) {
		this.entryBeans = entryBeans;
	}

	public ArrayList<String> getTypes() {
		return entryBeans.getTypes();
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	public double getPriceMax() {
		return  entryBeans.getPriceMax();
	}

	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}

	public TripList getTrips() {
		return trips;
	}

	public void setTrips(TripList trips) {
		this.trips = trips;
	}
}
