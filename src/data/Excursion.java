package data;

import java.util.ArrayList;

public class Excursion {

		private int id;
		private ArrayList<Event> events;
		private Date start;
		private Date end;
		private float price;
		
		public Excursion(int id, ArrayList<Event> events, Date start, Date end, float price) {
			super();
			this.id = id;
			this.events = events;
			this.start = start;
			this.end = end;
			this.price = price;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public ArrayList<Event> getEvents() {
			return events;
		}

		public void setEvents(ArrayList<Event> events) {
			this.events = events;
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

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}
		
}
