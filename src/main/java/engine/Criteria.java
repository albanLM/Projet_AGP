package engine;

import java.util.ArrayList;

public class Criteria {
    private int duration;
    private float maxPrice;
    private ArrayList<String> keywords;
    private EnumTripType typeOfTrip;

    public Criteria(int duration, float maxPrice, ArrayList<String> keywords, EnumTripType typeOfTrip) {
		super();
		this.duration = duration;
		this.maxPrice = maxPrice;
		this.keywords = keywords;
		this.typeOfTrip = typeOfTrip;
	}

	public void addKeywords(ArrayList<String> newKeywords) {
        keywords.addAll(newKeywords);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

}
