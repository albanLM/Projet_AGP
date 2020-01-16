package engine;

import data.Excursion;
import data.Trip;
import ihm.Criteria;
import ihm.EnumComfort;

import java.util.ArrayList;

public class TripBuilder {
    ExcursionBuilder excursionBuilder;

    public TripBuilder(ExcursionBuilder excursionBuilder) {
        this.excursionBuilder = excursionBuilder;
    }

    public ArrayList<Trip> buildTrips(Criteria criteria) {
        // Ajouter keywords en fonction du confort
        addKeywords(criteria);

        // Définir le nombre d'excursion en fonction du confort
        int excursionCount = defineExcursionCount(criteria.getComfort());

        // Construire des offre selon certains critères prédéfinis
        ArrayList<Trip> proposedTrips = new ArrayList<>();
        proposedTrips.add(getMostPertinentTrip(criteria));
        proposedTrips.add(getLowerPriceTrip(criteria));
        proposedTrips.add(getMostExpensiveTrip(criteria));

        return proposedTrips;
    }

    private Trip getMostExpensiveTrip(Criteria criteria) {
        Trip trip = new Trip();
        ArrayList<Excursion> excursions = excursionBuilder.buildExcursions(criteria.getKeywords());
        trip.setExcursions(excursions);
        return null;
    }

    private Trip getMostPertinentTrip(Criteria criteria) {
        return null;
    }

    private Trip getLowerPriceTrip(Criteria criteria) {
        return null;
    }

    // Faire une requete pour chaque mot clé ajouté
    private void addKeywords(Criteria criteria) {
        ArrayList<String> newKeywords = new ArrayList<>();
         switch (criteria.getComfort())
         {
             case Relaxing:
                 newKeywords.add("Facile, convient à tout public");
                 break;
             case Sportive:
                 newKeywords.add("volcan");
                 newKeywords.add("montagnes");

                 break;
             case Historic:
                 newKeywords.add("histoire");
                 newKeywords.add("historique");
                 break;
             case Intense:
                 newKeywords.add("toute la journée");
                 break;
         }
    }

    private int defineExcursionCount(EnumComfort comfort) {
        return 0;
    }
}
