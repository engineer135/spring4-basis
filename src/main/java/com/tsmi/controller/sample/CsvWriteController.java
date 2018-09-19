package com.tsmi.controller.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CsvWriteController {
	@RequestMapping("/csvDownload")
    public ModelAndView csvDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ModelAndView mav = new ModelAndView();
 
        List<Map<String, String>> sampleList = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("article_seq", "1");
        map1.put("title", "제목1");
        map1.put("contents", "내용1");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("article_seq", "2");
        map2.put("title", "제목2");
        map2.put("contents", "내용2");
        sampleList.add(map1);
        sampleList.add(map2);
        
        mav.addObject("columnIds", "article_seq,title,contents");
        mav.addObject("columnNames", "게시판순번,제목,내용");
        mav.addObject("excelDataList", sampleList);
        
        mav.setViewName("csvWriteView");
        return mav;
    }
}
