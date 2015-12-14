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
      <div class="article-content">
        <div class="article-header"><span>微软、苹果、小米押宝PC背后的未来逻辑</span></div>
        <div class="article-time-and-author"><span class="time">2015.10.12</span>
          <div class="sub-title"><span class="article-auth"><span class="from"><span class="authname">吴俊宇</span></span></span></div>
          <div class="clearfix"></div>
        </div>
        <div class="article-text">
          <div class="mixin-article default">
            <pre style="word-wrap: break-word;" class="text">
			<p class="art-quote">这两年来，万物移动的潮流成为了业内的主流观点。不少业内人士表示，未来的办公、娱乐、学习等一站式的用户场景都将脱离PC，由手机操作完成。</p><p class="text">然而，这两年来，以iOS和Android未代表的移动端操作系统在生产力工具这一层面上始终没有突破，人们逐渐意识到，传统的笔记本电脑才是他们应该回归的地方。虽然要回归，但完全采用传统的PC显然不是最佳选择。我们看到，微软、苹果、小米都在寻求未来PC的发展方向。这背后正是移动端反哺PC端，PC未来必将全面触控化带来的必然结果。</p><h2><p class="art-title">两端融合成为趋势</p></h2><p class="text">今年以来，国内外各厂商越来越注重PC产品新形态的探索。微软、苹果以及传闻中的小米都成为了探索的先行者。值得注意的是，移动端和PC端的两端融合都成为了这些先行者的探索思路。</p>
			<p class="text">10月6日，微软硬件新品发布会上，微软通过两款PC产品征服了世界。全功能平板电脑Surface&nbsp;Pro&nbsp;4以及微软的第一款笔记本Surface&nbsp;Book惊艳无比，触控笔、触摸屏以及注重生产力的Windows系统使得微软的两款笔记本叫好又叫座。至此，微软的Win10和Win10&nbsp;Mobile实现了手机与PC之间的进一步互联互通。</p><p class="text">苹果则是两条腿走路，一方面通过iPhone带来的品牌优势不断改进并推广自己的Macbook产品线，另一方面则推出类笔记本形态的iPad&nbsp;Pro，企图通过一种新形式挽救平板电脑这一产品线，并寻找PC和手机两端融合的新道路。</p>
			<p class="text">小米也是如此。今年夏季以来，小米频频被供应链传出将涉足PC行业的消息。这几天来，更是被曝出引进联想副总裁，要在2016年推出笔记本的传闻。根据目前媒体的公开报道，小米笔记本可能会与传统PC大不相同，以MIUI为核心的小米笔记本会探索一条两端融合的新思路。</p><h2><p class="art-title">移动端正反哺PC端</p></h2>
			<p class="text">这次PC端和手机端的两端融合实际上与多年前微软所开发的多普达掌上电脑大不相同。多普达掌上电脑完全是PC端移植到移动端的产物，无论是图标、UI、外观，多普达都无法脱离当时Windows&nbsp;98以及Windows&nbsp;XP的逻辑。</p>
			<p class="text">在多普达的时代，多普达是PC延伸的产物，但从Win8采用Windows&nbsp;Phone上的Metro&nbsp;UI开始，我们可以发现，手机端反哺PC端已经成为了PC的一大发展趋势，PC逐渐成为了手机的延伸产物。只可惜Windows&nbsp;8这一步迈得太大，终究是扯着了蛋。</p><p class="text">移动端反哺PC端这一逻辑放在苹果的Mac身上更是明显。Mac用户大多由iPhone用户转化而来。由于iPhone带来的极致体验以及方便的云同步服务，拥有一台Mac成为了iPhone用户的最佳选择。</p>
			<p class="text">多年以前，微软试图让手机变得更像PC,但走过Win10的改进之后，微软正在试图让PC更像手机。在Win10上，微软正是试图让手机端和PC端的视觉体验和操作逻辑尽可能相同。</p><p class="text">微软另一个大招更值得我们警觉，Win10&nbsp;Mobile正式版上即将实现的一个名为Continuum的功能，让Window&nbsp;Phone只要接上显示器就可以变成一台简单的Win10电脑，这正是得益于微软推出的Universal&nbsp;App。</p><h2><p class="art-title">未来PC形态几何？</p>
			</h2><p class="text">业内曾一直唱衰PC，认为PC产业已是夕阳产业。但在这种移动端反哺PC端的趋势下，PC产业实际上正在迎来一场新变革，由移动端反哺、两端融合为目标的PC产业正是急需攻克的朝阳产业。</p>
			<p class="text">传统的笔记本电脑产品几乎都是翻盖式的。但目前来看，在新一代的PC中，我们见到了更多的产品形态，滑盖式、翻转式、折叠式，甚至可插拔的屏幕，产品的形态发生了前所未有的变化，一方面它足够轻薄便携，低功耗同时性能足够强悍，另一方面除了拥有传统笔记本电脑的功能以外，凭借着触控、轻薄甚至可插拔的屏幕等特点，也拥有了平板电脑的特性，满足我们在不同使用场合中的无缝衔接，并且数据也不用倒来倒去。</p>
			<p class="text">但这依然不够，因为微软的Surface以及苹果的Macbook与手机之间的体验仍然不够统一，PC和手机两款产品之间还是存在诸多连接上的障碍。</p><p class="text">未来PC的形态一定是全触控式的。两款产品、一套系统。PC与手机拥有相同的图标、相同的UI、相同的内核、相同的使用方法，两者利用云同步多屏互动。微软、苹果的思路可谓是代表了未来。传闻中的小米实际上也正是以“移动端反哺PC端”的思路正在对自身的产品进行探索。</p>
			<p class="text">未来的PC办公趋势是跨平台、跨终端、跨屏幕的。这两年来，PC行业的发展正是体现着这一趋势。基于X86架构的atom和core m平台已经慢慢轻量化，越来越多的笔记本电脑也装上了触摸屏，打通PC和手机的技术条件正在变得越来越成熟。</p>
			<p class="text">正是如此，PC在这种大环境下非但不会死亡，反而迎来了新生。微软、苹果、小米纷纷押宝PC的背后，实际上看重的是PC作为生产力工具移动端无可替代的特点，未来的PC在移动端反哺和两端融合的大趋势下，依然大有作为。</p>
			<p class="text">用马云的一句话或许可以形容PC行业的历史和未来：PC的昨天很辉煌，今天很残酷，明天会更残酷，但是后天会很美好。</p>
</pre>
            <div class="note">本文为<a href="http://m.pintu360.com" class="link">品途网</a>作者: 吴俊宇创作，责编：邹初帆。欢迎转载，转载请注明原文出处：
              http://m.pintu360.com/article/561af768caa3e7163a46e0c6.html
              。本文仅代表作者观点，不代表品途网观点。 ]</div>
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
