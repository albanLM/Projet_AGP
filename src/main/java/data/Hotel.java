package data;

public class Hotel extends Place {
	
	@Override
	public String toString() {
		return "Hotel [" + "name=" + super.getName() +  ", pricePerDay=" + pricePerDay + ", beach=" + beach.toString() + ", descriptionFile=" + super.getDescriptionFile()+ "]";
	}

	private float pricePerDay;
	private Place beach;
	private String name; 
	private Coordinates coord; 
	private String descriptionFile; 

	public Hotel(String name, Coordinates coord, String descriptionFile, float pricePerDay, Place beach) {
		super(name, coord, descriptionFile);
		this.beach = beach; 
		this.name = name; 
		this.coord = coord; 
		this.pricePerDay = pricePerDay;
		this.beach = beach;
	}

	public float getPricePerDay() {
		return pricePerDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public String getDescriptionFile() {
		return descriptionFile;
	}

	public void setDescriptionFile(String descriptionFile) {
		this.descriptionFile = descriptionFile;
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
