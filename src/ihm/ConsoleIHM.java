package ihm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import org.json.JSONException;
import org.json.JSONObject;

public class ConsoleIHM {
	
	public static void console() {
		Scanner sc = new Scanner(System.in);
		String object, keywords;
		
		
		System.out.println("Console interrogation"
				+ "search for : ");
		System.out.println("1. site\n"
				+ "2. car\n"
				+ "3. hotel\n");	
		
		object = sc.nextLine();
		
		System.out.println("write your key words like \"hotel beach montain\"\n");
		
		keywords = sc.nextLine();
		
		System.out.println(object + keywords);
		
		switch (object) {
		case "1": object = "site";
			break;
		case "2": object = "car";
			break;
		case "3": object = "hotel";
		break;

		default: object = "error";
			break;
		}
		
		JSONObject js = new JSONObject();
		ArrayList<String> a = new ArrayList<String>();
		a.add("price<50");
		a.add("price>10");
		
		try {
			js.put("type", object);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			js.put("where", a);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		sc.close();
		
	}
	
	
	

}
