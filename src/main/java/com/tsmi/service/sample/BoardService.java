package com.tsmi.service.sample;

import java.util.List;
import java.util.Map;

import com.tsmi.vo.sample.BoardVO;

public interface BoardService {
	List<Map<String,Object>> selectUserList(BoardVO vo) throws Exception;
	public int insertUserInfo(BoardVO vo) throws Exception;
	public Map<String,Object> selectUserInfo(BoardVO vo) throws Exception;
	public int updateUserInfo(BoardVO vo) throws Exception;
}
