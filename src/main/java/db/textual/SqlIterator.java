package db.textual;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import db.sql.DatabaseConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SqlIterator implements IteratorInterface {

    private int currentPosition;
    private String query;
    private List<String> results;
    private String tableName;
	private String columnName;
	private String idName;
	
    public SqlIterator(String query,String tableName,String columnName,String idName) {
        this.query = query;
        this.tableName = tableName;
        this.setColumnName(columnName);
        this.setIdName(idName);
        this.currentPosition = 0;
        new DatabaseConnection();
		results = new ArrayList<>();
	}

	@Override
    public void init() throws IOException, ParseException {
        try {
        	ResultSet rs = null;
            Statement preparedStatement = (Statement) DatabaseConnection.getConnection().createStatement();
            System.out.println(!query.contains("*"));
			System.out.println(query);
            if(!query.contains(tableName)) {
            	rs = preparedStatement.executeQuery(query);
            	ResultSetMetaData metaData = rs.getMetaData();
                int columns = metaData.getColumnCount();
                
                
                
                while (rs.next()) {
                	String data =  metaData.getColumnName(1)+":" + rs.getString(1);
                	
                    for (int i = 2; i <= columns; i++) {
                    	data = data + "#"+metaData.getColumnName(i)+":" + rs.getString(i);
                	}
                    results.add(data);
                }
            }else {
	            
	            if(query.contains("*") || (query.contains(idName) && query.contains(columnName))) {
		            
		            rs = preparedStatement.executeQuery(query);
		            //System.out.println(query);
	            }else {
	            	
	            	String[] rsS = query.split("(?i)select");
		            rsS[1] = "SELECT "+tableName+"."+idName+","+columnName+","+rsS[1];
		            rs = preparedStatement.executeQuery(rsS[1]);
		            //System.out.println(rsS[1]);
	            }
	            
	            ResultSetMetaData metaData = rs.getMetaData();
	            int columns = metaData.getColumnCount();
	            
	            
	            
	            while (rs.next()) {
	            	String data =  rs.getInt(tableName+"."+idName) + "#" + rs.getString(columnName);
	            	
	                for (int i = 1; i <= columns; i++) {
	                	//System.out.println(metaData.getColumnName(i));
	                	if(!metaData.getColumnName(i).equals(columnName) && !metaData.getColumnName(i).equals(idName)) {
	                		data = data + "#"+metaData.getColumnName(i)+":" + rs.getString(i);
	                		
		                }
	                	
	            	}
	                results.add(data);
	            }
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
    
    public String position() {
		String doc = results.get(currentPosition);
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

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
