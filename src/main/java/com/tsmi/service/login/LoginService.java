package com.tsmi.service.login;

import java.util.Map;

import com.tsmi.vo.login.UserVO;

public interface LoginService {
	Map<String,Object> selectUserInfo(UserVO vo) throws Exception;
}
