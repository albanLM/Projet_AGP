package ihm;

import data.*;
import db.sql.DatabaseConnection;
import db.sql.PersistenceFacade;
import db.sql.exceptions.CancelInsertionIntoDBException;
import db.sql.exceptions.ClassNotPersistableException;
import db.sql.exceptions.ExitInsertionIntoDBException;

import java.sql.SQLException;
import java.util.Scanner;

public class TerminalDBUtility {
	
	public static void main(String[] args) {
		String line = "empty";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the DB filler utility");
		while(!line.equals("exit")) {
			System.out.println("Insert a new data in the DB : insert");
			System.out.println("Exit the utility : exit");
			System.out.println("Cancel an action in progress : cancel");
			System.out.println("Search in the database : search");
			line = scanner.nextLine();
			if(line.equals("search")) {
				ConsoleIHM.consoleIHM();

			}
			else if(line.equals("insert")) {
				boolean inserted = false;
				while(!line.equals("cancel") && !inserted && !line.equals("exit")){
					System.out.println("Insert an object from a type among Coordinates, TransportMethod, Place, Visit and Hotel");
					line = scanner.nextLine();
					try {
						if(line.equals("Coordinates")) {
							insertCoordinates(scanner, line);
							inserted = true;
						}
						else if(line.equals("TransportMethod")) {
							insertTransportMethod(scanner, line);
							inserted = true;
						}
						else if(line.equals("Place")) {
							insertPlace(scanner, line);
							inserted = true;
						}
						else if(line.equals("Visit")) {
							insertVisit(scanner, line);
							inserted = true;
						}
						else if(line.equals("Hotel")) {
							insertHotel(scanner, line);
							inserted = true;
						}
						else if(!line.equals("exit") && !line.equals("cancel")){
							System.out.println("Unexpected type");
						}
					}
					catch(SQLException e) {
						System.err.println("An error has occured during the insertion");
					}
					catch(ClassNotPersistableException e) {
						System.err.println("The object you asked to be inserted has not a valid type");
					}
					catch(CancelInsertionIntoDBException e) {
						line = "cancel";
					}
					catch(ExitInsertionIntoDBException e) {
						line = "exit";
					}
				}
				if(line.equals("cancel")) {
					System.out.println("Insertion has been canceled");
				}
				
				
			}
			else if(!line.equals("exit")){
				System.out.println("This command is not valid");
			}
		}
		System.out.println("You have successfully quit the utility");
		scanner.close();
	}
	
