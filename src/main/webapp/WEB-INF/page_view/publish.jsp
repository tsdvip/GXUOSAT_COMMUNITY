<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>

<html>
  <head>
    <title>【发帖】</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style_input.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
	
<style type="text/css">
	.p_post{
	clear:both;
		align : center;
	}
	
	 .but_p{
display: block;
width:60px;
height: 40px;
background: #13A89E;
text-align: center;
padding: auto;
position: relative;
margin: 0 10px 0 0; 
border-radius:5px;//圆角矩形属性
font-size: 50px;
text-decoration: none;
color: #fff;
}

.but_p:hover
{
background: #fa5ba5;
}


</style>
<script type="text/javascript">
	function addPost(){
		var boardId = $("input[name='boardId']").val();
		var userId = $("input[name='userId']").val();
		var title = $("input[name='title']").val();
		var content = $("#content").val();
		var paras = {'boardId':boardId,'userId': userId,'title': title,'content': content};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/post/addPost.do',
			data:paras,
			dataType:'json',
			type:'post',
			success:function(result){
				var b = confirm(result.data);
				if(b==true)  
			    {  
			        window.close();  
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
  	<div class="p_post">
  	<form action="#" >
  		<input type="hidden" name="boardId" value="${boardId }">
  		<input type="hidden" name="userId" value="${userId }">
	  <h3 align="center">标题：</h3><input type="text" name="title" value="" style="width:100%;height:30px;" class="mytxt" /><br>
	  <h3 align="center">内容：</h3><textarea style="width:100%;height:220px;" id="content" class="mytxt"></textarea>
		<br>
		<div  align="center">
			<input type="button" class="but_p" value="提交" onclick="addPost()">
		</div>
  	</form>
  	</div>
  </body>
</html>
