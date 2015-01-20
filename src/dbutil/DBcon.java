package dbutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.logging.Logger;

public abstract class DBcon {
	protected String dbms;
	protected String jarFile;
	protected String dbName;
	protected String userName;
	protected String password;
	protected String sid;
	protected String urlString;

	protected String driver;
	protected String serverName;
	protected int portNumber;
	protected Properties prop;
	protected Connection conn = null;
	
	protected void setProperties(String fileName) throws FileNotFoundException,
			IOException, InvalidPropertiesFormatException {
		Logger logger = Logger.getLogger("defaultLogger");
		this.prop = new Properties();
		FileInputStream fis = new FileInputStream(fileName);
		prop.loadFromXML(fis);

		this.dbms = this.prop.getProperty("dbms");
		this.jarFile = this.prop.getProperty("jar_file");
		this.driver = this.prop.getProperty("driver");
		this.dbName = this.prop.getProperty("database_name");
		this.userName = this.prop.getProperty("user_name");
		this.password = this.prop.getProperty("password");
		this.sid = this.prop.getProperty("sid");
		this.serverName = this.prop.getProperty("server_name");
		this.portNumber = Integer
				.parseInt(this.prop.getProperty("port_number"));
		logger.info("Server properties: "+prop);
		
	}

	public abstract Connection getConnection() throws SQLException;
	public final void closeConnection() throws SQLException{
		conn.close();
	}
}