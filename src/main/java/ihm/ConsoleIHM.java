package ihm;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleIHM {
	public static void consoleIHM() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Console IHM");
		System.out.println("Choose");

		System.out.println("type keywords");
		String keys = sc.nextLine();
		
		JSONObject js = new JSONObject();
		
		try {

			ArrayList<String> array = new ArrayList<String>();
			array.add("pricePerDay>10");
			array.add("pricePerDay<50");
			
			js.put("where", array);
			js.put("search", keys);
			
			
			
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
