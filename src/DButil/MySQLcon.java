package DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySQLcon extends DBcon{
	
	public MySQLcon(){
		super();
	}

	public void getConnection() {
	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", super.username);
	    connectionProps.put("password", super.password);

	    if (this.dbms.equals("mysql")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + "://" +
	                   this.serverName +
	                   ":" + this.portNumber + "/",
	                   connectionProps);
	    } else if (this.dbms.equals("derby")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + ":" +
	                   this.dbName +
	                   ";create=true",
	                   connectionProps);
	    }
	    System.out.println("Connected to database");
	    return conn;
	}
}