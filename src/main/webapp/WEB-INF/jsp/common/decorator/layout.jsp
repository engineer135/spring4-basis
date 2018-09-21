<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE>
<html>
  <head>
    <title><sitemesh:write property='title'/></title>
    
    <!-- 공통 JS/CSS -->
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.fix.clone.js"></script>
	<!-- airDatePicker -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/datepicker/css/datepicker.css" />
	<script src="${pageContext.request.contextPath}/js/datepicker/js/datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/datepicker/js/i18n/datepicker.en.js"></script>
	
	<!-- sumoSelect -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/multiselect/css/sumoselect.css" />
	<script src="${pageContext.request.contextPath}/js/multiselect/js/jquery.sumoselect.min.js"></script>
	
	
	
	<!-- jqGrid 관련 begin -->
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/js/jqgrid/js/i18n/grid.locale-kr.js"></script>
    <!-- This is the Javascript file of jqGrid -->   
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/js/jqgrid/js/jquery.jqGrid.min.js"></script>
    <!--  jsZip. jqGrid에서 엑셀 다운로드 기능 사용시 필요한 라이브러리 -->
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/js/jszip/jszip.min.js"></script>
    <!-- This is the localization file of the grid controlling messages, labels, etc.
    <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/js/jqgrid/css/jquery-ui.css" />
    <!-- The link to the CSS that the grid needs -->
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/js/jqgrid/css/ui.jqgrid.css" />
    <!-- jqGrid 관련 end -->
    
    <sitemesh:write property='head'/>
  </head>
  <body>
  	<p>sitemesh header</p>
    <sitemesh:write property='body'/>
    <p>sitemesh footer</p>
    
    
    <!-- 복사용 폼을 위한 영역 -->
    <div style="display: none;">
	    <hr>
			<h3>등록/수정폼 들어갈때 가져갈 검색 파라미터</h3>
		<hr>
	    <div id="cloneFormArea"></div>
    </div>
    <script>
    	/* 공통스크립트 */
    	$(document).ready(function() {
    		$('select').SumoSelect(); // 셀렉트 박스 전체적용
    	});
    	
    	// 폼 복사용 펑션
    	// 검색조건 복사해서, 등록/수정폼 들어갈때 가지고 갈 폼을 생성해준다.
    	// 복사는 리스트 조회시 실행.
    	// 검색어만 입력한뒤 조회 안하고 등록/수정 폼 들어갈때 실제로는 검색하지 않은 검색어 같이 들어가는걸 막기 위해 만듦.
    	function cloneForm( $form , cloneFormName ){
    		// 등록/수정폼에 가지고 갈 검색 파라미터 셋팅
    		var newForm = $form.clone();
    		newForm.each(function(){
    		    $(this).find(':input').removeAttr("id"); // id 제거
    		});
    		newForm[0].id = cloneFormName; // id 변경
    		$("#cloneFormArea").html(newForm);
    	}
    	
    </script>
  </body>
</html>