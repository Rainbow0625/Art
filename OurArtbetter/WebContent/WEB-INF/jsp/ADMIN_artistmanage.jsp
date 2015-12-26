<%@page import="java.util.List"%>
<%@page import="com.art.entity.Artist"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel = "Shortcut Icon" href="images/favicon.ico">
<title>DrinkArt</title>
<link rel="stylesheet" type="text/css" href="css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" type="text/css" />
<link rel="stylesheet" href="css/reveal.css">	
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
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
		</style>
</head>
<body>	<div class="login-bg"></div>
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
				<h3>艺术家管理</h3>
				<div class="operate-table clear">
					<form action="/OurArtbetter/ADMIN_setDateAndPos/" method="post">
						<table class="lc_prolist" id="infolist">
							<thead>
								<tr>
									<th>艺术家ID</th>
									<th>电话号码</th>
									<th>真实姓名</th>
									<th>状态</th>
									<th>操作</th>
									<th colspan=2>审核</th>
								</tr>
							</thead>
							<%
								List ul = null;
								if (request.getSession().getAttribute("artist_list") != null) {
									ul = (List) request.getSession().getAttribute("artist_list");
									int length = ul.size();
									for (int i = 0; i < length; i++) {
										Artist artist = (Artist) ul.get(i);
										int id = artist.getId();
										String tel = artist.getTel();
										String realName = artist.getRealName();
										int status = artist.getState();

										String operation;
										int data;
										String message;
										String cur_state;
										if (status == 1) {
											operation = "禁言";
											data = 0;
											message = "确定要禁言该艺术家吗？";
											cur_state = "合法";
										} else {
											operation = "取消禁言";
											data = 1;
											message = "确定要取消禁言该艺术家吗？";
											cur_state = "禁言";
										}
							%>
							<tr>
								<td><%=id %></td>
								<td><%=tel %></td>
								<td><%=realName %></td>
								<td><%=cur_state %></td>

								<td><a href="javascript:void(0)"
									onclick="if(window.confirm('<%=message%>')) this.href='/OurArtbetter/setUserIlleagalOrleagal?cur_tel=<%=tel%>&cur_state=<%=data%>'"><%=operation%></a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:void(0)"
									onclick="if(window.confirm('确定要重置该用户的密码吗？')) this.href='/OurArtbetter/resetPassword?cur_id=<%=id %>&resetType=1'">重置密码</a>

								</td>
								<td colspan=2><a href="javascript:void(0)"
									onclick="if(window.confirm('确定要拒绝该艺术家的申请吗？')) this.href='/OurArtbetter/'">拒绝</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:void(0)"
									onclick="if(window.confirm('确定要通过该艺术家的申请吗？')) this.href='/OurArtbetter/'">通过</a>

								</td>
							</tr>
							<tr>
								<td colspan=10>{$page}</td>
							</tr>
							<%
		}
	}
%>
						</table>
					</form>
				</div>
			</div>
		</div>

		<script type="text/javascript">
	var i=1;
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