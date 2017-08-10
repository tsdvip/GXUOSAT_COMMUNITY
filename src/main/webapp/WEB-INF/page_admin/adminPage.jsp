<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html>
<head>
<title>后台管理</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/styles.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
	
</head>
<body>
	<div >
	<div align="center">
		<img src="<%=request.getContextPath()%>/images/admin_top.jpg">
	</div>
	<div>
		<nav>
			<ul class="fancyNav">
				<li id="home"><a href="<%=request.getContextPath()%>/index/goIndex.do" class="homeIcon">Home</a></li>
				<li id="news"><a href="<%=request.getContextPath()%>/admin/toPostCount.do">数据统计</a></li>
				<li id="about"><a href="<%=request.getContextPath()%>/admin/toUserManager.do">用户管理</a></li>
				<li id="services"><a href="<%=request.getContextPath()%>/admin/toBoardManager.do">板块管理</a></li>
				<li id="services"><a href="<%=request.getContextPath()%>/admin/toPostManager.do">帖子管理</a></li>
				<li id="contact"><a href="<%=request.getContextPath()%>/admin/toNoticeManager.do">公告管理</a></li>
				<li id="about"><a href="#contact">关于</a></li>
			</ul>
		</nav>
	</div>
	
	<c:if test="${empty view}">
        </c:if>     
        <c:if test="${not empty view}">
        	<div><jsp:include page="${view }.jsp"/></div> 
        </c:if>
		
	</div>
</body>
</html>