	public static Coordinates insertCoordinates(Scanner scanner, String line) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		return insertCoordinates(scanner, line, true);
	}
	public static Coordinates insertCoordinates(Scanner scanner, String line, boolean insert) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		int x = 0;
		int y = 0;
		
		boolean valid = false;
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("x : insert an integer");
			line = scanner.nextLine();
			try {
				x = Integer.parseInt(line);
				valid = true;
			}
			catch(NumberFormatException e) {
			}
		}
		valid = false;
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("y : insert an integer");
			line = scanner.nextLine();
			try {
				y = Integer.parseInt(line);
				valid = true;
			}
			catch(NumberFormatException e) {
			}
		}
		if(line.equals("cancel")) {
			throw new CancelInsertionIntoDBException();
		}
		if(line.equals("exit")) {
			throw new ExitInsertionIntoDBException();
		}

		Coordinates coord = new Coordinates(x, y);
		if(insert) {
			PersistenceFacade facade = new PersistenceFacade(DatabaseConnection.getConnection());
			facade.persist(coord);
		}
		return coord;
	}
	
	public static TransportMethod insertTransportMethod(Scanner scanner, String line) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		return insertTransportMethod(scanner, line, true);
	}
	public static TransportMethod insertTransportMethod(Scanner scanner, String line, boolean insert) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		String name = "";
		int speed = 0;
		float pricePerKm = 0.0f;
		
		boolean valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("name : insert a String");
			line = scanner.nextLine();
			if(!line.isEmpty()) {
				name = line;
				valid = true;
			}
		}
		valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("speed : insert an integer");
			line = scanner.nextLine();
			try {
				speed = Integer.parseInt(line);
				valid = true;
			}
			catch(NumberFormatException e) {
			}
		}
		valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("pricePerKm : insert a float");
			line = scanner.nextLine();
			try {
				pricePerKm = Float.parseFloat(line);
				valid = true;
			}
			catch(NumberFormatException e) {
			}
		}
		if(line.equals("cancel")) {
			throw new CancelInsertionIntoDBException();
		}
		if(line.equals("exit")) {
			throw new ExitInsertionIntoDBException();
		}

		TransportMethod method = new TransportMethod(name, speed, pricePerKm);
		if(insert) {
			PersistenceFacade facade = new PersistenceFacade(DatabaseConnection.getConnection());
			facade.persist(method);
		}
		return method;
	}
	
	public static Place insertPlace(Scanner scanner, String line) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		return insertPlace(scanner, line, true);
	}
	public static Place insertPlace(Scanner scanner, String line, boolean insert) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		String name = "";
		Coordinates coord = null;
		String descriptionFile = "";
		
		boolean valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("name : insert a String");
			line = scanner.nextLine();
			if(!line.isEmpty()) {
				name = line;
				valid = true;
			}
		}

		valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("descriptionFile : insert a String");
			line = scanner.nextLine();
			if(!line.isEmpty()) {
				descriptionFile = line;
				valid = true;
			}
		}
		if(line.equals("cancel")) {
			throw new CancelInsertionIntoDBException();
		}
		if(line.equals("exit")) {
			throw new ExitInsertionIntoDBException();
		}
		
		System.out.println("You have to create Coordinates");
		coord = insertCoordinates(scanner, line, false);
		System.out.println("Coordinates created");
		
		Place place = new Place(name, coord, descriptionFile);

		if(insert) {
			PersistenceFacade facade = new PersistenceFacade(DatabaseConnection.getConnection());
			facade.persist(place);
		}
		return place;
	}
	
	public static Visit insertVisit(Scanner scanner, String line) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		return insertVisit(scanner, line, true);
	}
	public static Visit insertVisit(Scanner scanner, String line, boolean insert) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		float time = 0.0f;
		float price = 0.0f;
		Place place = null;
		
		boolean valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("time : insert a float");
			line = scanner.nextLine();
			try {
				time = Float.parseFloat(line);
				valid = true;
			}
			catch(NumberFormatException e) {
			}
		}
		
		valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("price : insert a float");
			line = scanner.nextLine();
			try {
				price = Float.parseFloat(line);
				valid = true;
			}
			catch(NumberFormatException e) {
			}
		}
		if(line.equals("cancel")) {
			throw new CancelInsertionIntoDBException();
		}
		if(line.equals("exit")) {
			throw new ExitInsertionIntoDBException();
		}
		
		System.out.println("You have to create a Place");
		place = insertPlace(scanner, line, false);
		System.out.println("Place created");
		
		Visit visit = new Visit(time, price, place);

		if(insert) {
			PersistenceFacade facade = new PersistenceFacade(DatabaseConnection.getConnection());
			facade.persist(visit);
		}
		return visit;
	}
	
	public static Hotel insertHotel(Scanner scanner, String line) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		return insertHotel(scanner, line, true);
	}
	public static Hotel insertHotel(Scanner scanner, String line, boolean insert) throws SQLException, ClassNotPersistableException, CancelInsertionIntoDBException, ExitInsertionIntoDBException {
		String name = "";
		String descriptionFile = "";
		float pricePerDay = 0.0f;
		Place beach = null;
		
		boolean valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("name : insert a String");
			line = scanner.nextLine();
			if(!line.isEmpty()) {
				name = line;
				valid = true;
			}
		}
		
		valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("descriptionFile : insert a String");
			line = scanner.nextLine();
			if(!line.isEmpty()) {
				descriptionFile = line;
				valid = true;
			}
		}
		
		valid = false;
		
		while(!line.equals("cancel") && !valid && !line.equals("exit")) {
			System.out.println("pricePerDay : insert a float");
			line = scanner.nextLine();
			try {
				pricePerDay = Float.parseFloat(line);
				valid = true;
			}
			catch(NumberFormatException e) {
			}
		}
		if(line.equals("cancel")) {
			throw new CancelInsertionIntoDBException();
		}
		if(line.equals("exit")) {
			throw new ExitInsertionIntoDBException();
		}
		
		System.out.println("You have to create a beach");
		beach = insertPlace(scanner, line, false);
		System.out.println("beach created");
		
		Hotel hotel = new Hotel(name, beach.getCoord(), descriptionFile, pricePerDay, beach);

		if(insert) {
			PersistenceFacade facade = new PersistenceFacade(DatabaseConnection.getConnection());
			facade.persist(hotel);
		}
		return hotel;
	}
}
