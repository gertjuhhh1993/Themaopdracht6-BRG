package Objects;

public class Attribute {
	private int order;
	private int value;
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
	 * @return an integer
	 */
	public int getValue() {
		return value;
	}
	/**
	 * setter for the attribute value
	 * 
	 * @param value integer which has to become the attribute value
	 */
	public void setValue(int value) {
		this.value = value;
	}
}