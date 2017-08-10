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
		    //��ȡ��ǰ��ַ���磺 http://localhost:8088/test/test.jsp
		    var curPath = window.document.location.href;
		    //��ȡ������ַ֮���Ŀ¼���磺 test/test.jsp
		    var pathName = window.document.location.pathname;
		    var pos = curPath.indexOf(pathName);
		    //��ȡ������ַ���磺 http://localhost:8088
		    var localhostPath = curPath.substring(0, pos);
		    //��ȡ��"/"����Ŀ�����磺/test
		    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		    return (localhostPath + projectName);//����ǰ�ô�
		}
		
	</script>
</head>

<body>
	<div class="c_list" >
		<h3 align="left">����顿</h3>
		<ul class="c_cate clearfix">
		<c:forEach items="${boards }" var="b">
			<li><a href="#" onclick="postList(${b.boardId})"> <i class="cc_logo"> <img
						src="<%=request.getContextPath()%>/images/view/common_22_icon.png"
						align="left" alt="" width="97" height="97">
				</i> <strong>${b.boardName }</strong>
					<p>
						��&nbsp;�飺&nbsp;${b.description }<br>
						����������${b.allNum }  �������ӣ�${b.goodNum }  ���շ�����${b.todayNum }<br>
						��&nbsp;����${b.masterName }
					</p>
			</a></li>
		</c:forEach>
			
		</ul>
	</div>
</body>
</html>
