package com.tsmi.controller.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsmi.service.sample.BoardService;
import com.tsmi.vo.sample.BoardVO;

@Controller
@RequestMapping("/sample/")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("list")
	public String list(Model model){
		return "/sample/list";
	}
	
	@RequestMapping("getList")
	@ResponseBody
	public Map<String,Object> getList(Model model, @ModelAttribute BoardVO vo) throws Exception{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<Map<String,Object>> userList = boardService.selectUserList(vo);
		resultMap.put("userList", userList);
		return resultMap;
	}
	
	@RequestMapping("form")
	public ModelAndView form() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sample/form");
	    return mv;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(HttpServletResponse response, @ModelAttribute BoardVO vo) throws Exception{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("msg", "성공적으로 등록되었습니다.");
		int result = this.boardService.insertUserInfo(vo);
		if(result <= 0) {
			resultMap.put("msg", "에러가 발생했습니다. 무슨 에러일까..");
		}
		resultMap.put("result", result);
	    return resultMap;
	}
	
	@RequestMapping("edit")
	public ModelAndView edit(@ModelAttribute BoardVO vo) throws Exception{
		// TODO 수정가능한 글인지 검증
		
		ModelAndView mv = new ModelAndView();
		Map<String,Object> userInfo = boardService.selectUserInfo(vo);
		mv.addObject("userInfo", userInfo);
		mv.setViewName("/sample/edit");
	    return mv;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(HttpServletResponse response, @ModelAttribute BoardVO vo) throws Exception{
		// TODO 수정가능한 글인지 검증
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("msg", "성공적으로 수정되었습니다.");
		int result = this.boardService.updateUserInfo(vo);
		if(result <= 0) {
			resultMap.put("msg", "에러가 발생했습니다. 무슨 에러일까..");
		}
		resultMap.put("result", result);
	    return resultMap;
	}
}
