package data;

import java.util.ArrayList;

public class Trip {
	private Hotel hotel;
	private ArrayList<Excursion> excursions;
	private float price;
	private Date start;
	private Date end;
	
	public Trip(Hotel hotel, ArrayList<Excursion> excursions, float price, Date start, Date end) {
		super();
		this.hotel = hotel;
		this.excursions = excursions;
		this.price = price;
		this.start = start;
		this.end = end;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
}
