package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

import DButil.DBcon;

public interface DAO {
	DBcon target = null;
	DBcon tool = null;
	public void fetch();
	public ResultSet fetch(Object o) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException;
}