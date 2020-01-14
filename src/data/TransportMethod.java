package data;

public class TransportMethod {
	private int id;
	private String name;
	private int speed;
	private float pricePerKm;
	
	public TransportMethod(int id, String name, int speed, float pricePerKm) {
		super();
		this.id = id;
		this.name = name;
		this.speed = speed;
		this.pricePerKm = pricePerKm;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public float getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(float pricePerKm) {
		this.pricePerKm = pricePerKm;
	}
}
