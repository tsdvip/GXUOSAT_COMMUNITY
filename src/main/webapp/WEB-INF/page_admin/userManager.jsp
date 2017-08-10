<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html>
<head>
<title>用户管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/table_style.css"
	type="text/css">

<style type="text/css">
.user_m1 {
	clear: both;
	width: 67.8%;
	height: 500px;
	margin-top: 20px;
}
</style>

<script type="text/javascript">
	function del(userId){
		var b = confirm("是否确认删除?");
		if(b==false){
			return;
		}
		var paras = {'userId':userId};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/admin/deleteUser.do',
			data:paras,
			dataType:'json',
			type:'post',
			success:function(result){
				var b = result.data;
				if(b=='success')  
			    {  
					document.location.reload();
			    }else{
			    	alert(b);
			    }
			},
			error:function(){
				alert("服务器繁忙！请稍后再试！");
			}
		});
	}
</script>
</head>
<body>
	<div align="center">
		<div align="left" class="user_m1">
			<div class="" style="font-size: 20px;font-family:'宋体';color:blue; ">
				【用户管理】<br>
			</div>
			<div id="container">

				<table class="zebra">
					<thead>
						<tr>
							<th>用户编号</th>
							<th>用户名</th>
							<th>用户级别</th>
							<th>手机号</th>
							<th>Eamil</th>
							<th style="font-size: 15px;color:red;"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users }" var="user">
						<tr>
							<td>${user.userId }</td>
							<td>${user.userName }</td>
							<td>${user.roleName }</td>
							<td>${user.phone }</td>
							<td>${user.email }</td>
							<td align="center"><a hrer="#" onclick="del(${user.userId })">[删除]</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>