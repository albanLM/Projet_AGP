package engine;

import data.Excursion;
import data.Place;
import db.FacadeDB;

import java.util.ArrayList;

public class ExcursionBuilder {
    private ArrayList<String> keywords;
    private ArrayList<Excursion> proposedExcursions;
    private PlaceSearch placeSearch;

    public ExcursionBuilder(ArrayList<String> keywords) {
        this.keywords = keywords;
        proposedExcursions = new ArrayList<>();
        placeSearch = new PlaceSearch(new FacadeDB());
    }

    public ArrayList<Excursion> buildExcursions() {
        // Chercher des lieux avec les keywords
        placeSearch.searchPlaces(keywords);
        ArrayList<Place> places = placeSearch.getPlaces();


        // Construire les véhicules correspondants

        return null;
    }

    public Excursion buildExcursion() {
        
        return null;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
}
