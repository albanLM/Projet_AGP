package engine;

import data.Hotel;
import data.Place;
import data.TransportMethod;
import data.Visit;

import java.util.ArrayList;

public class DataSearch {


    private String objectType;
    private ArrayList<String> conditions;
    private String keywords;

    public DataSearch(String objectType, ArrayList<String> conditions, String keywords) {
        this.objectType = objectType;
        this.conditions = conditions;
        this.keywords = keywords;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<String> conditions) {
        this.conditions = conditions;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public ArrayList<Hotel> searchHotel(){
        ArrayList<Hotel> list = new ArrayList<>();

        return list;
    }

    public ArrayList<Place> searchPlace(){
        ArrayList<Place> list = new ArrayList<>();

        return list;
    }

    public ArrayList<TransportMethod> searchTransport(){
        ArrayList<TransportMethod> list = new ArrayList<>();

        return list;
    }

    public ArrayList<Visit> searchVisit(){
        ArrayList<Visit> list = new ArrayList<>();

        return list;
    }

}
