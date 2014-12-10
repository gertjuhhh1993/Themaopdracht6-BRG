package Objects;

import java.util.ArrayList;

import DAO.DAO;

public class Businessrule {
	private String name;
	private String businessruletype;
	private String operator;
	public ArrayList<Value> values = new ArrayList<Value>();
	public Attribute attribute;
	public DAO dao;

	public void getInfo() {
		throw new UnsupportedOperationException();
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