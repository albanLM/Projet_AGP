package data;

public class Place {
	private int id;
	private String name;
	private Coordinates coord;
	private String descriptionFile;
	
	public Place(int id, String name, Coordinates coord, String descriptionFile) {
		super();
		this.id = id;
		this.name = name;
		this.coord = coord;
		this.descriptionFile = descriptionFile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
