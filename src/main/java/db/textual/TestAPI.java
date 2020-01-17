package db.textual;

import java.util.ArrayList;

public class TestAPI {

	public static void main(String[] args) {
		APIBde api = new APIBde("Place","description","id","./src/main/resources/inputFiles","./src/main/resources/indexFiles");
		
		String query = "SELECT id,description,name FROM Place, Hotel WHERE Place.id = Hotel.id_place and pricePerDay<20 WITH Cretan";
		//String query = "SELECT * FROM transportmethod where name='car'";
		ArrayList<String> r = api.executeSqle(query);
		for(String result :r) {
			System.out.println(result);
		}
	
	}

}
