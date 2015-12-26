<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%!
int dayNum =1; 
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel = "Shortcut Icon" href="images/favicon.ico"/>
<title>DrinkArt</title>
<link rel="stylesheet" type="text/css" href="css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" type="text/css" />
<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<style>
	   body{
		font-family:"Microsoft YaHei","Hiragino Sans GB","WenQuanYi Micro Hei", sans-serif;
		}
		 h3{
		 font-weight:bold;}
		
		 .lc_prolist input[type="button"]{
		 margin-left:4px;
		 }
	     .admin-main-r-wrapper{
		 float:left;
		 margin-left:20px;
		 }
		 .main{
		height:800px;}
		h2{
		margin-top:0px;
		}
		.admin-main-r-wrapper {
    padding: 19px 36px 0;
}
        .admin-main-r-wrapper h3{
		font-weight:bold;
		}
		th{
		text-align:center;
		}
		.daycss{
		width:30px;}
		</style>
</head>
<body>
<div class="login-bg"> </div>
<div class="admin-bgbar"> </div>
<div class="ui-mask" id="mask" onselectstart="return false"></div>
<div class="container clearfix"/>
<div class="login-bar-l">欢迎使用DrinkArt艺术品定制网站的后台管理系统!</div>
<div class="login-bar"> <a href="#" class="orange" style="cursor:default;">你好！管理员:{$adminname}</a> <a href="__APP__/Login/logout">退出</a> </div>
<div class="header clear">
  <h1 class="logo">DrinkArt</h1>
