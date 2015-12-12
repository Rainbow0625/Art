<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<base href="https://shapebootstrap.net/" />-->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="generator" content="Joomla! - Open Source Content Management" />
<title>Art</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/animate.min.css" type="text/css" />
<link rel="stylesheet" href="css/sppagebuilder.css" type="text/css" />
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/shapebootstrap.icon.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/preset1.css" type="text/css" class="preset" />
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
body{font-family:'SimSun'; font-weight:normal;background-color:#e5e5e5; }
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
.offcanvas-menu {
    background-color:#e83258;
}
.offcanvas-menu .offcanvas-inner .sp-module ul > li a {
    color: #ffffff;
}
.offcanvas-menu .offcanvas-inner .sp-module ul > li{
/*border-bottom:1px solid #e83258;*/
}

.section,.sppb-section{
background-color:#ffffff;}
.section{
margin:5%;
}
section.section {
    /* margin: 0; */
    padding: 0px 0 20px 0;
}
.shop-itemdetail{
width:100%;
height:15%;
font-size:17px;
padding-left:5%;
padding-right:5%;
}
.shop-itemprice{
color:#e83258;
font-size:20px;
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
          <h1 style="color:#913334;">Art</h1>
          </a></div>
      </div>
	  
      <div id="sp-account" class="col-xs-4 col-sm-5 col-md-4">
        <div class="sp-column ">
          <ul>
            <li><a class="btn btn-primary btn-submit-item hidden-sm hidden-xs" href="/login">Start Selling</a></li>
              <li><a class="btn btn-success btn-login hidden-sm hidden-xs" href="/login">Login</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="/login"><i class="fa fa-user"></i></a></li>
              <li><a class="btn btn-default btn-registration hidden-sm hidden-xs" href="/login?view=registration">Create an Account</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="#"><i class="fa fa-bars" style="background:url('images/search.png')no-repeat;    margin-top:90%;width: 100%;height: 100%;"></i></a></li>
			  <li><a class="btn btn-link btn-login visible-sm visible-xs" id="offcanvas-toggler" href="#"><i class="fa fa-bars" style="background:url('images/listimg.png');    margin-top:90%;width: 100%;height: 40%;"></i></a></li>
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
              <li class="sp-menu-item"><a  href="artistList" >签约艺术家</a></li>
               <li class="sp-menu-item"><a  href="artistList" >艺术品展示</a></li>
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

<section style="height:20%;">
<div id="myCarousel" class="carousel slide" style="width:100%;height:100%;background-color:#ffffff;">
              <!--<div id="myCarousel" class="carousel slide">-->
              <!-- 轮播（Carousel）指标-->
              <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
              </ol>
              <!-- 轮播（Carousel）项目-->
              <div class="carousel-inner" style="width:100%;height:100%;">
                <div class="item active"> <img src="images/title1.jpg" alt="First slide"> </div>
                <div class="item"> <img src="images/title2.jpg" alt="Second slide"> </div>
                <div class="item"> <img src="images/title3.jpg" alt="Third slide"> </div>
              </div>
              <!-- 轮播（Carousel）导航 -->
              <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev">&lsaquo;</a> <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a>
	       </div>
</section>

<!--购物车小图标-->
<div class="shoppingcart" style="width:8%;height:4%;position:fixed;right:10%;bottom:2%;z-index:100;">
   <a href="#"><img src="images/shoppingcart.png" alt="找不到图片" style="width:100%;height:100%;"></a>
</div>
            <!-- 艺术品商城 -->
             <c:if test="${! empty artwork_list}">
                    	<c:forEach var="artwork" items="${artwork_list}">
            <section id="section-works" class="section appear clearfix" style="background-color:#e5e5e5;">
              <div class="container">
                <div class="row mar-bot40">
                  <div class="col-md-offset-3 col-md-6">
                  
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="portfolio-items isotopeWrapper clearfix" id="3">
                       
						<article class="col-md-4 isotopeItem webdesign" style="border:1px solid #000000;border-radius:10px;background-color:#ffffff;padding-left:0;padding-right:0;">
                          <div class="portfolio-item" style="width:100%;height:85%;"> 
						   <img src="${artwork.imagesURL}" alt="" style="border:1px solid #d6d3d3;border-radius:10px;"/>
                            <div class="portfolio-desc align-center">
                              <div class="folio-info">
                                <h5><a href="#">Portfolio name</a></h5>
                                <a href="img/portfolio/art1.jpg" class="fancybox"><i class="fa fa-plus fa-2x"></i></a> </div>
                            </div>
                          </div>
						  <div class="${artwork.imagesURL}"style="">
						    <p style="color:#000000;">${artwork.artworkName}</p>
							<p>作者 :<span>${artwork.artworkName}</span></p>
							<p>价格 :<span>￥</span><span class="shop-itemprice">${artwork.artworkPrice}</span></p>
						  </div>
                        </article>
					   
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
           </c:forEach>
	                     </c:if>

    <footer id="sp-footer">
    <div class="container">
      <div class="row">
        <div id="sp-footer1" class="col-sm-12 col-md-12">
          <div class="sp-column "><span class="sp-copyright"> © 2015 ShapeBootstrap. Some Rights Reserved. A <a target="_blank" href="http://www.joomshaper.com">JoomShaper</a> Family.</span>
		 </div>
        </div>
      </div>
    </div>
  </footer>
  
  <div class="offcanvas-menu"> <a href="#" class="close-offcanvas"><i class="fa fa-remove" style="background:url('images/close.png');width:65%;height:65%;margin-left:-18%;margin-top:13%;"></i></a>
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
  <script>
   $("#myCarousel").carousel('cycle');
  </script>
</body>
</html>

