package db.sql;

import java.sql.Connection;
import java.sql.SQLException;

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
	
	public void persist(Object o) throws SQLException, ClassNotPersistableException {
		if(o instanceof Hotel){
			persister.persistHotel((Hotel) o);
		}
		else if(o instanceof Place){
			persister.persistPlace((Place) o); 
		}
		else if(o instanceof Visit) {
			persister.persistVisit((Visit) o);
		}
		else if(o instanceof TransportMethod) {
			persister.persistTransportMethod((TransportMethod) o);
		}
		else {
			throw new ClassNotPersistableException();
		}
	}
	
	public JDBCReader getReader(){
		return reader;
	}
}
