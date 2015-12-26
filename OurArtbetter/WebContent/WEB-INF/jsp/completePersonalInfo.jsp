<%@page import="com.art.entity.User"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb"
	dir="ltr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<base href="https://shapebootstrap.net/" />-->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="generator"
	content="Joomla! - Open Source Content Management" />
<title>DrinkArt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/artstyle.css">
<link href="css/sucaijiayuan.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"
	type="text/css" />
<style type="text/css">
body {
	font-family: Open Sans, sans-serif;
	font-weight: normal;
}

h1 {
	font-family: Open Sans, sans-serif;
	font-weight: 700;
}

h2 {
	font-family: Open Sans, sans-serif;
	font-weight: 600;
}

h3 {
	font-family: Open Sans, sans-serif;
	font-weight: normal;
}

h4 {
	font-family: Open Sans, sans-serif;
	font-weight: 700;
}

h5 {
	font-family: Open Sans, sans-serif;
	font-weight: 600;
}

h6 {
	font-family: Open Sans, sans-serif;
	font-weight: 600;
}

#sp-bottom {
	background-color: #3c3c3c;
	padding: 70px 0px 0px;
}

#sp-footer {
	background-color: #3c3c3c;
}

.btn-success,.sppb-btn-success {
	background-color: #e83258;
}

.group-control {
	display: inline-block;
	width: 100%;
	height: 20%;
}

.tip-control {
	display: inline-block;
	color: #e83258;
	font-size: 6px;
	width: 60%;
	height: 10%;
}

* {
	-ms-word-wrap: break-word;
	word-wrap: break-word;
}

html {
	-webkit-text-size-adjust: none;
	text-size-adjust: none;
}

html,body {
	height: 100%;
	width: 100%;
}

html,body,h1,h2,h3,h4,h5,h6,div,ul,ol,li,dl,dt,dd,iframe,textarea,input,button,p,strong,b,i,a,span,del,pre,table,tr,th,td,form,fieldset,.pr,.pc
	{
	margin: 0;
	padding: 0;
	word-wrap: break-word;
	font-family: verdana, Microsoft YaHei, Tahoma, sans-serif;
	*font-family: Microsoft YaHei, verdana, Tahoma, sans-serif;
}

body,ul,ol,li,dl,dd,p,h1,h2,h3,h4,h5,h6,form,fieldset,.pr,.pc,em,del {
	font-style: normal;
	font-size: 100%;
}

ul,ol,dl {
	list-style: none;
}

#Popy {
	background-color: #ffffff;;
}

._citys {
	width: 450px;
	display: inline-block;
	border: 2px solid #eee;
	padding: 5px;
	position: relative;
	background-color: #ffffff;
}

._citys span {
	color: #56b4f8;
	height: 15px;
	width: 15px;
	line-height: 15px;
	text-align: center;
	border-radius: 3px;
	position: absolute;
	right: 10px;
	top: 10px;
	border: 1px solid #56b4f8;
	cursor: pointer;
}

._citys0 {
	width: 100%;
	height: 34px;
	display: inline-block;
	border-bottom: 2px solid #56b4f8;
	padding: 0;
	margin: 0;
}

._citys0 li {
	display: inline-block;
	line-height: 34px;
	font-size: 15px;
	color: #888;
	width: 80px;
	text-align: center;
	cursor: pointer;
}

.citySel {
	background-color: #56b4f8;
	color: #fff !important;
}

._citys1 {
	width: 100%;
	display: inline-block;
	padding: 10px 0;
}

._citys1 a {
	width: 53px;
	height: 35px;
	display: inline-block;
	background-color: #f5f5f5;
	color: #666;
	margin-left: 3px;
	margin-top: 3px;
	line-height: 35px;
	text-align: center;
	cursor: pointer;
	font-size: 13px;
	overflow: hidden;
}

._citys1 a:hover {
	color: #fff;
	background-color: #56b4f8;
}

.AreaS {
	background-color: #56b4f8 !important;
	color: #fff !important;
}
</style>
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/emailAutoComplete.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>

