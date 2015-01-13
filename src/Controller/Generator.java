package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import Objects.Businessrule;

public class Generator {
	private Properties templateProperties,placeHolderProperties;
	private String ruleTemplate;
	private HashMap<String, String> placeHolderHashmap;
	private Businessrule br = new Businessrule();
	/**
	 * Generate the businessrule with the following steps
	 * 1. create a new businessrule
	 * 2. set the name of the businessrule
	 * 3. get the rest of the data for the businessrule from the tooldatabase
	 * 4. read the templates for the specific database
	 * 5. read the xmlfile with the placeholder definition to determine what to replace
	 * 6. fill a map(placeHolderHashmap) with the entry key and value
	 * 7. call method to replace the placeholders with the correct values
	 * @param brName
	 * @throws InvalidPropertiesFormatException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void generate(String brName) throws InvalidPropertiesFormatException, IOException, SQLException {
		br = new Businessrule();
		br.setName(brName);
		br.loadFromDbIntoObject();
		String[] nameParts = br.getName().split("_");
		/*
		 * BRG_IDD_TRG_RNG_ORA_001
		 * 0 = BRG = Businessrulegenerator
		 * 1 = IDD = Naam van het veld. eerste 2 letters en laatste letter
		 * 2 = TRG = Trigger
		 * 3 = RNG = Rule type
		 * 4 = ORA = Databasetype
		 * 5 = 001 = Volgnummer
		 */
		
		String databaseType = nameParts[4];
		String ruleType = nameParts[3];
		this.templateProperties = new Properties();
		String templateLocation = "Xml/RuleTemplates/" + databaseType + "/" + ruleType + ".xml";
		String placeholderLocation = "Xml/RuleTemplates/" + databaseType + "/" + ruleType + "Placeholder.xml";
		if(checkAvailableXML(templateLocation) && checkAvailableXML(placeholderLocation)){
			FileInputStream fisTemplate = new FileInputStream(templateLocation);
			templateProperties.loadFromXML(fisTemplate);
			
			this.placeHolderProperties = new Properties();
			FileInputStream fisPlaceholder = new FileInputStream(placeholderLocation);
			placeHolderProperties.loadFromXML(fisPlaceholder);
			
			Enumeration<Object> keys= placeHolderProperties.keys();
			placeHolderHashmap = new HashMap <String, String>();
			while(keys.hasMoreElements()){
				Object keyO = keys.nextElement();
				String key = keyO.toString();
				placeHolderHashmap.put(key, placeHolderProperties.getProperty(key));
				System.out.println(key + " --- " + placeHolderProperties.getProperty(key));
			}
			
			this.ruleTemplate = this.templateProperties.getProperty("template");
			System.out.println(ruleTemplate);
			System.out.println(replacePlaceholderWithValues(ruleTemplate));
		}
		else{
			//XML file doesn't exist
		}
	}

	public boolean checkAvailableXML(String fileLocation) {
		File f = new File(fileLocation);
		if(f.isFile()) {
			return true;
		}
		return false;
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
		
		for (HashMap.Entry<String, String> replacement : placeHolderHashmap.entrySet()) {
			String[] valueParts = replacement.getValue().split("\\.");
			String object = valueParts[0];
			String attribute = valueParts[1];
			String replacingValue = "NoValueFound";
			
			if(object.equals("businessrule")){
				switch (attribute) {
	            case "name": replacingValue = br.getName();break;
	            case "operator": replacingValue = br.getOperator();break;
	            case "values": 
	            	String[] values = replaceValues(br); 
	            	switch(valueParts[2] + ""){
	            	case "all": values;
	            	default: replacingValue = (valueParts[3].equals("order") ==true
	            			? valueParts[2]) + "" : 
	            				(valueParts[3].equals("value") ==true? value[integer.parseint(valueParts[2])-1]: replacingValue));
	            	};break;
	            	
	            case "attributes": 
	            	switch(valueParts[2]){
	            	case "all": br.getValues();
	            	default: replacingValue = (valueParts[3].equals("order") 
	            			? br.getValueByOrder(valueParts[2]).getOrder() + "" 
	            			: (valueParts[3].equals("schema") 
	            					? br.getAttributeByOrder(valueParts[2]).getSchema()
	            					: (valueParts[3].equals("tabel") 
	    	            					? br.getAttributeByOrder(valueParts[2]).getTabel()
	    	    	            			: (valueParts[3].equals("kolom") 
	    	    	    	            			? br.getAttributeByOrder(valueParts[2]).getKolom()
	    	    	    	    	            	: replacingValue))));
	            	};break;
				}
				unfinishedTemplate = unfinishedTemplate.replace(replacement.getKey(), replacingValue);
			}
		}
		
		finishedTemplate= unfinishedTemplate;
		return finishedTemplate;
	}
	public String[] replaceValue(BusinessRule rule) {
		String[] result = null;
		Value[] valueList = rule.getValues;
		for(Value v : valueList) {
			if(v.getDatatype.equals("String") {
				result.add("'"+v.getValue()+"'";
			} else if(v.getDatatype.equals("Number") {
				result.add(v.getValue());
			} else if(v.getDatatype.equals("Date") {
				
			}
		}
		return result;
	}
}
