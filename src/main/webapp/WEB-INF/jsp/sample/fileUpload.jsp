<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>	
		<h1>fileUpload sample</h1>
		<form method="POST" enctype="multipart/form-data" action="/sample/upload">
		    <p>File to upload: <input type="file" name="file"></p>
		    <input type="text" name="value" value="test string"/>
		    <p><input type="submit" value="Upload"> Press here to upload the file!</p>
		</form>
		
		<p><a href="/sample/download">파일 다운로드 테스트</a></p>
		
	</body>
</html>
