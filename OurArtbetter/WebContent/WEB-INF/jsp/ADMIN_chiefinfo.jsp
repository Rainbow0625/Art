<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div class="search" style="float:right;">
      <form action="#" method="post">
        <input type="text" name="searchname" placeholder="请输入您要搜索的资讯" />
        <input type="submit"  value="搜索" />
      </form>
    </div>
    <h3>资讯管理</h3>
    <div class="operate-table clear">
    
    
      <table class="lc_prolist">

        <thead>
          <tr>
            <th>广告标题</th>
            <th>创建时间</th>
			<th>上次修改时间</th>
			<th>采编</th>
            <th>审核情况</th>
            <!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
            <th>操作</th>
          </tr>
        </thead>
        
        
                <c:if test="${! empty allAdver}">
	  <c:forEach var="adver" items="${allAdver}"> 
	    <tr>
			<td><a href="/OurArtbetter/ADMIN_chiefLookThrough?id=${adver.id}">${adver.title}</a></td>
			<td>${adver.createTime}</td>
			<td>${adver.nextTime}</td>	
			<td>${adver.editor.id}</td>
			<td>${adver.state}</td>
            <td><input type="button" value="审核通过" onclick="window.location.href='/OurArtbetter/ADMIN_checkInfo?id=${adver.id}' " /> <input type="button" value="审核不通过" onclick="window.location.href='/OurArtbetter/ADMIN_failInfo?id=${adver.id}' " /> <input type="button" value="驳回意见"></input> <input type="button" value="设置上传时间位置"  onclick="window.location.href='/OurArtbetter/ADMIN_TosetDateAndPos?id=${adver.id}' "/> </td>
        </tr>
              </c:forEach>
	 </c:if>

        <tr>
          
        </tr>
 
     </table>



      <table class="lc_prolist">
     
        <thead>
          <tr>
            <th>咨询标题</th>
            <th>创建时间</th>
			<th>上次修改时间</th>
			<th>采编</th>
            <th>审核情况</th>
            <!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
            <th>操作</th>
          </tr>
        </thead>
        
          
           <c:if test="${! empty allInfo}">
	  <c:forEach var="info" items="${allInfo}"> 
          <tr>
			<td><a href="/OurArtbetter/ADMIN_chiefLookThrough?id=${info.id}">${info.title}</a></td>
			<td>${info.createTime}</td>
			<td>${info.nextTime}</td>	
			<td>${info.editor.id}</td>
            <td><c:if test="${info.state == '3'}">sss</c:if></td>
			<td><a href=" /OurArtbetter/ADMIN_checkInfo?id=${info.id} "><input type="button" value="审核通过" /></a>  <a href = "/OurArtbetter/ADMIN_failInfo?id=${info.id}"><input type="button" value="审核不通过"/></a>  <a href="  "> <input type="button" value="驳回意见"/></a>  <a href=" /OurArtbetter/ADMIN_TosetDateAndPos?id=${info.id} "><input type="button" value="设置上传时间位置"/> </a> </td>
           </tr>
         </c:forEach>
	 </c:if>
        
        
		
        <tr>
          
        </tr>
     
     </table>

      
      
    </div>
  </div>
</div>

</body>
</html>
