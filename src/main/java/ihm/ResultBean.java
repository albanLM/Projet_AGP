package ihm;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class ResultBean implements Serializable{
	

	private static final long serialVersionUID = 6955508471291131930L;
	@ManagedProperty(value="#{entryBean}")
	private EntryBean entryBeans; 
	private int duration;
	private String type;
	private double price;
	private String keywords;
	
	private ArrayList<String> types = new ArrayList<String>();
	
	public ResultBean() {
		
	}
	
	public String start() {
		return "entry"; 
	}
	
	public int getDuration() {
		return entryBeans.getDuration();
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getType() {
		return entryBeans.getType();
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return entryBeans.getPrice();
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getKeywords() {
		return entryBeans.getKeywords();
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public EntryBean getEntryBeans() {
		return entryBeans;
	}

	public void setEntryBeans(EntryBean entryBeans) {
		this.entryBeans = entryBeans;
	}

	public ArrayList<String> getTypes() {
		return entryBeans.getTypes();
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
}
