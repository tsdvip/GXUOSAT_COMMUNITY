<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<html>
<head>
<title>帖子列表</title>
<meta charset="UTF-8" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/cookie_util.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style_button.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
	
<style type="text/css">
	.info_1{
		width:71.2%;height:620px;
		font-size:20px;
		color: #fff;
	}
	.tb_1 tr{
		height: 70px;
	}
	
	.button {
	display: inline-block;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0,0,0,.3);
	-webkit-border-radius: .5em; 
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	box-shadow: 0 1px 2px rgba(0,0,0,.2);
	margin: 0px 40px 0px 0px;
}
.button:hover {
	text-decoration: none;
}
.button:active {
	position: relative;
	top: 1px;
}
</style>

<script type="text/javascript">
	function toEdit(){
		var userId = getCookie("userId");
		if(userId==null){
			alert("登录超时！请登录后再进行此操作！");
			return;
		}
		location.href = "/GXUOSAT_COMMUNITY/user/toEditInfo.do";
	}
	
</script>
</head>

<body>
	<center>
	<div class="info_1">
	<table class="tb_1" border="0" width="100%"  cellspacing="0" cellpadding="0">
		<tr>
			<td rowspan="7" width="40%" align="right" valign="top">
			<img id="head" src="<%=request.getContextPath()%>/images/face/user/${user.face}"
					style="margin: 50px 80px 0px 0px;"><br>
					<p style="margin: 0px 60px 0px 0px;">${roleName }</p>
					<input type="button" onclick="toEdit()" class="button" value="+编辑资料">
			</td>
			<td></td>
		</tr>
		<tr>
			<td>账户：${user.userName }</td>
		</tr>
		<tr>
			<td>昵称：${user.nickname }</td>
		</tr>
		<tr>
			<td>性别：${user.sex }</td>
		</tr>
		<tr>
			<td>来自：${user.address }</td>
		</tr>
		<tr>
			<td>Phone：${user.phone }</td>
		</tr>
		<tr>
			<td>E-mail：${user.email }</td>
		</tr>
	</table>
	
	</div>
		
	</center>
</body>
</html>