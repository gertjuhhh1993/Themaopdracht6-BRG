package Objects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

import DAO.DAO;
import DAO.DAOAttribute;
import DAO.DAOBusinessrule;
import DAO.DAOValue;

public class Businessrule {
	private String name;
	private String businessruletype;
	private String operator;
	public ArrayList<Value> values = new ArrayList<Value>();
	public Attribute attribute;
	public DAO dao;

	public ResultSet getInfo(String type) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException {
		DAO dao = null;
		if(type=="businessrule"){
			dao = new DAOBusinessrule();
		}else if(type=="attribute"){
			dao = new DAOAttribute();
		}else if(type=="value"){
			dao = new DAOValue();
		}
		return dao.fetch(this.name);	
	}

	public void loadFromDbIntoObject() throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException{
		ResultSet rs = getInfo("businessrule");
		this.setName(rs.getString("name"));
		this.setBusinessruletype(rs.getString("businessruletype"));
		this.setOperator(rs.getString("operator"));
		rs.close();
		
		rs = getInfo("value");
		while(rs.next()){
			Value v = new Value();
			v.setOrder(rs.getInt("order"));
			v.setValue(rs.getString("value"));
			
			values.add(v);
		}
		rs.close();
		
		rs = getInfo("attribute");
		while(rs.next()){
			Attribute a = new Attribute();
			//a.set
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBusinessruletype(String businessruletype) {
		this.businessruletype = businessruletype;
	}

	public String getBusinessruletype() {
		return this.businessruletype;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}
}