package com.tsmi.dao.sample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsmi.vo.sample.BoardVO;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sql;
	
	public List<Map<String,Object>> selectUserList(BoardVO vo) {
		return sql.selectList("board.selectUserList", vo);
	}
	
	public int insertUserInfo(BoardVO vo) {
		return sql.insert("board.insertUserInfo", vo);
	}
	
	public Map<String,Object> selectUserInfo(BoardVO vo) {
		return sql.selectOne("board.selectUserInfo", vo);
	}
	
	public int updateUserInfo(BoardVO vo) {
		return sql.update("board.updateUserInfo", vo);
	}
}
