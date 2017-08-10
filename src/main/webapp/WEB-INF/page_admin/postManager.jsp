<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html>
<head>
<title>版块管理</title>
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
	function del(postId) {
		var b = confirm("是否确认删除?");
		if (b == false) {
			return;
		}
		var paras = {
			'postId' : postId
		};
		$.ajax({
			url : '/GXUOSAT_COMMUNITY/admin/deletePost.do',
			data : paras,
			dataType : 'json',
			type : 'post',
			success : function(result) {
				var b = result.data;
				if (b == 'success') {
					document.location.reload();
				} else {
					alert(b);
				}
			},
			error : function() {
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
				【帖子管理】<br>
			</div>
			<div id="container">

				<table class="zebra">
					<thead>
						<tr>
							<th>帖子编号</th>
							<th>版块</th>
							<th>帖子标题</th>
							<th>作者</th>
							<th>发表时间</th>
							<th style="font-size: 15px;color:red;"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${posts }" var="post">
							<tr>
								<td>${post.postId}</td>
								<td>${post.boardName}</td>
								<td><a
									href="<%=request.getContextPath()%>/post/intoPost.do?postId=${post.postId}">
									${post.title }</a></td>
								<td>${post.userName }</td>
								<td>${post.postTime }</td>
								<td align="center"><a hrer="#"
									onclick="del(${post.postId })">[删除]</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>