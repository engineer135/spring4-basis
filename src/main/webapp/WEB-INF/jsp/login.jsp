<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
	<title>TMS Login</title>
	<!-- JS -->
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
	<!-- CSS -->
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body class="text-center">
  <form class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">TMS Login</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="text" id="id" name="userId" class="form-control" placeholder="id" autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="userPw" class="form-control" placeholder="Password">
    <!-- <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div> -->
    <button id="signIn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
  </form>

    <!-- JS -->
	<script>
    $(document).ready(function() {
    	$(document).on("click","#signIn",function(e){
    		e.preventDefault();
    		signIn();
    	});
    });

	function signIn() {
	     $.ajax({
	          url : '${pageContext.request.contextPath}/signIn',
	          data: $('form input').serialize(),
	          type: 'POST',
	          dataType : 'json',
	          beforeSend: function(xhr) {
	               xhr.setRequestHeader("Accept", "application/json");
	          }
	     }).done(function(data) {
	          //console.log(data);
	          if(data.isLogin == 'Y'){
	        	  location.replace("/main");
	          }else{
	        	  //alert("로그인 실패. 아이디 비번 확인");
	        	  location.replace("/main");
	          }
	     });

	}
	</script>
</body>
</html>