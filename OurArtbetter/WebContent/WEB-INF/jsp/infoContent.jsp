<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<base href="https://shapebootstrap.net/" />-->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="generator" content="Joomla! - Open Source Content Management" />
<title>drinkArt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/artstyle.css">
<style type="text/css">
body{    font-family: Arial, "宋体"; font-weight:normal; }
h1{font-family:Open Sans, sans-serif; font-weight:700; }
h2{font-family:Open Sans, sans-serif; font-weight:600; }
h3{font-family:Open Sans, sans-serif; font-weight:normal; }
h4{font-family:Open Sans, sans-serif; font-weight:700; }
h5{font-family:Open Sans, sans-serif; font-weight:600; }
h6{font-family:Open Sans, sans-serif; font-weight:600; }
#sp-bottom{ background-color:#3c3c3c;padding:70px 0px 0px; }
#sp-footer{ background-color:#3c3c3c; }
.member-photo img {
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    border-radius: 50%;
	width:60%;
	margin-left:19%;
}

.col-sm-6 {
    width: 100%;
}
.sp-megamenu-parent >li.active>a, .sp-megamenu-parent >li:hover>a {
color:#e8394a;
}

.offcanvas-menu .offcanvas-inner .sp-module ul > li a {
    color: #ffffff;
}
.offcanvas-menu .offcanvas-inner .sp-module ul > li{
/*border-bottom:1px solid #e83258;*/
}

.section,.sppb-section{
background-color:#ffffff;}
.body {
    width: 100%;
    overflow-x: hidden;
    max-width: 640px;
    font-family: 'Helvetica Neue','Hiragino Sans GB','Microsoft YaHei',STHeiti,Helvetica,Arial,sans-serif;
    position: relative;
}
.mixin-article.default pre.text {
    font-size: 1.4rem;
    line-height: 2.35rem;
    white-space: normal;
    color: #555;
}
.article-content {
    width: 100%;
    padding-left: 7.185%;
    padding-right: 7.185%;
	padding-top:3%;
	margin-bottom: 6.25%;
}
.art-title {
    display: block;
    color: #333;
    font-size: 2rem;
    line-height: 2.1rem;
    font-weight: bold;
    margin: 5.2% 0;
    background-color: #eee;
    padding-left: 5.4%;
    border-left: solid 5px #f3acb3;
    padding-top: 2.8%;
    padding-bottom: 1%;
}
.article-content .article-header {
    position: relative;
}
.article-content .article-time-and-author .sub-title {
    color: #aaa;
    display: inline-block;
    text-align: right;
    float: right;
}
.article-content .article-header span {
    font-size: 2.75rem;
    color: #000000;
    line-height: 2.625rem;
    font-weight: bold;
}
.article-content .article-time-and-author {
    position: relative;
    font-size: 1.1rem;
    margin-top: 2.1%;
}
pre {
    display: block;
    padding:0px;
    margin: 0 0 0px;
    font-size: 13px;
    line-height: 1.42857143;
    color: #333;
    word-break: break-all;
    word-wrap: break-word;
    background-color: #ffffff;
    border: 0px solid #ccc;
    border-radius: 0px;
}
p {
    margin: 0 0 0 0px;
}

  </style>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
<meta content="Premium & Free Bootstrap Templates & Themes" property="og:title" />
<meta content="website" property="og:type"/>
<meta content="https://shapebootstrap.net/" property="og:url" />
<meta content="Premium & Free Bootstrap Templates" property="og:title" />
<meta content="https://shapebootstrap.net/og-image.png" property="og:image" />
<meta content="All items are open source for any use, personal or commercial websites. Search and download what you like and get started!" property="og:description" />
<meta name="google-site-verification" content="vRFNCRSLlIhragUEpvDvFs0gK3kHISFZqPF6VNe-a8k" />
</head>
<body class="site com-sppagebuilder view-page no-layout no-task itemid-101 en-gb ltr  sticky-header layout-fluid">
<div class="body-innerwrapper">
  <header id="sp-header">
    <div class="container">
      <div class="row">
        <div id="sp-logo" class="col-xs-8 col-sm-3 col-md-2">
          <div class="sp-column "><a class="logo" href="/">
            <h1 style="color:#913334;">drinkArt</h1>
            </a></div>
        </div>
        <div id="sp-account" class="col-xs-4 col-sm-5 col-md-4">
          <div class="sp-column ">
            <ul>
              <li><a class="btn btn-success btn-login hidden-sm hidden-xs" href="/login">Login</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="/login"><i class="fa fa-user"></i></a></li>
              <li><a class="btn btn-default btn-registration hidden-sm hidden-xs" href="/login?view=registration">Create an Account</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="#"><i class="fa fa-bars" style="background:url('../../images/user.png')no-repeat;margin-top:80%;width: 130%;height: 80%;"></i></a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" id="offcanvas-toggler" href="#"><i class="fa fa-bars" style="background:url('../../images/listimg.png');    margin-top:90%;width: 100%;height: 40%;"></i></a></li>
              <li><a class="btn btn-link btn-cart hidden-sm hidden-xs" href="/cart"><i class="sb-icon-purchase"></i> <small class="my-cart">0</small></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </header>
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
              <li class="sp-menu-item"><a  href="/OurArtbetter/artistList" >签约艺术家</a></li>
              <li class="sp-menu-item"><a  href="/OurArtbetter/productList" >艺术品商城</a></li>
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
      <div class="article-content">
        <div class="article-header"><span>${information.title}</span></div>
        <div class="article-time-and-author"><span class="time">${information.createTime}</span>
          <div class="sub-title"><span class="article-auth"><span class="from"><span class="authname"></span></span></span></div>
          <div class="clearfix"></div>
        </div>
        <div class="article-text">
          <div class="mixin-article default">
            <pre style="word-wrap: break-word;" class="text">
            <div>
			${information.content}
			</div>
			</pre>
            <div class="note">[本文仅代表作者观点，不代表本网站观点。 ]</div>
          </div>
        </div>
      </div>
    </div>

<footer id="sp-footer"上>
  <div class="container">
    <div class="row">
      <div id="sp-footer1" class="col-sm-12 col-md-12">
        <div class="sp-column "><span class="sp-copyright"> © 2015 ShapeBootstrap. Some Rights Reserved. A <a target="_blank" href="http://www.joomshaper.com">JoomShaper</a> Family.</span> </div>
      </div>
    </div>
  </div>
</footer>
<div class="offcanvas-menu"> <a href="#" class="close-offcanvas"><i class="fa fa-remove" style="background:url('../../images/close.png');width:65%;height:65%;margin-left:-18%;margin-top:13%;"></i></a>
  <div class="offcanvas-inner">
    <div class="sp-module ">
      <h3 class="sp-module-title">DrinkArt</h3>
      <div class="sp-module-content">
        <ul class="nav menu">
          <li class="item-101 current active"><a href="/">首页</a></li>
          <li class="item-105"><a href="/items">签约艺术家</a></li>
          <li class="item-111"><a href="/productList">艺术品商城</a></li>
          <li class="item-106"><a href="/free-templates">艺术品在线定制</a></li>
          <li class="item-118"><a href="/blog">拍卖商城</a></li>
          <li class="item-125 deeper parent"><a href="#">艺术资讯</a></li>
          <li class="item-131"><a href="/affiliates" >联系我们</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>
<script>


  </script>
</body>
</html>
