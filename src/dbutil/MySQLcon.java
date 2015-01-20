package dbutil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.logging.Logger;

public class MySQLcon extends DBcon {
	
	public MySQLcon() throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		super();
		super.setProperties("Xml/Db/mysql-properties.xml");
	}
	public final Connection getConnection() throws SQLException{
		Logger logger = Logger.getLogger("defaultLogger");
		Connection conn = null;
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", super.userName);
		connectionProps.put("password", super.password);
	
		String currentUrlString = null;
			currentUrlString = "jdbc:" + super.dbms + "://" + super.serverName + "/" + super.dbName + "?user=" + super.userName + "&password=" + super.password;
			System.out.println(currentUrlString);
			//				  jdbc:oracle:thin:@" + host + ":" + port + ":" + sid, user, password);
			// String test = jdbc:mysql://localhost/test?user=super.userName&password=super.password
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(currentUrlString,
					connectionProps);
	
			this.urlString = currentUrlString + this.dbName;
			conn.setCatalog(this.dbName);
		
		logger.info("Connected to mysql database");
		return conn;
	}
}
