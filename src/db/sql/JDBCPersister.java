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

import db.sql.DatabaseConnection;

public class JDBCPersister {
	
	private Connection conn;
	
	public JDBCPersister(Connection co) {
		this.conn = co;
	}
	
	public void persistCoordinates(Coordinates coord) throws SQLException{

		Connection dbConnection = DatabaseConnection.getConnection();
		
		String readCoordinatesQuery = "SELECT id FROM Coordinates WHERE x = ? AND y = ?";
		String insertCoordinatesQuery = "INSERT INTO Place (x, y) VALUES (?,?)";
		
		//Check if coord already exists in the database
		PreparedStatement preparedStatement = dbConnection.prepareStatement(readCoordinatesQuery);
		
		preparedStatement.setInt(1, coord.getX());
		preparedStatement.setInt(2, coord.getY());
		
		ResultSet result = preparedStatement.executeQuery();
		boolean alreadyExists = result.next();
		
		preparedStatement.close();
		
		if(!alreadyExists) {
			//Insert coord in the database
			preparedStatement = dbConnection.prepareStatement(insertCoordinatesQuery);
			
			preparedStatement.setInt(1, coord.getX());
			preparedStatement.setInt(2, coord.getY());

			preparedStatement.executeUpdate();

			preparedStatement.close();
		}
	}
	
	String readCoordinatesPK = "SELECT id FROM Coordinates WHERE x = ? AND y = ?";
	
	public void persistPlace(Place place) throws SQLException{
		
		//First, persist place.coord
		persistCoordinates(place.getCoord());

		Connection dbConnection = DatabaseConnection.getConnection();
		
		String readCoordinatesPKQuery = "SELECT id FROM Coordinates WHERE x = ? AND y = ?";
		String insertPlaceQuery = "INSERT INTO Place (name, descriptionFile, id_coord) VALUES (?,?,?)";
		
		//Get the primary key of place.coordinates
		PreparedStatement preparedStatement = dbConnection.prepareStatement(readCoordinatesPKQuery);
		
		preparedStatement.setInt(1, place.getCoord().getX());
		preparedStatement.setInt(2, place.getCoord().getY());
		
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		int coordPK = result.getInt("id");
		
		preparedStatement.close();

		//Set place in the database
		preparedStatement = dbConnection.prepareStatement(insertPlaceQuery);
		
		preparedStatement.setString(1, place.getName());
		preparedStatement.setString(2, place.getDescriptionFile());
		preparedStatement.setInt(3, coordPK);

		preparedStatement.executeUpdate();

		preparedStatement.close();
	}

	public void persistHotel(Hotel hotel){
		
	}

	public void persistVisit(Visit visit){
		
	}

	public void persistTransportMethod(TransportMethod method){
		
	}
}
