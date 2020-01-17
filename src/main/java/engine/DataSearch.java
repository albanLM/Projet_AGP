package engine;

import data.Hotel;
import data.Place;
import data.TransportMethod;

import java.util.ArrayList;

public class DataSearch {
    private ArrayList<Place> places;
    private ArrayList<Hotel> hotels;
    private ArrayList<TransportMethod> vehicles;

    public void searchForPlaces(ArrayList<String> keywords) {

    }

    public void searchForHotels(ArrayList<String> keywords) {
    }

    public void searchForVehicles() {
        String request = "SELECT * FROM";
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<TransportMethod> getVehicles() {
        return vehicles;
    }
}
