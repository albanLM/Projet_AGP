package data;

import java.util.ArrayList;

public class Trip {
	private Hotel hotel;
	private ArrayList<Excursion> excursions;
	private float price;
	private Date start;
	private Date end;

	public Trip() {}

	public Trip(Hotel hotel, ArrayList<Excursion> excursions, Date start, Date end) {
		this.hotel = hotel;
		this.excursions = excursions;
		this.start = start;
		this.end = end;
		updatePrice();
	}

	private void updatePrice() {
		price = 0;
		for (Excursion excursion: excursions) {
			price += excursion.getPrice();
		}
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
		updatePrice();
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
