<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="utf-8"%>
<html>

<head>

    <meta charset="UTF-8">

  <title>制作3D旋转导航</title>
  <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/cookie_util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>

<script type="text/javascript">
function logout(){
	delCookie("userId");
	delCookie("nickname");
}

function getInfo(){
	var userId = getCookie("userId");
	if(userId==null){
		alert("您还未登录！请登录后再进行此操作！");
		return;
	}
	location.href = "/GXUOSAT_COMMUNITY/user/getInfo.do";
}

function toAdminPage(){
	var userId = getCookie("userId");
	//alert(ownerId);
	if(userId == null){
		alert("您的权限不足！");
		return ;
	}
	$.ajax({
		url:'/GXUOSAT_COMMUNITY/admin/checkRoot.do',
		dataType:'json',
		type:'post',
		success:function(result){
			var b = result.data;
			if(b=='success')  
		    {  
				location.href = "/GXUOSAT_COMMUNITY/admin/toPostCount.do";
		    }else{
		    	alert(b);
		    }
		   
		},
		error:function(){
			alert("服务器繁忙！请稍后再试！")
		}
	});
}
</script>


  <style>

        @import url("http://www.w3cplus.com/demo/css3/base.css");

        /*任务一：引入本地字体文件*/

        @font-face {

    font-family: 'sansationregular';

    font-weight: normal;

    font-style: normal;

}

        /* body {

          background-color:#edecec;

        }
 */
        

        /* basic menu styles */

        .nav-menu {

          display: block;

         /* background: #74adaa;*/

          width:881px;

          margin: 5px 10px 0px 50px;

        }

        .nav-menu > li {

          display: inline;

          float:left;     

          border-right:1px solid #94c0be;

        }

        .nav-menu > li:last-child {

          border-right: none;

        }

        .nav-menu li a {

          color: #fff;

          display: block;

          text-decoration: none;

          /*调用本地字体*/

          font-family:sansationregular;

          -webkit-font-smoothing: antialiased;

          -moz-font-smoothing: antialiased;

          font-smoothing: antialiased;

          text-transform: capitalize;

          overflow: visible;

          line-height: 20px;

          font-size: 19px;

          padding: 15px 30px 15px 31px;     

        }

        

        

        .three-d {

          /* 任务三、设置3D舞台布景 */

          -webkit-perspective: 200px;

          -moz-perspective: 200px;

          -ms-perspective: 200px;

          -o-perspective: 200px;

          perspective: 200px;

          /*任务四、设置3D舞台布景过渡效果*/

          -webkit-transition: all .07s linear;

          -moz-transition: all .07s linear;

          -ms-transition: all .07s linear;

          -o-transition: all .07s linear;

          transition:all .7s linear;

          position: relative;

        }

        

        .three-d:not(.active):hover {

          cursor: pointer;

        }

        

        /*任务五、给不是当前状态的3D舞台的悬浮与聚焦状态设置变形效果*/

        .three-d:not(.active):hover .three-d-box, 

        .three-d:not(.active):focus .three-d-box {

        -wekbit-transform: translateZ(-25px) rotateX(90deg);

        -moz-transform: translateZ(-25px) rotateX(90deg);

        -o-transform: translateZ(-25px) rotateX(90deg);

        -ms-transform: translateZ(-25px) rotateX(90deg);

        transform: translateZ(-25px) rotateX(90deg);

    /*    -webkit-transform:rotateX(90deg) translatez(-25px);*/

       /*   -webkit-transform:rotatex(90deg);*/

        }

        

        .three-d-box {

          /*任务六、给3D舞台中“.three-d-box”设置过渡与变形效果*/

          -webkit-transition: all .3s ease-out;

          -moz-transition: all .3s ease-out;

          -ms-transition: all .3s ease-out;

          -o-transition: all .3s ease-out;  

          transition: all .3s ease-out;

          -webkit-transform: translatez(-25px);

          -moz-transform: translatez(-25px);

          -ms-transform: translatez(-25px);

          -o-transform: translatez(-25px);

          transform: translatez(-25px);

          -webkit-transform-style: preserve-3d;

          -moz-transform-style: preserve-3d;

          -ms-transform-style: preserve-3d;

          -o-transform-style: preserve-3d;

          transform-style: preserve-3d;

          -webkit-pointer-events: none;

          -moz-pointer-events: none;

          -ms-pointer-events: none;

          -o-pointer-events: none;

          pointer-events: none;

          position: absolute;

          top: 0;

          left: 0;

          display: block;

          width: 100%;

          height: 100%;

        }

        

        /*任务七、给导航设置3D前，与3D后变形效果*/

        .front {

            -webkit-transform: rotatex(0deg) translatez(25px);

            -moz-transform: rotatex(0deg) translatez(25px);

            -ms-transform: rotatex(0deg) translatez(25px);

            -o-transform: rotatex(0deg) translatez(25px);

            transform: rotatex(0deg) translatez(25px);

         }

        

        .back {

          -webkit-transform: rotatex(-90deg) translatez(25px);

          -moz-transform: rotatex(-90deg) translatez(25px);

          -ms-transform: rotatex(-90deg) translatez(25px);

          -o-transform: rotatex(-90deg) translatez(25px);

          transform: rotatex(-90deg) translatez(25px);

          color: #FFE7C4; 

        }

        

        .front, .back {

/*          border:1px solid red;*/

          display: block;

          width: 100%;

          height: 100%;

          position: absolute;

          top: 0;

          left: 0;

          background: #74adaa;

          padding: 15px 30px 15px 31px; 

          color: white;

          -webkit-pointer-events: none;

          -moz-pointer-events: none;

          -ms-pointer-events: none;

          -o-pointer-events: none;

          pointer-events: none;

          -webkit-box-sizing: border-box;

          box-sizing: border-box;

        }

        /*任务八、设置导航当前状态与悬浮状态下的背景效果*/

        .nav-menu li .active .front,

        .nav-menu li .active .back,

        .nav-menu li a:hover .front,

        .nav-menu li a:hover .back {

             background-color: #51938f;

             -webkit-background-size: 5px 5px;

             background-size: 5px 5px;

             background-position: 0 0, 30px 30px;

             background-image: -webit-linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480), linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480);

             background-image: -moz-linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480), linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480);

             background-image: -ms-linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480), linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480);

             background-image: -o-linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480), linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480);

             background-image: linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480), linear-gradient(45deg, #478480 25%, transparent 25%, transparent 75%, #478480 75%, #478480);

        }

        .nav-menu ul {

          position: absolute;

          text-align: left;

          line-height: 40px;

          font-size: 14px;

          width: 200px;

          -webkit-transition: all 0.3s ease-in;

          -moz-transition: all 0.3s ease-in;

          -ms-transition: all 0.3s ease-in;

          -o-transition: all 0.3s ease-in;

          transition: all 0.3s ease-in;

          -webkit-transform-origin: 0px 0px;

          -moz-transform-origin: 0px 0px;

          -ms-transform-origin: 0px 0px;

          -o-transform-origin: 0px 0px;

          transform-origin: 0px 0px;

          -webkit-transform: rotateX(-90deg);

          -moz-transform: rotateX(-90deg);

          -ms-transform: rotateX(-90deg);

          -o-transform: rotateX(-90deg);

          transform: rotateX(-90deg);

          -webkit-backface-visibility: hidden;

          -moz-backface-visibility: hidden;

          -ms-backface-visibility: hidden;

          -o-backface-visibility: hidden;

          backface-visibility: hidden;

        }

        /*任务九、显示下拉导航菜单，并其设置一个变形效果*/

        .nav-menu > li:hover ul {

/*          display: block;*/

           -webkit-transform: rotateX(0deg);

           -moz-transform: rotateX(0deg);

           -ms-transform: rotateX(0deg);

           -o-transform: rotateX(0deg);

           transform: rotateX(0deg);

         }

  </style>

