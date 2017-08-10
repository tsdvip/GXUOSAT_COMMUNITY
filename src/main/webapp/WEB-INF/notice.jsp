<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>

<title>公告</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
 <style type="text/css">
 /*通用样式*/
body,ul,li,p,h1,h2,h3,h4,h5{
    margin:0;
    padding:0;
    font-size:100%;
}
body{
    font-family: 'Microsoft YaHei UI', 'Microsoft YaHei', SimSun, 'Segoe UI', Tahoma, Helvetica, Sans-Serif;
    font-size: 14px;
    background: #6f0b02;
}
button,input,select,textarea{
    font-family: inherit;
    font-size: 100%;
    margin: 0;
}
button,
html input[type="button"],
input[type="reset"],
input[type="submit"] {
    -webkit-appearance: button;
    cursor: pointer;
}
li{
    list-style: none;
}
a{
    text-decoration:none;
    color:#000;
    background: transparent;
}
a:focus{
    outline: none;
}
img{
    border:0;
}

.fl{
    float: left;
}
.fr{
    float: right;
}
.center{
    width: 1000px;
    margin: 0 auto 0;
}
/*content*/
.content{
    position: relative;
    margin: auto;
    width: 900px;
    height: 460px;
}
.l-pic-index{
	/*display:none;*/
    position: absolute;
    left: 400px;
    top: 1px;
    z-index:2;
    width:50px;
    height:460px;
    background: url("/GXUOSAT_COMMUNITY/images/j1.png") no-repeat right 0;
}
.r-pic-index{
	/*display:none;*/
    position: absolute;
    right: 400px;
    top: 0;
    z-index: 2;
    width:50px;
    *width:82px;
    height:460px;
    background: url("/GXUOSAT_COMMUNITY/images/j4.png") no-repeat left 0;
}
.l-bg-index{
    position: absolute;
    top: -3px;
    left: 430px;
    z-index: 1;
    width: 25px;
    height: 459px;
    background: url("/GXUOSAT_COMMUNITY/images/j2.png") right 0 no-repeat;
}
.r-bg-index{
    position: absolute;
    top:-4px;
    right: 430px;
    z-index: 1;
    width: 25px;
    height: 459px;
    background: url("/GXUOSAT_COMMUNITY/images/j3.png") 0 0 no-repeat;
}
.main-index{
    display: none;
    overflow: hidden;
    zoom:1;
    position: absolute;
    z-index: 5;
    width:530px;
    height:280px;
    left:145px;
    top:90px;
    color: #2e2e2e;
}
.intro-text{
    margin: 10px 0 0 44px;
    line-height: 1.8;
    text-indent: 30px;
}
 </style>	
</head>

<body>
 <div class="content" id="notice_1">
        <div class="l-pic-index"></div>
        <div class="r-pic-index"></div>
        <div class="l-bg-index"></div>
        <div class="r-bg-index"></div>
        <div class="main-index">
            <!-- <h1 class="title"><img src="./img/intro-title.png" alt=""></h1> -->
	            <p class="intro-text">
	               	${notice.content }
	            </p>
	            <p class="intro-text">${notice.ymd }</p>
        </div>
    </div>
</body>
<script>
 $(document).ready(function(){
        //卷轴展开效果
        $(".l-pic-index").animate({'left':'95px','top':'-4px'},1300);
        $(".r-pic-index").animate({'right':'-23px','top':'-5px'},1450);
        $(".l-bg-index").animate({'width':'433px','left':'73px'},1500);
        $(".r-bg-index").animate({'width':'433px','right':'-38px'},1500,function(){
            $(".main-index").fadeIn(800);
        });
    });
</script>
</html>
