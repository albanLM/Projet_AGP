package engine;

import data.Coordinates;
import data.Event;
import data.Place;
import data.Visit;

public class EventBuilder {
    EventBuilder(){}

    public Event buildEvent(){
        Coordinates c = new Coordinates(10, 20);
        Coordinates c2 = new Coordinates(15, 25);
        Place place = new Place("name", c, "description");
        return null;

    }
}
