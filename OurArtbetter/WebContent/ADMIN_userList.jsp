<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel = "Shortcut Icon" href="images/favicon.ico">
		<title>DrinkArt</title>
		<link rel="stylesheet" type="text/css" href="css/admin_style.css" />
		<link rel="stylesheet" type="text/css" href="css/admin.css" />

		<script type="text/javascript" src="js/jquery.1.10.2.js"></script>      
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
                    	<input type="text" name="searchname" placeholder="请输入您要搜索的姓名" />
                    	<input type="submit"  value="搜索" />
                    </form>
			   	 </div>
			   	  <h3>用户列表</h3>
			   	 
			   	 <div class="operate-table clear">
			   	 	<table class="lc_prolist">
			   	 		<thead>
			   	 		<tr>
			   	 			<th>用户名</th>
							<th>性别</th>
			   	 			<th>手机</th>
							<th>生日</th>
							<th>邮箱</th>
			   	 		    <th>用户类型</th>			   	 	
			   	 		    <th>操作</th>
							<th>认证</th>
			   	 		</tr>
			   	 		</thead>
			   	 		<volist name="users" id="">
			   	 			<tr>
			   	 				<td>{$v.name}</td>
			   	 				<td>{$vo.phone}</td>		   	 			
			   	 				<td>{$vo.rn}</td>
								<td>{$v.name}</td>
			   	 				<td>{$vo.phone}</td>		   	 			
			   	 				<td>{$vo.rn}</td>
			   	 				<td><input type="button" value="重置密码"/><input type="button" value="删除用户" /></a>
		   	 			   	<td><input type="button" value="艺术家认证"/></a>			   	 			</tr>
			   	 		</volist>
			   	 		<tr>
			   	 			<td colspan=10>{$page}</td>
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
