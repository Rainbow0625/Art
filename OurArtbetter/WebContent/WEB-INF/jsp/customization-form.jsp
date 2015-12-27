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
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/artstyle.css">
<link href="css/sucaijiayuan.css" type="text/css" rel="stylesheet" />

<style type="text/css">
body{font-family:Open Sans,sans-serif;font-weight:normal;}
h1{font-family:Open Sans,sans-serif;font-weight:700;}
h2{font-family:Open Sans,sans-serif;font-weight:600;}
h3{font-family:Open Sans,sans-serif;font-weight:normal;}
h4{font-family:Open Sans,sans-serif;font-weight:700;}
h5{font-family:Open Sans,sans-serif;font-weight:600;}
h6{font-family:Open Sans,sans-serif;font-weight:600;}
#sp-bottom{background-color:#3c3c3c;padding:70px 0px 0px;}
#sp-footer{background-color:#3c3c3c;}
.btn-success, .sppb-btn-success {
    background-color: #e83258;
}
.group-control{
display:inline-block;
width:100%;
height:20%;
}
.tip-control{
display:inline-block;
color:#e83258;
font-size:6px;
width:60%;
height:10%;
}


* { -ms-word-wrap: break-word; word-wrap: break-word; }
html { -webkit-text-size-adjust: none; text-size-adjust: none; }
html, body {height:100%;width:100%; }
html, body, h1, h2, h3, h4, h5, h6, div, ul, ol, li, dl, dt, dd, iframe, textarea, input, button, p, strong, b, i, a, span, del, pre, table, tr, th, td, form, fieldset, .pr, .pc { margin: 0; padding: 0; word-wrap: break-word; font-family: verdana,Microsoft YaHei,Tahoma,sans-serif; *font-family: Microsoft YaHei,verdana,Tahoma,sans-serif; }
body, ul, ol, li, dl, dd, p, h1, h2, h3, h4, h5, h6, form, fieldset, .pr, .pc, em, del { font-style: normal; font-size: 100%; }
ul, ol, dl { list-style: none; }

#artisttype option{
width:60%;}
p{font-size:13px;}
</style>
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
<script src="js/card.js" type="text/javascript"></script>

</head>
<body class="site com-users view-login no-layout no-task itemid-121 en-gb ltr  sticky-header layout-fluid">
<div class="body-innerwrapper">
<%@include file="header.jsp"%>
  
  <section id="sp-page-title">
    <div class="row">
      <div id="sp-title" class="col-sm-12 col-md-12">
        <div class="sp-column "></div>
      </div>
    </div>
  </section>
 
  <section id="sp-main-body" style="background-color:#e5e5e5;">
<div class="container">
<div class="row">
<div id="sp-component" class="col-sm-12 col-md-12">
<div class="sp-column ">


  <div class="productitem" style="background-color:#ffffff;margin-bottom:10%;padding:5%;">
                        <div class="row">
						
						   <div class="col-xs-3">
							  <img src="images/member1.jpg"/>
							</div>
							<div class="col-xs-9">
							  <p style="color:#000000;"><span>艺术家白玉国</span></p>
							 <p>联系电话 ：<span>1810232424</span></p>
							 <p>邮箱 ：<span>1223840780@qq.com</span></p>
							 <p style="float:left;display:inline;">qq ：<span>1810232424</span></p><img src="images/qq.jpg" alt="" style="float:left;"/>
							</div>
								
							</div>
                        </div>
					
						

<div class="row">
<div class="col-sm-6 col-sm-offset-3">
<div class="box registration">
<form id="member-registration" action="/OurArtbetter/completePersonalInfo" method="post" class="form-validate" enctype="multipart/form-data">
<div class="form-group">
<div class="text-center" style="font-size:25px;">艺术品定制</div>
</div>



<div class="form-group">
  <div class="group-control">
     <input type="text" name="" id="" value="" size="25" placeholder="规格"  autofocus=""/> 
  </div>
</div>

<div class="form-group">
  <div class="group-control">
      <select id="artisttype">
                  <option value ="1">---请选择定制艺术品类型----</option>
                  <option value ="2">玉石</option>
                  <option value="3">版画</option>
                  <option value="4">油画</option>
                  <option value="5">水墨</option>
                  <option value="6">素描</option>
				  <option value="7">书画</option>
				  <option value="8">陶瓷</option>
				  <option value="9">雕塑</option>
	  </select>
    </div>
</div>




<div class="form-group">
  <div class="group-control">
      <textarea  placeholder="  详细需求描述"  style="height:100px" autofocus=""></textarea> 
    </div>
</div>


<div class="form-group">
  <div class="group-control">
      <p>上传参考图片：</p>
					<div class="photo">
					<input type="file" id="input" name="input" accept="image/png,image/jpg,image/jpeg" onchange=
					"imagesSelected(this.files)" />
					</div>		
					       <div class="photo">
			<img id="image" src="" alt="照片预览" style="display:none;width:30%;height:20%;">		
					</div>
           
  </div>
</div>




<div class="form-group">
<button type="submit" class="btn btn-primary validate">提交订单</button>
<a class="btn btn-danger" href="/" title="Cancel">取消</a>
</div>

</div></div></div></section>

 <%@include file="footer.jsp"%>
  <%@include file="canvasmenu.jsp"%>
    <script>
     

 

function imagesSelected(myFiles) {
  document.getElementById("image").style.display="block";
  for (var i = 0, f; f = myFiles[i]; i++) {
    var imageReader = new FileReader();
	//console.log(f);
    imageReader.onload = (function(aFile) {
      return function(e) {
        var obj = document.getElementById("image");
		var objsrc =  e.target.result;
		obj.src =  objsrc;
		alert(objsrc);
      };
    })(f);
    imageReader.readAsDataURL(f);
  }
  //console.log(document.getElementById("input").value);
}

function dropIt(e) {  
   imagesSelected(e.dataTransfer.files); 
   e.stopPropagation();  
   e.preventDefault();   
}  

  </script>
</body>
</html>
