<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<base href="https://shapebootstrap.net/" />-->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="generator" content="Joomla! - Open Source Content Management" />
<title>drinkArt</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="../../css/template.css" type="text/css" />
<link rel="stylesheet" href="../../css/style.css">

<link rel="stylesheet" href="../../css/artstyle.css">
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

section.section {
    /* margin: 0; */
    padding: 20px 0 20px 0;
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
.list{
    font-size: 16px;/*字体大小适配*/
}
}
@media screen  and (max-width:619px){/*手机*/
.list{
    font-size: 4.2vw;/*字体大小适配*/
}
}
.col-md-6,.col-lg-4{
padding-left:0px;
padding-right:0px;
}
.list {
    height: 49px;
    line-height: 49px;
    border-bottom: 1px dashed #C0C0C0;
}
 .list span {
    float: right;
	font-size:10px;
}
.list a {
    color: #221E1F;
    text-decoration: none;
}
  </style>
<script src="../../js/jquery.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../js/main.js" type="text/javascript"></script>
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

 <section id="section-about" class="section appear clearfix sppb-section">
              <div class="container">
               <div class="main">
			   <!--如果a标签过长会直接用...替代-->
	  	  <div class="list"><span>2015-04-03</span><a href="/page/article/show.php?id=503" target="_blank" class="infotitle">承启印象派与野兽派的西班牙艺术家</a></div>
	  	  <div class="list"><span>2015-02-24</span><a href="/page/article/show.php?id=502" target="_blank" class="infotitle">聊聊古典主义绘画的那些事儿</a></div>
	  	  <div class="list"><span>2014-01-21</span><a href="/page/article/show.php?id=501" target="_blank" class="infotitle">插画艺术家 Alex Konahin 的超精致的线条艺术</a></div>
	  	  <div class="list"><span>2014-01-16</span><a href="/page/article/show.php?id=500" target="_blank" class="infotitle">西班牙艺术家Guim Tió Zarraluki绘画作品赏</a></div>
	  	  <div class="list"><span>2013-11-29</span><a href="/page/article/show.php?id=497" target="_blank" class="infotitle">被遮蔽的民国新锐画家群浮出水面</a></div>
	  	  <div class="list"><span>2013-11-05</span><a href="/page/article/show.php?id=492" target="_blank" class="infotitle">透纳：一个走在时代前面的艺术家</a></div>
	  	  <div class="list"><span>2013-11-01</span><a href="/page/article/show.php?id=491" target="_blank" class="infotitle">透纳生平传记</a></div>
	  	   	  <div class="list"><span>2015-04-03</span><a href="/page/article/show.php?id=503" target="_blank" class="infotitle">承启印象派与野兽派的西班牙艺术家</a></div>
	  	  <div class="list"><span>2015-02-24</span><a href="/page/article/show.php?id=502" target="_blank" class="infotitle">聊聊古典主义绘画的那些事儿</a></div>
	  	  <div class="list"><span>2014-01-21</span><a href="/page/article/show.php?id=501" target="_blank" class="infotitle">插画艺术家 Alex Konahin 的超精致的线条艺术</a></div>
	  	  <div class="list"><span>2014-01-16</span><a href="/page/article/show.php?id=500" target="_blank" class="infotitle">西班牙艺术家Guim Tió Zarraluki绘画作品赏</a></div>
	  		  	  <div class="list"><span>2013-11-01</span><a href="/page/article/show.php?id=491" target="_blank" class="infotitle">透纳生平传记</a></div>
	  	   	  <div class="list"><span>2015-04-03</span><a href="/page/article/show.php?id=503" target="_blank" class="infotitle">承启印象派与野兽派的西班牙艺术家</a></div>
	  	  <div class="list"><span>2015-02-24</span><a href="/page/article/show.php?id=502" target="_blank" class="infotitle">聊聊古典主义绘画的那些事儿</a></div>
	  	  <div class="list"><span>2014-01-21</span><a href="/page/article/show.php?id=501" target="_blank" class="infotitle">插画艺术家 Alex Konahin 的超精致的线条艺术</a></div>
	  	  <div class="list"><span>2014-01-16</span><a href="/page/article/show.php?id=500" target="_blank" class="infotitle">西班牙艺术家Guim Tió Zarraluki绘画作品赏</a></div>
	  	
	      </div>
                </div>
              </div>
            </section>
            <!--资讯-->
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
   $("#myCarousel").carousel('cycle');
   window.onload=judgelength; 
   function judgelength(){
   var elements = document.getElementsByClassName("infotitle");
   	console.log(elements.length);
   // var result = [];
    for(var i=0;i<elements.length;i++){//缓存length属性
        var element = elements[i];
        var str=element.innerHTML;
		console.log(str);
         var s = str;//要展示的字符串
		 var slength=0;
		 var count=0;
		 for (var j=0;j<s.length;j++) 
    { 
        if (str.charCodeAt(j) > 255) {//是中文
			     slength=slength+2;   
		if(slength<32)
		   count++;
		  // console.log(i);
			}
        else{ 
              slength=slength+1;
		    if(slength<32)
		      count++;	
		  }
    } 
	console.log(slength);
	console.log(count);
         if(slength>32){
          s=str.substring(0,count)+"...";
         console.log(s);   
		 element.innerHTML=s;
		 } 
        }  



   } 

  </script>
</body>
</html>
