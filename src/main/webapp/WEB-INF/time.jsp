<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.Date"%>
<%
	String[] weekdays = {"", "日", "一", "二", "三", "四", "五", "六"};
	String[] days = new String[42];
	for (int i = 0; i < 42; i++)
		days[i] = "";

	Date currentDay = new Date();
	int year = 1900 + currentDay.getYear();
	int month = currentDay.getMonth();
	int today = currentDay.getDate();
	int weekday = currentDay.getDay() + 1;

	String now = year + "年" + (month + 1) + "月" + today + "日" + " 星期"
			+ weekdays[weekday];
%>
<html>
<head>

<title>My JSP 'time.jsp' starting page</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/cookie_util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		if(getCookie('nickname') == null){
			$(".a1").html("欢迎！请登录！");
		}else{
			$(".a1").html("欢迎："+getCookie('nickname'));
		}
	});
</script>
<style type="text/css">
	.time_1{
		clear:both;
		color: #fff;
	}
</style>
</head>

<body>
	<table class="time_1" border="0" width="100%" cellspacing="0px"
		cellpadding="0px" style="font-size: 18px;margin: 5px 10px 10px 30px">
		<tr>
			<td align="center" ><%=now%> </td>
		</tr>
		<tr >
			<td align="center" class="a1" ></td>
		</tr>
	</table>
</body>
</html>
