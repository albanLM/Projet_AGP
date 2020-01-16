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
        float maxPrice = criteria.getMaxPrice() / duration;
        criteria.setMaxTimePerDay(criteria.getTypeOfTrip() == EnumTripType.Dynamic ? DYNAMIC_TIME_A_DAY : LAZY_TIME_A_DAY);

        /* Build the trip */
        // TODO : Set the trip dates

        trip.setHotel(getRandomHotel()); // Get a random hotel

        float totalPrice = 0;
        for (int i = 0; i < duration; i++) { // For each day : add an excursion or not
            if (criteria.getTypeOfTrip() == EnumTripType.Dynamic || Math.random() > 0.5) {
                Excursion excursion = excursionBuilder.buildExcursion(criteria, matchingEvents, nonMatchingEvents, matchingScores, nonMatchingScores, trip.getHotel());
                totalPrice += excursion.getPrice();
                finalExcursions.add(excursion);
            } else {
                finalExcursions.add(excursionBuilder.buildEmptyExcursion());
            }
        }
        trip.setExcursions(finalExcursions);
        trip.setPrice(totalPrice);

        return trip;
    }

    private Hotel getRandomHotel(Criteria criteria) {
        PlaceSearch placeSearch = new PlaceSearch();
        Hotel foundHotels = placeSearch.searchHotel(criteria.getKeywords());

        return foundHotels;
    }

}
