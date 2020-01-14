package db.sql;

import com.mysql.jdbc.Connection;

import data.Hotel;
import data.Place;
import data.Trajectory;
import data.TransportMethod;
import data.Visit;

public class JDBCPersister {
	
	private Connection conn;
	
	public JDBCPersister(Connection co) {
		conn = co;
	}
	
	public void persistPlace(Place place){
		
	}
	
	public void persistTransportMethod(TransportMethod method){
		
	}

	public void persistHotel(Hotel hotel){
		
	}

	public void persistTrajectory(Trajectory trajectory){
		
	}

	public void persistVisit(Visit visit){
		
	}
}
