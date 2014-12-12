package DButil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Oraclecon extends DBcon {
	
	public Oraclecon() throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		super();
		super.setProperties("Xml/Db/oracle-properties.xml");
	}
	public final Connection getConnection() throws SQLException{
		Connection conn = null;
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", super.userName);
		connectionProps.put("password", super.password);
	
		String currentUrlString = null;
			currentUrlString = "jdbc:" + super.dbms + ":thin:@" + super.serverName + ":" + super.portNumber + ":" + super.sid;
			System.out.println(currentUrlString);
			//				  jdbc:oracle:thin:@" + host + ":" + port + ":" + sid, user, password);
			// String test = "jdbc:oracle:thin:@145.89.21.30:8521:cursus01";
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(currentUrlString,
					connectionProps);
	
			this.urlString = currentUrlString + this.dbName;
			conn.setCatalog(this.dbName);
		
		System.out.println("Connected to database");
		return conn;
	}
}
