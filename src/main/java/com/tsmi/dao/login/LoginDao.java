package com.tsmi.dao.login;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsmi.dto.login.UserVO;

@Repository
public class LoginDao {
	
	@Autowired
	private SqlSession sql;
	
	public Map<String,Object> selectUserInfo(UserVO vo) {
		return sql.selectOne("login.selectUserInfo", vo);
	}
	
}
