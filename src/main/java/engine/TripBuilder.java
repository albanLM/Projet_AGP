package engine;

import data.*;

import java.util.ArrayList;

public class TripBuilder {
    private final int DYNAMIC_TIME_A_DAY = 10;
    private final int DYNAMIC_START_OF_DAY = 8;
    private final int LAZY_TIME_A_DAY = 6;
    private final int LAZY_START_OF_DAY = 10;

    public Trip buildTrip(Criteria criteria) {
        Trip trip = new Trip();
        ExcursionBuilder excursionBuilder = new ExcursionBuilder();
        ArrayList<Event> matchingEvents = new ArrayList<>();
        ArrayList<Event> nonMatchingEvents = new ArrayList<>();
        ArrayList<Float> matchingScores = new ArrayList<>();
        ArrayList<Float> nonMatchingScores = new ArrayList<>();
        ArrayList<Excursion> finalExcursions = new ArrayList<>();
        int duration = criteria.getNumberOfDays();
        float maxPrice = criteria.getMaxPrice() / duration;
        criteria.setMaxTimePerDay(criteria.getTypeOfTrip() == EnumTripType.Dynamic ? DYNAMIC_TIME_A_DAY : LAZY_TIME_A_DAY);

        /* Build the trip */
        trip.setStart(new Date(0, 0, 0));
        trip.setEnd(new Date(duration, 0, 0));
        trip.setHotel(getRandomHotel()); // Get a random hotel
        float totalPrice = 0;
        for (int i = 0; i < duration; i++) { // For each day : add an excursion or not
            if (criteria.getTypeOfTrip() == EnumTripType.Dynamic || Math.random() > 0.5) {
            	Date date = new Date(i, 0, 0);
                Excursion excursion = excursionBuilder.buildExcursion(criteria, matchingEvents, nonMatchingEvents, matchingScores, nonMatchingScores, trip.getHotel(), date);
                totalPrice += excursion.getPrice();
                finalExcursions.add(excursion);
            } else {
                finalExcursions.add(excursionBuilder.buildEmptyExcursion(new Date(i, 0, 0)));
            }
        }
        trip.setExcursions(finalExcursions);
        trip.setPrice(totalPrice);

        return trip;
    }

    private Hotel getRandomHotel() {

        DataSearch dataSearch = new DataSearch("hotel", null, null);

        ArrayList<Hotel> foundHotels = dataSearch.searchHotel();
        int randIndex = (int)Math.random()*foundHotels.size();

        return foundHotels.get(randIndex);

    }

}
