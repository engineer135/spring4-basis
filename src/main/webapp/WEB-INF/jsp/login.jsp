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
    <input type="text" id="id" class="form-control" placeholder="id" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <!-- <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div> -->
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
  </form>

    <!-- JS -->
	<script>
    $(document).ready(function() {
        $( '#create' ).click(function( event ){
             $('#cretModal').modal();
        });
    });
	function get_msg(message) {
	     var move = '90px';
	     jQuery('#message').text(message);
	     jQuery('#message').animate({
	          left : '+=' + move
	     }, 'slow', function() {
	          jQuery('#message').delay(500).animate({ left : '-=' + move }, 'slow');
	     });
	}

	<c:if test="${error == 'true'}">
	jQuery(function() {
	     get_msg("로그인 실패하였습니다.");
	});

	</c:if>

	function signin() {
	     $.ajax({
	          url : '${pageContext.request.contextPath}/signinProcess',
	          data: $('form input').serialize(),
	          type: 'POST',
	          dataType : 'json',
	          beforeSend: function(xhr) {
	               xhr.setRequestHeader("Accept", "application/json");
	          }
	     }).done(function(body) {
	          var message = body.response.message;
	          var error = body.response.error;
	          if (error) get_msg(message);

	          if (error == false) {
	               var url = '${referer}';
	               if (url == '') url = '<c:url value="${pageContext.request.contextPath}/m/m01" />';
	               location.href = url;
	          }
	     });

	}
	</script>
</body>
</html>