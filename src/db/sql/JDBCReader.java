package db.sql;

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
	
	public Place readPlace(){
		return null;
	}
	
	public TransportMethod readTransportMethod(){
		return null;
	}

	public Hotel readHotel(){
		return null;
	}

	public Trajectory readTrajectory(){
		return null;
	}

	public Visit readVisit(){
		return null;
	}
}
