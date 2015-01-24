package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

public interface DAO {
	public ResultSet fetch(Object o) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException;
	public void closeConnection();
}

