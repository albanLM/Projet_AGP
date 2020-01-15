package data;

public class Hotel extends Place {
	
	@Override
	public String toString() {
		return "Hotel [" + "name=" + super.getName() +  ", pricePerDay=" + pricePerDay + ", beach=" + beach.toString() + ", descriptionFile=" + super.getDescriptionFile()+ "]";
	}

	private float pricePerDay;
	private Place beach;

	public Hotel(String name, Coordinates coord, String descriptionFile, float pricePerDay, Place beach) {
		super(name, coord, descriptionFile);
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
