<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<%@include file="/WEB-INF/view/include/head.jsp" %>
	</head> 
	<body>
		<h2>${message}</h2>
		
		<a href="javascript:ajaxTest();"><button type="button" class="btn btn-success">Ajax Test</button></a>
		<br/><br/>
		<a href="testPage.do"><button type="button" class="btn btn-info">Test Page</button></a>
		<div id="testDiv"></div>
	</body>
	<script>
		$(function(){
			console.log("ready!");
			console.log(window['localStorage']);
			console.log(window.location.hash);
			
			// Replace the search result table on load.
			if (window['localStorage'] !== null) {
				console.log("not empty localStorage");
			    if ('testDiv' in localStorage && window.location.hash) {
			    	console.log("not empty localStorage and hash");
			        $("#testDiv").html(localStorage.getItem('testDiv'));
			    }
			}else{
				console.log("empty localStorage!");
			}
		});
		
		// Save the search result table when leaving the page.
		$(window).unload(function () {
			//if (window['localStorage'] !== null) {
		        var testDiv = $("#testDiv").html();
		        localStorage.setItem('testDiv', testDiv);
		    //}
		});
		
		function ajaxTest(){
			$.getJSON("/ajaxTest.do", null, function(data){
				alert(data.test);
				$("#testDiv").append(data.test + "</br>");
				window.location.hash = "#1";
			});
		}
	</script>
</html>
