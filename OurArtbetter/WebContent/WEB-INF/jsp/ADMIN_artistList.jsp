<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel = "Shortcut Icon" href="../../../images/favicon.ico">
		<title>DrinkArt</title>
		<link rel="stylesheet" type="text/css" href="。。/../css/admin_style.css" />
		<link rel="stylesheet" type="text/css" href="../../css/admin.css" />

		<script type="text/javascript" src="../../js/jquery.1.10.2.js"></script>      
		<style>
		 h3{
		 font-weight:bold;}
		
		 .lc_prolist input[type="button"]{
		 margin-left:4px;
		 }
	
		</style>		
	</head>
	
	<body>
		<div class="login-bg"> </div>
		<div class="admin-bgbar"> </div>
		<div class="ui-mask" id="mask" onselectstart="return false"></div>

		<div class="container clearfix">
			<div class="login-bar-l">æ¬¢è¿ä½¿ç¨DrinkArtèºæ¯åå®å¶ç½ç«çåå°ç®¡çç³»ç»!</div>
			<div class="login-bar">
				<a href="#" class="orange" style="cursor:default;">ä½ å¥½ï¼ç®¡çå:{$adminname}</a>
				<a href="__APP__/Login/logout">éåº</a>
			</div>
			<div class="header clear">
				<h1 class="logo">DrinkArt</h1>
			</div>
			<div class="main clearfix">
			<div class="admin-l-bar">
	<h2>åå°ç®¡çç³»ç»</h2>
	<ul>
		<li><a href="#" class="firstnav">é¦é¡µ</a></li>


		<li class="navhasul"><a href="#" class="firstnav">ç¨æ·ç®¡ç</a>
			<ul class="secondnav">
				<li><a href="#">ç¨æ·åè¡¨</a></li>
				<li><a href="#">èºæ¯å®¶åè¡¨</a></li>
				<li><a href="#">å¢å ç¨æ·</a></li>
			</ul>
		</li>

		<li class="navhasul"><a href="#" class="firstnav">è®¢åç®¡ç</a>
			<ul class="secondnav">
				<li><a href="#">ååè®¢åç®¡ç</a></li>
				<li><a href="#">å®å¶è®¢åç®¡ç</a></li>
				<li><a href="#">æåè®¢åç®¡ç</a></li>
			</ul>
		</li>

		<li class="navhasul"><a href="#" class="firstnav">èµè®¯å¹¿åç®¡ç</a>
			<ul class="secondnav">
		        <li><a href="#">èµè®¯ç®¡ç</a></li>
				<li><a href="#">å¹¿åç®¡ç</a></li>
			</ul>
		</li>

		<li class="navhasul"><a href="#" class="firstnav">ä¸å¡ç®¡ç</a>
			<ul class="secondnav">
			    <li><a href="#">æåç®¡ç</a></li>
				<li><a href="#">ååç®¡ç</a></li>
			</ul>
		</li>

        <li class="navhasul"><a href="#" class="firstnav">å¨è¯¢æè¯ç®¡ç</a>
		</li>
	</ul>
</div>
  <div class="admin-main-r-wrapper">
			   	
			   	 <div class="search" style="float:right;">			   	 	
                    <form action="__APP__/UserManage/search" method="post">                	
                    	<input type="text" name="searchname" placeholder="è¯·è¾å¥æ¨è¦æç´¢çå§å" />
                    	<input type="submit"  value="æç´¢" />
                    </form>
			   	 </div>
			   	  <h3>èºæ¯å®¶åè¡¨</h3>
			   	 
			   	 <div class="operate-table clear">
			   	 	<table class="lc_prolist">
			   	 		<thead>
			   	 		<tr>
			   	 			<th>ç¨æ·å</th>
							<th>æ§å«</th>
			   	 			<th>ææº</th>
							<th>çæ¥</th>
							<th>é®ç®±</th>
			   	 		    <th>èºæ¯å®¶ç±»å</th>	
							<th>èºæ¯å®¶ä»ç»</th>
							<th>ç§ç</th>			   	 	
			   	 		    <th>æä½</th>
							<th>è®¤è¯</th>
			   	 		</tr>
			   	 		</thead>
			   	 		<volist name="users" id="vo" key="k">
			   	 			<tr>
			   	 				<td>{$v.name}</td>
			   	 				<td>{$vo.phone}</td>		   	 			
			   	 				<td>{$vo.rn}</td>
								<td>{$v.name}</td>
			   	 				<td>{$vo.phone}</td>		   	 			
			   	 				<td>{$vo.rn}</td>
								<td>{$vo.rn}</td>
								<td><input type="button" value="ä¿®æ¹ç§ç" /></td>
			   	 				<td><div style="height:20px;width:140px;"><input type="button" value="éç½®å¯ç "/>
								<input type="button" value="å é¤"/></div></td>
			   	 			   	<td><input type="button" value="åæ¶èºæ¯å®¶è®¤è¯"/></td>
			   	 			</tr>
			   	 		</volist>
			   	 		<tr>
			   	 			<td colspan=10>{$page}</td>
			   	 		</tr>
			   	 	</table>
			   	 	</div>
			   </div>
			</div>
			<script type="text/javascript">
	$(function(){
		$(".navhasul").hover(function(){
			$(this).find(".firstnav").addClass("hovertri");
			$(this).children("ul").show();
		},function(){
			$(this).find(".firstnav").removeClass("hovertri");
			$(this).children("ul").hide();
		});
	})
</script>
	</body>		
