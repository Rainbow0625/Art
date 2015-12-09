<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>"ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel = "Shortcut Icon" href="../../../images/favicon.ico">
<title>DrinkArt</title>
<link rel="stylesheet" type="text/css" href="css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" type="text/css" />
<link rel="stylesheet" href="css/trumbowyg.css">
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="js/trumbowyg.js"></script>
<script src="js/fr.js"></script>
<script src="js/trumbowyg.upload.js"></script>
<script src="js/trumbowyg.base64.js"></script>
<style>
		body{
		font-family:"Microsoft YaHei","Hiragino Sans GB","WenQuanYi Micro Hei", sans-serif;
		}
		.main{
		height:800px;}
		h2{
		margin-top:0px;
		}
		.admin-main-r-wrapper {
    padding: 19px 36px 0;
}
        .admin-main-r-wrapper h3{
		font-weight:bold;
		}
		.operate-table label{
		color:#2B6AB8;
		font-size:12px;
		font-weight:normal;
		}
		            #main {
                max-width: 960px;
                margin: 0 auto;
            }
			.label-control{
			display:inline;
			float:left;
		    width:60px;	
			height:20px;
			margin-top:3px;
			}
			.label-control label{
				float:right;}

.container {
    width: 1016px;
}
.info-position,.info-price,.info-date,.info-title{
float:left;
margin-left:8px;
width:600px;
height:40px;
}
.info-content{
float:left;
margin-left:8px;
width:1000px;
height:450px;}
.inputtitle{
width:200px;
}


		</style>
</head>
<body>
<div class="login-bg"> </div>
<div class="admin-bgbar"> </div>
<div class="ui-mask" id="mask" onselectstart="return false"></div>
<div class="container clearfix">
<div class="login-bar-l">欢迎使用DrinkArt艺术品定制网站的后台管理系统!</div>
<div class="login-bar"> <a href="#" class="orange" style="cursor:default;">你好！管理员:{$adminname}</a> <a href="__APP__/Login/logout">退出</a> </div>
<div class="header clear">
  <h1 class="logo">DrinkArt</h1>
</div>
<div class="main clearfix">
  <div class="admin-l-bar">
    <h2>后台管理系统</h2>
    <ul>
      <li><a href="#" class="firstnav">首页</a></li>
      <li class="navhasul"><a href="#" class="firstnav">用户管理</a>
        <ul class="secondnav">
          <li><a href="#">用户列表</a></li>
          <li><a href="#">艺术家列表</a></li>
          <li><a href="#">增加用户</a></li>
        </ul>
      </li>
      <li class="navhasul"><a href="#" class="firstnav">订单管理</a>
        <ul class="secondnav">
          <li><a href="#">商城订单管理</a></li>
          <li><a href="#">定制订单管理</a></li>
          <li><a href="#">拍卖订单管理</a></li>
        </ul>
      </li>
      <li class="navhasul"><a href="#" class="firstnav">资讯广告管理</a>
        <ul class="secondnav">
          <li><a href="#">资讯管理</a></li>
          <li><a href="#">广告管理</a></li>
        </ul>
      </li>
      <li class="navhasul"><a href="#" class="firstnav">业务管理</a>
        <ul class="secondnav">
          <li><a href="#">拍卖管理</a></li>
          <li><a href="#">商城管理</a></li>
        </ul>
      </li>
      <li class="navhasul"><a href="#" class="firstnav">咨询投诉管理</a> </li>
    </ul>
  </div>
  <div class="admin-main-r-wrapper">
    <h3>资讯管理</h3>
    <div class="operate-table clear" style="margin-left:15px;">
	
	<div class="info-title">
	<div class="label-control">
	  <label>资讯标题：</label>
	  </div>
	  <input type="text" value="" id="" class="inputtitle"/>
	</div>
	<div class="info-content">
	<div class="label-control">
	 <label>资讯内容：</label>
	 </div>
    <div id="main" role="main" style="float:left;margin-left:-18px;">
      <form action="#">
        <div id="customized-buttonpane" class="editor">
          <h2>This is a demo of Trumbowyg with a customized button pane</h2>
          <p> The text is derived from Cicero's De Finibus Bonorum et Malorum (On the Ends of Goods and Evils, or alternatively [About] The Purposes of Good and Evil ). The original passage began: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit (Translation: &quot;Neither is there anyone who loves grief itself since it is grief and thus wants to obtain it&quot;). </p>
          <p style="text-align: center;"> <img src="http://alex-d.github.com/Trumbowyg/img/html5.png" alt="Blabla dans le alt"> </p>
          <p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos, minima, asperiores libero architecto sequi fugit dolore sunt in officiis facere ut quaerat ullam laudantium delectus aliquam tenetur alias! Ea, nisi, est earum temporibus dolores quas qui repellendus aliquid voluptatibus tempore facilis eligendi omnis reiciendis nihil ullam quo dolorem nam deleniti. Fugit dignissimos dolorum dolore voluptate repudiandae recusandae debitis. Neque, adipisci, maiores magni aliquam molestiae ex natus minus quod tempora nemo debitis eum laboriosam voluptatum ut architecto animi nobis vero quis dolore eaque! Corporis, dolore, illum, autem in eum ea doloribus ut consequuntur modi et ullam adipisci blanditiis corrupti ab voluptate. </p>
          <p> It is not known exactly when the text acquired its current standard form; it may have been as late as the 1960s. The passage was discovered by Richard McClintock, a Latin scholar who is the publications director at Hampden-Sydney College in Virginia, by searching for citings of the rarely used word 'consectetur' in classical literature. </p>
        </div>
      </form>
    </div>
	</div>
	
  <div style="float:left;margin-left:9px;">
    <input type="submit" value="提交" style="width:100px;height:30px;"/>
  </div>
  </div>
  </div>
</div>
<script type="text/javascript">
	$(function(){
		$(".navhasul").hover(function(){
			$(this).find(".firstnav").addClass("hovertri");
			$(this).children("ul").show();
		},function(){
			$(this).find(".firstnav").removeClass("hovertri");
			$(this).children("ul").hide();
		});
	})
	
   $(".input-append").datetimepicker({
   format: 'yyyy-mm-dd',
   autoclose:true,
   minView:2,//最精确到天
   startView:2,//一打开显示的是天
   forceParse:true
   
 
   });
	$('.dropdown-toggle').dropdown();
	$('#dropdown').on('show.bs.dropdown', function () {
	console.log("haha");
  // do something…
})

            /** Default editor configuration **/
       
            $('#customized-buttonpane').trumbowyg({
                lang: 'fr',
                closable: true,
                fixedBtnPane: true,
                btnsDef: {
                    // Customizables dropdowns
                    align: {
                        dropdown: ['justifyLeft', 'justifyCenter', 'justifyRight', 'justifyFull'],
                        ico: 'justifyLeft'
                    },
                    image: {
                        dropdown: ['insertImage', 'upload', 'base64'],
                        ico: 'insertImage'
                    }
                },
                btns: ['viewHTML',
                    '|', 'formatting',
                    '|', 'btnGrp-test',
                    '|', 'align',
                    '|', 'btnGrp-lists',
                    '|', 'image']
            });



            /** Simple customization with current options **/
      
</script>
</body>
