package data;

public class Hotel extends Place {
	
	private float pricePerDay;
	private Place beach;

	public Hotel(int id, String name, Coordinates coord, String descriptionFile, float pricePerDay, Place beach) {
		super(id, name, coord, descriptionFile);
		this.pricePerDay = pricePerDay;
		this.beach = beach;
	}

	public float getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Place getBeach() {
		return beach;
	}

	public void setBeach(Place beach) {
		this.beach = beach;
	}

}
