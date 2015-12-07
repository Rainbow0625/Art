<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<base href="https://shapebootstrap.net/" />-->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="generator" content="Joomla! - Open Source Content Management" />
<title>Art</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="../../css/animate.min.css" type="text/css" />
<link rel="stylesheet" href="../../css/sppagebuilder.css" type="text/css" />
<link rel="stylesheet" href="../../css/magnific-popup.css" type="text/css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:regular,700,600&amp;latin" type="text/css" />
<link rel="stylesheet" href="../../css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="../../css/shapebootstrap.icon.css" type="text/css" />
<link rel="stylesheet" href="../../css/template.css" type="text/css" />
<link rel="stylesheet" href="../../css/preset1.css" type="text/css" class="preset" />
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/artstyle.css">
<!-- skin -->
<link rel="stylesheet" href="skin/default.css">
<style type="text/css">
body{font-family:Open Sans,sans-serif;font-weight:normal;}
h1{font-family:Open Sans,sans-serif;font-weight:700;}
h2{font-family:Open Sans,sans-serif;font-weight:600;}
h3{font-family:Open Sans,sans-serif;font-weight:normal;}
h4{font-family:Open Sans,sans-serif;font-weight:700;}
h5{font-family:Open Sans,sans-serif;font-weight:600;}
h6{font-family:Open Sans,sans-serif;font-weight:600;}
#sp-bottom{background-color:#3c3c3c;padding:70px 0px 0px;}
#sp-footer{background-color:#3c3c3c;}
.btn-success, .sppb-btn-success {
    background-color: #e83258;
}
</style>
<script src="../../js/jquery.min.js" type="text/javascript"></script>
<script src="../../js/jquery-noconflict.js" type="text/javascript"></script>
<script src="../../js/jquery-migrate.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../js/favorites.js" type="text/javascript"></script>
<script src="../../js/sppagebuilder.js" type="text/javascript"></script>
<script src="../../js/jquery.magnific-popup.min.js" type="text/javascript"></script>
<script src="../../js/cart.js" type="text/javascript"></script>
<script src="../../js/jquery.sticky.js" type="text/javascript"></script>
<script src="../../js/matchheight.js" type="text/javascript"></script>
<script src="../../js/main.js" type="text/javascript"></script>
<meta content="Premium & Free Bootstrap Templates & Themes" property="og:title" />
<meta content="website" property="og:type"/>
<meta content="https://shapebootstrap.net/" property="og:url" />
<meta content="Premium & Free Bootstrap Templates" property="og:title" />
<meta content="https://shapebootstrap.net/og-image.png" property="og:image" />
<meta content="All items are open source for any use, personal or commercial websites. Search and download what you like and get started!" property="og:description" />
<meta name="google-site-verification" content="vRFNCRSLlIhragUEpvDvFs0gK3kHISFZqPF6VNe-a8k" />
<script type="text/javascript">
window.setInterval(function(){var r;try{r=window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP")}catch(e){}if(r){r.open("GET","/index.php?option=com_ajax&format=json",true);r.send(null)}},3600000);
  </script>
<meta name="google-site-verification" content="vRFNCRSLlIhragUEpvDvFs0gK3kHISFZqPF6VNe-a8k">
</head>
<body class="site com-users view-login no-layout no-task itemid-121 en-gb ltr  sticky-header layout-fluid">
<div class="body-innerwrapper">
<header id="sp-header">
  <div class="container">
    <div class="row">
      <div id="sp-logo" class="col-xs-8 col-sm-3 col-md-2">
        <div class="sp-column "><a class="logo" href="/">
          <h1 style="color:#913334;">DrinkArt</h1>
          </a></div>
      </div>
	  
      <div id="sp-account" class="col-xs-4 col-sm-5 col-md-4">
        <div class="sp-column ">
          <ul>
            <li><a class="btn btn-primary btn-submit-item hidden-sm hidden-xs" href="/login">Start Selling</a></li>
              <li><a class="btn btn-success btn-login hidden-sm hidden-xs" href="/login">Login</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="/login"><i class="fa fa-user"></i></a></li>
              <li><a class="btn btn-default btn-registration hidden-sm hidden-xs" href="/login?view=registration">Create an Account</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" id="offcanvas-toggler" href="#"><i class="fa fa-bars" style="background:url('../../images/listimg.png');    margin-top:90%;width: 100%;height: 40%;"></i></a></li>
              <li><a class="btn btn-link btn-cart hidden-sm hidden-xs" href="/cart"><i class="sb-icon-purchase"></i> <small class="my-cart">0</small></a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  </header>
  
  <div id="sp-navbar-sticky-wrapper" class="sticky-wrapper" style="height: 45px;">
   <section id="sp-navbar" class=" hidden-xs">
  <div class="container">
    <div class="row">
      <div id="sp-categories" class="col-sm-4 col-md-2">
        <div class="sp-column ">
          <div class="sp-module "> </div>
        </div>
      </div>
      <div id="sp-menu" class="col-sm-8 col-md-7">
        <div class="sp-column ">
          <div class='sp-megamenu-wrapper'>
            <ul class="sp-megamenu-parent menu-fade hidden-xs">
              <li class="sp-menu-item current-item active"><a  href="/" >首页</a></li>
              <li class="sp-menu-item hidden"><a  href="/free-templates" >艺术资讯</a></li>
              <li class="sp-menu-item"><a  href="artistList" >签约艺术家</a></li>
              <li class="sp-menu-item"><a  href="/items" >艺术品商城</a></li>
              <li class="sp-menu-item"><a  href="/popular-items" >艺术品在线定制</a></li>
              <li class="sp-menu-item"><a  href="/blog" >拍卖商城</a></li>
              <li class="sp-menu-item sp-has-child"><a  href="#" ><i class="fa fa-support"></i> 联系我们</a></li>
		
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
  <section id="sp-main-body">
    <div class="container">
      <div class="row">
        <div id="sp-component" class="col-sm-12 col-md-12">
          <div class="sp-column ">
            <div id="system-message-container"> </div>
            <div class="row">
              <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                <div class="page-login-form box login">
                  <div class="login-description text-center"> 登录 </div>
                  <form action="/login?task=user.login" method="post" class="form-validate">
                    <div class="form-group">
                      <div class="group-control">
                        <input type="text" name="username" id="username" value="" class="validate-username required" size="25" placeholder="Username" required="" aria-required="true" autofocus="">
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="group-control">
                        <input type="password" name="password" id="password" value="" placeholder="Password" class="validate-password required" size="25" maxlength="99" required="" aria-required="true">
                      </div>
                    </div>
                    <div class="checkbox">
                      <label>
                      <input id="remember" type="checkbox" name="remember" class="inputbox" value="yes">
                      记住密码 </label>
                    </div>
                    <div class="form-group">
                      <button type="submit" class="btn btn-success btn-lg btn-block btn-login"> 登录 </button>
                    </div>
                   <div class="form-links form-group" style="margin-top:30%;">
                     <ul>
                    <li style="margin-left:0%;"> <a href="#"> 忘记密码?</a> </li>
                    <li style="margin-left:23%;"> <a href="#"> 注册</a> </li>
                     </ul>
                  </div>
                  </form>
				  
                </div>
               
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <footer id="sp-footer" style="bottom:0;">
    <div class="container">
      <div class="row">
        <div id="sp-footer1" class="col-sm-12 col-md-12">
          <div class="sp-column "><span class="sp-copyright"> © 2015 ShapeBootstrap. Some Rights Reserved. A <a target="_blank" href="http://www.joomshaper.com">JoomShaper</a> Family.</span></div>
        </div>
      </div>
    </div>
  </footer>
  <div class="offcanvas-menu"> <a href="#" class="close-offcanvas"><i class="fa fa-remove" style="background:url('../../images/close.png');width:65%;height:65%;margin-left:-18%;margin-top:13%;"></i></a>
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
           <li class="item-131"><a href="/affiliates" >联系我们</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</body>
</html>