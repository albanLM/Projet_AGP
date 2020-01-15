package engine;

import data.Excursion;
import data.Trip;
import ihm.Criteria;
import ihm.EnumComfort;

import java.util.ArrayList;

public class TripBuilder {
    private final int tripCount = 5;

    public TripBuilder() {}

    public ArrayList<Trip> buildTrips(Criteria criteria) {
        // Ajouter keywords en fonction du confort
        addKeywords(criteria.getComfort());

        // Définir le nombre d'excursion en fonction du confort
        int excursionCount = defineExcursionCount(criteria.getComfort());

        // Construire des listes d'excursions pour chaque offre
        ArrayList<Trip> proposedTrips = new ArrayList<>();
        ExcursionBuilder excursionBuilder = new ExcursionBuilder();
        for (int i = 0; i< 5; i++)
        {
            Trip temp = new Trip();
            ArrayList<Excursion> temp2 = excursionBuilder.buildExcursions(criteria.getKeywords());
            temp.setExcursions(temp2);
            proposedTrips.add(temp);
        }

        // Supprimer les offres dont le prix total ne correspond pas à l'intervalle
        deleteIllegalTrips(proposedTrips, criteria.getMinPrice(), criteria.getMaxPrice());
        return null;
    }

    private void addKeywords(EnumComfort comfort) {
    }

    private int defineExcursionCount(EnumComfort comfort) {
        return 0;
    }

    private void deleteIllegalTrips(ArrayList<Trip> proposedTrips, float minPrice, float maxPrice) {
    }
}
