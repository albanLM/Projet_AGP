package engine;

import java.util.ArrayList;

public class Criteria {
    private int numberOfDays;
    private float maxPrice;
    private ArrayList<String> keywords;
    private EnumTripType typeOfTrip;
    private float maxTimePerDay;

    public Criteria(int duration, float maxPrice, ArrayList<String> keywords, EnumTripType typeOfTrip) {
		super();
		this.numberOfDays = duration;
		this.maxPrice = maxPrice;
		this.keywords = keywords;
		this.typeOfTrip = typeOfTrip;
	}

	public void addKeywords(ArrayList<String> newKeywords) {
        keywords.addAll(newKeywords);
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

	public EnumTripType getTypeOfTrip() {
		return typeOfTrip;
	}

	public void setTypeOfTrip(EnumTripType typeOfTrip) {
		this.typeOfTrip = typeOfTrip;
	}

	public float getMaxTimePerDay() {
		return maxTimePerDay;
	}

	public void setMaxTimePerDay(float maxTimePerDay) {
		this.maxTimePerDay = maxTimePerDay;
	}

}
