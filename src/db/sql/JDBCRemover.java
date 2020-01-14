package db.sql;

import com.mysql.jdbc.Connection;

import data.Hotel;
import data.Place;
import data.Trajectory;
import data.TransportMethod;
import data.Visit;

public class JDBCRemover {

	private Connection conn;
	
	public JDBCRemover(Connection co) {
		conn = co;
	}
	
	public void removePlace(Place place){
		
	}
	
	public void removeTransportMethod(TransportMethod method){
		
	}

	public void removeHotel(Hotel hotel){
		
	}

	public void removeTrajectory(Trajectory trajectory){
		
	}

	public void removeVisit(Visit visit){
		
	}
}
