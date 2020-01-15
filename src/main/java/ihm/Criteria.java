package ihm;

import java.util.ArrayList;

public class Criteria {
    private int numberOfDay;
    private float minPrice, maxPrice;
    private ArrayList<String> keywords;
    private EnumComfort comfort;

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
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

    public EnumComfort getComfort() {
        return comfort;
    }

    public void setComfort(EnumComfort comfort) {
        this.comfort = comfort;
    }
}
