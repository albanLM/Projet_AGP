package db.sql;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import data.Hotel;
import data.Place;
import data.Trajectory;
import data.TransportMethod;
import data.Visit;

public class JDBCReader {
	
	private Connection conn;
	
	public JDBCReader(Connection co){
		conn = co;
	}
	
	public Place readPlace(int id){
		return null;
	}
	
	public ArrayList<Place> readAllPlaces(){
		return null;
	}
	
	public TransportMethod readTransportMethod(int id){
		return null;
	}
	
	public ArrayList<TransportMethod> readAllTransportMethods(){
		return null;
	}

	public Hotel readHotel(int id){
		return null;
	}
	
	public ArrayList<Hotel> readAllHotels(){
		return null;
	}

	public Visit readVisit(int id){
		return null;
	}
	
	public ArrayList<Visit> readAllVisits(){
		return null;
	}
}
