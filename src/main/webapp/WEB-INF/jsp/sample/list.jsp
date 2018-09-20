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
		<h1>list sample</h1>
		<h3>조회할때 사용하는 검색 파라미터</h3>
		<form id="searchForm">
			<p>아이디<input type="text" id="searchUserId" name="searchUserId" value="${param.searchUserId}"/></p>
			<p>이름<input type="text" id="searchUserName" name="searchUserName" value="${param.searchUserName}"/></p>
			<p>
				KB1
				<select id="searchUserKb1" name="searchUserKb1">
					<option value="Y" <c:if test="${param.searchUserKb1 eq 'Y'}">selected</c:if> >Y</option>
					<option value="N" <c:if test="${param.searchUserKb1 eq 'N'}">selected</c:if> >N</option>
				</select>
			</p>
			<hr>
			<p>현재페이지<input type="text" id="cPage" name="cPage" value="${param.cPage}"/></p>
			<hr>
			<input type="submit" id="search" value="조회">
		</form>
		
		<input type="button" id="goForm" value="등록"/>
		
		<table id="jqGrid"></table>
    	<div id="jqGridPager"></div>
    	<button id="csvExport">Export to CSV</button>
    	<button id="excelExport">Export to EXCEL</button>
    	
    	<script>
    		var GRID;
    		
		    $(document).ready(function() {
		    	getList();
		    	
		    	$(document).on("click","#search",function(e){
		    		e.preventDefault();
		    		getList();
		    	});
		    	
		    	$(document).on("click","#goForm",function(e){
		    		e.preventDefault();
		    		// 현재 페이지 가져오기
		    		//alert($('#jqGrid').getGridParam('page'));
		    		$("#cloneSearchForm input[name=cPage]").val($('#jqGrid').getGridParam('page')); // 현재 페이지 셋팅
		    		$("#cloneSearchForm").attr({"action":"${pageContext.request.contextPath}/sample/form"}).submit();
		    	});
		    	
		    	
		    	
		    	
		    	
		    	$("#csvExport").on("click", function(){
					$("#jqGrid").jqGrid("exportToCsv",{
						separator: ",",
						separatorReplace : "", // in order to interpret numbers
						quote : '"', 
						escquote : '"', 
						newLine : "\r\n", // navigator.userAgent.match(/Windows/) ?	'\r\n' : '\n';
						replaceNewLine : " ",
						includeCaption : true,
						includeLabels : true,
						includeGroupHeader : true,
						includeFooter: true,
						fileName : "jqGridExport.csv",
						returnAsString : false
					})
				});
				
				
				
				
				$("#excelExport").on("click", function(){
					$("#jqGrid").jqGrid("exportToExcel",{
						includeLabels : true,
						includeGroupHeader : true,
						includeFooter: true,
						fileName : "jqGridExport.xlsx",
						maxlength : 40 // maxlength for visible string data 
				});
			})
				
		    });
		
			function getList() {
				// 검색조건을 복사해둔다.
				cloneForm( $("#searchForm"), "cloneSearchForm" );
				
			     $.ajax({
			          url : '${pageContext.request.contextPath}/sample/getList',
			          data: $('#searchForm').serialize(),
			          type: 'get',
			          dataType : 'json',
			          success : function(data) {
					    	 console.log(data);
					    	 makeGrid(data.userList);
					  },
					  error : function(err) {
					    	 console.log(err);
					  }
			     });
			}
			
			function makeGrid(list){
				if(GRID){
					// 기존에 그리드가 있는 경우
					GRID
					.jqGrid("clearGridData", true)
					.jqGrid('setGridParam',
					        { 
					            datatype: 'local',
					            data:list
					        })
					.trigger("reloadGrid");
				}else{
					// 처음 생성할 경우
					GRID = $("#jqGrid").jqGrid({
		                datatype: "local",
		                data: list,
		                colModel: [
		                    { label: '아이디', name: 'USER_ID', key: true, width: 75 },
		                    { label: '이름', name: 'USER_NAME', width: 150 },
		                    { label: 'KB1', name: 'USER_KB1', width: 150 },
		                ],
		                ondblClickRow: function(){
		                    var rowId = $("#jqGrid").getGridParam('selrow');
		                    console.log($("#jqGrid").getRowData(rowId)); // row 정보
		                    
		                    $("#cloneSearchForm").append('<input type="hidden" name="userId" value="' + rowId + '" >'); // 타겟 아이디 추가
		                    $("#cloneSearchForm input[name=cPage]").val($('#jqGrid').getGridParam('page')); // 현재 페이지 셋팅
				    		$("#cloneSearchForm").attr({"action":"${pageContext.request.contextPath}/sample/edit", "method":"post"}).submit();
		                },
						viewrecords: true,
		                width: 780,
		                height: 250,
		                rowNum: 20,
		                page: "${param.cPage}" || 1,
		                pager: "#jqGridPager"
		            });
				}
			}
			</script>
	
	</body>
</html>
