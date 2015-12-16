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
<title>drinkArt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="css/artstyle.css">
<style type="text/css">
body{font-family:Open Sans, sans-serif; font-weight:normal; }
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
.section{
margin:5%;
border-bottom:1px solid #e83258;
}
section.section {
    /* margin: 0; */
    padding: 80px 0 20px 0;
}
.sppb-addon-container{
    height:4%;
    line-height: 4%;
    font-family: "黑体";
    color: #0000000;
    padding-top: 0%;
}
.sppb-addon-container i {
    display: inline-block;
    width:10px;
    height: 10px;
    background: #e56565;
    vertical-align: bottom;
    margin-right: 3%;
}

.sppb-addon-container a{
color:#000000;
}
@media screen  and (min-width:619px){/*pc*/
.sppb-addon-container{
    font-size: 16px;/*字体大小适配*/
    padding-bottom: 12%;
}
}
@media screen  and (max-width:619px){/*手机*/
.sppb-addon-container{
    font-size: 3.8vw;/*字体大小适配*/
	    padding-bottom: 3%;
}
}
.col-md-6,.col-lg-4{
padding-left:0px;
padding-right:0px;}
  </style>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
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
          <h1 style="color:#913334;">drinkArt</h1>
          </a></div>
      </div>
	  
      <div id="sp-account" class="col-xs-4 col-sm-5 col-md-4">
        <div class="sp-column ">
          <ul>
              <li><a class="btn btn-success btn-login hidden-sm hidden-xs" href="/login">Login</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="/login"><i class="fa fa-user"></i></a></li>
              <li><a class="btn btn-default btn-registration hidden-sm hidden-xs" href="/login?view=registration">Create an Account</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="#"><i class="fa fa-bars" style="background:url('images/user.png')no-repeat;margin-top:80%;width: 130%;height: 80%;"></i></a></li>
	  
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
              <li class="sp-menu-item hidden"><a  href="/OSSSS" >艺术资讯</a></li>
              <li class="sp-menu-item"><a  href="/OurArtbetter/artistList" >签约艺术家</a></li>
              <li class="sp-menu-item"><a  href="/OurArtbetter/productList" >艺术品商城</a></li>
              <li class="sp-menu-item"><a  href="/OurArtbetter/ADMIN_infolist" >艺术品在线定制</a></li>
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
<section id="sp-page-title">
  <div class="row">
    <div id="sp-title" class="col-sm-12 col-md-12">
      <div class="sp-column "></div>
    </div>
  </div>
</section>

<section  class="sppb-section section-intro" style="margin:0px;padding:20px 0;">
<div class="sppb-container">
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
                <div class="item active"> <img src="images/art2.jpg" alt="First slide"> </div>
                <div class="item"> <img src="images/art.jpg" alt="Second slide"> </div>
                <div class="item"> <img src="images/art2.jpg" alt="Third slide"> </div>
              </div>
              <!-- 轮播（Carousel）导航 -->
              <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev">&lsaquo;</a> <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a>
	       </div>
            </section>
            <!--资讯-->
           
             <section id="section-about" class="section appear clearfix sppb-section">
              <div class="container">
                <div class="row mar-bot40">
                  <div class="col-md-offset-3 col-md-6">
                    <div class="section-header">
                      <h2 class="section-heading animated" data-animation="bounceInUp">艺术资讯</h2>
                      <p>为你提供最新的资讯。</p>
                    </div>
                  </div>
                </div>
                
                <table>
                <c:if test="${! empty infoList}">
				<c:forEach var="infomation" items="${infoList}">  
				 <tr>
                <div class="sppb-row">
                  <div class="sppb-col-sm-4 col-lg-4 col-md-6">
                    <div class="sppb-addon-container" style="width:100%;height:30%;">
						<i></i><a href="">${infomation.title}</a>
					</div>
                  </div>
                 </div>
                 </tr>
                
                <!-- 
                  <div class="sppb-col-sm-4 col-lg-4 col-md-6" style="left:0%;">
                     <div class="sppb-addon-container" style="width:100%;height:30%;">
<i></i><a href="">${infomation.title}</a>
                      </div>
                  </div>
                  <div class="sppb-col-sm-4 col-lg-4 col-md-6">
                   <div class="sppb-addon-container" style="width:100%;height:30%;">
