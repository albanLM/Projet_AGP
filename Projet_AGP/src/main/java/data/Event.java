package data;

public abstract class Event {
	private float time;
	private float price;

	public Event(float time, float price) {
		super();
		this.time = time;
		this.price = price;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
