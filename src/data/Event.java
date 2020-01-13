package data;

public abstract class Event {
	private int id;
	private float time;
	private float price;

	public Event(int id, float time, float price) {
		super();
		this.id = id;
		this.time = time;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
