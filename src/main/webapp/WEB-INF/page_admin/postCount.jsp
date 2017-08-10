<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>帖子统计</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/table_style.css"
	type="text/css">

<link rel="stylesheet"
	href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
<link href="<%=request.getContextPath()%>/css/foundation-datepicker.css"
	rel="stylesheet" type="text/css">

<style type="text/css">
.count_1 {
	color: #fff;
	clear: both;
	width: 67.8%;
	height: 500px;
	margin-top: 20px;
}
#echart {
	width:100%;
	height: 500px;
}
</style>
<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/echarts-all.js"></script>
<script type="text/javascript">
	//生成表格
	$(function() {
		var myChart = echarts.init(document.getElementById("echart"));
		var dates = ${dates };
		var postNum = ${postNum};

		option = {
			tooltip : {
				show : true
			},
			legend : {
				data : ['帖子数']
			},
			xAxis : [ {
				type : 'category',
				data : dates,
				axisLabel : {
					//X轴刻度配置
					interval : 0
				//0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '帖子数',
				type : 'line',
				data : postNum
			}]
		};
		myChart.setOption(option, true);
	});

</script>


</head>
<body>
	<div align="center">
		<div class="count_1">
		<form action="<%=request.getContextPath()%>/admin/toPostCount.do" method="post">
		
			<table class="table">
				<thead>
					<tr>
						<th>日期: <input type="text" class="span2" name="startDate" value="" id="dpd1">至
							<input type="text" class="span2" name="endDate" value="" id="dpd2">
							&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">
						</th>
					</tr>
				</thead>
			</table>
		</form>

			<div id="echart"></div>

			<div id="container">

				<table class="zebra">
					<thead>
						<tr>
							<th>日期</th>
							<th>发帖数</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${datas }" var="data">
						<tr>
							<td>${data.date }</td>
							<td>${data.num }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/foundation-datepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/locales/foundation-datepicker.zh-CN.js"></script>
	<script>
		$('#demo-1').fdatepicker();
		$('#demo-2').fdatepicker({
			format : 'yyyy-mm-dd hh:ii',
			pickTime : true
		});
		$('#demo-3').fdatepicker();

		var nowTemp = new Date();
		var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp
				.getDate(), 0, 0, 0, 0);
		var checkin = $('#dpd1').fdatepicker({
			/* onRender : function(date) {
				return date.valueOf() < now.valueOf() ? 'disabled' : '';
			} */
		}).on('changeDate', function(ev) {
			if (ev.date.valueOf() > checkout.date.valueOf()) {
				var newDate = new Date(ev.date)
				newDate.setDate(newDate.getDate() + 1);
				checkout.update(newDate);
			}
			checkin.hide();
			$('#dpd2')[0].focus();
		}).data('datepicker');
		var checkout = $('#dpd2')
				.fdatepicker(
						{
							onRender : function(date) {
								return date.valueOf() <= checkin.date.valueOf() ? 'disabled'
										: '';
							}
						}).on('changeDate', function(ev) {
					checkout.hide();
				}).data('datepicker');
	</script>
</body>
</html>