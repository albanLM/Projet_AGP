package db.textual;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import db.sql.DatabaseConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlIterator implements OperatorInterface {

    private int currentPosition;
    private String query;
    private List<String> results;

    public SqlIterator(String query) {
        this.query = query;
        this.currentPosition = 0;
        new DatabaseConnection();
		results = new ArrayList<>();
	}

	@Override
    public void init() throws IOException, ParseException {
        try {
            Statement preparedStatement = (Statement) DatabaseConnection.getConnection().createStatement();
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                String data = rs.getInt("id") + "#" + rs.getString("descriptionFile");
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

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<String> getResults() {
		return results;
	}

	public void setResults(List<String> results) {
		this.results = results;
	}

}
