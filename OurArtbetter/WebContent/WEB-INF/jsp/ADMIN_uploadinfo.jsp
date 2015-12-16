<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel = "Shortcut Icon" href="images/favicon.ico">
<title>DrinkArt</title>
<link rel="stylesheet" type="text/css" href="../../css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="../../css/admin.css" />
<link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css" />
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


<%@include file="ADMIN_header.jsp" %>

<div class="main clearfix">


<!-- 把<div class="admin-l-bar">替换成下面这个-->
<%@include file="ADMIN_lbar.jsp"%> 

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
            <th>资讯位置</th>
            <th colspan=2>上传时间</th>
            <th>价格</th>
            <th>资讯标题</th>
            <th>资讯内容</th>
			<th>编辑</th>
            <th>审核情况</th>
            <!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
            <th>操作</th>
          </tr>
        </thead>
        <volist name="users" id="">
          <tr>
            <td><select>
                <option value ="">1</option>
                <option value ="">2</option>
                <option value="">3</option>
                <option value="">4</option>
              </select></td>
            <td colspan=2><div class="input-append date" id="datetimepicker" data-date="" data-date-format="dd-mm-yyyy 00:00:00">
                <input class="span2" size="16" type="text" value="2015-12-07 00:00:00">
                <!--这个需要后台设置value为当前时间-->
                <span class="add-on"><i class="icon-th"></i></span> </div></td>
            <td><span>￥</span>{$vo.la}</td>
			<td>资讯标题</td>
            <td><input type="button" value="查看资讯内容"/></td>
			<td>吴虹</td>
            <td><input type="button" value="审核通过"/>
			  </td>
			  <td><input type="button" value="上传资讯"/>
			  </td>
          </tr>
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
	   $(".input-append").datetimepicker({
   format: 'yyyy-mm-dd 00:00:00',
   autoclose:true,
   minView:2,//最精确到天
   startView:2,//一打开显示的是天
   forceParse:true
   
 
   });
</script>
</body>
</html>