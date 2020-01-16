package db.textual;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class BuildRequest {
	
	private String type; 
	private String query; 
	
	public BuildRequest() {
		
	}
	
	public boolean isAskingHotel() {
		return type.equalsIgnoreCase("Hotel"); 
	}
	
	public boolean isAskingTransport() {
		return type.equalsIgnoreCase("Transport"); 
	}
	
	public boolean isAskingPlace() {
		return type.equalsIgnoreCase("place"); 
	}
	
	public void buildQuery(JSONObject jsonObject, String sql) throws JSONException {
		query = sql; 
		if(jsonObject.has("where")) {
			System.out.println(jsonObject);
			
			ArrayList<String> list = new ArrayList<String>();     
			JSONArray jsonArray = (JSONArray) jsonObject.get("where"); 
			if (jsonArray != null) { 
				query+=" AND "; 
			   int len = jsonArray.length();
			   System.out.println(len);
			   for (int i=0;i<len;i++){ 
			    list.add(jsonArray.get(i).toString());
			   } 
			} 
		    Iterator<String> iterator = list.listIterator();
		  
		      while(iterator.hasNext()) {
		        query += " "+iterator.next()+" "; 
		        if(iterator.hasNext()) query+= " AND "; 
		      }
		}
		if(jsonObject.has("search")) {
			String search; 
			search = jsonObject.getString("search"); 
			query+= " WITH "+ search; 
		}
		System.out.println("SQL REQUEST : "+query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
