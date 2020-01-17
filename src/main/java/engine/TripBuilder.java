package engine;

import data.*;
import db.FacadeDB;
import db.textual.APIBde;

import java.sql.SQLException;
import java.util.ArrayList;

public class TripBuilder {
    private final int DYNAMIC_TIME_A_DAY = 10;
    private final int DYNAMIC_START_OF_DAY = 8;
    private final int LAZY_TIME_A_DAY = 6;
    private final int LAZY_START_OF_DAY = 10;
    
    public TripBuilder() {
    	
    }

    public Trip buildTrip(Criteria criteria) throws SQLException {
        Trip trip = new Trip();
        APIBde api = new APIBde("place","description","id","./src/main/resources/inputFiles","./src/main/resources/indexFiles");
        //FacadeDB fdb = new FacadeDB("./src/main/resources/indexFiles", "./src/main/resources/inputFiles");

        String kw = "";
        for (String str : criteria.getKeywords()){
            kw = kw.concat(str+ " ");
        }
        DataSearch ds = new DataSearch("visit", null, kw);
        ExcursionBuilder excursionBuilder = new ExcursionBuilder();

        ArrayList<Float> matchingScores = parseStringArray(api.executeSqle(FacadeDB.createQuery(ds)));

        ArrayList<Event> matchingEvents = new ArrayList<>();
        for (Visit v : ds.searchVisit()){
            Event e = (Event) v;
            matchingEvents.add(v);
        }


        ds = new DataSearch("visit", null, null);

        ArrayList<Event> nonMatchingEvents = new ArrayList<>();
        for (Visit v : ds.searchVisit()){
            Event e = (Event) v;
            nonMatchingEvents.add(v);
        }

        ArrayList<Float> nonMatchingScores = parseStringArray(api.executeSqle(FacadeDB.createQuery(ds)));


        ArrayList<Excursion> finalExcursions = new ArrayList<>();
        int duration = criteria.getNumberOfDays();
        float maxPrice = criteria.getMaxPrice() / duration;
        criteria.setMaxTimePerDay(criteria.getTypeOfTrip() == EnumTripType.B ? DYNAMIC_TIME_A_DAY : LAZY_TIME_A_DAY);

        /* Build the trip */
        trip.setStart(new Date(0, 0, 0));
        trip.setEnd(new Date(duration, 0, 0));
        trip.setHotel(getRandomHotel()); // Get a random hotel
        float totalPrice = 0;
        for (int i = 0; i < duration; i++) { // For each day : add an excursion or not
            if (criteria.getTypeOfTrip() == EnumTripType.B || Math.random() > 0.5) {
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

    private Hotel getRandomHotel() throws SQLException {

        DataSearch dataSearch = new DataSearch("hotel", null, null);

        ArrayList<Hotel> foundHotels = dataSearch.searchHotel();
        int randIndex = (int)Math.random()*foundHotels.size();

        return foundHotels.get(randIndex);

    }

    public ArrayList<Float> parseStringArray(ArrayList<String> array){
        ArrayList<Float> floats = new ArrayList<>();
        String tmp = "";
        for (String str : array){
            tmp = str.split(":")[1].split("#")[0];
            floats.add(Float.valueOf(tmp));
        }

        return floats;
    }

}
