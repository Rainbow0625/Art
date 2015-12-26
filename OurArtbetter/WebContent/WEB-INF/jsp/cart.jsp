<%@page import="java.awt.Checkbox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="js/Calculation.js"></script>
<script type="text/javascript">

function doType(url) {
	var frm = document.all("form2");
	frm.action = url;
	frm.submit();
}
function add(id,q)
{
	var name = "text_box" + id;
	var e = document.getElementById(name);
	var c = e.value;
	var quantity = parseInt(q);
	if(quantity>=parseInt(c)+1)
	{
		
		e.value = parseInt(c)+1;
		//得到小计
		var strTotal = "total" + id;
		var eleTotal= document.getElementById(strTotal);
		var pretotal = parseInt(eleTotal.value); //原来的小计
		
		
		
		//得到单价
		var strItemPrice = "itemprice-" + id;
		var eleItemPrice = document.getElementById(strItemPrice);
		var price =  parseInt(eleItemPrice.value);
		
		//更新小计
		var t = pretotal +  price;
		eleTotal.value = t.toFixed(1);
		
		//更新合计
		updateTotal();
		
		
		//响应服务器,更新session
		var m= "menuId-" + id;
		var strId = document.getElementById(m).value;
		var menuId = parseInt(strId);
		var url = "OurArtbetter&menuId=" + menuId;	
		updateSession(url);
	}
	else
	{
		alert("库存不足！");
	}
}

function minus(id)
{
	var name = "text_box" + id;
	var e = document.getElementById(name)
	var c = e.value;
	if(c>1)
		e.value = parseInt(c)-1;
	
	//得到小计
	var strTotal = "total" + id;
	var eleTotal= document.getElementById(strTotal);
	var pretotal = parseInt(eleTotal.value); //原来的小计

	//得到单价
	var strItemPrice = "itemprice-" + id;
	var eleItemPrice = document.getElementById(strItemPrice);
	var price =  parseInt(eleItemPrice.value);
	//更新小计
	
	var t = pretotal -  price;
	if(t>0)
	{	
		eleTotal.value = t.toFixed(1);					
		//更新合计	
		updateTotal();
		//更新session		
		var m= "menuId-" + id;
		var strId = document.getElementById(m).value;
		var menuId = parseInt(strId);
		var url = "OurArtbetter/addCart&menuId=" + menuId;
		updateSession(url);
	}
	
	
}


function getXMLRequest(){  
	var request;  
	try{  
		//for火狐等浏览器  
		request = new XMLHttpRequest();  
	}catch(e){  
		try{  
			//for IE  
			request = new ActiveXObject("Microsoft.XMLHttp");    
		}catch(e){  
			alert("您的浏览器不支持AJAX!!!");  
			return null;  
		}  
	}  
	return request;  
}  

function updateSession(url){  
	var request = getXMLRequest();//得到XMLHttpRequest对象  					
	request.open("POST",url,true);  //将请求发送出去  
	request.send(null);  
}  

function removeProduct(obj,url)
{
	//客户端界面
	var tr=obj.parentNode.parentNode;
	var tbody=tr.parentNode;
	tbody.removeChild(tr);
	
	updateTotal();
	
	//session更新
	var request = getXMLRequest();//得到XMLHttpRequest对象  					
	request.open("POST",url,true);  //将请求发送出去  
	request.send(null);  
}

function updateTotal()
{

	var arr = document.getElementsByName("total");
	var sum=0;
	
	for(var i=0;i<arr.length;i++){
	 	sum = parseInt(sum) +  parseInt(arr[i].value);
	}
	var e = document.getElementById("sumTotal");
	e.value = sum.toFixed(1);
}
</script>


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

<div class="gwc" style=" margin:auto;">
	<div class="gwc" style=" margin:auto;">
		<table cellpadding="0" cellspacing="0" class="gwc_tb2">
			<tr class="table-nav">
                <td>商品</td>
                <td>单价</td>
                <td>数量</td>
                <td>小计</td>
                <td>操作</td>
       		</tr>
       		<c:if test="${sessionScope.cart.cartItems.size()!= 0}">
			<c:forEach items="${sessionScope.cart.cartItems}" var="item" varStatus="status">
			<tr id="item-${status.count}" class="table-content">
			
				<td><a href="/OurArtbetter/findByPid=${item.product.artworkId}"><img class="item-image" src="${item.product.imagesURL}"/></a> <input type="hidden" name="menuId-${status.count}" id="menuId-${status.count}" value="${item.product.artworkId}"/><a href="/OurArtbetter/findByPid=${item.product.artworkId}">${item.product.artworkName}</a></td>
				<td><input name="itemprice-${status.count}" id="itemprice-${status.count}" type="hidden" value="${item.product.artworkPrice}" />${item.product.artworkPrice}</td>
				<td>
					<input name="min${status.count}" id="min${status.count}" type="button" value=" - " onclick="minus('${status.count}')" />
					<input  name="text_box${status.count}" id="text_box${status.count}" type="text" value="${item.count}" readonly="readonly" style="width:30px; text-align:center; border:1px solid #ccc;" />
					<input name="add${status.count}" id="add${status.count}" type="button" value=" + " onclick="add('${status.count}','${item.product.quantity}')" />
				</td>
				<td><input name="total" id="total${status.count}" value="${item.subtotal}" readonly="readonly" style="width:100px;background:#FFF"/>
	            </td>
				<td><input type="button" value="移除" onclick="removeProduct(this,'OurArtbetter/addCart&menuId=${item.product.artworkId}')" style="background-color: #FFF" /></td>
			</tr>
			</c:forEach>
			</c:if>
		</table>
		
		
		
		
	<form name="form2" method="post" action="Shoppingcart.jsp">	
		<table cellpadding="0" cellspacing="0" class="gwc_tb3">
			<tr>		
				<td class="tb3_td3">合计:<span>￥<input name="sumTotal" id="sumTotal" type="text" readonly="readonly" value="${ cart.total }" style="background:none;font-size:20px" /></span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></span></td>
	            <td class="tb3_td3"><a href="/OurArtbetter/productList" class="jz2" id="jz2">继续购物</a></td>
				<td class="tb3_td4"><a
						href="${pageContext.request.contextPath}/saveOrder"
						id="jz2" class="jz2">结算</a></td>
			</tr>
		</table>
	</form>
	</div>
	<c:if test="${sessionScope.cart.cartItems.size() == 0}">
			<div class="span24">
				<div class="step step1">
					<center style="color: red">
						<span><h2>亲!您还没有购物!请先去购物!</h2></span>
					</center>
				</div>
			</div>
		</c:if>
</div>

</body>
</html>