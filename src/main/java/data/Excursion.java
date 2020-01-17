package data;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Excursion {
    private ArrayList<Event> events;
  
    private Date start;
    private Date end;
    private float price;

    public Excursion(ArrayList<Event> events, Date start, Date end, float price) {
        super();
        this.events = events;
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
    
    private ArrayList<Visit> getVisit(){
    	ArrayList<Visit> visit = new ArrayList<Visit>();
    	
    	for(Event ev : events) {
    		visit.add((Visit) ev); 
    	}
    	
    	return visit;
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
