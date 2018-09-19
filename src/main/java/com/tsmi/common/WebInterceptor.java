package com.tsmi.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WebInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		logger.debug("=============== INTERCEPTOR BEGIN =================");
		logger.debug(request.getServletPath().toString());
		boolean isPassed = true;
		
		// 로그인 체크
		/*Map<String,Object> loginUser = (Map<String, Object>) request.getSession().getAttribute("loginUser");
		if(loginUser == null) {
			logger.error("LOGIN REQUIRED... PAGE ACCESS DENIED");
			response.sendRedirect("/login");
			return false;
		}*/
		
		logger.debug("=============== INTERCEPTOR END =================");
		return isPassed;
	}
}
