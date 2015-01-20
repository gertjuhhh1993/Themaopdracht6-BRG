package exception;

import java.io.FileNotFoundException;

public class XmlNotFoundException extends FileNotFoundException{
	public XmlNotFoundException(){
		super();
	}
	/**
	 * Constructor with a specific error message.
	 * @param fileLocation
	 */
	public XmlNotFoundException(String fileLocation){
		super("The file located at '" + fileLocation + "' can not be found.");
	}

}
