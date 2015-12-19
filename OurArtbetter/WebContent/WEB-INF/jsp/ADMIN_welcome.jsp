<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel = "Shortcut Icon" href="images/favicon.ico"/>
<title>DrinkArt</title>
<link rel="stylesheet" type="text/css" href="css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<style>
	   body{
		font-family:"Microsoft YaHei","Hiragino Sans GB","WenQuanYi Micro Hei", sans-serif;
		height:300px;
		}
		.main {
    height: 400px;
}
		.header {
       height: 115px;
     
	   }
		 h3{
		 font-weight:bold;}
		
		 .lc_prolist input[type="button"]{
		 margin-left:4px;
		 }
	     .admin-main-r-wrapper{
		 float:left;
		 margin-left:20px;
		 }
		h2{
		margin-top:0px;
		}
		.admin-main-r-wrapper {
    padding: 19px 36px 0;
}
        .admin-main-r-wrapper h3{
		font-weight:bold;
		}
		th{
		text-align:center;
		}
		label{
		color:#2B6AB8;
		font-weight:norml;
		}
		.ui-dialog {
    width: 380px;
    height: auto;
    border: 1px solid #efefef;
    margin-left:32%;
    margin-top: 50px;
}
       .admin-main-r-wrapper input[type="submit"]{
	   height:30px;
	   }
	   .login-input input {
    height: 20px;
}
.admin-l-bar{
height:530px;}
.admin-main-r-wrapper {
    width: 704px;
    height:530px;
	
}
.admin-l-bar h2 {
    height: 55px;
    font-size: 16px;
    background-color: #092e5d;
    line-height: 55px;
    border-bottom: 2px solid #dedede;
}
.admin-l-bar {
    float: left;
    width: 150px;
    padding-bottom: 10px;
    position: relative;
    color: #fff;
    text-align: center;
    background-color: #073a7c;
}
.admin-welcome-content{
   margin-top:100px;
    width: 844px;
    height:272px;
}
.admin-l-bar li a.firstnav {
    display: block;
    width: 140px;
    padding-left: 10px;
    height: 42px;
    line-height: 42px;
    text-indent: -10px;
    letter-spacing: 2px;
    background-color: #073a7c;
    color: #eaeaea;
}
		</style>
</head>
<body>
<div class="login-bg"> </div>
<div class="admin-bgbar"> </div>
<div class="ui-mask" id="mask" onselectstart="return false"></div>
<div class="container clearfix">
<div class="login-bar-l">欢迎使用DrinkArt艺术品定制网站的后台管理系统!</div>
<div class="header clear">
  <h1 class="logo">DrinkArt</h1>
</div>
<div class="main clearfix">

<%@include file="ADMIN_lbar.jsp"%> 

  <div class="admin-main-r-wrapper" >
   <div class="admin-welcome-content" style="background-image:url('images/welcome3.png');">
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
</script>
</body>
</html>
