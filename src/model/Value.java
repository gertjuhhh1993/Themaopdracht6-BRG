package model;

public class Value {
	private int order;
	private String value;
	public String Datatype;
	
	public void setDatatype(String Datatype) {
		this.Datatype = Datatype;
	}
	public String getDatatype() {
		return Datatype;
	}
	/**
	 * getter for the attribute order
	 * @return an integer
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * setter for the attribute order
	 * 
	 * @param order integer which has to become the attribute order
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * getter for the attribute value
	 * 
	 * @return a String
	 */
	public String getValue() {
		return value;
	}
	/**
	 * setter for the attribute value
	 * 
	 * @param value String which has to become the attribute value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}