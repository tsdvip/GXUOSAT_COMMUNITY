<%@ page contentType="text/html; charset=gb2312"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>1</title>
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<style type="text/css">
body .jq22-container {
	float: left;
	width: 730px;
}

.art{
	color: #fff;
}

.jq22-header h1 {
	text-align: center;
	font-size: 18px;
}

section.awSlider .carousel {
	display: table;
	z-index: 2;
	-moz-box-shadow: 0 0 4px #444;
	-webkit-box-shadow: 0 0 4px #444;
	box-shadow: 0 0 15px rgba(1, 1, 1, .5);
}

section.awSlider {
	margin: 1px 1px 1px 183px;
	padding: 13px;
	position: relative;
	display: table;
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

section.awSlider:hover>img {
	-ms-transform: scale(1.2);
	-webkit-transform: scale(1.2);
	transform: scale(1.2);
	opacity: 1;
}

section.awSlider img {
	pointer-events: none;
}

section.awSlider>img {
	position: absolute;
	top: 30px;
	z-index: 1;
	transition: all .3s;
	filter: blur(1.8vw);
	-webkit-filter: blur(2vw);
	-moz-filter: blur(2vw);
	-o-filter: blur(2vw);
	-ms-filter: blur(2vw);
	-ms-transform: scale(1.1);
	-webkit-transform: scale(1.1);
	transform: scale(1.1);
	opacity: .5;
}

.card_content{
	text-indent:2em;
	background-color: #33CCCC;
}
</style>
</head>
<body>
	<div class="jq22-container">
		<section class="awSlider">
			<div class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target=".carousel" data-slide-to="0" class="active"></li>
					<li data-target=".carousel" data-slide-to="1"></li>
					<li data-target=".carousel" data-slide-to="2"></li>
					<li data-target=".carousel" data-slide-to="3"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="<%=request.getContextPath()%>/img/a1.jpg">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/img/a2.jpg">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/img/a3.jpg">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/img/a4.jpg">
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href=".carousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				</a> <a class="right carousel-control" href=".carousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				</a>
			</div>
		</section>

	</div>

	<div class="art">
		<article style="width: 71.2%; height: 100px;">
			<h2 align="center" style="margin: 10px">学校简介</h2>
			<div align="left">
				<p>
					广西科技大学坐落在中国历史文化名城、中国工业化信息化融合试点城市--柳州市，是国务院学位委员会批准的学士、硕士学位授权单位，是"卓越医生教育培养计划"试点高校，直属于广西壮族自治区人民政府管理。2013年经自治区学位委员会批准，正式确定为2013-2018年立项建设新增博士学位授予单位。是一所以工为主，包含工、管、理、经、文、法、艺术、教育、医学等9大学科门类的多科性高等学校。
				</p>
				<p>该校于2013年4月18日经教育部批准由原广西工学院和原柳州医学高等专科学校合并组建而成，原广西工学院始建于1958年，1982年合并广西轻工业学院、广西机械工业学院、广西石油化工学院，1985年从南宁迁至柳州办学。原柳州医学高等专科学校创建于1951年，2003年经教育部批准升格为"柳州医学高等专科学校"。</p>
			</div>
		</article>
	</div>



	<script src='<%=request.getContextPath()%>/js/bootstrap.min.js'></script>
	<script>
		$('section.awSlider .carousel').carousel({
			pause : 'hover',
			interval : 2000
		});
		var startImage = $('section.awSlider .item.active > img').attr('src');
		$('section.awSlider').append('<img src="' + startImage + '">');
		$('section.awSlider .carousel').on('slid.bs.carousel', function() {
			var bscn = $(this).find('.item.active > img').attr('src');
			$('section.awSlider > img').attr('src', bscn);
		});
	</script>

</body>
</html>