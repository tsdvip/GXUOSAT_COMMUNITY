jQuery(function(){

function autFun2(){
	var mW2=$(".slider").width();
	var mBL2=625/205;
	$(".slider .slideBox .bd").css("height",mW2/mBL2);
	$(".slider .slideBox .bd img").css("width",mW2);
	$(".slider .slideBox .bd img").css("height",mW2/mBL2);
}

setInterval(autFun2,1);



})
$(document).ready(function(){
    $("#btn-bars").click(function(){
	$(".header .navbar").slideToggle(500);
    });
});
$(function(){
    $('#monavber li').hover(function(){
       $(this).addClass('on');  
    },function(){
       $(this).removeClass('on'); 
    });
});
//导航高亮
jQuery(document).ready(function($){ 
var datatype=$("#monavber").attr("data-type");
    $(".navbar>li ").each(function(){
        try{
            var myid=$(this).attr("id");
            if("index"==datatype){
                if(myid=="nvabar-item-index"){
                    $("#nvabar-item-index").addClass("active");
                }
            }else if("category"==datatype){
                var infoid=$("#monavber").attr("data-infoid");
                if(infoid!=null){
                    var b=infoid.split(' ');
                    for(var i=0;i<b.length;i++){
                        if(myid=="navbar-category-"+b[i]){
                            $("#navbar-category-"+b[i]+"").addClass("active");
                        }
                    }
                }
            }else if("article"==datatype){
                var infoid=$("#monavber").attr("data-infoid");
                if(infoid!=null){
                    var b=infoid.split(' ');
                    for(var i=0;i<b.length;i++){
                        if(myid=="navbar-category-"+b[i]){
                            $("#navbar-category-"+b[i]+"").addClass("active");
                        }
                    }
                }
            }else if("page"==datatype){
                var infoid=$("#monavber").attr("data-infoid");
                if(infoid!=null){
                    if(myid=="navbar-page-"+infoid){
                        $("#navbar-page-"+infoid+"").addClass("active");
                    }
                }
            }else if("tag"==datatype){
                var infoid=$("#monavber").attr("data-infoid");
                if(infoid!=null){
                    if(myid=="navbar-tag-"+infoid){
                        $("#navbar-tag-"+infoid+"").addClass("active");
                    }
                }
            }
        }catch(E){}
    });
	$("#monavber").delegate("a","click",function(){
		$(".navbar>li").each(function(){
			$(this).removeClass("active");
		});
		if($(this).closest("ul")!=null && $(this).closest("ul").length!=0){
			if($(this).closest("ul").attr("id")=="munavber"){
				$(this).addClass("active");
			}else{
				$(this).closest("ul").closest("li").addClass("active");
			}
		}
	});
});

$(function() {
	    $(window).scroll(function(){		
		    if($(window).scrollTop()>500){		
			    $("#gttop").show();
		    }else{
			    $("#gttop").hide();
		    }
	    });		
	    $("#gttop").click(function(){
		    $("body,html").animate({scrollTop:0},1500);
		    return false;
	    });		
    });
	
	
	
	

	

	
	
	
	
	