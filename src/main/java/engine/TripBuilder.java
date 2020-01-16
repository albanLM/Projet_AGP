package engine;

import data.Event;
import data.Excursion;
import data.Hotel;
import data.Trip;

import java.util.ArrayList;

public class TripBuilder {
    private final int DYNAMIC_TIME_A_DAY = 10;
    private final int LAZY_TIME_A_DAY = 6;

    public Trip buildTrip(Criteria criteria) {
        Trip trip = new Trip();
        ExcursionBuilder excursionBuilder = new ExcursionBuilder();
        ArrayList<Event> matchingEvents = new ArrayList<>();
        ArrayList<Event> nonMatchingEvents = new ArrayList<>();
        ArrayList<Float> matchingScores = new ArrayList<>();
        ArrayList<Float> nonMatchingScores = new ArrayList<>();
        ArrayList<Excursion> finalExcursions = new ArrayList<>();
        int duration = criteria.getDuration();
        int maxTimePerDay = criteria.getTypeOfTrip() == EnumTripType.Dynamic ? DYNAMIC_TIME_A_DAY : LAZY_TIME_A_DAY;
        criteria.setMaxTimePerDay(maxTimePerDay);
        float maxPrice = criteria.getMaxPrice() / duration;

        /* Build the trip */
        trip.setHotel(getRandomHotel()); // Get a random hotel

        for (int i = 0; i < duration; i++) {
            if (criteria.getTypeOfTrip() == EnumTripType.Dynamic || Math.random() > 0.5) {
            	//finalExcursions.add(excursionBuilder.buildExcursion(criteria));
            }
            else finalExcursions.add(excursionBuilder.buildEmptyExcursion());
        }

        return trip;
    }

    private Hotel getRandomHotel() {
        return null;
    }

}
