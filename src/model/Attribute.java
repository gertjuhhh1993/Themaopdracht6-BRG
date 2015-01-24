package model;

public class Attribute {
	private int order;
	private String schema;
	private String tabel; 
	private String kolom;

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
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getTabel() {
		return tabel;
	}
	public void setTabel(String tabel) {
		this.tabel = tabel;
	}
	public String getKolom() {
		return kolom;
	}
	public void setKolom(String kolom) {
		this.kolom = kolom;
	}

}