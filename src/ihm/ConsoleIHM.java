package ihm;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import data.Hotel;
import data.Place;
import db.FacadeDB;
import ihm.exceptions.CancelInsertionIntoDBException;
import ihm.exceptions.ExitInsertionIntoDBException;

public class ConsoleIHM {
	private static String indexDir = "indexFiles";
	 private static String dataDir = "inputFiles";
	public static void consoleIHM() throws CancelInsertionIntoDBException, ExitInsertionIntoDBException{
		FacadeDB facade = new FacadeDB(indexDir, dataDir); 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Console IHM");
		System.out.println("Choose an object\n"
				+ "1. beaches\n"
				+ "2. hotels\n"
				+ "3. places");
		
		String object = sc.nextLine();
		if (object.equals("cancel")) {
			throw new CancelInsertionIntoDBException();
		}
		if (object.equals("exit")) {
			throw new ExitInsertionIntoDBException();
		}
		
		

		System.out.println("type keywords");
		String keys = sc.nextLine();
		
		JSONObject js = new JSONObject();
		
		try {
			ArrayList<String> array = new ArrayList<String>();
			
			switch (object) {
			case "1":
				System.out.println("add condtion");
				System.out.print("pricePerDay");
				String bCondition = sc.nextLine();
				
				if (bCondition.equals("cancel")) {
					throw new CancelInsertionIntoDBException();
				}
				if (bCondition.equals("exit")) {
					throw new ExitInsertionIntoDBException();
				}
				
				array.add("Hotel.pricePerDay" +bCondition);
				
				js.put("where", array);
				js.put("search", keys);
				
				ArrayList<Place> beaches = facade.getBeaches(js); 
				
				
				for (int i = 0; i < beaches.size(); i++) {
				      System.out.println(beaches.get(i).toString());
				}
				break;
				
			case "2" : 
				
				System.out.println("add condtion");
				System.out.print("name");
				String hCondition = sc.nextLine();
				if (hCondition.equals("cancel")) {
					throw new CancelInsertionIntoDBException();
				}
				if (hCondition.equals("exit")) {
					throw new ExitInsertionIntoDBException();
				}
				
				array.add("name" +hCondition);
				
				js.put("where", array);
				js.put("search", keys);
				
				ArrayList<Hotel> hotels = facade.getHotels(js); 
				
				
				for (int i = 0; i < hotels.size(); i++) {
				      System.out.println(hotels.get(i).toString());
				}
				break;
				
				
				case "3" : 
					
//					System.out.println("add condtion");
//					System.out.print("name");
//					String pCondition = sc.nextLine();
//					if (pCondition.equals("cancel")) {
//						throw new CancelInsertionIntoDBException();
//					}
//					if (pCondition.equals("exit")) {
//						throw new ExitInsertionIntoDBException();
//					}
//					array.add("name" +pCondition);
//					
//					js.put("where", array);
//					js.put("search", keys);
					
					ArrayList<Hotel> places = facade.getHotels(js); 
					
					
					for (int i = 0; i < places.size(); i++) {
					      System.out.println(places.get(i).toString());
					}
					break;

			default:
				break;
			}

			
			
			
			System.out.println(js);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*
		switch (object) {
		case "hotels":
			ArrayList<Hotel> array = fdbe.getHotels(js);
			
			for (int i = 0; i < array.size(); i++) {
				System.out.println(array.get(i).getName() + array.get(i).getPricePerDay());
			}
			break;
			
		case "beaches":
			
			break

		default:
			break;
		}
		
		*/
		
		
		
		
	}
}
