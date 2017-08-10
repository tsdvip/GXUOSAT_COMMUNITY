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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css_1.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<style type="text/css">
.user_m1 {
	clear: both;
	width: 67.8%;
	height: 500px;
	margin-top: 20px;
}
</style>

<script type="text/javascript">
	function del(boardId){
		var b = confirm("是否确认删除?");
		if(b==false){
			return;
		}
		var paras = {'boardId':boardId};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/admin/deleteBoard.do',
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

<script>

jQuery(document).ready(function($) {
	

	$('.theme-edit').click(function(e){
		
		var boardId = $(e.target).parent().prevAll().eq(3).text();
		$("#boardId").val(boardId);
		var boardName = $(e.target).parent().prevAll().eq(2).text();
		$("#boardName").val(boardName);
		var description = $(e.target).parent().prevAll().eq(1).text();
		$("#description").val(description);
		var masterName = $(e.target).parent().prevAll().eq(0).text();
		$("#masterName").val(masterName);
		
		$('.theme-popover-mask').fadeIn(100);

		$('.theme-popover').slideDown(200);

	});
	
$('.theme-add').click(function(e){
	

	$("#boardId").val("");
	$("#boardName").val("");
	$("#description").val("");
	$("#masterName").val("");
		
		$('.theme-popover-mask').fadeIn(100);

		$('.theme-popover').slideDown(200);

	});

	$('.theme-poptit .close').click(function(){

		$('.theme-popover-mask').fadeOut(100);

		$('.theme-popover').slideUp(200);

	});



});

function boardManager(){
	var boardId = $("#boardId").val();
	var boardName = $("#boardName").val();
	var description = $("#description").val();
	var masterName = $("#masterName").val();
	
	var paras = {
			'boardId' : boardId,'boardName' : boardName,'description' : description,'masterName' : masterName
		};
		$.ajax({
			url : '/GXUOSAT_COMMUNITY/admin/boardManager.do',
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
				【版块管理】<br>
			</div>
			<div id="container">

				<table class="zebra">
					<thead>
						<tr>
							<th>版块编号</th>
							<th>版块名称</th>
							<th>版块简介</th>
							<th>版主</th>
							<th style="font-size: 15px;color:red;"><a class="theme-add" hrer="">[添加]</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boards }" var="board">
						<tr>
							<td>${board.boardId }</td>
							<td id="1111">${board.boardName }</td>
							<td>${board.description }</td>
							<td>${board.masterName }</td>
							<td align="center"><a class="theme-edit" hrer="">[编辑]</a>&nbsp;&nbsp;&nbsp;<a hrer="#" onclick="del(${board.boardId })">[删除]</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class="theme-popover">

     <div class="theme-poptit">

          <a href="javascript:;" title="关闭" class="close">×</a>

          <h3>版块</h3>

     </div>

     <div class="theme-popbod dform">

           <form class="theme-signin" name="loginform" action="" method="post">

                <ol>


                     <li><input class="ipt" type="hidden" id="boardId" name="boardId" value="" size="20" /></li>
                     <li><strong>版块名称：</strong><input class="ipt" type="text" id="boardName" name="boardName" value="" size="20" />[最多5个字符]</li>

                     <li><strong>版块简介：</strong><input class="ipt" type="text" id="description" name="description" value="" size="20" />[最多10个字符]</li>
                     
                     <li><strong>版主名称：</strong><input class="ipt" type="text" id="masterName" name="masterName" value="" size="20" /></li>

                     <li><input class="btn btn-primary" type="button" onclick="boardManager()" name="submit" value="保存" /></li>

                </ol>

           </form>

     </div>

</div>
</body>
</html>