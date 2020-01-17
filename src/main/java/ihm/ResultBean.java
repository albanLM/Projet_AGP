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
	private TripList listtrips; 
	private ArrayList<String> infos = new ArrayList<String>(); 
	public ArrayList<String> getInfos() {
		return infos;
	}

	public void setInfos(ArrayList<String> infos) {
		this.infos = infos;
	}

	String keywords;
	
	public double getPriceMin() {
		return  entryBeans.getPriceMin();
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	
	public ResultBean() {
		ArrayList<Trip> trip = new ArrayList<Trip>(); 
		ArrayList<Visit> events = new ArrayList<Visit>(); 
		String inf = "";
		ArrayList<String> types = new ArrayList<String>();
		ArrayList<Excursion> exc = new ArrayList<Excursion>(); 
		events.add(new Visit(10,10, new Place("2222", new Coordinates(10,10), "1111"))); 
		events.add(new Visit(20,20, new Place("au revoir", new Coordinates(10,10), "au revoir")));
		events.add(new Visit(10,10, new Place("33333", new Coordinates(10,10), "1111"))); 
		events.add(new Visit(20,20, new Place("au revoir", new Coordinates(10,10), "au revoir")));
		events.add(new Visit(10,10, new Place("4444", new Coordinates(10,10), "1111"))); 
		events.add(new Visit(20,20, new Place("au revoir", new Coordinates(10,10), "au revoir")));
		exc.add(new Excursion(events, new Date(10,10,2012), new Date(10,10,2012), 20));
		exc.add(new Excursion(events, new Date(10,10,2012), new Date(10,10,2012), 20));
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
		
		setListTrips(new TripList(trip)); 
		
		System.out.println("hotel "+listtrips.getTrips().get(0).getHotel().getName());
		System.out.println("SSSS "+listtrips.getTrips().get(0).getExcursions().get(0).getEvents().get(0).getPlace().getName());
		
		for(Trip tr : listtrips.getTrips()) {
			inf+=" Hotel "+tr.getHotel().getName()+"\n "; 
			for(Excursion ex : tr.getExcursions()) {
				inf+=" Departure Time "+ex.getStart().getDay()+"\n"; 
				for(Visit vi : ex.getEvents()) {
					inf+=" Excursion"+vi.getPlace().getName()+"\n"; 
				}
				inf+="\n \n"; 
			}
			System.out.println(inf);
			infos.add(inf); 
			inf = ""; 
		}
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

	public double getPriceMax() {
		return  entryBeans.getPriceMax();
	}

	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}

	public TripList getListtrips() {
		return listtrips;
	}

	public void setListTrips(TripList listtrips) {
		this.listtrips = listtrips;
	}


}