<i></i><a href="">${infomation.title}</a>
                      </div>
                  </div>
                   -->
               </c:forEach>
 				</c:if>
 				</table> 
                
              
              </div>
              
            </section>
            <!--资讯-->
            
			<!-- 艺术家 -->
            <section id="section-about" class="section appear clearfix">
              <div class="container">
                <div class="row mar-bot40">
                  <div class="col-md-offset-3 col-md-6">
                    <div class="section-header">
                      <h2 class="section-heading animated" data-animation="bounceInUp">签约艺术家</h2>
                      <p>成为签约艺术家，我们因你而精彩。</p>
                    </div>
                  </div>
                </div>
                <c:forEach var="artist" items="${artist_list}">
                <div class="row align-center mar-bot40">
                  <div class="col-md-3">
                    <div class="team-member">
                      <figure class="member-photo"><img src="${artist.photo}" alt="" /></figure>
                      <div class="team-detail">
                        <h4>${artist.realName}</h4>
                        <span>${artist.introduction}</span> </div>
                    </div>
                  </div>
                </div>
                </c:forEach>
            </section>
              
            <!-- /about -->
            <!-- 艺术品商城 -->
            <section id="section-works" class="section appear clearfix" style="background-color:#ffffff;">
              <div class="container">
                <div class="row mar-bot40">
                  <div class="col-md-offset-3 col-md-6">
                    <div class="section-header">
                      <h2 class="section-heading animated" data-animation="bounceInUp">艺术品商城</h2>
                      <p></p>
                    </div>
                  </div>
                </div>
               
        <form action="ajaxTest()">
                    	<c:forEach var="product" items="${product_list}">
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="portfolio-items isotopeWrapper clearfix" id="3">
                        <article class="col-md-4 isotopeItem webdesign">
                          <div class="portfolio-item"> <img src="${product.imagesURL}" alt="" />
                            <div class="portfolio-desc align-center">
                              <div class="folio-info">
                                <h5><a href="#">${product.artworkName}</a></h5>
                                <a href="img/portfolio/art1.jpg" class="fancybox"><i class="fa fa-plus fa-2x"></i></a> </div>
                            </div>
                          </div>
                        </article>
                      </div>
                    </div>
                  </div>
                </div>
                 </c:forEach>
	                     
	                     </form>
              </div>
            </section>
            <!-- 定制 -->
            <section class="section appear clearfix">
              <div class="container">
                <div class="row mar-bot40">
                  <div class="col-md-offset-3 col-md-6">
                    <div class="section-header">
                      <h2 class="section-heading animated" data-animation="bounceInUp">艺术品定制</h2>
                      <p></p>
                    </div>
                  </div>
                </div>
                <c:forEach var="custommade" items="${custommade_list}">
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="portfolio-items isotopeWrapper clearfix" id="3">
                        <article class="col-md-4 isotopeItem photography">
                          <div class="portfolio-item"> <img src="${custommade.imagesURL}" alt="" />
                            <div class="portfolio-desc align-center">
                              <div class="folio-info">
                                <h5><a href="#">${custommade.artworkName}</a></h5>
                                <a href="img/portfolio/img5.jpg" class="fancybox"><i class="fa fa-plus fa-2x"></i></a> </div>
                            </div>
                          </div>
                        </article>
                      </div>
                    </div>
                  </div>
                </div>
                </c:forEach>
              </div>
            </section>
            <!--end-->
            <!-- 拍卖-->
            <section id="section-works" class="section appear clearfix" style="background-color:#ffffff;">
              <div class="container">
                <div class="row mar-bot40">
                  <div class="col-md-offset-3 col-md-6">
                    <div class="section-header">
                      <h2 class="section-heading animated" data-animation="bounceInUp">艺术品拍卖</h2>
                      <p></p>
                    </div>
                  </div>
                </div>
                <c:forEach var="auction" items="${auction_list}">
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="portfolio-items isotopeWrapper clearfix" id="3">
                        <article class="col-md-4 isotopeItem print">
                          <div class="portfolio-item"> <img src="${auction.imagesURL}" alt="" />
                            <div class="portfolio-desc align-center">
                              <div class="folio-info">

                                <h5><a href="#">${auction.artworkName}</a></h5>
                                <a href="img/portfolio/img9.jpg" class="fancybox"><i class="fa fa-plus fa-2x"></i></a> </div>
                            </div>
                          </div>
                        </article>
                      </div>
                    </div>
                  </div>
                </div>
                </c:forEach>
              </div>
            </section>
          <!--end 拍卖-->

    <footer id="sp-footer"上>
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
        <h3 class="sp-module-title">drinkArt</h3>
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
   $("#myCarousel").carousel('cycle');
  </script>
</body>
</html>
