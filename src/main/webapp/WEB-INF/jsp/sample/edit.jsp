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
		<h1>edit sample</h1>
		<form>
			<!-- 검색 파라미터 -->
			<h3>검색 파라미터(목록으로 돌아갈 경우 사용)</h3>
			<p>
				아이디<input type="text" name="searchUserId" value="${param.searchUserId}" class="searchParam"/>
				이름<input type="text" name="searchUserName" value="${param.searchUserName}" class="searchParam"/>
				kb1<input type="text" name="searchUserKb1" value="${param.searchUserKb1}" class="searchParam"/>
				cPage<input type="text" name="cPage" value="${param.cPage}" class="searchParam"/>
			</p>
			
			<hr>
			
			<h3>데이터 파라미터</h3>
			<!-- 데이터 파라미터 -->
			<input type="hidden" id="userId" name="userId" value="${userInfo.USER_ID}"/>
			<p>아이디 : ${userInfo.USER_ID}</p>
			<p>이름<input type="text" id="userName" name="userName" value="${userInfo.USER_NAME}"/></p>
			<p>비밀번호<input type="password" id="userPw" name="userPw" value="${userInfo.USER_PW}"/></p>
			<p>
				KB1
				<select id="userKb1" name="userKb1">
					<option value="Y" <c:if test="${userInfo.USER_KB1 eq 'Y'}">selected</c:if> >Y</option>
					<option value="N" <c:if test="${userInfo.USER_KB1 eq 'N'}">selected</c:if> >N</option>
				</select>
			</p>
			<input type="submit" id="update" value="수정하기~~~~">
		</form>
		
		<p><input type="button" id="goList" value="목록"/></p>
    	
    	<script>
		    $(document).ready(function() {
		    	$(document).on("click","#goList",function(e){
		    		e.preventDefault();
		    		location.href="${pageContext.request.contextPath}/sample/list?" + $(".searchParam").serialize();
		    	});
		    	
		    	$(document).on("click","#update",function(e){
		    		e.preventDefault();
		    		// validation check...
		    		
		    		updateData();
		    	});
		    });
		    
		    
		    function updateData(){
		    	$.ajax({
			          url : '${pageContext.request.contextPath}/sample/update',
			          data: $('form').serialize(),
			          type: 'post',
			          dataType : 'json',
			          success : function(data) {
					    	 console.log(data);
					    	 alert(data.msg);
					    	 if(data.result > 0){
					    		 location.replace("${pageContext.request.contextPath}/sample/list?"+$(".searchParam").serialize());
					    	 }
					  },
					  error : function(err) {
					    	 console.log(err);
					    	 alert("에러가 발생했습니다.");
					  }
			     });
		    }
		    
		</script>
	</body>
</html>
