<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DrinkArt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/preset1.css" type="text/css" class="preset" />
<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="js/Calculation.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<style type="text/css">
body{font-family:'Microsoft Yahei'; font-weight:normal;background-color:#e5e5e5;}
h1{font-family:Open Sans, sans-serif; font-weight:700;font-size:24px;}
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
padding-right:5%;
}
.orderitem{
margin-top:5%;
padding:4%;
background-color:#ffffff;
}
  </style>
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
<%@include file="header.jsp"%>
 <section id="sp-main-body">
    <div class="container">	
     <div class="row">
        <div id="sp-component" class="col-sm-12 col-md-12">
          <div class="sp-column">
            <div id="akeeba-renderjoomla">
              <div class="product-details">
                
                <div class="row">
                  <div class="col-sm-8 col-xs-12">
                  
       		    <c:if test="${sessionScope.cart.cartItems.size()!= 0}">
			     <c:forEach items="${sessionScope.cart.cartItems}" var="item" varStatus="status">
			    <div class="orderitem">
					
					   <div class="productitem">
                        <div class="row">
			    <div id="item-${status.count}" class="table-content">
			
				<div class="col-xs-4">
				   <a href="/OurArtbetter/findByPid=${item.product.artworkId}">
				      <img class="item-image" src="${item.product.imagesURL}"/>
				   </a> 
				 </div>
				 
				   <input type="hidden" name="menuId-${status.count}" id="menuId-${status.count}" value="${item.product.artworkId}"/>
				
               <div class="col-xs-8">
				   <div style="display:inline;">
				     <a href="/OurArtbetter/findByPid=${item.product.artworkId}">${item.product.artworkName}</a>
			       </div>
				   <div style="float:right;">
				      <span style="font-size:6px;margin-top:-2%;"> 单价：￥</span>
				      <input name="itemprice-${status.count}" id="itemprice-${status.count}" type="hidden" value="${item.product.artworkPrice}" style="font-size:6px;margin-top:-2%;"/>${item.product.artworkPrice}
				   </div>
				   
				   <div style="font-size:6px;height:17px;">
					 <input name="min${status.count}" id="min${status.count}" type="button" value="-" style="float:left;width:10%;height:17px;padding:0px 0px;line-height:0px;" onclick="minus('${status.count}')" />
					 <input  name="text_box${status.count}" id="text_box${status.count}" type="text" value="${item.count}" readonly="readonly" style="float:left;width:20%;height:17px;min-height:10px;padding:0px 0px; text-align:center; border:1px solid #ccc;line-height:0px;font-size:8px;" />
					 <input name="add${status.count}" id="add${status.count}" type="button" value="+" style="float:left;width:10%;height:17px;padding:0px 0px;line-height:0px;=" onclick="add('${status.count}','${item.product.quantity}')"/>
			          <input name="total" id="total${status.count}" value="${item.subtotal}" readonly="readonly" style="float:right;width:25%;background:#FFF;line-height:0px;height:17px;padding:0px 0px;min-height:10px;"/>
			       </div>
				</div>
				
              </div>
             </div>
             </div>
             
             <div class="productcount">
				
				 <input type="button" value="删除商品" onclick="removeProduct(this,'OurArtbetter/addCart&menuId=${item.product.artworkId}')" style="color:#ffffff;border-radius:2px;background-color:#ea4f4f;border:1px solid #ea4f4f;" />		   
		          <input type="button" value="立即购买" style="float:right;color:#ffffff;border-radius:2px;background-color:#8f1c22;border:1px solid #8f1c22;"/>
		      </div>
             
             </div>
			</c:forEach>
		   </c:if>
		
	 <form name="form2" method="post" action="Shoppingcart.jsp">		   
		<div class="orderitem">
           <div class="productitem">
            <div class="row">
		        <div>
		         <span style="float:left;margin-left:10%;margin-top:2%;"> 总计:</span><span style="float:left;font-size:30px; font-weight:bold;margin-top:2%;">￥</span><input name="sumTotal" id="sumTotal" type="text" readonly="readonly" value="${ cart.total }" style="float:left;width:40%;background:none;font-size:20px" />
		         <label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label>
	            </div>
	            
            </div>
           </div>
           
           <div class="productcount" style="margin-bottom:5%;padding-bottom:5%;">
		          <a href="${pageContext.request.contextPath}/saveOrder" id="jz2" class="jz2"> <input type="button" value="结算" style="float:right;width:75px;color:#ffffff;border-radius:2px;background-color:#8f1c22;border:1px solid #8f1c22;"/></a>
                       <a href="/OurArtbetter/productList" class="jz2" id="jz2"> <input type="button" value="继续购物"  style="float:right;margin-right:5%;color:#ffffff;border-radius:2px;background-color:#ea4f4f;border:1px solid #ea4f4f;" />	</a>
                </div>
                
          </div> 
       </form>		
          
         </div>
         </div>
         </div>
         </div>
         </div>
         </div>
         </div>
         </section>
        
		
		
		
		

<div>
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
  <%@include file="footer.jsp"%>
  <%@include file="canvasmenu.jsp"%>
</body>
</html>