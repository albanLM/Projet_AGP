
package db.textual;

import db.FacadeDB;
import engine.DataSearch;

import java.util.ArrayList;

public class TestAPI {

	public static void main(String[] args) {
		APIBde api = new APIBde("place","description","id","./src/main/resources/inputFiles","./src/main/resources/indexFiles");

		String query = "SELECT * FROM place, hotel WHERE place.id = hotel.id_place and pricePerDay<20 WITH Cretan";
		//String query = "SELECT * FROM transportmethod where name='car'";
		ArrayList<String> list = new ArrayList<>();
		list.add("pricePerDay<25");
		list.add("pricePerDay>20");
		DataSearch ds = new DataSearch("hotel", list, null);
		System.out.println(FacadeDB.createQuery(ds));

		ArrayList<String> r = api.executeSqle(FacadeDB.createQuery(ds));
		for(String result :r) {
			System.out.println(result);
		}

	
	}

}
