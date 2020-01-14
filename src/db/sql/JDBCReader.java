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
	
	public ArrayList<Place> readAllPlaces() throws SQLException{
		ArrayList<Place> places = new ArrayList<Place>();
		
		String placeQuery = "SELECT * FROM Place";
		String coordsQuery = "SELECT * FROM Coordinates WHERE id=?";
		
		PreparedStatement placeStatement = conn.prepareStatement(placeQuery);
		ResultSet resultPlace = placeStatement.executeQuery();
		
		while(resultPlace.next()!=false) {
			PreparedStatement coordsStatement = conn.prepareStatement(coordsQuery);
			coordsStatement.setInt(1,resultPlace.getInt("id_coords"));
			ResultSet resultCoords = coordsStatement.executeQuery();
			
			Coordinates coords = new Coordinates(resultCoords.getInt("x"),resultCoords.getInt("y"));
			
			places.add(new Place(resultPlace.getString("name"),coords,resultPlace.getString("descriptionFile")));
		}
		
		return places;
	}
	
	public TransportMethod readTransportMethod(int id) throws SQLException{
		String transportQuery = "SELECT * FROM TransportMethod WHERE id=?";
		
		PreparedStatement transportStatement = conn.prepareStatement(transportQuery);
		transportStatement.setInt(1,id);
		ResultSet resultTransport = transportStatement.executeQuery();
		
		return new TransportMethod(resultTransport.getString("name"),resultTransport.getInt("speed"),resultTransport.getFloat("pricePerKm"));
	}
	
	public ArrayList<TransportMethod> readAllTransportMethods() throws SQLException{
		ArrayList<TransportMethod> methods = new ArrayList<TransportMethod>();
		String transportQuery = "SELECT * FROM TransportMethod WHERE";
		
		PreparedStatement transportStatement = conn.prepareStatement(transportQuery);
		ResultSet resultTransport = transportStatement.executeQuery();
		
		while(resultTransport.next()!=false) {
			methods.add(new TransportMethod(resultTransport.getString("name"),resultTransport.getInt("speed"),resultTransport.getFloat("pricePerKm")));
		}
		
		return methods;
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
	
	public ArrayList<Hotel> readAllHotels() throws SQLException{
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		String hotelQuery = "SELECT * FROM Hotel";
		
		PreparedStatement hotelStatement = conn.prepareStatement(hotelQuery);
		ResultSet resultHotel = hotelStatement.executeQuery();
		
		while(resultHotel.next()!=false) {
			Place place = this.readPlace(resultHotel.getInt("id"));
			Place beach = this.readPlace(resultHotel.getInt("id_beach"));
			
			hotels.add(new Hotel(place.getName(),place.getCoord(),place.getDescriptionFile(),resultHotel.getFloat("pricePerDay"),beach));
		}
		
		return hotels;
	}

	public Visit readVisit(int id) throws SQLException{
		String visitQuery = "SELECT * FROM Visit WHERE id=?";
		
		PreparedStatement visitStatement = conn.prepareStatement(visitQuery);
		visitStatement.setInt(1,id);
		ResultSet resultVisit = visitStatement.executeQuery();
		
		Place place = this.readPlace(resultVisit.getInt("id_place"));
		
		return new Visit(resultVisit.getFloat("visitTime"),resultVisit.getFloat("price"),place);
	}
	
	public ArrayList<Visit> readAllVisits() throws SQLException{
		ArrayList<Visit> visits = new ArrayList<Visit>();
		
String visitQuery = "SELECT * FROM Visit";
		
		PreparedStatement visitStatement = conn.prepareStatement(visitQuery);
		ResultSet resultVisit = visitStatement.executeQuery();
		
		while(resultVisit.next()!=false) {
			Place place = this.readPlace(resultVisit.getInt("id_place"));
			visits.add(new Visit(resultVisit.getFloat("visitTime"),resultVisit.getFloat("price"),place));
		}
		
		return visits;
	}
}
