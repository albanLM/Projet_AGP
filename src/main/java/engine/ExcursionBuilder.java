package engine;

import java.util.ArrayList;

import data.Event;
import data.Date;
import data.Excursion;

public class ExcursionBuilder {

	public Excursion buildExcursion(Criteria criteria, ArrayList<Event> matchingEvents, ArrayList<Event> nonMatchingEvents, ArrayList<Float> matchingScores, ArrayList<Float> nonMatchingScores) {
		Excursion excursion = new Excursion(null, null, null, 0);
        ArrayList<Event> finalEvents = new ArrayList<>();

		/* Build the excursion (first line is only temporary)*/
		
		return excursion;
	}

	public Excursion buildEmptyExcursion() {
		return new Excursion(new ArrayList<Event>(), new Date(0, 0, 0), new Date(0, 0, 0), 0);
	}
}
