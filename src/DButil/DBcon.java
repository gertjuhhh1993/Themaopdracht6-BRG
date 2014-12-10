package DButil;

import DAO.DAO;
import Controller.Oraclecon;

public abstract class DBcon {
	protected String username;
	protected String password;
	protected String serverName;
	protected String dbName;
	protected String portNumber;
	protected String dbms;

	public void getConnection() {}
}