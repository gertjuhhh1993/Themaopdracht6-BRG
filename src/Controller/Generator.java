package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import Objects.Attribute;
import Objects.Businessrule;
import Objects.Value;

public class Generator {
	private Properties prop,p2;
	private String template;
	public Listener _unnamed_Listener_;
	private HashMap<String, String> hm;
	private Businessrule br = new Businessrule();
	/**
	 * Generate the businessrule with the following steps
	 * 1. create a new businessrule
	 * 2. set the name of the businessrule
	 * 3. get the rest of the data for the businessrule from the tooldatabase
	 * 4. read the templates for the specific database
	 * 5. read the xmlfile with the placeholder definition to determine what to replace
	 * 6. fill a map(hm) with the entry key and value
	 * 7. call method to replace the placeholders with the correct values
	 * @param brName
	 * @throws InvalidPropertiesFormatException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void generate(String brName) throws InvalidPropertiesFormatException, IOException, SQLException {
//		br = new Businessrule();
//		br.setName(brName);
//		br.loadFromDbIntoObject();
		this.prop = new Properties();
		FileInputStream fis = new FileInputStream("Xml/RuleTemplates/oracle.xml");
		prop.loadFromXML(fis);
		
		this.p2 = new Properties();
		FileInputStream fisPlaceholder = new FileInputStream("Xml/RuleTemplates/oraclePlaceholder.xml");
		p2.loadFromXML(fisPlaceholder);
		Enumeration<Object> keys= p2.keys();
		hm = new HashMap <String, String>();
		while(keys.hasMoreElements()){
			Object keyO = keys.nextElement();
			String key = keyO.toString();
			hm.put(key, p2.getProperty(key));
			System.out.println(key + " --- " + p2.getProperty(key));
		}
		this.template = this.prop.getProperty("range");
		System.out.println(template);
		System.out.println(replacePlaceholderWithValues(template));
	}

	public void checkAvailableXML(Object aLanguage) {
		throw new UnsupportedOperationException();
	}
	/**
	 * replacePlaceholderWithValues is a method that replaces
	 * placeholder names with actual names. 
	 * 
	 * @param unfinishedTemplate A String which contains the values that the placeholder should become.
	 * @return The value.
	 */
	public String replacePlaceholderWithValues(String unfinishedTemplate){
		String finishedTemplate = "";
		
		for (HashMap.Entry<String, String> replacement : hm.entrySet()) {
			unfinishedTemplate = unfinishedTemplate.replace(replacement.getKey(), replacement.getValue());
			String[] array = replacement.getValue().split("\\.");
			String object = array[0];
			String attribute = array[1];
			String replacingValue = "NoValueFound";
//			
//			private String businessruletype;
//			private String operator;
//			public ArrayList<Value> values = new ArrayList<Value>();
//			public Attribute attribute;
			if(object == "businessrule"){
				switch (attribute) {
	            case "name": replacingValue = br.getName();
	            case "operator": replacingValue = br.getOperator();
	            case "values": br.getValueByOrder(array[2]).getValue();
	           // case "attributes": br.getAttributeByOrder(array[2]).getValue();
	            break;
				}
			}
			
		}
		
		/*
		 * BR_RNG_01
		 * min == 1 --> 20
		 * max == 2 --> 25
		 * 
		 */
		finishedTemplate= unfinishedTemplate;
		return finishedTemplate;
	}
}