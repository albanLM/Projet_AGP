package ihm;


import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class  EntryBean implements Serializable{
	private static final long serialVersionUID = 6955508471291131930L;
	
	private int duration; 
	private String type; 
	private float price; 
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
		types.add("Détente"); 
		types.add("aventures"); 
		types.add("romantique"); 
		types.add("want"); 
		type = types.get(0);
		for (String student : types) {
			SelectItem menuChoice = new SelectItem(student);
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

	public float getPrice() {
		System.out.println(price);
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
	

}
