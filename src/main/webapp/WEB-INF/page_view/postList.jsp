<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>帖子列表</title>
<meta charset="UTF-8" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/cookie_util.js"></script>

<style type="text/css">
	.post_list{
		width:71.2%;height:820px;
	}
	
	.td_1 {
border-top: 1px solid #EE82EE;
border-left: 0px solid black;
border-right: 0px solid black;
border-bottom: 0px solid black; 
}
 .tb_1{
 	margin-top: 15px;
 }
</style>

<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery.page.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style_button.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.page.js"></script>

<script type="text/javascript">
//异步获取某页的帖子
function pagePost(postList){
	var strTable = '<table class="tb_1" border="0" width="100%" bgcolor="#DCDCDC" cellspacing="0" cellpadding="0">'+
			'<tr><td width="13%" rowspan="3" align="center">'+ 
			'<img id="head" src="<%=request.getContextPath()%>/images/face/user/[post.face]"'+
			'style="margin-bottom: 5px;"><br>'+
			'[post.userName]'+
			'</td>'+
			'<td height="20">'+
			'<h1><a href="<%=request.getContextPath()%>/post/intoPost.do?postId=[post.postId]" title="链接到 [post.title]" rel="bookmark">[post.title]</a></h1></td></tr>'+
			'<tr height="80" class="letter">'+
			'<td class="td_1">[post.content]...</td></tr>'+
			'<tr height="20" class="letter"><td align="right">'+
			'回复:( [post.answerNum] )&nbsp;&nbsp;&nbsp;&nbsp;发帖时间：[post.postTime]&nbsp;&nbsp;'+
			'</td></tr></table>';
		
	var div = $("#page_post").empty();
	this.posts = postList;
	var allPost = "";
	for(var i=0;i<posts.length;i++){
		var post = this.posts[i];
		var str = strTable.replace('[post.face]', post.face);
		str = str.replace('[post.postId]', post.postId);
		str = str.replace('[post.userName]', post.userName);
		str = str.replace('[post.title]',post.title);
		str = str.replace('[post.title]',post.title);
		str = str.replace('[post.content]', post.content);
		str = str.replace('[post.answerNum]', post.answerNum);
		str = str.replace('[post.postTime]', post.postTime);
		allPost += str;
	}
	div.append(allPost);
}

</script>

<script type="text/javascript">
function openwin(boardId) {
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
</script>

<script type="text/javascript">
	$(function(){
		$("#page").Page
	({
			totalPages : 9,//分页总数
			liNums : 7,//分页的数字按钮数(建议取奇数)
			activeClass : 'activP', //active 类样式定义
			callBack : function(page) {
				var boardId = $("#boardId").val();
				var d = {"pageNum" : page,"boardId" : boardId};
				$.ajax({
					url:"/GXUOSAT_COMMUNITY/post/pagePost.do",
					data: d,
					dataType:"json",
					type:"post",
					success:function(postList){
						pagePost(postList.data);
						
						
					},
					error:function(){
						alert("服务器繁忙！请稍后再试！")
					}
				});
			}
		});
	});
	
</script>
	
	<style type="text/css">
		.post_000{
		width:77.4%;
			float:left;
			margin-right: 10px;
		}
		
		.post_111{
		width:19%;
			float:left;
			margin-top: 15px;
		}
	</style>
</head>

<body>
	<center>
	<div>
	<input id="boardId" type="hidden" value=${boardId }>
	</div>
	<div class="post_list" >
	<div class="post_000" id="page_post">
	<c:forEach items="${postList }" var="post">
	<table class="tb_1" border="0" width="100%" bgcolor=#DCDCDC cellspacing="0" cellpadding="0">
			<tr><td width="13%" rowspan="3" align="center">
						<img id="head" src="<%=request.getContextPath()%>/images/face/user/${post.face}"
					style="margin-bottom: 5px;"><br>
					${post.userName }
					</td>
					<td height="20" style="color: #EE82EE;">
						<h1><a href="<%=request.getContextPath()%>/post/intoPost.do?postId=${post.postId}" title="链接到 ${post.title }" rel="bookmark">${post.title }</a></h1></td></tr>
				<tr height="80" class='letter'>
					<td class="td_1">${post.content }...</td></tr>
				<tr height="20" class='letter'><td align="right">
						回复:( ${post.answerNum } )&nbsp;&nbsp;&nbsp;&nbsp;发帖时间：${post.postTime }&nbsp;&nbsp;
					</td></tr></table>
	
	</c:forEach>
	
	</div>
	
	<div class="post_111">
  		<table  border="0" width="100%" bgcolor="#FFF" cellspacing="0" cellpadding="0">
  			<tr align="center" height="80"><td>
  				<a href="" onclick="openwin(${boardId })" class="hvr-outline-out button2">+&nbsp;发&nbsp;帖&nbsp;</a>
  				
  			</td></tr>
  			<tr align="center" height="40"><td>
				热门板块：
  			</td></tr>
  			<tr align="center" height="35"><td>
				<a href="<%=request.getContextPath()%>/post/listPost.do?boardId=1" class="hvr-reveal button2">社区互动</a>&nbsp;
				<a href="<%=request.getContextPath()%>/post/listPost.do?boardId=2" class="hvr-reveal button2">学习交流</a>
  			</td></tr>
  			<tr align="center" height="35"><td>
				<a href="<%=request.getContextPath()%>/post/listPost.do?boardId=3" class="hvr-reveal button2">资源共享</a>&nbsp;
				<a href="<%=request.getContextPath()%>/post/listPost.do?boardId=4" class="hvr-reveal button2">时尚交流</a>
  			</td></tr>
  			<tr align="center" height="35"><td>
				<a href="<%=request.getContextPath()%>/post/listPost.do?boardId=1" class="hvr-reveal button2">社区互动</a>&nbsp;
				<a href="<%=request.getContextPath()%>/post/listPost.do?boardId=2" class="hvr-reveal button2">学习交流</a>
  			</td></tr>
  			<tr align="center" height="50"><td valign="bottom">
  				请关注我们：
  			</td></tr>
  			<tr align="center" height="250"><td>
  				<img id="head" src="<%=request.getContextPath()%>/images/view/weixin_gzh.jpg"
					style="border:1 solid;margin-bottom: 5px;">
  			</td></tr>
  			
  		</table>
  	</div>
	
	</div>
	<div>
		<br>
		<br>
		<br>
		<div id="page" class="page_1"></div>
	
	</div>
	
	</center>
</body>
</html>