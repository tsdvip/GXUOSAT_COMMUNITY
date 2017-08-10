<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'toLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/reg.css"/>
<style type="text/css">
	.clear{
		height: 450px;
		clear: both;
	}
</style>
  </head>
  
  <body >
     <div class="clear" align="center" width="71.2%">
		<p align="center" style="padding-top: 150px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message }</p>
		<c:if test="${not empty state }">
		<p><a href="<%=request.getContextPath()%>/log_in.html"><input type="button" value="µÇÂ¼"></a></p>
		</c:if>
     </div>
  </body>
</html>
