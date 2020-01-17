package engine;

import java.util.ArrayList;

import data.Date;
import data.Event;
import data.Excursion;
import data.Hotel;

public class ExcursionBuilder {
	
	private ArrayList<Event> events;
	private ArrayList<Float> scores;

	public Excursion buildExcursion(Criteria criteria, ArrayList<Event> matchingEvents, ArrayList<Event> nonMatchingEvents, ArrayList<Float> matchingScores, ArrayList<Float> nonMatchingScores, Hotel hotel, Date start) {
		Excursion excursion = new Excursion(new ArrayList<Event>(), start, start, 0.0f);
		EventBuilder eventBuilder = new EventBuilder();
		
		for(Float f : matchingScores) {
			scores.add(f + 1.0f);
		}
		for(Float f : nonMatchingScores) {
			scores.add(0.3f);
		}
		events.addAll(matchingEvents);
		events.addAll(nonMatchingEvents);
		
		while(!events.isEmpty() && !scores.isEmpty()) {
			float scoresSum = 0.0f;
			for(Float f : scores) {
				scoresSum += f;
			}
			double randomNumber = (float)(Math.random() * scoresSum);
			int index = 0;
			while(randomNumber > scores.get(index)) {
				index++;
			}
			Event possibleEvent = events.get(index);
			scores.remove(index);
			events.remove(index);
			
			eventBuilder.buildEvent(possibleEvent, excursion, criteria.getMaxTimePerDay(), criteria.getMaxPrice()/criteria.getDuration(), hotel);
		}
		
		eventBuilder.buildBackToHotel(excursion, hotel);
		
		return excursion;
	}

	public Excursion buildEmptyExcursion() {
		return null;
	}
}
