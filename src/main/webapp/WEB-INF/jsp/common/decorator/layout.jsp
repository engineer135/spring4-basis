<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
  <head>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
  </head>
  <body>
  	sitemesh header
    <sitemesh:write property='body'/>
    sitemesh footer
  </body>
</html>