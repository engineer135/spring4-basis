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
		<h1>ajaxFileUpload sample</h1>
		<form method="POST" enctype="multipart/form-data" action="/sample/upload" id="fileUploadForm">
		    <p>File to upload: <input type="file" name="file"></p>
		    <input type="text" name="value" value="test string"/>
		    <p><input type="submit" value="Upload" id="btnSubmit"> Press here to upload the file!</p>
		</form>
		
		<h1>Ajax Post Result</h1>
		<span id="result"></span>
		
		<script>
			$(document).ready(function () {
	
			    $("#btnSubmit").click(function (event) {
			        //stop submit the form, we will post it manually.
			        event.preventDefault();
	
			        // Get form
			        var form = $('#fileUploadForm')[0];
			        
					// Create an FormData object 
			        var data = new FormData(form);
	
					// If you want to add an extra field for the FormData
			        data.append("CustomField", "This is some extra data, testing");
	
					// disabled the submit button
			        $("#btnSubmit").prop("disabled", true);
	
			        $.ajax({
			            type: "POST",
			            enctype: 'multipart/form-data',
			            url: "/sample/ajaxUpload",
			            data: data,
			            processData: false,
			            contentType: false,
			            cache: false,
			            timeout: 600000,
			            success: function (data) {
	
			                $("#result").text(data);
			                console.log("SUCCESS : ", data.msg);
			                $("#btnSubmit").prop("disabled", false);
	
			            },
			            error: function (e) {
	
			                $("#result").text(e.responseText);
			                console.log("ERROR : ", e);
			                $("#btnSubmit").prop("disabled", false);
	
			            }
			        });
	
			    });
	
			});
		</script>
	</body>
</html>
