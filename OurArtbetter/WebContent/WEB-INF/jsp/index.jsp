<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="generator" content="Joomla! - Open Source Content Management" />
<title>DrinkArt</title>
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
<%@include file="header.jsp"%>
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
              
               <!-- 需要修改！！显示图片 -->
                <div class="item active"><img src="${adver1.image}" alt="First slide" >  </div>
                <div class="item"> <img src="${adver2.image}" alt="Second slide"> </div>
                
                <div class="item "> <img src="${adver3.image}"  alt="Third slide"> </div>
              
              </div>
              <!-- 轮播（Carousel）导航 -->
              <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev">&lsaquo;</a> <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a>
	       </div>
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
						<i></i><a href="/OurArtbetter/infoContent/${infomation.id}">${infomation.title}</a>
					</div>
                  </div>
                 </div>
                 </tr>
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
            <!-- 定制 
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
            <!-- 拍卖
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
        end 拍卖-->

  <!--把footer开头的那个块替换成下面的-->
  <%@include file="footer.jsp"%>
  <!-- 把div改成下面这个-->
  <%@include file="canvasmenu.jsp"%>


  <script>
   $("#myCarousel").carousel('cycle');
  </script>
  </div>
</body>

</html>
