<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html>
<head>
<title>公告管理</title>
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
	function del(noticeId){
		var b = confirm("是否确认删除?");
		if(b==false){
			return;
		}
		var paras = {'noticeId':noticeId};
		$.ajax({
			url:'/GXUOSAT_COMMUNITY/admin/deleteNotice.do',
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
		
		var noticeId = $(e.target).parent().prevAll().eq(2).text();
		$("#noticeId").val(noticeId);
		var content = $(e.target).parent().prevAll().eq(1).text();
		$("#content").val(content);
		var ymd = $(e.target).parent().prevAll().eq(0).text();
		$("#ymd").val(ymd);
		
		$('.theme-popover-mask').fadeIn(100);

		$('.theme-popover').slideDown(200);

	});
	
$('.theme-add').click(function(e){
	

	$("#noticeId").val("");
	$("#content").val("");
	$("#ymd").val("");
		
		$('.theme-popover-mask').fadeIn(100);

		$('.theme-popover').slideDown(200);

	});

	$('.theme-poptit .close').click(function(){

		$('.theme-popover-mask').fadeOut(100);

		$('.theme-popover').slideUp(200);

	});



});

function noticeManager(){
	var noticeId = $("#noticeId").val();
	var content = $("#content").val();
	var ymd = $("#ymd").val();
	
	var paras = {
			'noticeId' : noticeId,'content' : content,'ymd' : ymd
		};
		$.ajax({
			url : '/GXUOSAT_COMMUNITY/admin/noticeManager.do',
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
				【公告管理】<br>
			</div>
			<div id="container">

				<table class="zebra">
					<thead>
						<tr style="font-size: 16px;">
							<th>公告编号</th>
							<th>公告内容</th>
							<th>公告日期</th>
							<th style="color:red;"><a class="theme-add" hrer="">[添加]</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${notices }" var="notice">
						<tr style="font-size: 15px;">
							<td>${notice.noticeId }</td>
							<td>${notice.content }</td>
							<td>${notice.ymd }</td>
							<td align="center"><a class="theme-edit" hrer="">[编辑]</a>&nbsp;&nbsp;&nbsp;<a hrer="#" onclick="del(${notice.noticeId })">[删除]</a></td>
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

          <h3>公告</h3>

     </div>

     <div class="theme-popbod dform">

           <form class="theme-signin" name="loginform" action="" method="post">

                <ol>


                     <li><input class="ipt" type="hidden" id="noticeId" name="noticeId" value="" size="20" /></li>

                     <li><strong>公告日期：</strong><input class="ipt" type="text" id="ymd" name="ymd" value="" size="20" />[格式：yyyy-MM-dd]</li>
                     <li><strong>公告内容：</strong><textarea class="ipt" style="width: 180px;height: 150px;" id="content" name="content"></textarea>[最多200个字符]</li>
                     
                     <li><input class="btn btn-primary" type="button" onclick="noticeManager()" name="submit" value="保存" /></li>

                </ol>

           </form>

     </div>

</div>
</body>
</html>