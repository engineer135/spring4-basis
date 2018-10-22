package com.tsmi.common;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class CommonFileUpload {
	private static final Logger logger = LoggerFactory.getLogger(CommonFileUpload.class);
	
	public static Map<String,Object> fileUpload(MultipartFile file) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", 1);
    	resultMap.put("msg", "업로드 완료");
    	
		// 파일경로 설정
		String destFileDir = "";
		String resource = "properties/setting.properties";
        Properties properties = new Properties();
        
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
            destFileDir = properties.getProperty("file.upload.path");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(destFileDir.equals("")) {
        	logger.error("properties에 파일 경로가 지정되지 않았습니다.");
        	resultMap.put("result", 0);
        	resultMap.put("msg", "파일 경로가 지정되지 않았습니다.");
        	return resultMap;
        }
		
	String extension = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        // 확장자 체크
        if(!fileType.equals("")) {
        	boolean isAllowedExt = false;
        	
        	for(String allowedExt : fileAllowedExt.split(",")) {
        		logger.debug("allowedExt===="+allowedExt);
        		logger.debug("uploaded file extension===="+extension);
             	if(allowedExt.indexOf(extension) < 0) {
             		/*logger.error("불가능한 파일 확장자 업로드.");
                 	resultMap.put("result", 0);
                 	resultMap.put("msg", "유효한 확장자가 아닙니다.\r\n"+fileAllowedExt+" 만 업로드 가능합니다.");
                 	return resultMap;*/
             	}else {
             		isAllowedExt = true;
             		break;
             	}
             }
        	
        	if(!isAllowedExt) {
        		logger.error("불가능한 파일 확장자 업로드.");
             	resultMap.put("result", 0);
             	resultMap.put("msg", "유효한 확장자가 아닙니다.\r\n"+fileAllowedExt+" 만 업로드 가능합니다.");
             	return resultMap;
        	}
        }
        
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        destFileDir = destFileDir + year + "\\\\" + month + "\\\\" + day + "\\\\";
        
        logger.debug("destFileDir============="+destFileDir);
        
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();
        int nano = currentTime.getNano();
        
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        Random generator = new Random();
        int randomInt = Math.abs(generator.nextInt());
        String newFileName = "f_"+ randomInt + "_" + hour + "" + minute + ""+ second + "" + nano + "." + extension;
        
        logger.debug("newFileName============="+newFileName);
        		
        try {
	        /**
	         * Set the path where to save the file.
	         * ex. "C:\\images\\" + file.getOriginalFilename() //win
	         * ex. "/images/" + file.getOriginalFilename() //nix
	         */
	    	File toUploadDir = new File(destFileDir);
	    	toUploadDir.mkdirs(); // 폴더 생성
	        file.transferTo(new File(destFileDir+newFileName));
	        //successful
	        // TODO 파일 정보 담아서 리턴
	    } catch (IllegalStateException e) {
	        //error
	    	e.printStackTrace();
	    } catch (IOException e) {
	        //error
	    	e.printStackTrace();
	    }
        
        return resultMap;
	}
	
}