</head>
<body
	class="site com-users view-login no-layout no-task itemid-121 en-gb ltr  sticky-header layout-fluid">

	<%@include file="header.jsp"%>


	<section id="sp-page-title">
	<div class="row">
		<div id="sp-title" class="col-sm-12 col-md-12">
			<div class="sp-column "></div>
		</div>
	</div>
	</section>

	<!--<section id="sp-main-body" style="background-color:#f4d1d4*/;">-->
	<section id="sp-main-body" style="background-color:#e5e5e5;">
	<div class="container">
		<div class="row">
			<div id="sp-component" class="col-sm-12 col-md-12">
				<div class="sp-column ">
					<div class="row">
						<div class="col-sm-8">
							<ul class="nav nav-tabs" role="tablist">
								<!---span里是新消息有几条-->
								<li><a href="#">我的订单<span>0</span></a></li>
								<li class="active"><a href="#">我的信息</a></li>
								<li><a href="#">我的申请<span>0</span></a></li>
							</ul>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3">
							<div class="box registration">
								<form id="member-registration"
									action="/OurArtbetter/completePersonalInfo" method="post"
									class="form-validate" enctype="multipart/form-data">
									<div class="form-group">
										<div class="text-center" style="font-size: 25px;">完善个人信息</div>
									</div>
									<div class="form-group">
										<div class="group-control">
											<span>手机号：</span><span><%=session.getAttribute("userName")%></span>
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<input type="text" name="nickName" id="" value="" size="25"
												placeholder="昵称" autofocus="">
										</div>
									</div>

									<div class="form-group">
										<div class="group-control" name="gender">
											<label> <input type="radio" name=""
												id="optionsRadios1" value="male" check> 男
											</label> <label> <input type="radio" name=""
												id="optionsRadios2" value="female"> 女
											</label>
										</div>
									</div>

									<div class="form-group">
										<div class="parentCls group-control">
											<input type="text" name="email" class="inputElem"
												id="mailbox" value="" size="25" placeholder="邮箱" />
											<div class="tip-control" id="mail-test">
												<span><i></i></span>
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<input type="text" name="code" class="inputElem"
												id="mailcode" value="" size="25" placeholder="邮政编码" />
											<div class="tip-control" id="code-test">
												<span><i></i></span>
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<input type="text" id="city" name="address" placeholder="地址" />
										</div>
									</div>

									<div class="form-group">
										<div class="group-control">
											<div class="input-append date" id="datetimepicker"
												data-date="" data-date-format="dd-mm-yyyy">
												<input class="span2" size="16" type="text" id="infodate"
													name="birthday" placeholder="生日" />
												<!--这个需要后台设置value为当前时间-->
												<span class="add-on"><i class="icon-th"></i></span>
											</div>
										</div>
									</div>

									<div class="form-group">
										<button type="submit" class="btn btn-primary validate">提交</button>
										<a class="btn btn-danger" href="/" title="Cancel">取消</a> <input
											type="hidden" name="option" value="com_users"> <input
											type="hidden" name="task" value="registration.register">
									</div>
									<input type="hidden" name="433ee394962401c7e7cdaa850a4d9d19"
										value="1">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	</section>

	<!--把footer开头的那个块替换成下面的-->
	<%@include file="footer.jsp"%>
	<!-- 把div改成下面这个-->
	<%@include file="canvasmenu.jsp"%>

	<script>
		$("#mailbox").blur(function() {
			var mail = document.getElementById("mailbox").value;
			console.log(mail);
			var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
			if (mail == "") {
				document.getElementById("mail-test").innerHTML = "格式错误";
			} else if (!reg.test(mail)) {
				// alert("非法的电子邮件"); 
				// return false; 
				//alert("!");
				document.getElementById("mail-test").innerHTML = "格式错误";
			} else {
				document.getElementById("mail-test").innerHTML = "格式正确";
			}
		});

		$("#mailcode").blur(function() {
			var ss = document.getElementById('mailcode').value;
			var re = /^[1-9][0-9]{5}$/;
			if (re.test(ss))
				document.getElementById('code-test').innerHTML = "邮政编码格式正确";
			else if (ss == "")
				document.getElementById('code-test').innerHTML = "邮政编码格式不为空";
			else {
				document.getElementById('code-test').innerHTML = "邮政编码格式不正确";

			}
		});

		$("#city").click(function(e) {
			SelCity(this, e);
		});

		$(".input-append").datetimepicker({
			format : 'yyyy-mm-dd',
			autoclose : true,
			minView : 2,//最精确到天
			startView : 2,//一打开显示的是天
			forceParse : true

		});
	</script>

</body>
</html>
