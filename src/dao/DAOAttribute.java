package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InvalidPropertiesFormatException;

import dbutil.DBcon;
import dbutil.Oraclecon;

public class DAOAttribute implements DAO{
	private Connection con;
	/**
	 * 
	 * An empty constructor
	 */
	public DAOAttribute(){}

	/**
	 * The method fetch fetches a resultset from the database, specifically created for the Attribute object
	 * @param o This is the name of the businessrule.
	 * @throws FileNotFoundException should the database not be found, this exception gets thrown.
	 * @throws InvalidPropertiesFormatException Thrown to indicate that an operation could not complete because the input did not conform to the appropriate XML document type for a collection of properties
	 * @throws IOException should the reading or writing to/from a file not succeed, this exception gets thrown.
	 * @throws SQLException If the sql doesn't succeed, this exception gets thrown.
	 * @return returns the resultSet from the database.
	 */
	@Override
	public ResultSet fetch(Object o) throws FileNotFoundException,
			InvalidPropertiesFormatException, IOException, SQLException {
		String name = (String)o;
		DBcon db = new Oraclecon();
		con = db.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Attribute WHERE businessrulenaam='"+name+"'");
		return rs;
	}
	
	public void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}