</head>

<body>

  <div id="nav">

    <ul class="nav-menu clearfix unstyled">

      <li><a href="<%=request.getContextPath()%>/index/goIndex.do" class="three-d active">

        首页

        <span class="three-d-box"><span class="front">&#x9996;&#x9875;</span><span class="back">&#x9996;&#x9875;</span></span>

      </a></li>
      
      <li><a href="#" onclick="getInfo()" class="three-d">

        个人中心

        <span class="three-d-box"><span class="front">&#x4E2A;&#x4EBA;&#x4E2D;&#x5FC3;</span><span class="back">&#x4E2A;&#x4EBA;&#x4E2D;&#x5FC3;</span></span>

      </a></li>

      <li><a href="#" onclick="toAdminPage()" class="three-d">

        后台管理

        <span class="three-d-box"><span class="front">&#x540E;&#x53F0;&#x7BA1;&#x7406;</span><span class="back">&#x540E;&#x53F0;&#x7BA1;&#x7406;</span></span>

      </a></li>
      <li><a href="<%=request.getContextPath()%>/user/reg.do" class="three-d">

              注册

              <span class="three-d-box"><span class="front">&#x6CE8;&#x518C;</span><span class="back">&#x6CE8;&#x518C;</span></span>

          </a></li>
      
      <li><a href="<%=request.getContextPath()%>/log_in.html" class="three-d">

        登录

        <span class="three-d-box"><span class="front">&#x767B;&#x5F55;</span><span class="back">&#x767B;&#x5F55;</span></span></a>

        <ul class="clearfix unstyled drop-menu">

          <li><a href="<%=request.getContextPath()%>/index/goIndex.do" onclick="logout()" class="three-d">

              注销

              <span class="three-d-box"><span class="front">&#x6CE8;&#x9500;</span><span class="back">&#x6CE8;&#x9500;</span></span>

          </a></li>

        </ul>

      </li>
      
      <li><a href="<%=request.getContextPath()%>/index/notice.do" class="three-d">

        公告栏

        <span class="three-d-box"><span class="front">&#x516C;&#x544A;&#x680F;</span><span class="back">&#x516C;&#x544A;&#x680F;</span></span>

      </a></li>
      

    </ul>

  </div>

</body>

</html>