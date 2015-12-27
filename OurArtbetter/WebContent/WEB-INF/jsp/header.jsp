<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <header id="sp-header">
    <div class="container">
      <div class="row">
        <div id="sp-logo" class="col-xs-8 col-sm-3 col-md-2">
          <div class="sp-column "><a class="logo" href="/">
            <h1><span style="color:#000000;">Drink</span><span style="color:#e83258;">Art</span></h1>
            </a></div>
        </div>
        <div id="sp-search" class="col-sm-4 col-md-6 hidden-xs">
          <div class="sp-column ">
            <form id="product-search" action="https://shapebootstrap.net/" method="get">
              <input type="hidden" name="option" value="com_product">
              <input type="hidden" name="view" value="products">
              <input type="hidden" name="Itemid" value="105">
              <i class="sb-icon-search"></i>
              <input type="text" name="search" placeholder="Search Templates" value="">
            </form>
          </div>
        </div>
        <div id="sp-account" class="col-xs-4 col-sm-5 col-md-4">
          <div class="sp-column ">
            <ul>
              <li><a class="btn btn-primary btn-submit-item hidden-sm hidden-xs" href="/login">Start Selling</a></li>
              <li><a class="btn btn-success btn-login hidden-sm hidden-xs" href="/OurArtbetter/TurnToLogin">Login</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" href="/OurArtbetter/TurnToLogin?userName=<%=session.getAttribute("userName")%>" style="margin-top:40%;"><i style="background:url('images/glyphicons-4-user.png');width:127%;height:40%;" class="fa fa-bars"></i></a></li>
              <li><a class="btn btn-default btn-registration hidden-sm hidden-xs" href="/login?view=registration">Create an Account</a></li>
              <li><a class="btn btn-link btn-login visible-sm visible-xs" id="offcanvas-toggler" href="#"><i class="fa fa-bars" style="background:url('images/listimg.png');    margin-top:90%;width: 100%;height: 40%;"></i></a></li>
              <li><a class="btn btn-link btn-cart hidden-sm hidden-xs" href="/cart"><i class="sb-icon-purchase"></i> <small class="my-cart">0</small></a></li>
            </ul>
          </div>
        </div>
		
      </div>
    </div>
  </header>
  
   <div id="sp-navbar-sticky-wrapper" class="sticky-wrapper" style="height: 45px;">
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
              <li class="sp-menu-item"><a  href="/OurArtbetter/artistList" >艺术品展示</a></li>
              <li class="sp-menu-item"><a  href="/OurArtbetter/artistList" >签约艺术家</a></li>
              <li class="sp-menu-item"><a  href="/OurArtbetter/productList" >艺术品商城</a></li>
              <li class="sp-menu-item"><a  href="/popular-items" >艺术品在线定制</a></li>
              <li class="sp-menu-item"><a  href="/blog" >个人中心</a></li>
              
           
            </ul>
          </div>
        </div>
      </div>
     
      </div>
    </div>
  </div>
</section>
</div>
