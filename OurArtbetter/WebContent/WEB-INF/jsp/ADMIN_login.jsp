<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
		 margin-left:100px;
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
       .login-button{
	   height:40px;
	   }
	   .login-input select {
    height: 32px;
    width: 150px;
    float: right;
    margin-top: -1px;
    padding: 5px 12px;
    border: 1px solid #ddd;
    background: none;
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
  <div class="admin-main-r-wrapper" >
   <div class="ui-dialog" id="dialogMove" onselectstart='return false;'>
					<div class="ui-dialog-title" id="dialogDrag" onselectstart="return false;">
						<h2>登录</h2>
					</div>
					<form action="/OurArtbetter/Login?loginType=2" method="post">
						<div class="ui-dialog-content">
							<div class="login-input login-ID">账号
								<input type="text" name="name" style="height:30px;"/>
							</div>
							<div class="login-input login-password">密码
								<input type="password" name="password" style="height:30px;"/>
							</div>
							<div class="login-input">管理员类型
							 <select name="adminType">
							 <option name="editor"value="editor">采编</option>
							 <option name="chiefEditor"value="chiefEditor">主编</option>
							 <option name="admin"value ="admin">后台管理员</option>
							 </select>
							</div>
							<div><font color="#FF0000"> ${message}</font></div>
							<input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录" class="login-button" />
						</div>
					</form>
				</div>
   </div>
</div>
</body>
</html>
