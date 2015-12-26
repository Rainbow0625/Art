<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="generator" content="Joomla! - Open Source Content Management" />
<title>OurArtbetter</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/preset1.css" type="text/css" class="preset" />
<link rel="stylesheet" href="css/style.css"/>
<style type="text/css">
body{ font-family: "Microsoft YaHei" ! important;  font-weight:normal;background-color:#e5e5e5; }
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

.orderitem{
padding:2% 6%;
    background: #fff;
    margin-bottom: 30px;
    -webkit-box-shadow: 2px 2px 2px 0px rgba(5, 5, 5, 0.06);
    box-shadow: 2px 2px 2px 0px rgba(5, 5, 5, 0.06);

}
.button-control{
margin-top:4%;
}

.button-control input[type="button"]{
width:40%;
height:45px;
border-radius:5px;
color:#ffffff;
}
@media screen  and (min-width:619px){/*pc*/
.product-price span{
font-size:16px;
}
}
@media screen  and (max-width:619px){/*手机*/
.product-price span{
font-size:5vw;
}
}

.box .box-title {
    font-size: 20px;
	}
.sp-column{
margin-top:5%;
}

.product-details .product-actions {
    background: #fff;
    padding: 10% 0% 0% 6%;
    margin-bottom: 30px;
}
.row a{
color:#777;
}
.productitem{
padding-top:10%;
padding-bottom:5%;
    border-bottom: 1px solid #e5e5e5;
	}
.productcount{
padding-top:10%;
padding-bottom:5%;
padding-left:5%;
padding-right:5%;}
.productcount p{
font-size:8px;
}
.productcount input[type="button"]{
font-size:10px;
width:30%;
height:20%;
}
  </style>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<meta content="Premium & Free Bootstrap Templates & Themes" property="og:title" />
<meta  property="og:type" content="website"/>
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
<section id="sp-navbar" class="hidden-xs">
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
  <section id="sp-main-body">
    <div class="container">
      <div class="row">
        <div id="sp-component" class="col-sm-12 col-md-12">
          <div class="sp-column">
            <div id="akeeba-renderjoomla">
              <div class="product-details">
                
                <div class="row">
                  <div class="col-sm-8">
                    <ul class="nav nav-tabs" role="tablist">
                    <li class="active"><a href="#">我的订单<span>${order.oid}</span></a></li>
                      <li><a href="#">我的商店</a></li>
                    </ul>
                    
                    
	 <div class="product-details"> 
         
					  <c:forEach var="orderItem" items="${order.orderItems}">
					   <div class="orderitem">
					  <div style="width:100%;height:10px;"><p style="font-size:8px;float:left;"><p>订单编号 : <span><c:out value="${order.oid}" /></span></p></div>
					   <div class="productitem">
                        <div class="row">
							<div class="col-xs-4">
							  <img src="${ pageContext.request.contextPath }/<c:out value="${ orderItem.product.imagesURL}"/>"/>
							</div>
							<div class="col-xs-8">
							  <span style="color:#000000;"><c:out value="${orderItem.product.artworkName}" /></span> <p  style="float:right;color:#000000;"><span>￥</span><span>${orderItem.product.artworkPrice}</span></p>
							  <p><small>数量:<c:out value="${orderItem.count}" /></small></p><!--不知道要不要-->
							  <p><small>小计:<c:out	value="${orderItem.subtotal}" /></small></p>
							</div>
							</div>
                        </div>
                         </c:forEach>
						    <div class="productcount">
						   <div class="row">
                             <p style="float:right;">合计：<span>￥</span><big><span><c:out value="${order.total}" /></span></big>  （含运费<span>￥</span><span>0.00</span>）</p>						 
                        </div>
				       </div>
                      </div>
         		<form id="orderForm"
				action="${ pageContext.request.contextPath }/payOrder"
				method="post">
				<input type="hidden" name="oid"
					value="<c:out value="${order.oid}"/>" />
				<div class="span24">
					<p>
						收货地址：<input name="address" type="text"
							value="<c:out value="${sessionScope.user.address}"/>"
							style="width: 350px" /> <br /> 收货人&nbsp;&nbsp;&nbsp;：<input
							name="nickName" type="text"
							value="<c:out value="${sessionScope.user.nickName}"/>"
							style="width: 150px" /> <br /> 联系方式：<input name="tel"
							type="text" value="<c:out value="${sessionScope.user.tel}"/>"
							style="width: 150px" />
					</p><hr />
					  <div class="productitem">
                        <div class="row">
							<div class="col-xs-12">
							 <p style="float:left"><input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"/>工商银行</p><img  src="images/bank_img/icbc.bmp" style="float:left;width:154px;height:33px;margin-left:6%;"/>
							</div>
							
							<div class="col-xs-12" style="margin-top:3%;">
							 <p style="float:left"><input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行</p><img  src="images/bank_img/bc.bmp" style="float:left;width:154px;height:33px;margin-left:6%;"/>
							</div>
							
							<div class="col-xs-12" style="margin-top:3%;">
							 <p style="float:left"><input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行</p><img  src="images/bank_img/bcc.bmp" style="float:left;width:154px;height:33px;margin-left:6%;"/>
							</div>
							
								<div class="col-xs-12" style="margin-top:3%;">
							 <p style="float:left"><input type="radio" name="pd_FrpId" value="CEB-NET-B2C" />光大银行 <img  src="images/bank_img/guangda.bmp" style="float:left;width:154px;height:33px;margin-left:6%;"/>
							</div>
							
								<div class="col-xs-12" style="margin-top:3%;">
							 <p style="float:left"><input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行</p><img  src="images/bank_img/cmb.bmp" style="float:left;width:154px;height:33px;margin-left:6%;"/>
							</div>
							</div>
					
					
                        </div>
					<hr />
					<p style="text-align: right">
					 <a href="/OurArtbetter/">
					 <input type="button" value="取消" style="color:#ffffff;border-radius:2px;background-color:#ea4f4f;border:1px solid #ea4f4f;"/>
					</a>
						<a
							href="javascript:document.getElementById('orderForm').submit();">
							<input type="submit" value="确认支付" style="color:#ffffff;border-radius:2px;background-color:#ea4f4f;border:1px solid #ea4f4f;"/>
						</a>
					</p>
				</div>
			</form>
		</div>
				
					 <div class="shoppingcart" style="width:8%;height:5%;position:fixed;right:10%;bottom:2%;z-index:100;">
   <a href="#"><img src="images/shoppingcart.png" alt="找不到图片" style="width:100%;height:100%;"/></a>
</div>	 
                    </div>
                  </div>
             
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

           

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
</body>
</html>
