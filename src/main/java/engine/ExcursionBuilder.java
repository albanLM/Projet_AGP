package engine;

import java.util.ArrayList;

import data.Event;
import data.Excursion;

public class ExcursionBuilder {

	public Excursion buildExcursion(Criteria criteria, ArrayList<Event> matchingEvents, ArrayList<Event> nonMatchingEvents, ArrayList<Float> matchingScores, ArrayList<Float> nonMatchingScores) {
		Excursion excursion = new Excursion(null, null, null, 0);
        ArrayList<Event> finalEvents = new ArrayList<>();
		
		/* Build the excursion (first line is only temporary)*/
		
		return excursion;
	}

	public Excursion buildEmptyExcursion() {
		return null;
	}
}
