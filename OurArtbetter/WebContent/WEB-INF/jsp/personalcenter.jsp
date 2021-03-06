<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb"
	dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<base href="https://shapebootstrap.net/" />-->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="generator"
	content="Joomla! - Open Source Content Management" />
<title>DrinkArt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/artstyle.css">
<link href="css/sucaijiayuan.css" type="text/css" rel="stylesheet" />

<style type="text/css">
body {
	font-family: Open Sans, sans-serif;
	font-weight: normal;
}

h1 {
	font-family: Open Sans, sans-serif;
	font-weight: 700;
}

h2 {
	font-family: Open Sans, sans-serif;
	font-weight: 600;
}

h3 {
	font-family: Open Sans, sans-serif;
	font-weight: normal;
}

h4 {
	font-family: Open Sans, sans-serif;
	font-weight: 700;
}

h5 {
	font-family: Open Sans, sans-serif;
	font-weight: 600;
}

h6 {
	font-family: Open Sans, sans-serif;
	font-weight: 600;
}

#sp-bottom {
	background-color: #3c3c3c;
	padding: 70px 0px 0px;
}

#sp-footer {
	background-color: #3c3c3c;
}

.btn-success,.sppb-btn-success {
	background-color: #e83258;
}

.group-control {
	display: inline-block;
	width: 100%;
	height: 20%;
}

.tip-control {
	display: inline-block;
	color: #e83258;
	font-size: 6px;
	width: 60%;
	height: 10%;
}

* {
	-ms-word-wrap: break-word;
	word-wrap: break-word;
}

html {
	-webkit-text-size-adjust: none;
	text-size-adjust: none;
}

html,body {
	height: 100%;
	width: 100%;
}

html,body,h1,h2,h3,h4,h5,h6,div,ul,ol,li,dl,dt,dd,iframe,textarea,input,button,p,strong,b,i,a,span,del,pre,table,tr,th,td,form,fieldset,.pr,.pc
	{
	margin: 0;
	padding: 0;
	word-wrap: break-word;
	font-family: verdana, Microsoft YaHei, Tahoma, sans-serif;
	*font-family: Microsoft YaHei, verdana, Tahoma, sans-serif;
}

body,ul,ol,li,dl,dd,p,h1,h2,h3,h4,h5,h6,form,fieldset,.pr,.pc,em,del {
	font-style: normal;
	font-size: 100%;
}

ul,ol,dl {
	list-style: none;
}

#Popy {
	background-color: #ffffff;;
}

._citys {
	width: 450px;
	display: inline-block;
	border: 2px solid #eee;
	padding: 5px;
	position: relative;
	background-color: #ffffff;
}

._citys span {
	color: #56b4f8;
	height: 15px;
	width: 15px;
	line-height: 15px;
	text-align: center;
	border-radius: 3px;
	position: absolute;
	right: 10px;
	top: 10px;
	border: 1px solid #56b4f8;
	cursor: pointer;
}

._citys0 {
	width: 100%;
	height: 34px;
	display: inline-block;
	border-bottom: 2px solid #56b4f8;
	padding: 0;
	margin: 0;
}

._citys0 li {
	display: inline-block;
	line-height: 34px;
	font-size: 15px;
	color: #888;
	width: 80px;
	text-align: center;
	cursor: pointer;
}

.citySel {
	background-color: #56b4f8;
	color: #fff !important;
}

._citys1 {
	width: 100%;
	display: inline-block;
	padding: 10px 0;
}

._citys1 a {
	width: 53px;
	height: 35px;
	display: inline-block;
	background-color: #f5f5f5;
	color: #666;
	margin-left: 3px;
	margin-top: 3px;
	line-height: 35px;
	text-align: center;
	cursor: pointer;
	font-size: 13px;
	overflow: hidden;
}

._citys1 a:hover {
	color: #fff;
	background-color: #56b4f8;
}

.AreaS {
	background-color: #56b4f8 !important;
	color: #fff !important;
}
</style>
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/emailAutoComplete.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>

