package com.tsmi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContoller {
	
	@RequestMapping("/")
	public void root(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("/login");
	}
	
	@RequestMapping("/main")
	public String main(Model model){
		return "main";
	}

}
