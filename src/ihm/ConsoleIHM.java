package ihm;

import java.util.Scanner;

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
		
		
		
		sc.close();
		
	}
	
	
	

}
