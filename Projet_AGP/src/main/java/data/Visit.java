package data;

public class Visit extends Event {

	private Place place;
	
	public Visit(float time, float price, Place place) {
		super(time, price);
		this.place = place;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}
