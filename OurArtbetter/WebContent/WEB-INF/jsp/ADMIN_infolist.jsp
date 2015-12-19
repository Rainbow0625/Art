<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel = "Shortcut Icon" href="/images/favicon.ico"/>
		<title>DrinkArt</title>
		<link rel="stylesheet" type="text/css" href="/css/admin_style.css" />
		<link rel="stylesheet" type="text/css" href="/css/admin.css" />

		<script type="text/javascript" src="/js/jquery.1.10.2.js"></script>     
		<style>
		 h3{
		 font-weight:bold;}
		
		 .lc_prolist input[type="button"]{
		 margin-left:4px;
		 }
	
		</style>		
	</head>
	
	<body>
		<div class="login-bg"> </div>
		<div class="admin-bgbar"> </div>
		<div class="ui-mask" id="mask" onselectstart="return false"></div>

		<div class="container clearfix">
			<div class="login-bar-l">欢迎使用DrinkArt艺术品定制网站的后台管理系统!</div>
			<div class="login-bar">
				<a href="#" class="orange" style="cursor:default;">你好！管理员:{$adminname}</a>
				<a href="__APP__/Login/logout">退出</a>
			</div>
			<div class="header clear">
				<h1 class="logo">DrinkArt</h1>
			</div>
			<div class="main clearfix">
			<div class="admin-l-bar">
			</div>
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

        <li class="navhasul"><a href="#" class="firstnav">咨询投诉管理</a>
		</li>
	</ul>
</div>

  <div class="admin-main-r-wrapper">
			   	
			   	 <div class="search" style="float:right;">			   	 	
                    <form action="#" method="post">                	
                    	<input type="text" name="searchname" placeholder="请输入您要搜索的资讯" />
                    	<input type="submit"  value="搜索" />
                    </form>
			   	 </div>
			   	  <h3>资讯管理</h3>
			   	 
			   	 <div class="operate-table clear">
			   	 
			   	 
			   	 <!-- 广告 -->
			   	 <table class="lc_prolist">
			   	 
				 
			   	 		<thead>
			   	 		<tr>
			   	 			<th>广告标题</th>
			   	 			<th>创建时间</th>
							<th>上次修改时间</th>
			   	 			<th>审核情况</th>
			   	 			<th>审核的主编</th>
							<!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
							<th>操作</th>
			   	 		</tr>
			   	 		</thead>
			   	 			<c:if test="${! empty myAdver}">
				 			<c:forEach var="adver" items="${myAdver}"> 
			   	 			<tr>
			   	 				<td>${adver.title}</td>
			   	 				<td>${adver.createTime}</td>
			   	 				<td>${adver.nextTime}</td>		   	 			
			   	 				<td>${adver.state}</td>
			   	 				<td>${adver.chiefEditor.id}</td>
			   	 				<td><input type="button" value="修改" onclick="window.location.href=' /OurArtbetter/ADMIN_ToUpdateInfo/${adver.id}  '" /><input type="button" value="删除" onclick=" window.location.href=' /OurArtbetter/ADMIN_deleteInfo/${adver.id} ' "/></td>
		   	 			   </tr>
		   	 			   </c:forEach>
			   	 		  </c:if>
			   	 		
						<tr>
						  <!--跳到单个资讯的页面-->
						  <td colspan=10><a href="/OurArtbetter/ADMIN_uploadinfo" style="float:right;text-decoration:underline;font-size:14px;color:#2B6AB8;"><span><img src="images/addnew.png" alt="" style="width:10px;height:10px;"/></span><span style="margin-left:2px;">新建广告</span></a></td>
						</tr>
			   	 		<tr>
			   	 			
			   	 		</tr>
			   	 		
			   	 	
			   	 	</table>
			   	 
			   	 
			   	 
			   	 
			   	  	 <!-- 咨询 -->
			   	 	<table class="lc_prolist">
			   	 	
			   	 		<thead>
			   	 		<tr>
			   	 			<th>咨询标题</th>
			   	 			<th>创建时间</th>
							<th>上次修改时间</th>
			   	 			<th>审核情况</th>
			   	 			<th>审核的主编</th>
							<!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
							<th>操作</th>
			   	 		</tr>
			   	 		</thead>
			   	 		<c:if test="${! empty myInfo}">
						<c:forEach var="info" items="${myInfo}"> 
			   	 			<tr>
			   	 				<td>${info.title}</td>
			   	 				<td>${info.createTime}</td>
			   	 				<td>${info.nextTime}</td>		   	 			
			   	 				<td>${info.state}</td>
			   	 				<td>${info.chiefEditor.id}</td>
			   	 				<td><input type="button" value="修改" onclick="window.location.href=' /OurArtbetter/ADMIN_ToUpdateInfo/${info.id} '"/><input type="button" value="删除" onclick=" window.location.href=' /OurArtbetter/ADMIN_deleteInfo/${info.id} ' "/></td>
		   	 			   </tr>
		   	 			   
		   	 			   </c:forEach>
			   	 			</c:if>
						<tr>
						  <!--跳到单个资讯的页面-->
						  <td colspan=10><a href="/OurArtbetter/ADMIN_uploadinfo" style="float:right;text-decoration:underline;font-size:14px;color:#2B6AB8;"><span><img src="images/addnew.png" alt="" style="width:10px;height:10px;"/></span><span style="margin-left:2px;">新建资讯</span></a></td>
						</tr>
			   	 		<tr>
			   	 			
			   	 		</tr>
			   	 		
			   	 	
			   	 	</table>
			   	 	
			   	 	
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
