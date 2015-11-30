<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head><title>Add Users</title></head>
<body>
<h1>Add Users</h1>
<h2><a href="/springMVC_Demo/index.jsp">Welecme</a></h2>
<a href="/springMVC_Demo/user.html">show ALL Users</a>

<br />
<br />
<c:url var="addUser" value="/user/add.html" />
<form:form modelAttribute="user" method="POST" action="${addUser}">
	
	<form:label path="realName">真实姓名</form:label>
	<form:input path="realName"></form:input>
	<br />
	<form:label path="nickName">昵称</form:label>
	<form:password path="nickName"></form:password>
	<br />
	<form:radiobutton checked="checked"  path="gender" value="男"/>男
	<form:radiobutton  path="gender" value="女"/>女
	<br />
	<form:label path="tel">电话：</form:label>
	<form:input path="tel"></form:input>
	<br />
	<form:label path="email">邮箱：</form:label>
	<form:input path="email"></form:input>
	<br />
	<form:label path="birthday">生日：</form:label>
	<form:input path="birthday"></form:input>
	<br />
	<form:label path="password">密码：</form:label>
	<form:input path="password" ></form:input>
	<br />
	
	<input type="submit" value="注册" />
	
</form:form>

</body>
</html>