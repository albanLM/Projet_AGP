package db.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;

import data.Coordinates;
import data.Hotel;
import data.Place;
import data.TransportMethod;
import data.Visit;

public class JDBCPersister {
	
	private Connection conn;
	
	public JDBCPersister() {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public void persistCoordinates(Coordinates coord) throws SQLException{
		
		String readCoordinatesQuery = "SELECT id FROM Coordinates WHERE x = ? AND y = ?";
		String insertCoordinatesQuery = "INSERT INTO Coordinates (x, y) VALUES (?,?)";
		
		//Check if coord already exists in the database
		PreparedStatement preparedStatement = conn.prepareStatement(readCoordinatesQuery);
		
		preparedStatement.setInt(1, coord.getX());
		preparedStatement.setInt(2, coord.getY());
		
		ResultSet result = preparedStatement.executeQuery();
		boolean alreadyExists = result.next();
		
		preparedStatement.close();
		
		if(!alreadyExists) {
			//Insert coord in the database
			preparedStatement = conn.prepareStatement(insertCoordinatesQuery);
			
			preparedStatement.setInt(1, coord.getX());
			preparedStatement.setInt(2, coord.getY());

			preparedStatement.executeUpdate();

			preparedStatement.close();
		}
	}
	
	public void persistPlace(Place place) throws SQLException{
		
		//First, persist place.coord
		persistCoordinates(place.getCoord());
		
		String readCoordinatesPKQuery = "SELECT id FROM Coordinates WHERE x = ? AND y = ?";
		String insertPlaceQuery = "INSERT INTO Place (name, descriptionFile, id_coord) VALUES (?,?,?)";
		
		//Get the primary key of place.coordinates
		PreparedStatement preparedStatement = conn.prepareStatement(readCoordinatesPKQuery);
		
		preparedStatement.setInt(1, place.getCoord().getX());
		preparedStatement.setInt(2, place.getCoord().getY());
		
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		int coordPK = result.getInt("id");
		
		preparedStatement.close();

		//Set place in the database
		preparedStatement = conn.prepareStatement(insertPlaceQuery);
		
		preparedStatement.setString(1, place.getName());
		preparedStatement.setString(2, place.getDescriptionFile());
		preparedStatement.setInt(3, coordPK);

		preparedStatement.executeUpdate();

		preparedStatement.close();
	}

	public void persistHotel(Hotel hotel) throws SQLException{
		//First, persist the Place part of hotel and its beach
		Place place = new Place(hotel.getName(), hotel.getCoord(), hotel.getDescriptionFile());
		persistPlace(place);
		persistPlace(hotel.getBeach());
		
		String readPlacePKQuery = "SELECT id FROM Place WHERE name = ? AND descriptionFile = ?";
		String readBeachPKQuery = "SELECT id FROM Place WHERE name = ? AND descriptionFile = ?";
		String insertHotelQuery = "INSERT INTO Hotel (id_place, pricePerDay, id_beach) VALUES (?,?,?)";

		//Then, get the primary key of the Place part and the beach
		PreparedStatement preparedStatement = conn.prepareStatement(readPlacePKQuery);
		
		preparedStatement.setString(1, place.getName());
		preparedStatement.setString(2, place.getDescriptionFile());
		
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		int placePK = result.getInt("id");
		
		preparedStatement.close();
		
		preparedStatement = conn.prepareStatement(readBeachPKQuery);
		
		preparedStatement.setString(1, hotel.getBeach().getName());
		preparedStatement.setString(2, hotel.getBeach().getDescriptionFile());
		
		result = preparedStatement.executeQuery();
		result.next();
		
		int beachPK = result.getInt("id");

		//Set place in the database
		preparedStatement = conn.prepareStatement(insertHotelQuery);
		
		preparedStatement.setInt(1, placePK);
		preparedStatement.setFloat(2, hotel.getPricePerDay());
		preparedStatement.setInt(3, beachPK);

		preparedStatement.executeUpdate();

		preparedStatement.close();
		
	}

	public void persistVisit(Visit visit) throws SQLException{
		//First, persist the Place of visit
		persistPlace(visit.getPlace());
		
		String readPlacePKQuery = "SELECT id FROM Place WHERE name = ? AND descriptionFile = ?";
		String insertVisitQuery = "INSERT INTO Visit (visitTime, price, id_place) VALUES (?,?,?)";

		//Then, get the primary key of the Place
		PreparedStatement preparedStatement = conn.prepareStatement(readPlacePKQuery);
		
		preparedStatement.setString(1, visit.getPlace().getName());
		preparedStatement.setString(2, visit.getPlace().getDescriptionFile());
		
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		int placePK = result.getInt("id");
		
		preparedStatement.close();

		//Set visit in the database
		preparedStatement = conn.prepareStatement(insertVisitQuery);
		
		preparedStatement.setFloat(1, visit.getTime());
		preparedStatement.setFloat(2, visit.getPrice());
		preparedStatement.setInt(3, placePK);

		preparedStatement.executeUpdate();

		preparedStatement.close();
	}

	public void persistTransportMethod(TransportMethod method) throws SQLException{
		String insertVisitQuery = "INSERT INTO TransportMethod (name, speed, pricePerKm) VALUES (?,?,?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(insertVisitQuery);
		
		preparedStatement.setString(1, method.getName());
		preparedStatement.setInt(2, method.getSpeed());
		preparedStatement.setFloat(3, method.getPricePerKm());
		
		preparedStatement.executeUpdate();

		preparedStatement.close();
	}
}
