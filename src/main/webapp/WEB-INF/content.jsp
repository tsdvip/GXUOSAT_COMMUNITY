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
			<h2 align="center" style="margin: 10px">ѧУ���</h2>
			<div align="left">
				<p>
					�����Ƽ���ѧ�������й���ʷ�Ļ����ǡ��й���ҵ����Ϣ���ں��Ե����--�����У��ǹ���ԺѧλίԱ����׼��ѧʿ��˶ʿѧλ��Ȩ��λ����"׿Խҽ�����������ƻ�"�Ե��У��ֱ���ڹ���׳��������������������2013�꾭������ѧλίԱ����׼����ʽȷ��Ϊ2013-2018�������������ʿѧλ���赥λ����һ���Թ�Ϊ�������������ܡ��������ġ�����������������ҽѧ��9��ѧ������Ķ���Ըߵ�ѧУ��
				</p>
				<p>��У��2013��4��18�վ���������׼��ԭ������ѧԺ��ԭ����ҽѧ�ߵ�ר��ѧУ�ϲ��齨���ɣ�ԭ������ѧԺʼ����1958�꣬1982��ϲ������ṤҵѧԺ��������е��ҵѧԺ������ʯ�ͻ���ѧԺ��1985�������Ǩ�����ݰ�ѧ��ԭ����ҽѧ�ߵ�ר��ѧУ������1951�꣬2003�꾭��������׼����Ϊ"����ҽѧ�ߵ�ר��ѧУ"��</p>
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