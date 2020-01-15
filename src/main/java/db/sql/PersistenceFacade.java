package db.sql;

import java.sql.Connection;
import java.sql.SQLException;

import data.Coordinates;
import data.Hotel;
import data.Place;
import data.TransportMethod;
import data.Visit;
import db.sql.exceptions.ClassNotPersistableException;

public class PersistenceFacade {
	
	private JDBCPersister persister;
	private JDBCReader reader;
	
	public PersistenceFacade(Connection co) {
		persister = new JDBCPersister(co);
		reader = new JDBCReader(co);
	}
	
	public void persist(Object obj) throws SQLException, ClassNotPersistableException{
		if(obj instanceof Coordinates){
			persister.persistCoordinates((Coordinates) obj);
		}
		else if(obj instanceof Hotel){
			persister.persistHotel((Hotel) obj);
		}
		else if(obj instanceof Place){
			persister.persistPlace((Place) obj); 
		}
		else if(obj instanceof Visit) {
			persister.persistVisit((Visit) obj);
		}
		else if(obj instanceof TransportMethod) {
			persister.persistTransportMethod((TransportMethod) obj);
		}
		else {
			throw new ClassNotPersistableException();
		}
		System.out.println("Insertion completed");
	}
	
	public JDBCReader getReader(){
		return reader;
	}
}
