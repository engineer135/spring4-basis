package com.tsmi.controller.sample;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tsmi.common.CommonFileDownload;
import com.tsmi.common.CommonFileUpload;

@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.GET)
    public String fileUpload() {
		return "/sample/fileUpload";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") MultipartFile file, @RequestParam Map<String, Object> param) {
		logger.debug(param.toString());// 파일 외 정보
		Map<String,Object> fileInfo = CommonFileUpload.fileUpload(file);
	    ModelAndView model = new ModelAndView();
	    //set message
	    model.setViewName("index");
	
	    return model;
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
    public void download(HttpServletResponse response) throws Exception {
		Map<String,Object> fileInfo = new HashMap<String,Object>();
		CommonFileDownload.fileDownload(fileInfo, response);
	}

}
