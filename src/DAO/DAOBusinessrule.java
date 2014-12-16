package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InvalidPropertiesFormatException;

import DButil.*;

public class DAOBusinessrule implements DAO{
	/**
	 * The method fetch fetches a resultset from the database, specifically created for the BusinessRule object
	 * @param o The object to store the resultset in.
	 * @throws FileNotFoundException should the database not be found, this exception gets thrown.
	 * @throws InvalidPropertiesFormatException Thrown to indicate that an operation could not complete because the input did not conform to the appropriate XML document type for a collection of properties
	 * @throws IOException should the reading or writing to/from a file not succeed, this exception gets thrown.
	 * @throws SQLException If the sql doesn't succeed, this exception gets thrown.
	 * @return returns the resultSet from the database.
	 */
	public ResultSet fetch(Object o) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException {
		String name = (String)o;
		DBcon db = new Oraclecon();
		Connection con = db.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Businessrule WHERE BUSINESSRULENAAM='" + name + "'");
		//con.close();
		return rs;
	}
}