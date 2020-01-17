package ihm;


import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class  EntryBean implements Serializable{
	private static final long serialVersionUID = 6955508471291131930L;
	
	private int duration; 
	private String type; 
	private float priceMin;
	private float priceMax;
	EnumComfort enumComfort; 
	private ArrayList<SelectItem> items = new ArrayList<SelectItem>();
	private ArrayList<String> types = new ArrayList<String>();
	public ArrayList<String> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	private String keywords; 
	
	public ArrayList<SelectItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<SelectItem> items) {
		this.items = items;
	}

	private boolean connected = false;

	public EntryBean() {
//		TripBuilder tripbuilder = new TripBuilder(new Criteria(getDuration(), getPriceMax(), getKeywords(), getSelect))
		for(EnumComfort env : EnumComfort.values()){
			System.out.println(env.getText());
			types.add(env.getText()); 
		}
		
		for (String item : types) {
			System.out.println(item);
			SelectItem menuChoice = new SelectItem(item);
			items.add(menuChoice);	
		}
	}

	public int getDuration() {
		System.out.println(duration);
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getType() {
		System.out.println(type);
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public float getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(float priceMin) {
		this.priceMin = priceMin;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public String start() {
		return "result"; 
	}

	public float getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(float priceMax) {
		this.priceMax = priceMax;
	}
	

}
