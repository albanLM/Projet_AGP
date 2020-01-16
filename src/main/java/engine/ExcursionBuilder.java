package engine;

import data.Excursion;

import java.util.ArrayList;

public class ExcursionBuilder {
    private ArrayList<String> keywords;

    public ExcursionBuilder(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public ArrayList<Excursion> buildExcursions() {
        // Chercher des lieux avec les keywords
        // Chercher les véhicules correspondant
        return null;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
}
