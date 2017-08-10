<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>帖子内容</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style_button.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style_input.css">
<style type="text/css">
.post_c {
	width: 70.8%;
}

.post_000 {
	width: 77.5%;
	float: left;
	margin-right: 10px;
}

.post_111 {
	width: 19%;
	float: left;
}

.tr_0000 td {
	border-top: 1px solid #EE82EE;
	border-left: 0px solid black;
	border-right: 0px solid black;
	border-bottom: 0px solid black;
}

.td_0000 {
	border-top: 0px dashed black;
	border-left: 1px solid #EE82EE;
	border-right: 0px solid black;
	border-bottom: 1px solid #EE82EE;
}

.but_p {
	display: block;
	width: 50px;
	height: 30px;
	background: #13A89E;
	text-align: center;
	padding: auto;
	position: relative;
	margin: 0 10px 0 0;
	border-radius: 5px; //
	圆角矩形属性 font-size: 50px;
	text-decoration: none;
	color: #fff;
}

.but_p:hover {
	background: #fa5ba5;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/cookie_util.js"></script>

<script type="text/javascript">
	//打开发帖页面
	function openwin(boardId,rootPath) {
		var iWidth = 420;                          //弹出窗口的宽度;
		  var iHeight = 414;                        //弹出窗口的高度;
		  var iTop = (window.screen.availHeight-30-iHeight)/2;       //获得窗口的垂直位置;
		  var iLeft = (window.screen.availWidth-10-iWidth)/2;           //获得窗口的水平位置;
	window
	.open(
		"/GXUOSAT_COMMUNITY/post/publish.do?boardId="
				+ boardId,
		"newwindow",
		'height=' + iHeight + ',innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no'); //写成一行
	}
	
	//回复帖子
	function answer(){
		var postId = $("input[name='postId']").val();
		var content = $("#content").val();
		if(content==null){
			alert("请输入内容！");
		}
		var paras = {'postId': postId,'content': content};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/post/answer.do',
			data:paras,
			dataType:'json',
			type:'post',
			success:function(result){
				var b = result.data;
				if(b=='success')  
			    {  
					document.location.reload();
			    }else{
			    	var flag = confirm(b);
			    	if(flag==true){
			    		location.href="/GXUOSAT_COMMUNITY/log_in.html";
			    	}
			    }
			   
			},
			error:function(){
				alert("服务器繁忙！请稍后再试！");
			}
		});
	}
	
	//删除帖子
	function deletePost(ownerId,postId){
		var userId = getCookie("userId");
		//alert(ownerId);
		if(userId == null){
			return ;
		}
		var paras={'ownerId':ownerId,'postId':postId};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/post/deletePost.do',
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
				alert("服务器繁忙！请稍后再试！");
			}
		});
		
	}
	
	//删除回复
	function deleteAnswer(ownerId,postId,answerId){
		var userId = getCookie("userId");
		//alert(ownerId);
		if(userId == null){
			return ;
		}
		var paras={'ownerId':ownerId,'postId':postId,'answerId':answerId};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/post/deleteAnswer.do',
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
	
	//加精
	function addGood(postId){
		var userId = getCookie("userId");
		//alert(ownerId);
		if(userId == null){
			return ;
		}
		var roleId = getCookie("roleId");
		if(roleId == null){
			return;
		}
		var paras={'postId':postId};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/post/addGood.do',
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
	
	//取消加精
	function cancelGood(postId){
		var userId = getCookie("userId");
		//alert(ownerId);
		if(userId == null){
			return ;
		}
		var roleId = getCookie("roleId");
		if(roleId == null){
			return;
		}
		var paras={'postId':postId};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/post/cancelGood.do',
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
	<div class="post_c">
		<div class="post_000">
			<table class="post_tab1" align="left" width="100%" border="0"
				width="100%" bgcolor="#FFF" cellspacing="0" cellpadding="0">
				<tr height="40">
					<td width="18%"></td>
					<td ><h1>${postContent.post.title }
					<c:if test="${postContent.post.is_good==null }">
						<span style="font-size: 10px">
							<a href="#"
								onclick="addGood(${postContent.post.postId })">[+加精]</a>
						</span>
					</c:if>
					<c:if test="${postContent.post.is_good!=null }">
						<span style="font-size: 10px">
							<a href="#"
								onclick="cancelGood(${postContent.post.postId })">[取消加精]</a>
						</span>
					</c:if>
					</h1></td>
				</tr>
				<tr height="330" align="center" valign="top" class="tr_0000">
					<td style="padding-top: 12px"><img id="head"
						src="<%=request.getContextPath()%>/images/face/user/${postContent.user.face }"
						style="margin-bottom: 5px;"><br>
						${postContent.user.nickname }<br>
						来自：${postContent.user.address }</td>
					<td
						style="border-left: 1px solid #EE82EE;border-top: 1px solid #EE82EE;padding-top: 20px;padding-left: 20px;"
						align="left">${postContent.post.content }</td>
				</tr>
				<tr height="30" align="center" valign="top">
					<td style="border-bottom: 1px solid #EE82EE; "></td>
					<td class="td_0000" align="right"><a href="#"
						onclick="deletePost(${postContent.user.userId },${postContent.post.postId })">[删除]</a>&nbsp;&nbsp;发表于：${postContent.post.postTime }&nbsp;&nbsp;</td>
				</tr>
				<c:forEach items="${answers }" var="answer">
					<tr height="60" align="center" valign="top">
						<td><img id="head"
							src="<%=request.getContextPath()%>/images/face/user/${answer.user.face }"
							style="border:1 solid;margin-bottom: 2px;margin-top: 13px;"><br>
							${answer.user.nickname }<br></td>
						<td
							style="border-left: 1px solid #EE82EE; padding-top: 20px;padding-left: 20px;"
							align="left">${answer.answer.content }</td>
					</tr>
					<tr height="10" align="center" valign="top">
						<td style="border-bottom: 1px solid #EE82EE; "></td>
						<td class="td_0000" align="right"><a href="#"
							onclick="deleteAnswer(${postContent.user.userId },${postContent.post.postId },${answer.answer.answerId })">[删除]</a>&nbsp;&nbsp;
							回复于：${answer.answer.answerTime }&nbsp;&nbsp;</td>
					</tr>
				</c:forEach>
			</table>
			<form action="">
				<input type="hidden" name="postId"
					value="${postContent.post.postId }"> <input type="hidden"
					name="userId" value="${postContent.post.userId }">
				<div align="right">
					<textarea style="width:79%;height:100px; margin-top: 20px;"
						id="content" class="mytxt"></textarea>
				</div>
				<div align="right" style="margin-right: 295px; margin-top: 15px;">
					<input type="button" onclick="answer()" class="but_p" value="回复">
				</div>
			</form>
		</div>

		<div class="post_111">
			<table border="0" width="100%" bgcolor="#FFF" cellspacing="0"
				cellpadding="0">
				<tr align="center" height="120">
					<td><a href="#bottom" class="hvr-outline-out button2">+&nbsp;回&nbsp;复&nbsp;</a>&nbsp;
						<a href="#" onclick="openwin(${postContent.post.boardId })"
						class="hvr-outline-out button2">+&nbsp;发&nbsp;帖&nbsp;</a></td>
				</tr>
				<tr align="center" height="40">
					<td>热门板块：</td>
				</tr>
				<tr align="center" height="35">
					<td><a
						href="<%=request.getContextPath()%>/post/listPost.do?boardId=1"
						class="hvr-reveal button2">社区互动</a>&nbsp; <a
						href="<%=request.getContextPath()%>/post/listPost.do?boardId=2"
						class="hvr-reveal button2">学习交流</a></td>
				</tr>
				<tr align="center" height="35">
					<td><a
						href="<%=request.getContextPath()%>/post/listPost.do?boardId=3"
						class="hvr-reveal button2">资源共享</a>&nbsp; <a
						href="<%=request.getContextPath()%>/post/listPost.do?boardId=4"
						class="hvr-reveal button2">时尚交流</a></td>
				</tr>
				<tr align="center" height="35">
					<td><a
						href="<%=request.getContextPath()%>/post/listPost.do?boardId=1"
						class="hvr-reveal button2">社区互动</a>&nbsp; <a
						href="<%=request.getContextPath()%>/post/listPost.do?boardId=2"
						class="hvr-reveal button2">学习交流</a></td>
				</tr>
				<tr align="center" height="50">
					<td valign="bottom">请关注我们：</td>
				</tr>
				<tr align="center" height="250">
					<td><img id="head"
						src="<%=request.getContextPath()%>/images/view/weixin_gzh.jpg"
						style="border:1 solid;margin-bottom: 5px;"></td>
				</tr>

			</table>
		</div>
	</div>

</body>
</html>
