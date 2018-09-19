package com.engineer135.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engineer135.service.TestService;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/showMessage")
	public String showMessage(Model model){
		System.out.println("이건 타나?");
		model.addAttribute("message", "welcome spring4");
		return "showMessage";
	}
	
	@RequestMapping("/showMessage2")
	public String showMessage2(Model model){
		System.out.println("이건 타나?");
		model.addAttribute("message", "welcome spring4");
		return "showMessage2";
	}
	
	@RequestMapping("/testPage")
	public String testPage(Model model){
		System.out.println("testPage");
		return "testPage";
	}
	
	@RequestMapping("/ajaxTest")
	@ResponseBody
	public Map<String,Object> ajaxTest(){
		System.out.println("ajax 들어옴");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("test", "ajax gogo");
		return resultMap;
	}
	
	//@Resource
	@Autowired
	TestService testService;
	
	@RequestMapping("/test")
	public void test(){
		testService.test();
	}
	
	@RequestMapping("/add")
	public void add(@RequestParam HashMap<String, Object> params){
		logger.debug("params======"+params);
		testService.add(params);
	}
}
