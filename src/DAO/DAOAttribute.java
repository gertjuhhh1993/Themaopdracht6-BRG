package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

public class DAOAttribute implements DAO{
	
	public DAOAttribute(){
		super();
	}

	public void fetch() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ResultSet fetch(Object o) throws FileNotFoundException,
			InvalidPropertiesFormatException, IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}