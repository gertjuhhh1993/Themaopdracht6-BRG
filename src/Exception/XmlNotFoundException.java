package Exception;

import java.io.FileNotFoundException;

public class XmlNotFoundException extends FileNotFoundException{
	public XmlNotFoundException(){
		super();
	}
	
	public XmlNotFoundException(String fileLocation){
		super("The file located at '" + fileLocation + "' can not be found.");
	}

}
