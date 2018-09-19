package com.engineer135.dao;

import java.sql.SQLException;
import java.util.HashMap;

public interface ProjectDao {
	void test() throws SQLException;
	int add(HashMap<String,Object> map);
}
