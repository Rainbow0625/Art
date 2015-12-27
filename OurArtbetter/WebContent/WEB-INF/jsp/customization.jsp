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
.title {
    height: 22px;
    line-height: 22px;
    font-size: 22px;
    font-family: "黑体";
    color: #3b3b3b;
    padding-top:7%;
    padding-bottom: 13%;
}
.title i {
    display: inline-block;
    width: 22px;
    height: 22px;
    background: #e56565;
    vertical-align: bottom;
    margin-right: 3px;
}

}
p{
color:#1f1f1f;
font-size:13px;
}
p font {
    color: #f85c5c;
	font-size:18px;
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

  <section id="sp-main-body">
    <div class="container">
      <div class="row">
        <div id="sp-component" class="col-sm-12 col-md-12">
          <div class="sp-column">
            <div id="akeeba-renderjoomla">
              <div class="product-details">
                
                <div class="row">
                  <div class="col-sm-12">

					  
					<div class="orderitem">

					   <div class="title"><i></i>定制流程</div>
					    <div class="row">
						<div class="col-xs-12">
  <p><font>曾经</font> 我们把幸福藏在心里，收入钱包，放在电脑、手机上，装在相册里。</p>
  <p style="margin-left:7%;"><font>今天</font> 我们将幸福融进艺术，用充满灵感的创作，将幸福留住、传世。。。</p>
  <p><font>定制</font> 起源于欧洲，在中世纪的欧洲，宫廷贵族制定属于自己的油画就已经是一种时代潮流，当时的文艺复兴把油画定制服务推举到了一个空前发展的阶段油画定制成为一种宫廷贵族的专利，宫廷会聘用最好的艺术家为他们量身打造自己喜欢的作品，用以装饰自己的建筑与空间，也作为一种炫耀自己财富与地位的本钱。当然，随着时间的推移，宫廷贵族没落。定制油画普通人都可以拥有的一种艺术体验，当前油画定制已经成为了一种时尚，定制属于自己心中最美好的一瞬间 ，也成为馈赠亲人、爱人、有人的时尚礼品。</p>
</div>
							<div class="col-xs-12" style="text-align:center;">
					      <img src="images/customization.png" alt="" style="margin:0 auto;"/>
						  </div>
                        
                      </div>
					  
					<div class="orderitem">
					   <div class="productitem">
                        
							
							</div>
                        </div>
						
				
						
						  <div class="productcount">
						   <div class="row">
						   
							<div class="col-xs-12" style"text-align:center;">
							 <a href="/OurArtbetter/customizationForm" ><input type="button" value="开启定制之旅" style="display:block;color:#ffffff;border-radius:2px;background-color:#8f1c22;border:1px solid #8f1c22;margin:0 auto;width:80%;height:40px;"/></a>
                        </div>
						</div>
				       </div>
                      </div>
					  
					  
					  				<div class="orderitem">

					   <div class="title"><i></i>定制案例</div>
					    <div class="row">
					
                        
                      </div>
					  
					<div class="orderitem">
					   <div class="productitem">
                           <div class="row">
						     <div class="col-xs-6">
							   <img src="images/art6.jpg" alt=""/>
							 </div>
							    <div class="col-xs-6">
							   <img src="images/art5.jpg" alt=""/>
							 </div>
							 </div>
							 
							  <div class="row" style="margin-top:13%;">
							    <div class="col-xs-6">
							       <img src="images/art1.jpg" alt=""/>
							    </div>
							    <div class="col-xs-6">
							       <img src="images/art2.jpg" alt=""/>
							    </div>
							  </div>
							  
							   <div class="row" style="margin-top:13%;">
							    <div class="col-xs-6">
							   <img src="images/art3.jpg" alt=""/>
							 </div>
							 
							  <div class="col-xs-6">
							   <img src="images/art4.jpg" alt=""/>
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
