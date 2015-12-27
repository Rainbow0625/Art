<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<title>DrinkArt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/preset1.css" type="text/css" class="preset" />

<script>
	function saveCart() {
		document.getElementById("cartForm").submit();
	}
</script>
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

.fa {
    display: inline-block;
    font-family: FontAwesome;
    font-style: normal;
    font-weight: normal;
    line-height: 1;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
.fa-bars:before {
    content: "\f0c9";
}
article{
margin-top:10%;
}
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
   <a href="/OurArtbetter/myCart"><img src="images/shoppingcart.png" alt="找不到图片" style="width:100%;height:100%;"></a>
</div>
<div class="row mar-bot40"style="background-color:#ffffff;">
                  <div class="col-md-offset-3 col-md-6" style="padding:2% 8%;">
                    <div class="item-type" style="background-color:#e5e5e5;border-radius:3px;width:25%;text-align:center;border-bottom:1px solid #e5e5e5;margin-left:2%;" id="item-type">
					   <span id="showitemtype">	<a href="${ pageContext.request.contextPath }/index">商品分类</a>|</span>
					</div>
					<c:forEach items="${sessionScope.cList}" var="c">
					<div class="item-typedrop" style="z-index:100;display:block;width:100%;height:20%;display:none;" id="item-typedrop">
		   <li><a href="${ pageContext.request.contextPath }/findByCid/<c:out value="${c.cid}"/>/1">
				<c:out value="${c.cname}"></c:out> 
			  </a>
		   </li>

				</div>
				</c:forEach>
                  </div>
                </div>
            <!-- 艺术品商城 -->
            <section id="section-works" class="section appear clearfix" style="background-color:#e5e5e5;">
              <div class="container">
                <div class="row">
                  <div class="col-md-12 col-xs-12">
                    <div class="row">     
					  <c:forEach var="p" items="${artwork_list}">
					    <form id="cartForm"action="${ pageContext.request.contextPath }/addCart"method="post">
						 <article class="col-md-4 col-xs-12 isotopeItem webdesign" style="border:1px solid #000000;border-radius:10px;background-color:#ffffff;padding-left:0;padding-right:0;padding-bottom:5%;">
                          <div class="portfolio-item" style="width:100%;height:85%;"> 
						   <img src="${p.imagesURL}" alt="找不到图片" style="border:1px solid #d6d3d3;border-radius:10px;"/>
                            <div class="portfolio-desc align-center">
                              <div class="folio-info">
                            </div>
                          </div>
						  <div class="shop-itemdetail"style="">
						   <a href="/OurArtbetter/findByPid?pid=${p.artworkId} ">
						    <p style="color:#000000;">${p.artworkName}</p></a>
						    <p>编号:<c:out value="${p.artworkId }" /></p>
							<p>作者 :<span>aaa</span></p>
							<p>价格 :<span>￥</span><span class="shop-itemprice">${p.artworkPrice}</span></p>
						
				<input type="hidden" name="artworkId"
					value="<c:out value="${p.artworkId }"/>" />
				
				<dl class="quantity">
						<dt style="float:left">购买数量:</dt>
						<dd>
							<input id="count" name="count" value="1" maxlength="4" style="float:left;width:25%;margin-left:5%;height:26px;min-height:10px;"onpaste="return false;" type="text" />
						</dd>
						<dd style="float:left;">件</dd>
					</dl>
					<div class="buy">
					<input type="submit" value="加入购物车" style="float:right;margin-left:3%;margin-top:5%;background-color:#e83258;color:#ffffff;border:1px solid #e83258;border-radius:4px;" onclick="saveCart()" />
					</div>
					</div>					
						  </div>
                        </article>
                        </form>
						</c:forEach>
			
					</div>
				</div>
				
                  </div>
                </div>
              </div>
            </section>
          

  <%@include file="footer.jsp"%>
  <%@include file="canvasmenu.jsp"%>
  <script>
   $("#myCarousel").carousel('cycle');
   $("#item-type").click(function(){
  // alert("a");
     if(document.getElementById("item-typedrop").style.display=="none"){
	 document.getElementById("item-typedrop").style.display="block";
	 }
	 else
	  document.getElementById("item-typedrop").style.display="none";
   });
   $(".itemstyle").click(function(){
      var val=$(this).text();
	  console.log(val);
      document.getElementById("showitemtype").innerHTML=val;
	   document.getElementById("showitemtype").style.color="#e83258";
      document.getElementById("item-typedrop").style.display="none";
   });
  </script>
</body>
</html>
