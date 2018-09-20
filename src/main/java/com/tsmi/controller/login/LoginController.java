package com.tsmi.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsmi.service.login.LoginService;
import com.tsmi.vo.login.UserVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Model model){
		return "login";
	}
	
	@RequestMapping(value="/signIn", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> signIn(HttpServletRequest request, Model model, UserVO vo) throws Exception{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("isLogin", "N");
		Map<String,Object> user = loginService.selectUserInfo(vo);
		if(user != null) {
			request.getSession().setAttribute("loginUser", user);
			resultMap.put("isLogin", "Y");
		}
		return resultMap;
	}
}
