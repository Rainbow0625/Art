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
<title>Art</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/preset1.css" type="text/css" class="preset" />
<link rel="stylesheet" href="css/style.css">
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
.ok{
margin-left:-6%;
margin-top:13%;
}
.usd{
margin-left:6%;
}
.brush{
margin-left:-6%;
margin-top:8%;
}
.shadow{
margin-top:-5%;
}
}


.productcount input[type="button"]{
font-size:10px;
width:80px;
height:20%;}
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
  <section id="sp-main-body">
    <div class="container">
      <div class="row">
        <div id="sp-component" class="col-sm-12 col-md-12">
          <div class="sp-column">
            <div id="akeeba-renderjoomla">
              <div class="product-details">
                
                <div class="row">
                  <div class="col-sm-12">
                   <div class="col-sm-12">
                    <ul class="nav nav-tabs" role="tablist" style="font-size:8px;">
                      <li class="active"><a href="#">我的订单<span>0</span></a></li>
                      <li><a href="#">我的信息</a></li>
					   <li><a href="#">我的申请<span>0</span></a></li>
                    </ul>
                    <ul class="nav nav-tabs" role="tablist" style="font-size:8px;">
                      <li><a href="#">商城订单<span>0</span></a></li>
                      <li class="active"><a href="#">定制订单<span>0</span></a></li>
                    </ul>
				
					
                    <div class="product-details"> 
                      <div class="product-actions shadow">
                        <div class="row" style="font-size:6px;">
                        	   <div class="col-sm-3 col-xs-3"><a href="#"><img src="images/glyphicons-207-ok-2.png"/><p class="active-order ok">待审核</p></a></div>
				             <div class="col-sm-3 col-xs-3"><a href="#"><img src="images/glyphicons-228-usd.png" class="usd"/><p style="margin-left:-3%;">待付款</p></a></div>
							 <div class="col-sm-3 col-xs-3"><a href="#"><img src="images/glyphicons-235-brush.png"/><p class="brush"  >创作中</p></a></div>
							 <div class="col-sm-3 col-xs-3"><a href="#"><img src="images/glyphicons-59-truck.png"/><p>待收货</p></a></div>
                        </div>
                      </div>
					  
					  
					 	<div class="orderitem">
		
					      <div style="width:100%;height:20px;"><p style="display:inline;float:left;color:#777;font-size:14px;">艺术家 : <span>白玉国</span></p>
							<p style="float:right;color:#e83258;font-size:8px;display:inline;">等待艺术家审核</p>
							</div>
					   <div class="productitem">
                        <div class="row">
							<div class="col-xs-4">
							  <img src="images/thing1.jpg"/>
							</div>
							<div class="col-xs-8">
							  <!-- <span style="color:#000000;">雪林</span>
							  <p  style="float:right;color:#000000;"></p> -->
							  <p><small>定制说明</small></p><!--不知道要不要-->
							</div>
							</div>
							
                        </div>
						 
						 		 <div class="productcount">
						   <div class="row">
							  <input type="button" value="审核不同意" style="color:#ffffff;border-radius:2px;background-color:#ea4f4f;border:1px solid #ea4f4f;"/>
							 <input type="button" value="审核同意" style="float:right;color:#ffffff;border-radius:2px;background-color:#8f1c22;border:1px solid #8f1c22;"/>
                        </div>
				       </div>
						 
                      </div>
					  
						
			
					  
				
				
                     
					 </div>
					 
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

           
  <%@include file="footer.jsp"%>
  <%@include file="canvasmenu.jsp"%>
</body>
</html>
