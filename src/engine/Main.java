package engine;

import ihm.ConsoleIHM;
import ihm.exceptions.CancelInsertionIntoDBException;
import ihm.exceptions.ExitInsertionIntoDBException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		try {
			ConsoleIHM.consoleIHM();
		} catch (CancelInsertionIntoDBException | ExitInsertionIntoDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
