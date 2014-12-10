package DAO;

import DButil.DBcon;

public interface DAO {
	DBcon target = null;
	DBcon tool = null;
	public void fetch();
}