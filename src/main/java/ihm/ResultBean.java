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

	private double priceMax;
	private Trip trip; 
	
	public Trip getTrip() {
		return entryBeans.getTrip();
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	String keywords;


	
	public ResultBean() {
	
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


}
