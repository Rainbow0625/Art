<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<link rel="stylesheet" href="../../css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="../../css/template.css" type="text/css" />
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/artstyle.css">
<!-- skin -->
<link rel="stylesheet" href="skin/default.css">
<style type="text/css">
body {
	line-height: 24px;
	background-color: #e5e5e5;
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
</style>
<script src="../../js/jquery.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../js/main.js" type="text/javascript"></script>
<meta content="Premium & Free Bootstrap Templates & Themes"
	property="og:title" />
<meta content="website" property="og:type" />
<meta content="https://shapebootstrap.net/" property="og:url" />
<meta content="Premium & Free Bootstrap Templates" property="og:title" />
<meta content="https://shapebootstrap.net/og-image.png"
	property="og:image" />
<meta
	content="All items are open source for any use, personal or commercial websites. Search and download what you like and get started!"
	property="og:description" />
<meta name="google-site-verification"
	content="vRFNCRSLlIhragUEpvDvFs0gK3kHISFZqPF6VNe-a8k" />
<script type="text/javascript">
window.setInterval(function(){var r;try{r=window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP")}catch(e){}if(r){r.open("GET","/index.php?option=com_ajax&format=json",true);r.send(null)}},3600000);
  </script>
<meta name="google-site-verification"
	content="vRFNCRSLlIhragUEpvDvFs0gK3kHISFZqPF6VNe-a8k">
</head>
<body
	class="site com-users view-login no-layout no-task itemid-121 en-gb ltr  sticky-header layout-fluid">
	<%@include file="header.jsp"%>

	<section id="sp-page-title">
	<div class="row">
		<div id="sp-title" class="col-sm-12 col-md-12">
			<div class="sp-column "></div>
		</div>
	</div>
	</section>
	<section id="sp-main-body">
	<div class="container">
		<div class="row">
			<div id="sp-component" class="col-sm-12 col-md-12">
				<div class="sp-column ">
					<div id="system-message-container"></div>
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
							<div class="page-login-form box login">
								<div class="login-description text-center">登录</div>
								<form action="/OurArtbetter/Login?loginType=1" method="post"
									class="form-validate">
									<div class="form-group">
										<div class="group-control">
											<input type="text" name="tel" id="username" value=""
												class="validate-username required" size="25"
												placeholder="Username" required="" aria-required="true"
												autofocus="">
										</div>
									</div>
									<div class="form-group">
										<div class="group-control">
											<input type="password" name="password" id="password" value=""
												placeholder="Password" class="validate-password required"
												size="25" maxlength="99" required="" aria-required="true">
										</div>
									</div>
									<div class="checkbox">
										<label> <input id="remember" type="checkbox"
											name="remember" class="inputbox" value="yes"> 记住密码
										</label>
									</div>
									<div class="form-group">
										<button type="submit"
											class="btn btn-success btn-lg btn-block btn-login">
											登录</button>
									</div>

								</form>

							</div>
							<div class="form-links form-group" style="margin-top: 30%;">
								<ul>
									<li style="float: left; margin-left: 0%;"><a href="">
											忘记密码?</a></li>
									<li style="float: left; margin-left: 1%;"><a
										href="/OurArtbetter/TurnToRegister"> 注册</a></li>
									<li style="float: left; margin-left: 1%;"><a
										href="/OurArtbetter/TurnToAdminLogin"> 管理员登录?</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!--把footer开头的那个块替换成下面的-->
	<%@include file="footer.jsp"%>
	<!-- 把div改成下面这个-->
	<%@include file="canvasmenu.jsp"%>

</body>
</html>