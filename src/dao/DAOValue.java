package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InvalidPropertiesFormatException;
import java.util.logging.Logger;

import dbutil.DBcon;
import dbutil.Oraclecon;

public class DAOValue implements DAO{
	private Connection con;
	/**
	 * The method fetch fetches a resultset from the database, specifically created for the Value object
	 * @param o The object to store the resultset in.
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
		System.out.println(name);
		ResultSet rs = st.executeQuery("SELECT * FROM value WHERE businessrulenaam='" + name + "'");
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