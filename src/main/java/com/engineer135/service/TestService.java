package com.engineer135.service;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engineer135.dao.ProjectDao;

@Service
public class TestService {
	
	@Autowired
	ProjectDao projectDao;
	
	public void test(){
		try {
			projectDao.test();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int add(HashMap<String,Object> map){
		for(int i=0; i<3; i++){
			map.put("id", "id"+i);
			projectDao.add(map);
		}
		return 0;
	}
}
