<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %> 
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored="false"%>
<!doctype html>
<html>
  <head>
    <title>广西科技大学校园社区</title>
<style type="text/css">
	body{
		background-image:url("<%=request.getContextPath()%>/images/index/bg.jpg");
		background-size: 100% 100%;
		background-repeat:repeat-x;
		background-attachment:fixed;
	}
</style>
  </head>
  <body >
      <div align="center">
        <div ><jsp:include page="top.jsp"/></div>        
        <div  style="float: right;" ><jsp:include page="menu.jsp"/></div>        
        <div style="float: right;"><jsp:include page="time.jsp"/></div>  
        <c:if test="${empty view}">
	        <div><jsp:include page="content.jsp"/></div>        
	        <div ><jsp:include page="board.jsp"/></div>        
        </c:if>     
        <c:if test="${not empty view}">
        	<div><jsp:include page="${view }.jsp"/></div> 
        </c:if>
        <div ><jsp:include page="end.jsp"/></div>        
    </div>
  </body>
</html>