package db.textual;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import com.mysql.jdbc.Statement;

import db.sql.DatabaseConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlIterator implements OperatorInterface{
	
	private int currentPosition = 0; 
	private String query;
	private List<String> results = new ArrayList<>();
	
	public SqlIterator(String query) {
		this.query = query;
		new DatabaseConnection();
	}

	
	@Override
	public void init() throws IOException, ParseException {
		try {
			Statement  preparedStatement = (Statement) DatabaseConnection.getConnection().createStatement();
			ResultSet rs = preparedStatement.executeQuery(query);
			while(rs.next()) {
				String data = rs.getInt("id")+"#"+rs.getString("descriptionFile");
				System.out.println(data);
				results.add(data);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() {
		return currentPosition < results.size();
	}

	@Override
	public String next() {
		if (!hasNext()) {
            return null;
        }
        String doc = results.get(currentPosition);
        currentPosition++;
        return doc; 
	}

	@Override
	public void reset() {
		currentPosition = 0; 
	}

}
