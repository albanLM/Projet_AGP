package engine;

import data.Excursion;
import data.Trip;
import ihm.Criteria;

import java.util.ArrayList;

public class TripBuilder {
    ExcursionBuilder excursionBuilder;
    private Criteria criteria;

    private ArrayList<Trip> proposedTrips;

    public TripBuilder(Criteria criteria) {
        this.criteria = criteria;
        this.proposedTrips = new ArrayList<>();
    }

    public void buildTrips() {
        updateCriteria(); // Add keywords depending on comfort
        excursionBuilder = new ExcursionBuilder(criteria.getKeywords());
        excursionBuilder.buildExcursions();
    }

    public Trip buildTrip() {
        for (int i = 0; i < criteria.getExcursionCount(); i++)
        {
            proposedTrips.add(getRandomTrip());
        }
        return null;
    }


    /*private Trip getMostExpensiveTrip() {
        return null;
    }

    private Trip getMostPertinentTrip() {
        return null;
    }

    private Trip getLowerPriceTrip() {
        return null;
    }*/
    private Trip getRandomTrip () {
        ArrayList<Excursion> excursions = excursionBuilder.buildExcursions();
        return null;
    }

    private void updateCriteria() {
        ArrayList<String> newKeywords = new ArrayList<>();
        switch (criteria.getComfort())
        {
            case Relaxing: // 20%
                newKeywords.add("");
                break;
            case Sportive:
                break;
            case Historic:
                break;
            case Intense:
                break;
        }
    }

    public ExcursionBuilder getExcursionBuilder() {
        return excursionBuilder;
    }

    public void setExcursionBuilder(ExcursionBuilder excursionBuilder) {
        this.excursionBuilder = excursionBuilder;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public ArrayList<Trip> getProposedTrips() {
        return proposedTrips;
    }
}
