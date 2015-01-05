import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

import Controller.Generator;
import DButil.DBcon;


public class MainTest {
private static DBcon dbcon;
private static Connection c1;
	public static void main(String[] args) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException {
		Generator g = new Generator();
		g.generate("BRG_IDD_TRG_RNG_ORA_013");
	}

}
