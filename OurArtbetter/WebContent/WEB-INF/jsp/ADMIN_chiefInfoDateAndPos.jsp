<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel = "Shortcut Icon" href="images/favicon.ico">
<title>DrinkArt</title>
<link rel="stylesheet" type="text/css" href="../../css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="../../css/admin.css" />
<link rel="stylesheet" href=../../"css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="../../css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="../../css/bootstrap-datetimepicker.min.css" type="text/css" />
<script type="text/javascript" src="../../js/jquery.1.10.2.js"></script>
<script src="../../js/jquery.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap-datetimepicker.js" type="text/javascript"></script>
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
    
    
    
    
    <form action="/OurArtbetter/ADMIN_setDateAndPos/"  method="post">
      <table class="lc_prolist" >
        <thead>
          <tr>
            <th>软文位置</th>
            <th colspan=2>上传时间</th>
            <th>价格</th>
            <th>软文标题</th>
            <!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
            <th>操作</th>
          </tr>
        </thead>
        <volist name="users" id="">
          <tr>
            <td><select name="columnId" >
                <option value ="1">广告栏 1</option>
                <option value ="2">广告栏2</option>
                <option value="3">广告栏3</option>
                <option value="4">资讯栏1</option>
                <option value="5">资讯栏2</option>
                <option value="6">资讯栏3</option>
              </select>
            </td>
            <td colspan=2><div class="input-append date" id="datetimepicker" data-date="" data-date-format="dd-mm-yyyy 00:00:00" style="width:40px;">
                <input class="span2" size="16" type="text" value="2015-12-07 00:00:00">
                <!--这个需要后台设置value为当前时间-->
                <span class="add-on"><i class="icon-th"></i></span> </div></td>
            <td><span>￥</span>${price}</td>   <!-- 需要计算 -->
			<td>资讯标题</td>
			<td><input type="button" value="上传资讯"/></td>
		  </tr>
        </volist>
		<tr>
						  <!--跳到单个资讯的页面-->
						  <td colspan=10><a href="javascript:void(0)" style="float:right;text-decoration:underline;font-size:14px;color:#2B6AB8;" onClick="addtimepos()"><span><img src="../../images/addnew.png" alt="" style="width:10px;height:10px;"/></span><span style="margin-left:2px;">新建资讯时间位置</span></a></td>
						</tr>
			   	 		<tr>
        <tr>
          <td colspan=10>{$page}</td>
        </tr>
      </table>
      </form>
      
      
      
        <table class="lc_prolist" >
        <thead>
          <tr>
            <th>资讯位置</th>
            <th colspan=2>上传时间</th>
            <th>价格</th>
            <th>资讯标题</th>
            <!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
            <th>操作</th>
          </tr>
        </thead>
        <volist name="users" id="">
          <tr>
            <td></td>
            <td colspan=2><div class="input-append date" id="datetimepicker" data-date="" data-date-format="dd-mm-yyyy 00:00:00" style="width:40px;">
                <input class="span2" size="16" type="text" value="2015-12-07 00:00:00">
                <!--这个需要后台设置value为当前时间-->
                <span class="add-on"><i class="icon-th"></i></span> </div></td>
            <td><span>￥</span>{$vo.la}</td>
			<td>资讯标题</td>
			<td><input type="button" value="上传资讯"/></td>
		  </tr>
        </volist>
		<tr>
						  <!--跳到单个资讯的页面-->
						  <td colspan=10><a href="javascript:void(0)" style="float:right;text-decoration:underline;font-size:14px;color:#2B6AB8;" onClick="addtimepos()"><span><img src="../../images/addnew.png" alt="" style="width:10px;height:10px;"/></span><span style="margin-left:2px;">新建资讯时间位置</span></a></td>
						</tr>
			   	 		<tr>
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
	   $(".input-append").datetimepicker({
   format: 'yyyy-mm-dd 00:00:00',
   autoclose:true,
   minView:2,//最精确到天
   startView:2,//一打开显示的是天
   forceParse:true
   
 
   });
   function addtimepos(){
   var newTr = infolist.insertRow(1);
   newTr.innerHTML = ' <tr><td><select><option value ="">1</option><option value ="">2</option><option value="">3</option> <option value="">4</option>' +'</select></td><td colspan=2><div class="input-append date" id="datetimepicker" data-date="" data-date-format="dd-mm-yyyy 00:00:00"'+'style="width:40px;"><input class="span2" size="16" type="text" value="2015-12-07 00:00:00"><span class="add-on"><i class="icon-th"></i></span>'+
   ' </div></td><td><span>￥</span>{$vo.la}</td><td>资讯标题</td><td><input type="button" value="上传资讯"/></td></tr>';
   }
</script>
</body>
