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
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" type="text/css" />
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<style>
	   body{
		font-family:"Microsoft YaHei","Hiragino Sans GB","WenQuanYi Micro Hei", sans-serif;
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
		th{
		text-align:center;
		}
		textarea{
		width:800px;
		height:600px;
		}
		.admin-l-bar {

    height: 800px;
}
.admin-main-r-wrapper {
    padding: 19px 100px 0;
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
</div>
<div class="main clearfix">
<%@include file="ADMIN_lbar.jsp"%> 
  <div class="admin-main-r-wrapper">
  <form action="/OurArtbetter/ADMIN_updateinfo?id=${information.id}"  method="post"  enctype="multipart/form-data">
    <h3>资讯管理</h3>
    <div class="operate-table clear" style="margin-left:15px;">
    	<div class="info-title">
			<div class="label-control">
		  	<label>资讯标题：</label>
		 	</div>
	  		<input type="text" name ="title" id="title" class="inputtitle"  value = "${information.title }"></input>
		</div>
		<div>
			<select name="contentType" >
                <option value ="INFO">资讯</option>
                <option value ="ADVER">广告</option>
            </select>
		</div>

	<div>
  	<label>照片：</label><input type="file" name="uploadImage" id="uploadImage" />
 	</div>



	<div class="info-content">
		<div class="label-control"><label>资讯内容：</label></div>
    
       <textarea name= "content" id="content" >${information.content} </textarea>
	   <script type="text/javascript"  >CKEDITOR.replace('content');</script>
	</div>
    </div>
    
	<div style="float:left;margin-left:9px;">
    	<input type="submit" value="确认修改" style="width:100px;height:30px;margin-left:7px;margin-top:20px;" />
  	</div>
  	</form>
  </div>
</div>
   <script type="text/javascript">
   CKEDITOR.replace('content');
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