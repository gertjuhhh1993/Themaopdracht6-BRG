package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.logging.Logger;

import dao.DAO;
import dao.DAOAttribute;
import dao.DAOBusinessrule;
import dao.DAOValue;


public class Businessrule {
	private String name;
	private String businessruletype;
	private String operator;
	private ArrayList<Value> values = new ArrayList<Value>();
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	private DAO dao;
/**
 * getInfo gets a resultset from the database based on the given type
 * @param type specifies what you need to fetch from the database
 * @throws FileNotFoundException
 * @throws InvalidPropertiesFormatException
 * @throws IOException
 * @throws SQLException
 * @return a resultset with the database entries of that type
 */
	public ResultSet getInfo(String type) throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException {
		dao = null;
		if(type.equals("businessrule")){
			dao = new DAOBusinessrule();
		}else if(type.equals("attribute")){
			dao = new DAOAttribute();
		}else if(type.equals("value")){
			dao = new DAOValue();
		}
		return dao.fetch(this.name);	
	}
	/**
	 * loads the resultset from @see Businessrule#getInfo(String) into the corresponding object
	 * @throws FileNotFoundException should the database not be found, this exception gets thrown.
	 * @throws InvalidPropertiesFormatException Thrown to indicate that an operation could not complete because the input did not conform to the appropriate XML document type for a collection of properties
	 * @throws IOException should the reading or writing to/from a file not succeed, this exception gets thrown.
	 * @throws SQLException If the sql doesn't succeed, this exception gets thrown.
	 */
	public void loadFromDbIntoObject() throws FileNotFoundException, InvalidPropertiesFormatException, IOException, SQLException{
		Logger logger = Logger.getLogger("defaultLogger");
		logger.info("Loading rule from database");
		ResultSet rs = getInfo("businessrule");
		
		if(rs.next()){
			this.setName(rs.getString("BUSINESSRULENAAM"));
			this.setBusinessruletype(rs.getString("BUSINESSRULETYPENAAM"));
			this.setOperator(rs.getString("OPERATORNAAM"));
			rs.close();
			
			rs = getInfo("value");
			while(rs.next()){
				Value v = new Value();
				v.setOrder(rs.getInt("valorder"));
				v.setValue(rs.getString("value"));
				v.setDatatype(rs.getString("datatype"));
				
				values.add(v);
			}
			rs.close();
			
			rs = getInfo("attribute");
			while(rs.next()){
				Attribute a = new Attribute();
				a.setOrder(rs.getInt("attorder"));
				a.setSchema(rs.getString("schema"));
				a.setTabel(rs.getString("tabel"));
				a.setKolom(rs.getString("kolom"));
				
				attributes.add(a);
			}
			rs.close();
		}
		else{
			logger.warning("This rule is not available in the database.");
		}
		dao.closeConnection();
		
	}
	/**
	 * setter for the attribute name
	 * 
	 * @param name String which has to become the attribute name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter for the attribute name
	 * 
	 * @return a String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for the attribute businessruletype
	 * 
	 * @param businessruletype String which has to become the attribute businessruletype
	 */
	public void setBusinessruletype(String businessruletype) {
		this.businessruletype = businessruletype;
	}
	/**
	 * getter for the attribute businessruletype
	 * 
	 * @return a String
	 */
	public String getBusinessruletype() {
		return this.businessruletype;
	}
	/**
	 * setter for the attribute operator
	 * 
	 * @param operator String which has to become the attribute operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * getter for the attribute operator
	 * 
	 * @return a String
	 */
	public String getOperator() {
		return this.operator;
	}

	public ArrayList<Value> getValues() {
		return values;
	}
	public void setValues(ArrayList<Value> values) {
		this.values = values;
	}
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}
	/**
	 * a method to get the values out of the values ArrayList
	 * @param orderNr the order number from which the method has to search
	 * @return a value that corresponds with the orderNr
	 */
	public Value getValueByOrder(String orderNr) {
		int order = Integer.parseInt(orderNr);
		Value returnValue = null;
		for(Value v:values){
			if(v.getOrder() == order){
				returnValue = v;
				break;
			}
		}
		return returnValue;
	}
	
	public Attribute getAttributeByOrder(String orderNr) {
		int order = Integer.parseInt(orderNr);
		Attribute returnAttribute = null;
		for(Attribute a:attributes){
			if(a.getOrder() == order){
				returnAttribute = a;
				break;
			}
		}
		return returnAttribute;
	}
}