</div>
<div class="main clearfix">

  <div class="admin-main-r-wrapper">
    <div class="search" style="float:right;">
      <form action="#" method="post">
        <input type="text" name="searchname" placeholder="请输入您要搜索的资讯" />
        <input type="submit"  value="搜索" />
      </form>
    </div>
    <h3>上线设置 :</h3>
    <h3 id="title">${info.contentType}标题：${info.title } </h3>
    <div class="operate-table clear">
      <form action="/OurArtbetter/ADMIN_setDateAndPos?id=${ info.id }"  method="post"  id="newDateAndPos">
        <!-- 需要修改 -->
        <table class="lc_prolist" >
          <thead>
            <tr id="trid">
              <th colspan=2>上线时间</th>
              <th colspan=2>上线天数</th>
              <th colspan=2>下线时间</th>
              <th>软文位置</th>
              <th>价格</th>
              <!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
              <th>操作</th>
            </tr>
          </thead>
          <volist name="users" id="type">
            <tr>
              <td colspan=2><div class="input-append date" id="datetimepicker" data-date="" data-date-format="dd-mm-yyyy 00:00:00" style="width:40px;">
                  <input class="span2" size="16" type="text" value=""  id="startDate" name="startDate"/>
                  <span class="add-on"><i class="icon-th"></i></span> </div></td>
              <td colspan=2><input type="text" class="daycss"/></td>
              <td colspan=2><label id="leavedate">2222222222</label></td>
              <td><select name="columnId" id="columnId">
                  <!-- 需要用Ajax即时显示出来，这个时段哪些栏目已经被设置过了 -->
                  <option value ="1">广告栏1</option>
                  <option value ="2">广告栏2</option>
                  <option value="3">广告栏3</option>
                  <option value="4">资讯栏1</option>
                  <option value="5">资讯栏2</option>
                  <option value="6">资讯栏3</option>
                </select>
              </td>
              <td><span>￥</span>price!!!!</td>
              <!-- 需要用Ajax即时显示出来 -->
              <td><input type="submit" value="设置上线"/></td>
            </tr>
          </volist>
        </table>
      </form>
      <h3>该条软文设置记录：</h3>
      <form action="/OurArtbetter/ADMIN_getDateAndPosByInfoId"  method="post">
        <table class="lc_prolist" >
          <thead>
            <tr>
              <th colspan=2>在线时间</th>
              <th>软文栏目</th>
              <th>价格</th>
              <!--审核情况就是主编审核是否通过，如果通过了的话，我要把按钮改颜色，说明已经不可修改-->
              <th>操作</th>
            </tr>
          </thead>
          <c:if test="${! empty dateAndPosList}">
            <c:forEach var="dateAndPos" items="${dateAndPosList}">
              <volist name="users" id="">
                <tr>
                  <td colspan=2> ${ dateAndPos.date } <span class="add-on"><i class="icon-th"></i></span> </td>
                  <td> ${dateAndPos.infoColumn.id}
                    <c:if test="${dateAndPos.infoColumn.id == 1 } "> 广告轮播图1 </c:if>
                    <c:if test="${dateAndPos.infoColumn.id == 2}  "> 广告轮播图2 </c:if>
                    <c:if test="${dateAndPos.infoColumn.id == 3}  "> 广告轮播图3 </c:if>
                    <c:if test="${dateAndPos.infoColumn.id  == 4} "> 咨询栏目1 </c:if>
                    <c:if test="${dateAndPos.infoColumn.id  == 5} "> 资讯栏目2 </c:if>
                    <c:if test="${dateAndPos.infoColumn.id  == 6 } "> 资讯栏目3 </c:if>
                  </td>
                  <td><span>￥</span>${dateAndPos.infoColumn.price}</td>
                  <!-- 需要计算dayNum -->
                  <td><a href="/OurArtbetter/ADMIN_deleteDateAndPos?id=${dateAndPos.id}">
                    <input type="button" value="删除"   />
                    </a></td>
                  <!-- 修改 -->
                </tr>
              </volist>
            </c:forEach>
          </c:if>
        </table>
      </form>
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
	 var mydate = new Date();
    var str =mydate.getFullYear() + "-";
    str += (mydate.getMonth()+1) + "-";
    str += mydate.getDate();
	document.getElementById("startDate").value=str+" 00:00:00";
	 document.getElementById("leavedate").innerHTML=str+" 00:00:00";
	$(".input-append").datetimepicker({
   format: 'yyyy-mm-dd 00:00:00',
   autoclose:true,
   minView:2,//最精确到天
   startView:2,//一打开显示的是天
   forceParse:true
   });
	
	/*
   function addtimepos(){
   var newTr = infolist.insertRow(1);
   newTr.innerHTML = ' <tr><td><select><option value ="">1</option><option value ="">2</option><option value="">3</option> <option value="">4</option>' +'</select></td><td colspan=2><div class="input-append date" id="datetimepicker" data-date="" data-date-format="dd-mm-yyyy 00:00:00"'+'style="width:40px;"><input class="span2" size="16" type="text" value="2015-12-07 00:00:00"><span class="add-on"><i class="icon-th"></i></span>'+
   ' </div></td><td><span>￥</span>{$vo.la}</td><td>资讯标题</td><td><input type="button" value="上传资讯"/></td></tr>';
   }*/
   $(".daycss").blur(function(){
	   //alert("hahah");
	   //alert(document.getElementById("startDate").value);
	   var datetime=document.getElementById("startDate").value;
	   var date=datetime.substr(0,10);
      // alert(date);
	
	
	   var days=$(this).val();
	  // alert(days);
	   if((date!=null)&&(days!=null)){
	       var d=new Date(date); 
		   var day=parseInt(days);
       d.setDate(d.getDate()+day); 
       var month=d.getMonth()+1; 
       var day = d.getDate(); 
       if(month<10){ 
          month = "0"+month; 
        } 
       if(day<10){ 
       day = "0"+day; 
       } 
       var val = d.getFullYear()+"-"+month+"-"+day+" 00:00:00"; 

	   document.getElementById("leavedate").innerHTML=val;
	   var title=document.getElementById("title").innerHTML;
	   console.log(title);
		  $.ajax({  
	        data:{message:date+" "+days+" "+title},  
	        type:"GET",  
	        dataType: 'text',  
	        url:"/OurArtbetter/ADMIN_info",  
	        error:function(data){  
	            console.log("出错了！！:"+data);  
	        },  
	        success:function(data){  
	            console.log("success:"+data); 
	            var array=data.split(" ");
	            for(var i=0;i<data.length;i++){
	            	if(array[i]==1)
	            	$("#columnId option[value='1']").remove();
	            	else if(array[i]==2)
		            	$("#columnId option[value='2']").remove();
		           else if(array[i]==3)
			            $("#columnId option[value='3']").remove();
		        	else if(array[i]==4)
		            	$("#columnId option[value='4']").remove();
		         	else if(array[i]==5)
		            	$("#columnId option[value='5']").remove();
		         	else if(array[i]==6)
		            	$("#columnId option[value='6']").remove();
	            	
	            }
	         
	        }  
	        });
	   
	   }
   });
   

   </script>
</body>
</html>
