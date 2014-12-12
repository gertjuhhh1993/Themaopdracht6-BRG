import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

import Controller.Generator;
import DButil.DBcon;
import DButil.Oraclecon;


public class MainTest {
private static DBcon dbcon;
private static Connection c1;
	public static void main(String[] args) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException {
		//dbcon = new Oraclecon();
		//c1 = dbcon.getConnection();
		Generator g = new Generator();
		g.generate("test");
	}

}
