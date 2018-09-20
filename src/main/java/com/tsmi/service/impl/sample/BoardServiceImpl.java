package com.tsmi.service.impl.sample;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsmi.dao.sample.BoardDao;
import com.tsmi.service.sample.BoardService;
import com.tsmi.vo.sample.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Map<String, Object>> selectUserList(BoardVO vo) throws Exception {
		return boardDao.selectUserList(vo);
	}

	@Override
	public int insertUserInfo(BoardVO vo) throws Exception {
		return boardDao.insertUserInfo(vo);
	}

	@Override
	public Map<String, Object> selectUserInfo(BoardVO vo) throws Exception {
		return boardDao.selectUserInfo(vo);
	}

	@Override
	public int updateUserInfo(BoardVO vo) throws Exception {
		return boardDao.updateUserInfo(vo);
	}

}
