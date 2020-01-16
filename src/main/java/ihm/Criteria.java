package ihm;

import data.Date;

import java.util.ArrayList;

public class Criteria {
    private int duration;
    private float minPrice, maxPrice;
    private ArrayList<String> keywords;
    private EnumComfort comfort;
    private int excursionCount;
    private Date start;
    private Date end;

    public Criteria(int duration, float minPrice, float maxPrice, ArrayList<String> keywords, EnumComfort comfort, Date start, Date end) {
        this.duration = duration;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.keywords = keywords;
        this.comfort = comfort;
        this.start = start;
        this.end = end;
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

    public int getExcursionCount() {
        return excursionCount;
    }

    public void setExcursionCount(int excursionCount) {
        this.excursionCount = excursionCount;
    }

    public Date getStart() { return this.start; }

    public void setStart(Date start) {this.start = start; }

    public Date getEnd() { return end; }

    public void setEnd(Date end) { this.end = end; }
}
