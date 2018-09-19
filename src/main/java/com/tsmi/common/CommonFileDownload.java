package com.tsmi.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class CommonFileDownload {
	public static void fileDownload(Map<String,Object> fileInfo, HttpServletResponse response) throws Exception {
		// TODO 파일정보에서 다운받을 파일 설정하기
		File file = new File("C:\\tms-upload\\2018\\9\\19\\f_130440268017497822000000.png");

		response.setContentType("application/download");
		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		
		BufferedInputStream inStrem = null;
		BufferedOutputStream outStream = null;
		try {
			inStrem = new BufferedInputStream(new FileInputStream(file));
			outStream = new BufferedOutputStream(response.getOutputStream());
			
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = inStrem.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			outStream.flush();
			inStrem.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
	        if (inStrem != null) inStrem.close();
	    }
		
	}
}
