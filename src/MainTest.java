import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

import DAO.DAO;
import DAO.DAOBusinessrule;
import DButil.DBcon;
import DButil.Oraclecon;


public class MainTest {
private static DBcon dbcon;
private static Connection c1;
	public static void main(String[] args) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException {
		dbcon = new Oraclecon();
		c1 = dbcon.getConnection();
		DAO dao = new DAOBusinessrule();
		ResultSet rs = dao.fetch("Testgert");
		rs.next();
		System.out.println(rs.getString("OPERATORNAAM"));
		dao.closeConnection();
//		Generator g = new Generator();
//		g.generate("test");
	}

}