</head>
<body
	class="site com-users view-login no-layout no-task itemid-121 en-gb ltr  sticky-header layout-fluid">
	<div class="body-innerwrapper">
		<header id="sp-header">
		<div class="container">
			<div class="row">
				<div id="sp-logo" class="col-xs-8 col-sm-3 col-md-2">
					<div class="sp-column ">
						<a class="logo" href="/">
							<h1>
								<span style="color: #000000;">Drink</span><span
									style="color: #e83258;">Art</span>
							</h1>
						</a>
					</div>
				</div>
				<div id="sp-search" class="col-sm-4 col-md-6 hidden-xs">
					<div class="sp-column ">
						<form id="product-search" action="https://shapebootstrap.net/"
							method="get">
							<input type="hidden" name="option" value="com_product"> <input
								type="hidden" name="view" value="products"> <input
								type="hidden" name="Itemid" value="105"> <i
								class="sb-icon-search"></i> <input type="text" name="search"
								placeholder="Search Templates" value="">
						</form>
					</div>
				</div>
				<div id="sp-account" class="col-xs-4 col-sm-5 col-md-4">
					<div class="sp-column ">
						<ul>
							<li><a
								class="btn btn-primary btn-submit-item hidden-sm hidden-xs"
								href="/login">Start Selling</a></li>
							<li><a class="btn btn-success btn-login hidden-sm hidden-xs"
								href="/login">Login</a></li>
							<li><a class="btn btn-link btn-login visible-sm visible-xs"
								href="/login"><i class="fa fa-user"></i></a></li>
							<li><a
								class="btn btn-default btn-registration hidden-sm hidden-xs"
								href="/login?view=registration">Create an Account</a></li>
							<li><a class="btn btn-link btn-login visible-sm visible-xs"
								id="offcanvas-toggler" href="#"><i class="fa fa-bars"
									style="background: url('images/listimg.png'); margin-top: 90%; width: 100%; height: 40%;"></i></a></li>
							<li><a class="btn btn-link btn-cart hidden-sm hidden-xs"
								href="/cart"><i class="sb-icon-purchase"></i> <small
									class="my-cart">0</small></a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
		</header>

		<div id="sp-navbar-sticky-wrapper" class="sticky-wrapper"
			style="height: 45px;">
			<section id="sp-navbar" class=" hidden-xs">
			<div class="container">
				<div class="row">
					<div id="sp-categories" class="col-sm-4 col-md-2">
						<div class="sp-column ">
							<div class="sp-module "></div>
						</div>
					</div>
					<div id="sp-menu" class="col-sm-8 col-md-7">
						<div class="sp-column ">
							<div class='sp-megamenu-wrapper'>
								<ul class="sp-megamenu-parent menu-fade hidden-xs">
									<li class="sp-menu-item current-item active"><a href="/">首页</a></li>
									<li class="sp-menu-item hidden"><a href="/free-templates">艺术资讯</a></li>
									<li class="sp-menu-item"><a href="artistList">签约艺术家</a></li>
									<li class="sp-menu-item"><a href="/items">艺术品商城</a></li>
									<li class="sp-menu-item"><a href="/popular-items">艺术品在线定制</a></li>
									<li class="sp-menu-item"><a href="/blog">拍卖商城</a></li>
									<li class="sp-menu-item sp-has-child"><a href="#"><i
											class="fa fa-support"></i> 联系我们</a></li>

								</ul>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		</section>
	</div>

	<section id="sp-page-title">
	<div class="row">
		<div id="sp-title" class="col-sm-12 col-md-12">
			<div class="sp-column "></div>
		</div>
	</div>
	</section>

	<!--<section id="sp-main-body" style="background-color:#f4d1d4*/;">-->
	<section id="sp-main-body" style="background-color:#e5e5e5;">
	<section id="sp-main-body">
	<div class="container">
		<div class="row">
			<div id="sp-component" class="col-sm-12 col-md-12">
				<div class="sp-column ">
					<div id="system-message-container"></div>
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3">
							<div class="box registration">
								<form id="member-registration"
									action="/OurArtbetter/completePersonalInfo" method="post"
									class="form-validate" enctype="multipart/form-data">
									<div class="form-group">
										<div class="text-center" style="font-size: 25px;">完善个人信息</div>
									</div>
									<div class="form-group">
										<div class="group-control">
											<span>手机号：</span><span name="tel"
												value="<%=session.getAttribute("userName")%>"><%=session.getAttribute("userName")%></span>
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<input type="password" name="password" value="" size="10"
												placeholder="密码" autofocus="" id="pwdtext" />
										</div>
										<div class="tip-control" id="pwd-test">
											<span><i></i></span>
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<input type="text" name="nickName" id="" value="" size="25"
												placeholder="昵称" autofocus="">
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<label> <input type="radio" name="gender"
												id="optionsRadios1" value="male" checked> 男
											</label> <label> <input type="radio" name="gender"
												id="optionsRadios2" value="female"> 女
											</label>
										</div>
									</div>

									<div class="form-group">
										<div class="parentCls group-control">
											<input type="text" name="email" class="inputElem"
												id="mailbox" value="" size="25" placeholder="邮箱" />
											<div class="tip-control" id="mail-test">
												<span><i></i></span>
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<!--
     <input type="text" name="" id="" value=""  size="5" placeholder="省"  autofocus="" /> 
	  <input type="text" name="" id="" value=""  size="5" placeholder="市"  autofocus="" /> 
	   <input type="text" name="" id="" value=""  size="5" placeholder="区/县"  autofocus=""/> 
	    <input type="text" name="" id="" value=""  size="5" placeholder="详细地址"  autofocus=""/> -->

											<input type="text" id="city" name="address" />


										</div>
									</div>

									<div class="form-group">
										<button type="submit" class="btn btn-primary validate">提交</button>
										<a class="btn btn-danger" href="/" title="Cancel">取消</a> <input
											type="hidden" name="option" value="com_users"> <input
											type="hidden" name="task" value="registration.register">
									</div>
									<input type="hidden" name="433ee394962401c7e7cdaa850a4d9d19"
										value="1">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section> </section>

	<footer id="sp-footer" style="bottom:0;">
	<div class="container">
		<div class="row">
			<div id="sp-footer1" class="col-sm-12 col-md-12">
				<div class="sp-column ">
					<span class="sp-copyright"> © 2015 ShapeBootstrap. Some
						Rights Reserved. A <a target="_blank"
						href="http://www.joomshaper.com">JoomShaper</a> Family.
					</span>
				</div>
			</div>
		</div>
	</div>
	</footer>
	<div class="offcanvas-menu" style="background-color: #f4d1d4">
		<a href="#" class="close-offcanvas"><i class="fa fa-remove"
			style="background: url('images/close.png'); width: 65%; height: 65%; margin-left: -18%; margin-top: 13%;"></i></a>
		<div class="offcanvas-inner">
			<div class="sp-module ">
				<h3 class="sp-module-title">Art</h3>
				<div class="sp-module-content">
					<ul class="nav menu">
						<li class="item-101 current active"><a href="/">首页</a></li>
						<li class="item-105"><a href="/items">签约艺术家</a></li>
						<li class="item-111"><a href="/popular-items">艺术品商城</a></li>
						<li class="item-106"><a href="/free-templates">艺术品在线定制</a></li>
						<li class="item-118"><a href="/blog">拍卖商城</a></li>
						<li class="item-125 deeper parent"><a href="#">艺术资讯</a></li>
						<li class="item-131"><a href="/affiliates">联系我们</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script>
		$("#pwdtext").blur(function() {
			var pwd = document.getElementById("pwdtext").value;
			// document.getElementById("pwd-test").innerHTML="密码正确";
			console.log(pwd);
			$.ajax({
				type : "GET",
				url : "/info/uploadInfo",/*改成需要的url地址*/
				data : {
					"pwd" : pwd
				},
				dataType : "text",
				success : function(data) {
					document.getElementById("pwd-test").innerHTML = "密码正确";
				},
				error : function(data) {
					document.getElementById("pwd-test").innerHTML = "密码错误";
				}
			});

		});
		$("#mailbox").blur(function() {
			var mail = document.getElementById("mailbox").value;
			console.log(mail);
			var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
			if (mail == "") {
				document.getElementById("mail-test").innerHTML = "格式错误";
			} else if (!reg.test(mail)) {
				// alert("非法的电子邮件"); 
				// return false; 
				//alert("!");
				document.getElementById("mail-test").innerHTML = "格式错误";
			} else {
				document.getElementById("mail-test").innerHTML = "格式正确";
			}
		});
		$("#city").click(function(e) {
			SelCity(this, e);
		});
	</script>
</body>
</html>
