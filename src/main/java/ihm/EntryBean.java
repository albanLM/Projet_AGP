package ihm;


import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import data.Trip;
import engine.Criteria;
import engine.DataSearch;
import engine.EnumTripType;
import engine.TripBuilder;

@ManagedBean
@SessionScoped
public class  EntryBean implements Serializable{
	private static final long serialVersionUID = 6955508471291131930L;
	
	private int duration; 
	private String type; 
	private float priceMax;
	private EnumTripType enumComfort; 
	private ArrayList<SelectItem> items = new ArrayList<SelectItem>();
	private ArrayList<String> types = new ArrayList<String>();
	private Trip trip; 
	private ArrayList<String> conditions = new ArrayList<String>(); 
	private String keywords; 
	
	
	
	
	public String start() {
		return "result";
	}
	


	public EntryBean() {
		ArrayList<String> keys = new ArrayList<String>(); 
		keys.add(keywords); 
		Criteria criteria  = new Criteria(duration, priceMax, keys, EnumTripType.fromString(type)); 
		trip = new TripBuilder().buildTrip(criteria);  
		
		
	
		for(EnumComfort env : EnumComfort.values()){
			System.out.println(env.getText());
			types.add(env.getText()); 
		}
		
		for (String item : types) {
			SelectItem menuChoice = new SelectItem(item);
			items.add(menuChoice);	
		}
		
	}






	public int getDuration() {
		return duration;
	}






	public void setDuration(int duration) {
		this.duration = duration;
	}






	public String getType() {
		return type;
	}






	public void setType(String type) {
		this.type = type;
	}






	public float getPriceMax() {
		return priceMax;
	}






	public void setPriceMax(float priceMax) {
		this.priceMax = priceMax;
	}






	public EnumTripType getEnumComfort() {
		return enumComfort;
	}






	public void setEnumComfort(EnumTripType enumComfort) {
		this.enumComfort = enumComfort;
	}






	public ArrayList<SelectItem> getItems() {
		return items;
	}






	public void setItems(ArrayList<SelectItem> items) {
		this.items = items;
	}






	public ArrayList<String> getTypes() {
		return types;
	}






	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}






	public Trip getTrip() {
		return trip;
	}






	public void setTrip(Trip trip) {
		this.trip = trip;
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

	
	

}
