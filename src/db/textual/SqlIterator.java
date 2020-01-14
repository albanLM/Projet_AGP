package db.textual;

import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlIterator implements OperatorInterface{
	
	private ResultSet results;
	private String query; 
	private static String host;
	private static String base;
	private static String user;
	private static String password;
	private static String url;

	/**
	 * Lazy singleton instance.
	 */
	private Connection connection;

	public SqlIterator(String query) {
		query = query; 
	}

	
	@Override
	public void init() throws IOException, ParseException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			results = preparedStatement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() throws SQLException {
		try {
            return !results.isLast();
        } catch (SQLException e) {
            return false;
        }
	}

	@Override
	public Object next() {
		try {
			if (!hasNext()) {
	            return null;
	        }
			
			results.next();

	        return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void reset() {
	}

}
