<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date"%>
<%@ page isELIgnored="false"%>
<html>
<head>

<title>My JSP 'time.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
	
	<script type="text/javascript">
		function postList(boardId){
			location.href=getRootPath()+"/post/listPost.do?boardId="+boardId;
		}
		
		function getRootPath() {
		    //获取当前网址，如： http://localhost:8088/test/test.jsp
		    var curPath = window.document.location.href;
		    //获取主机地址之后的目录，如： test/test.jsp
		    var pathName = window.document.location.pathname;
		    var pos = curPath.indexOf(pathName);
		    //获取主机地址，如： http://localhost:8088
		    var localhostPath = curPath.substring(0, pos);
		    //获取带"/"的项目名，如：/test
		    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		    return (localhostPath + projectName);//发布前用此
		}
		
	</script>
</head>

<body>
	<div class="c_list" >
		<h3 align="left">【版块】</h3>
		<ul class="c_cate clearfix">
		<c:forEach items="${boards }" var="b">
			<li><a href="#" onclick="postList(${b.boardId})"> <i class="cc_logo"> <img
						src="<%=request.getContextPath()%>/images/view/common_22_icon.png"
						align="left" alt="" width="97" height="97">
				</i> <strong>${b.boardName }</strong>
					<p>
						简&nbsp;介：&nbsp;${b.description }<br>
						帖子总数：${b.allNum }  精华帖子：${b.goodNum }  今日发帖：${b.todayNum }<br>
						版&nbsp;主：${b.masterName }
					</p>
			</a></li>
		</c:forEach>
			
		</ul>
	</div>
</body>
</html>
