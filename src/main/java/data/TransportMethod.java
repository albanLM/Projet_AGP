package data;

public class TransportMethod {
	private String name;
	private int speed;
	private float pricePerKm;
	
	public TransportMethod(String name, int speed, float pricePerKm) {
		super();
		this.name = name;
		this.speed = speed;
		this.pricePerKm = pricePerKm;
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
