import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import controller.Generator;
import dbutil.DBcon;


public class MainTest {
private static DBcon dbcon;
private static Connection c1;
	public static void main(String[] args) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException {
		Generator g = new Generator();
		Logger logger = Logger.getLogger("defaultLogger");
		try {
			FileHandler fh = new FileHandler("log.txt");
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		logger.setLevel(Level.ALL);
		logger.info("Logger is actief");
		g.generate("BRG_IDD_TRG_ACMP_ORA_022");
	}
}
