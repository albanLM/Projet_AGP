package engine;

import data.Excursion;
import data.Trip;
import ihm.Criteria;

import java.util.ArrayList;

public class TripBuilder {
    ExcursionBuilder excursionBuilder;
    private Criteria criteria;

    public TripBuilder(ExcursionBuilder excursionBuilder, Criteria criteria) {
        this.excursionBuilder = excursionBuilder;
        this.criteria = criteria;
    }

    public ArrayList<Trip> buildTrips() {
        // Ajouter keywords en fonction du confort
        addKeywords();

        // Définir le nombre d'excursion en fonction du confort
        int excursionCount = defineExcursionCount();

        // Construire des offre selon certains critères prédéfinis
        ArrayList<Trip> proposedTrips = new ArrayList<>();
        proposedTrips.add(getMostPertinentTrip());
        proposedTrips.add(getLowerPriceTrip());
        proposedTrips.add(getMostExpensiveTrip());

        return proposedTrips;
    }

    private Trip getMostExpensiveTrip() {
        Trip trip = new Trip();
        ArrayList<Excursion> excursions = excursionBuilder.buildExcursions();
        trip.setExcursions(excursions);
        return null;
    }

    private Trip getMostPertinentTrip() {
        return null;
    }

    private Trip getLowerPriceTrip() {
        return null;
    }

    private void addKeywords() {
        ArrayList<String> newKeywords = new ArrayList<>();
        switch (criteria.getComfort())
        {
            case Relaxing:
                newKeywords.add("");
                break;
            case Sportive:
                break;
            case Historic:
                break;
            case Romantic:
                break;
            case Intense:
                break;
        }


    }

    private int defineExcursionCount() {
        return 0;
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
}
