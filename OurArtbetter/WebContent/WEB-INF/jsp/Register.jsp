
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
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/animate.min.css" type="text/css" />
<link rel="stylesheet" href="css/sppagebuilder.css" type="text/css" />
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:regular,700,600&amp;latin"
	type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/shapebootstrap.icon.css"
	type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/preset1.css" type="text/css"
	class="preset" />
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="css/artstyle.css">
<!-- skin -->
<link rel="stylesheet" href="skin/default.css">
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
</style>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery-noconflict.js" type="text/javascript"></script>
<script src="js/jquery-migrate.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/favorites.js" type="text/javascript"></script>
<script src="js/sppagebuilder.js" type="text/javascript"></script>
<script src="js/jquery.magnific-popup.min.js" type="text/javascript"></script>
<script src="js/cart.js" type="text/javascript"></script>
<script src="js/jquery.sticky.js" type="text/javascript"></script>
<script src="js/matchheight.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
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
	window.setInterval(function() {
		var r;
		try {
			r = window.XMLHttpRequest ? new XMLHttpRequest()
					: new ActiveXObject("Microsoft.XMLHTTP")
		} catch (e) {
		}
		if (r) {
			r.open("GET", "/index.php?option=com_ajax&format=json", true);
			r.send(null)
		}
	}, 3600000);
</script>
<meta name="google-site-verification"
	content="vRFNCRSLlIhragUEpvDvFs0gK3kHISFZqPF6VNe-a8k">
</head>
<body class="site com-users view-login no-layout no-task itemid-121 en-gb ltr  sticky-header layout-fluid">
	<%@include file="header.jsp"%>

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
								<form action="/OurArtbetter/Register"method="post" >

									<div class="group-control">
										tel <input type="text" name="tel">
									</div>



									<div class="form-group">
										<div class="group-control">
											password <input type="password" name="password">
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											确认密码 <input type="password" name="confirmPassword">
										</div>
									</div>
									<button type="submit" >注册</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section> </section>

 <!--把footer开头的那个块替换成下面的-->
  <%@include file="footer.jsp"%>
  <!-- 把div改成下面这个-->
  <%@include file="canvasmenu.jsp"%>
	</body>
</html>
