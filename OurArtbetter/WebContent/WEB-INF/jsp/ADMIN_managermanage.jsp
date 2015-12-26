<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="Shortcut Icon" href="images/favicon.ico">
<title>DrinkArt</title>
<link rel="stylesheet" type="text/css" href="css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"
	type="text/css" />
<link rel="stylesheet" href="css/reveal.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<style>
body {
	font-family: "Microsoft YaHei", "Hiragino Sans GB",
		"WenQuanYi Micro Hei", sans-serif;
}

h3 {
	font-weight: bold;
}

.lc_prolist input[type="button"] {
	margin-left: 4px;
}

.admin-main-r-wrapper {
	float: left;
	margin-left: 20px;
}

.main {
	height: 800px;
}

h2 {
	margin-top: 0px;
}

.admin-main-r-wrapper {
	padding: 19px 36px 0;
}

.admin-main-r-wrapper h3 {
	font-weight: bold;
}

th {
	text-align: center;
}
</style>
</head>
<body>
	<div class="login-bg"></div>
	<div class="admin-bgbar"></div>
	<div class="ui-mask" id="mask" onselectstart="return false"></div>
	<div class="container clearfix">
		<div class="login-bar-l">欢迎使用DrinkArt艺术品定制网站的后台管理系统!</div>
		<div class="login-bar">
			<a href="#" class="orange" style="cursor: default;">你好！管理员:${sessionScope.admin.name}</a>
			<a href="/OurArtbetter/LoginOut">退出</a>
		</div>
		<div class="header clear">
			<h1 class="logo">DrinkArt</h1>
		</div>
		<div class="main clearfix">
			<%@ include file="ADMIN_lbar.jsp"%>
			<div class="admin-main-r-wrapper">
				<div class="search" style="float: right;">
					<form action="#" method="post">
						<input type="text" name="searchname" placeholder="请输入您要搜索的艺术家ID" />
						<input type="submit" value="搜索" />
					</form>
				</div>
				<h3>管理员管理</h3>
				<div class="operate-table clear">
					<form action="/OurArtbetter/ADMIN_setDateAndPos/" method="post">
						<table class="lc_prolist" id="infolist">
							<thead>
								<tr>
									<th>管理员ID</th>
									<th>账号</th>
									<th>设置权限</th>
									<th>设置</th>
									<th>操作</th>
								</tr>
							</thead>
							<c:forEach var="ad" items="${sessionScope.admin_list}">
								<tr>
									<td>${ad.id}</td>
									<td>${ad.name}</td>
									<td>${ad.adminType}</td>
									<td><input type="button" value="设置" class="" /></td>
									<td><a href="/OurArtbetter/resetPassword?cur_id=${ad.id}&resetType=2">重置密码</a></td>
								</tr>
							</c:forEach>
							<tr>
          <td colspan=10><a href="javascript:void(0)" style="float:right;text-decoration:underline;font-size:14px;color:#2B6AB8;" onClick="add()"><span><img src="images/addnew.png" alt="" style="width:10px;height:10px;"/></span><span style="margin-left:2px;">新建管理员</span></a></td>
						</tr>
							<tr>
								<td colspan=10>{$page}</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>


		<script type="text/javascript">
			var i = 1;
			$(function() {
				$(".navhasul").hover(function() {
					$(this).find(".firstnav").addClass("hovertri");
					$(this).children("ul").show();
				}, function() {
					$(this).find(".firstnav").removeClass("hovertri");
					$(this).children("ul").hide();
				});
			});

			 function add(){
   var newTr = infolist.insertRow(1);
   newTr.innerHTML ='<tr><td><input type="text"/></td><td><input type="text/"></td><td><select name="" id=""><option value ="1">主编</option><option value ="2">采编</option><option value="3">后台管理员</option></select></td><td colspan=2><input type="button" value="设置" class=""/></td></tr>';
   }
		</script>
</body>