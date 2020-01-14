package db.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import data.Coordinates;
import data.Hotel;
import data.Place;
import data.TransportMethod;
import data.Visit;

public class JDBCReader {
	
	private Connection conn;
	
	public JDBCReader(Connection co){
		conn = co;
	}
	
	public Place readPlace(int id) throws SQLException{
		String placeQuery = "SELECT * FROM Place WHERE id=?";
		String coordsQuery = "SELECT * FROM Coordinates WHERE id=?";
		
		PreparedStatement placeStatement = conn.prepareStatement(placeQuery);
		placeStatement.setInt(1,id);
		ResultSet resultPlace = placeStatement.executeQuery();
		
		PreparedStatement coordsStatement = conn.prepareStatement(coordsQuery);
		coordsStatement.setInt(1,resultPlace.getInt("id_coords"));
		ResultSet resultCoords = coordsStatement.executeQuery();
		
		Coordinates coords = new Coordinates(resultCoords.getInt("x"),resultCoords.getInt("y"));
		
		return new Place(resultPlace.getString("name"),coords,resultPlace.getString("descriptionFile"));
	}
	
	public ArrayList<Place> readAllPlaces(){
		return null;
	}
	
	public TransportMethod readTransportMethod(int id) throws SQLException{
		String transportQuery = "SELECT * FROM TransportMethod WHERE id=?";
		
		PreparedStatement transportStatement = conn.prepareStatement(transportQuery);
		transportStatement.setInt(1,id);
		ResultSet resultTransport = transportStatement.executeQuery();
		
		return new TransportMethod(resultTransport.getString("name"),resultTransport.getInt("speed"),resultTransport.getFloat("pricePerKm"));
	}
	
	public ArrayList<TransportMethod> readAllTransportMethods(){
		return null;
	}

	public Hotel readHotel(int id) throws SQLException{
		Place place = this.readPlace(id);
		
		String hotelQuery = "SELECT * FROM Hotel WHERE id=?";
		
		PreparedStatement hotelStatement = conn.prepareStatement(hotelQuery);
		hotelStatement.setInt(1,id);
		ResultSet resultHotel = hotelStatement.executeQuery();
		
		Place beach = this.readPlace(resultHotel.getInt("id_beach"));
		
		return new Hotel(place.getName(),place.getCoord(),place.getDescriptionFile(),resultHotel.getFloat("pricePerDay"),beach);
	}
	
	public ArrayList<Hotel> readAllHotels(){
		return null;
	}

	public Visit readVisit(int id) throws SQLException{
		String visitQuery = "SELECT * FROM Visit WHERE id=?";
		
		PreparedStatement visitStatement = conn.prepareStatement(visitQuery);
		visitStatement.setInt(1,id);
		ResultSet resultVisit = visitStatement.executeQuery();
		
		Place place = this.readPlace(resultVisit.getInt("id_place"));
		
		return new Visit(resultVisit.getFloat("visitTime"),resultVisit.getFloat("price"),place);
	}
	
	public ArrayList<Visit> readAllVisits(){
		return null;
	}
}
