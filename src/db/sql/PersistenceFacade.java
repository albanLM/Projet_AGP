package db.sql;

import com.mysql.jdbc.Connection;

public class PersistenceFacade {
	
	private JDBCPersister persister;
	private JDBCReader reader;
	private JDBCRemover remover;
	
	public PersistenceFacade(Connection co) {
		persister = new JDBCPersister(co);
		reader = new JDBCReader(co);
		remover = new JDBCRemover(co);
	}
	
	public void persist(Object o){
		
	}
	
	public void remove(Object o){
		
	}
	
	public JDBCReader getReader(){
		return reader;
	}
}
