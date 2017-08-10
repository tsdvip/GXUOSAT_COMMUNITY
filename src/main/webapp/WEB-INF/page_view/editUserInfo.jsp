<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>用户注册</title>
<meta charset="UTF-8" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/login.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/reg.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/cookie_util.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("select").change(function() {
			var v = $(this).val();
			$("#head").attr("src", "../images/face/user/" + v);
		});
	});
	
	function edit(){
		var oldPwd = $("input[name='oldPwd']").val();
		if(oldPwd==null || $.isEmptyObject(oldPwd)){
			alert("必须输入密码才可以修改信息哦！");
			return;
		}
		var password = $("input[name='password']").val();
		var sex = $("input[name='sex']").val();
		var face = $("#face").val();
		var nickname = $("input[name='nickname']").val();
		var phone = $("input[name='phone']").val();
		var email = $("input[name='email']").val();
		var address = $("input[name='address']").val();
		var paras = {'oldPwd':oldPwd,'password':password,'sex':sex,'face':face,'nickname':nickname,'phone':phone,'email':email,'address':address};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/user/editInfo.do',
			data:paras,
			dataType:'json',
			type:'post',
			success:function(result){
				var b = result.data;
				if(b=='success')  
			    {  
					self.location=document.referrer;
			    }else{
			    	alert(b);
			    }
			},
			error:function(){
				alert("服务器繁忙！请稍后再试！")
			}
		});
	}
</script>
</head>

<body>
	<center>
		<table border="0" width="71.2%" bgcolor="#fff" cellspacing="0"
			cellpadding="0">
			<form action="#">
				<input type="hidden" name="method" value="userReg"> <input
					type="hidden" name="validate" value="yes">
				<tr height="80">
					<td colspan="5" align="center"
						style="text-indent:20;font-size: 28px;">编辑用户信息</td>
				</tr>
				<tr height="45" class='letter'>
					<td align="right" width="37%">账户：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="4"><input type="text" name="userName" value="${user.userName }" readonly="true">&nbsp;(不可更改)</td>
				</tr>
				<tr height="45" class='letter'>
				<td align="right">原密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="4"><input type="password" name="oldPwd"
					id="old_password">
					<div class='warning1' id='warning_2' style="display: none;">
						<span>密码长度过短</span>
					</div></td>
			</tr>
			<tr height="45" class='letter'>
				<td align="right">新密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="4"><input type="password" name=""
					id="regist_password">
					<div class='warning1' id='warning_2' style="display: none;">
						<span>密码长度过短</span>
					</div></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="4"><html:errors property="userPassword" /></td>
			</tr>
			<tr height="45" class='letter'>
				<td align="right">确认新密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="3"><input type="password" name="password"
					id="final_password">
					<div class='warning1' id='warning_3' style="display: none;">
						<span>密码输入不一致</span>
					</div></td>
				<td rowspan="3" width="20%" valign="bottom"
					style="padding-bottom:10"><img id="head"
					src="<%=request.getContextPath()%>/images/face/user/user0.gif"
					style="border:1 solid"></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="4"><html:errors property="aginPassword" /></td>
			</tr>
			<tr height="45" class='letter'>
				<td align="right" class='letter'>用户性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width="15%"><input <c:if test="${user.sex=='男' }">checked</c:if>
					style="vertical-align:middle; margin-top:0;" type="radio"
					name="sex" value="男">男 <input <c:if test="${user.sex=='女' }">checked</c:if>
					style="vertical-align:middle; margin-top:0;" type="radio"
					name="sex" value="女">女</td>
				<td width="15%" align="right">用户头像：</td>
				<td width="15%" align="left"><select id="face" name="face">
						<option value="user0.gif">头像1</option>
						<option value="user1.gif">头像2</option>
						<option value="user2.gif">头像3</option>
				</select></td>
			</tr>
			<tr height="45" class='letter'>
				<td align="right">昵称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="4"><input type="text" name="nickname" value="${user.nickname }"></td>
			</tr>
			<tr height="45" class='letter'>
				<td align="right">联系电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="4"><input type="text" name="phone" value="${user.phone }"></td>
			</tr>
			<tr height="45" class='letter'>
				<td align="right">E-mail：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="4"><input type="text" name="email" value="${user.email }"></td>
			</tr>
			<tr height="45" class='letter'>
				<td align="right">来自：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="4"><input type="text" name="address" value="${user.address }"></td>
			</tr>
			<tr height="80">
				<td>&nbsp;</td>
				<td colspan="4"><input type="button" onclick="edit()" value="提交" /> <input
					type="button" value="重置" onclick="window.location.reload()">
				</td>
			</tr>
			</form>
		</table>
		<br>
	</center>
</body>
</html>