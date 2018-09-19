package com.tsmi.service.impl.login;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsmi.dao.login.LoginDao;
import com.tsmi.dto.login.UserVO;
import com.tsmi.service.login.LoginService;

import ch.qos.logback.classic.Logger;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginDao loginDao;
	
	@Override
	public Map<String,Object> selectUserInfo(UserVO vo) throws Exception {
		Map<String,Object> user = loginDao.selectUserInfo(vo);
		
		if(user == null) {
			logger.error("LOGIN ERROR - 회원정보 없음");
		}else {
			logger.debug("LOGIN SUCCESS");
		}
		
		return user;  
	}

}
